<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/pages.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="${jsRoot}/jquery-1.11.1.min.js"></script>
		<link href="${cssRoot}/right_style.css" rel="stylesheet">
		<!-- 引入 Bootstrap -->
		<link href="${toolRoot}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${toolRoot}/bootstrap/css/bootstrap-self.css" rel="stylesheet">
		<script src="${toolRoot}/bootstrap/js/bootstrap.min.js"></script>
		<!-- 引入 select2 -->
		<link href="${toolRoot}/select/select2.min.css" rel="stylesheet">
		<script src="${toolRoot}/select/select2.full.min.js"></script>
		<script src="${toolRoot}/select/select2-self.js"></script>
		<!-- 引入分页 -->
		<script src="${jsRoot}/page.js"></script>
		<script type="text/javascript">
			$(function(){
				$("div.customerSearchBar ul > li").click(function (e) {
					$("div.customerSearchBar ul > li").removeClass("active");
					$(this).addClass("active");
				});
				//函数来源page.js
				page("messageDataListForm", ${page.pageInfo}, "pageMessageDataList");
			});
			function goEditMessageData(id){
				var title = $("#title").val();
				var province = $("#province").val();
				var messagetype = $("#messagetype").val();
				window.location="/messageData/goEditMessageData?id="+id+"&titleQuery="+title+"&provinceQuery="+province+"&messagetypeQuery="+messagetype;
			}
			function deleteMessageData(id,isdelete){
				$.ajax({
					url:'/ajax/deleteMessageData',
					data:{
						id:id,
						isdelete:isdelete
					},
					dataType:'json',
					type:'post',
					cache:false,
					async:false,
					success:function(data) {
						if(data.info=='1'){
							alert("操作成功!");
							location.reload();
						}else{
							alert("操作失败!");
						}
					},
					error : function(){
						alert("操作失败!");
					}
				});
			}
		</script>
	</head>
<body style="width: 95%;  font-size: 13px;">
	<form class="form-horizontal" id="messageDataListForm" action="/messageData/messageDataList" method="POST">
		<div class="r_box" style="margin-top: 10px;">
			<div style="height: 15px; width: 100%;"><span></span></div>
			<span class="infoLable">标题：</span>
				<input id="title" name="title" type="text" value="${query.title }" class="self-form-control" style="width: 150px;"/>
			<span class="infoLable">所在省市：</span>&nbsp;
			<select class="" name='province' id="province" style="width: 110px;height: 28px;">
				<option value="0">请选择</option>
				<c:forEach items="${provinceList}" var="province" varStatus="status">
					<option value='${province.id}'<c:if test="${query.province==province.id}">selected</c:if>>
	            		${province.provinceName} 
	            	</option>
				</c:forEach>
			</select>
			<span class="infoLable">信息类型：</span>
			<select class="select-nosearch" name="messagetype" id="messagetype"  style="width: 110px;height: 28px;">
				<option value="0">---请选择---</option>
				<c:forEach items="${messageTypeList}" var="messageType" varStatus="status">
					<option value='${messageType.id}'<c:if test="${query.messagetype==messageType.id}">selected</c:if> >
						${messageType.messageName} 
					</option>
				</c:forEach>
			</select>
			<span class="infoLable">前台模块：</span>
			<select class="select-nosearch" name="frontmodule" id="frontmodule"  style="width: 110px;height: 28px;">
				<option value="0">---请选择---</option>
				<option value='1'<c:if test="${query.frontmodule=='1'}">selected</c:if> >热点信息</option>
				<option value='2'<c:if test="${query.frontmodule=='2'}">selected</c:if> >推荐项目</option>
				<option value='3'<c:if test="${query.frontmodule=='3'}">selected</c:if> >级别项目</option>
			</select>
			<span class="infoLable">状态：</span>
			<select class="select-nosearch" name="isdelete" id="isdelete"  style="width: 110px;height: 28px;">
				<option value="">---请选择---</option>
				<option value='0'<c:if test="${query.isdelete=='0'}">selected</c:if> >未删除</option>
				<option value='1'<c:if test="${query.isdelete=='1'}">selected</c:if> >已删除</option>
			</select>
			<button type="submit" class="btn btn-default" style="background-color:#337ab7;">搜索</button>
			<br />
			<div><span></span></div>
		</div>
		<div class="r_box" >
			<table width="100%" cellpadding="0" cellspacing="0" class="table-bordered">
				<tr>
					<th width="5%" align="center" height="38" align="center">
						序号
					</th>
					<th width="13%" align="center">
						标题
					</th>
					<th width="8%" align="center">
						省市
					</th>
					<th width="8%" align="center">
						信息类型
					</th>
					<th width="8%" align="center">
						前台模块
					</th>
					<th width="8%" align="center">
						日期
					</th>
					<th width="8%" align="center">
						创建人
					</th>
					<th width="8%" align="center">
						状态
					</th>
					<th width="8%" align="center">
						操作
					</th>
				</tr>
				<c:forEach items="${page.result}" var="data" varStatus="count">
					<tr>
						<td align="center" height="33" align="center">
							${count.count}
						</td>
						<td align="center" title="${data.title}">
							<c:if test="${fn:length(data.title)>20 }">
								${fn:substring(data.title,0,20) }...
							</c:if>
							<c:if test="${fn:length(data.title)<=20 }">
								${data.title }
							</c:if>
						</td>
						<td align="center">
							${data.provincename}
						</td>
						<td align="center">
							${data.messagename}
						</td>
						<td align="center">
							<c:if test="${data.frontmodule=='1'}">热点信息</c:if>
							<c:if test="${data.frontmodule=='2'}">推荐项目</c:if>
							<c:if test="${data.frontmodule=='3'}">级别项目</c:if>
						</td>
						<td align="center">
							${data.dateString}
						</td>
						<td align="center">
							${data.userRealName}
						</td>
						<td align="center">
							<c:if test="${data.isdelete==0}">未删除</c:if>
							<c:if test="${data.isdelete==1}">已删除</c:if>
						</td>
						<td align="center">
							<c:if test="${data.isdelete==0}">
								<button type="button" class="btn btn-success" onclick="goEditMessageData('${data.id}')" target="_blank">编辑</button>
								<button type="button" class="btn btn-success" onclick="deleteMessageData('${data.id}','1')" target="_blank">删除</button>
							</c:if>
							<c:if test="${data.isdelete==1}">
								<button type="button" class="btn btn-success" onclick="deleteMessageData('${data.id}','0')" target="_blank">还原</button>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="10" height="30" bgcolor="#D9F3FD" align="left" class="pageMessageDataList">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
