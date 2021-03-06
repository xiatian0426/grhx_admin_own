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
		<script src="${jsRoot}/userinfo/editFrontData.js"></script>
		<script type="text/javascript">
			$(function(){
				//函数来源page.js
				page("frontDataListForm", ${page.pageInfo}, "pageFrontDataList");
			});
		</script>
	</head>
<body style="width: 95%;  font-size: 13px;">
	<form class="form-horizontal" id="frontDataListForm" action="/frontData/list" method="POST">
		<div class="r_box" style="margin-top: 10px;">
			<div style="height: 15px; width: 100%;"><span></span></div>
			<span class="infoLable">名称：</span>
				<input name="name" type="text" class="self-form-control" style="width: 100px;" value="${query.name }"/>
			<span class="infoLable">类别：</span>
				<select class="select-nosearch" name="type" style="width: 120px;height: 28px;">
					<option value="" selected="selected">---请选择---</option>
					<option value="1" <c:if test="${query.type=='1' }">selected="selected"</c:if>>行业动态</option>
					<option value="2" <c:if test="${query.type=='2' }">selected="selected"</c:if>>展会信息</option>
					<option value="3" <c:if test="${query.type=='3' }">selected="selected"</c:if>>优秀供应商</option>
					<option value="4" <c:if test="${query.type=='4' }">selected="selected"</c:if>>会员中标榜</option>
				</select>
			<span class="infoLable">状态：</span>
				<select class="select-nosearch" name="isdelete" style="width: 120px;height: 28px;">
					<option value="" selected="selected">---请选择---</option>
					<option value="0" <c:if test="${query.isdelete==0 }">selected="selected"</c:if>>未删除</option>
					<option value="1" <c:if test="${query.isdelete==1 }">selected="selected"</c:if>>已删除</option>
				</select>
			<button type="submit" class="btn btn-default"
					style="background-color:#337ab7;">搜索</button>
			<br />
			<div><span></span></div>
		</div>
		<div class="r_box" >
			<table width="100%" cellpadding="0" cellspacing="0" class="table-bordered">
				<tr>
					<th width="5%" align="center" height="38" align="center">
						序号
					</th>
					<th width="15%" align="center">
						名称
					</th>
					<th width="10%" align="center">
						url
					</th>
					<th width="14%" align="center">
						类别
					</th>
					<th width="14%" align="center">
						创建时间
					</th>
					<th width="10%" align="center">
						状态
					</th>
					<th width="23%" align="center">
						操作
					</th>
				</tr>
				<c:forEach items="${page.result}" var="frontData" varStatus="count">
					<tr>
						<td align="center" height="33" align="center">
							${count.count}
						</td>
						<td align="center">
							${frontData.name}
						</td>
						<td align="center">
							${frontData.url}
						</td>
						<td align="center">
							<c:if test="${frontData.type=='1' }">行业动态</c:if>
							<c:if test="${frontData.type=='2' }">展会信息</c:if>
							<c:if test="${frontData.type=='3' }">优秀供应商</c:if>
							<c:if test="${frontData.type=='4' }">会员中标榜</c:if>
						</td>
						<td align="center">
							${frontData.createDateString}
						</td>
						<td align="center">
							<c:if test="${frontData.isdelete==0 }">未删除</c:if>
							<c:if test="${frontData.isdelete==1 }"><font color="red">已删除</font></c:if>
						</td>
						<td align="center">
							<div class="btn-group">
								<button type="button" class="btn btn-success" onclick="goEditFrontData('${frontData.id}');" target="_blank">编辑</button>
							</div>
							<c:if test="${frontData.isdelete==0 }">
								<div class="btn-group">
									<button type="button" class="btn btn-success" onclick="deleteFrontData('${frontData.id}','1');" target="_blank">删除</button>
								</div>
							</c:if>
							<c:if test="${frontData.isdelete==1 }">
								<div class="btn-group">
									<button type="button" class="btn btn-success" onclick="deleteFrontData('${frontData.id}','0');" target="_blank">还原</button>
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8" height="40" bgcolor="#D9F3FD" align="left" class="pageFrontDataList">
						<%-- 共${page.recordCount}条|当前${page.currentPage}/${page.pageCount}页 --%>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
