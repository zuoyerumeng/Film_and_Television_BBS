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
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>
	<script type="text/javascript" src="<%=path %>/js/menu.js"></script>
	<script type="text/javascript" src="<%=path %>/js/ajax.js"></script>	
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
          <td>系统设置首页 » ${txt }</td></tr></tbody></table><br>
			<form method="post" action="<%=path%>/forumsAdd.action">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tableborder">
					<tr class="header"><td colspan="3">${txt }</td></tr>
					<tr align="center">
						<td class="altbg1" width="15%">名称:</td>
						<td class="altbg2" width="85%"><input type="text" name="name" value="" size="20" maxlength="50"></td>
					</tr>
					<c:if test="${fn:length(forumsList)>0}">
						<tr align="center">
							<td class="altbg1" width="15%">${td }:</td>
							<td class="altbg2" width="85%">
								<select name="fup">
									<c:forEach items="${requestScope.forumsList}" var="forums">
										<option value="${forums.fid }">${forums.name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>						
					</c:if>
				</table>
				<br/>
				<center>
					<input type="hidden" name="type" value="${type }">
					<input class="button" type="submit" name="catsubmit" value="提 交">
				</center>
			</form>          
          </td></tr></tbody></table>
  </body>
</html>
