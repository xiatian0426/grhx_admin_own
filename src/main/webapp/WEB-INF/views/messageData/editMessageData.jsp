<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/pages.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>修改客户</title>
	<%@ include file="../common/jsp_contants.jsp"%>
	<%@ include file="../common/js_contants.jsp"%>
	<link rel="stylesheet" type="text/css" href="${cssRoot }/right_style.css" />
	<link rel="stylesheet" type="text/css" href="${cssRoot }/zTreeStyle.css" />
	<script type="text/javascript" src="${jsRoot }/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${jsRoot }/move_sel_tree.js"></script>
	<!-- 日历控件 -->
	<script type="text/javascript" src="${toolRoot }/My97DatePicker/WdatePicker.js"></script>
	<!-- ZTree控件 -->
	<script type="text/javascript" src="${jsRoot }/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript"
		src="${jsRoot }/jquery.ztree.excheck-3.5.min.js"></script>
	<script type="text/javascript" src="${jsRoot }/dtree.js"></script>
	<!-- 验证 -->
	<link rel="stylesheet" href="${toolRoot }/validata/validationEngine.css" />
	<script type="text/javascript" src="${toolRoot }/validata/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${toolRoot }/validata/jquery.validationEngine-zh_CN.js" charset="utf-8"></script>
	<!-- 引入 Bootstrap -->
	<link href="${toolRoot}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${toolRoot}/bootstrap/css/bootstrap-self.css" rel="stylesheet">
	<script src="${toolRoot}/bootstrap/js/bootstrap.min.js"></script>
	<!-- 文档编辑 -->
	<script type="text/javascript" charset="utf-8"
		src="<%=toolRoot%>/kindeditor/kindeditor.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=toolRoot%>/kindeditor/lang/zh_CN.js"></script>
	<!-- 引入 select2 -->
	<link href="${toolRoot}/select/select2.min.css" rel="stylesheet">
	<script src="${toolRoot}/select/select2.full.min.js"></script>
	<script src="${toolRoot}/select/select2-self.js"></script>
	<script type="text/javascript">
		//字符串去空格
		String.prototype.trim=function(){
			return this.replace(/(^\s*)|(\s*$)/g, "");
		}
		var editor;
		KindEditor.ready(function(K) {
			//创建编辑器
			editor = K.create('#editor_id');
		});
		$(function(){
			//开启表单验证
			$("#editMessageDataFrom").validationEngine();
		});
		function edit(){
			var date = $("#date").val();
			if(date==''){
				$("#date").validationEngine("showPrompt","日期不能是空","error");
				return false;
			}
			var province = $("#province").val();
			if(province=='' || province=='0'){
				$("#province").validationEngine("showPrompt","省市不能是空","error");
				return false;
			}
			var messagetype = $("#messagetype").val();
			if(messagetype=='' || messagetype=='0'){
				$("#messagetype").validationEngine("showPrompt","信息类型不能是空","error");
				return false;
			}
			if(editor.html()==''){
				alert("内容不能为空!");
				return false;
			}
		}
	</script>
</head>
<body style=" font-size: 13px;">
	<form action="/messageData/editMessageData" name="messageDataForm" method="post" target="_self" id="editMessageDataFrom" onsubmit="return edit();">
		<input type="hidden" name="id" value="${messageData.id }"/>
		<input type="hidden" name="titleQuery" value="${titleQuery }"/>
		<input type="hidden" name="provinceQuery" value="${provinceQuery }"/>
		<input type="hidden" name="messagetypeQuery" value="${messagetypeQuery }"/>
		<div class="clearB"></div>
		<div class="r_box" style="padding: 5px;">
			<div style="line-height:48px; font-weight: bold;font-size: 20px;" align="center">
				信息数据修改
			</div>
			<table  style=" font-size: 13px; " align="center" border="1">
				<tr>
					<td style="background:#A0E0F7; padding: 10px 35px; width: 150px;"><font color="red">*</font>&nbsp;标题：</td>
					<td >
						<input id="title" name="title" value="${messageData.title}" type="text" style="width: 172px;" 
						class="validate[required,noSpecialCaracters,maxSize[200]] text-input self-form-control"/>
					</td>
					<td style="background:#A0E0F7; padding: 10px 35px; width: 150px;"><font color="red">*</font>&nbsp;日期：</td>
					<td >
						<input type="text" class="Wdate"
								onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								name="date" id="date" value="${messageData.dateString}" />
					</td>
				</tr>
				<tr>
					<td style="background:#A0E0F7; padding: 10px 35px;"><font color="red">*</font>&nbsp;省市：</td>
					<td >
						<select name='province' id="province" style="width: 172px;">
							<option value='0'>请选择</option>
							<c:forEach items="${provinceList}" var="province" varStatus="status">
								<option value='${province.id}' <c:if test="${messageData.province==province.id }">selected = selected</c:if>>
									${province.provinceName} 
								</option>
							</c:forEach>
						</select>
					</td>
					<td style="background:#A0E0F7; padding: 10px 35px;"><font color="red">*</font>&nbsp;信息类型：</td>
					<td >
						<select class="select-nosearch" name='messagetype' id="messagetype" style="width: 172px">
							<option value='0'>请选择</option>
							<c:forEach items="${messageTypeList}" var="messagetype" varStatus="status">
								<option value='${messagetype.id}' <c:if test="${messageData.messagetype==messagetype.id }">selected = selected</c:if>>${messagetype.messageName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td style="background:#A0E0F7; padding: 10px 35px;">&nbsp;前台模块：</td>
					<td colspan="3">
						<select name="frontmodule" id="frontmodule" style="width: 172px;">
							<option value='0'>请选择</option>
							<option value='1' <c:if test="${messageData.frontmodule=='1' }">selected = selected</c:if>>热点信息 </option>
							<option value='2' <c:if test="${messageData.frontmodule=='2' }">selected = selected</c:if>>推荐项目 </option>
							<option value='3' <c:if test="${messageData.frontmodule=='3' }">selected = selected</c:if>>级别项目 </option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="background:#A0E0F7; padding: 10px 35px;"><font color="red">*</font>&nbsp;内容：</td>
					<td colspan="3">
						<textarea id="editor_id" name="content" style="height: 350px;">${messageData.content }</textarea>
					</td>
				</tr>
			</table>
			<div class="sub_div">
				<input type="submit" class="sub_btn" value=" "/>
				<input type="button" class="back_btn" onclick="javascript:history.go(-1);" value=" " />
			</div>
		</div>
	</form>
</body>
</html>
