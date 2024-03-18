<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel=stylesheet type=text/css href="<%=path %>/css/admincp.css">
	<script type="text/javascript">
		function delConfim()
		{
			return window.confirm('确认删除?');
		}
	</script>
  </head>
  
  <body>
<div id=append_parent></div>
<table cellspacing=6 cellpadding=2 width="100%" border=0>
  <tbody>
  <tr>
    <td>
      <table class=guide cellspacing=0 cellpadding=0 width="100%" border=0>
        <tbody>
        <tr>
          <td>系统设置首页 » 用户管理</td></tr></tbody></table><br>
		 	
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableborder">
				<tr class="header">
					<td>用户名</td>
					<td>真实姓名</td>
					<td>邮箱</td>
					<td>操作</td>
				</tr>
		 	<c:forEach items="${requestScope.userList}" var="user">
				<tr align="center">
					<td class="altbg1">${user.userName }</td>
					<td class="altbg1">${user.realName }</td>
					<td class="altbg1">${user.email }</td>
					<td class="altbg2">
						<a onclick="javascript:return delConfim()" href="<%=path %>/userDel.action?id=${user.id }">删除</a>
					</td>
				</tr>
		 	</c:forEach>
		</table>
		 	   
          </td></tr></tbody></table>
  </body>
</html>
