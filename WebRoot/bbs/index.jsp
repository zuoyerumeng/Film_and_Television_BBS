<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<meta content="ie=7.0000" http-equiv="x-ua-compatible">
	<meta name=generator content="mshtml 11.00.9600.16428">
	<meta name=mssmarttagspreventparsing content=true>
	<meta content=yes http-equiv=msthemecompatible>
	<meta content=ie=7 http-equiv=x-ua-compatible>
	
	<link rel=stylesheet type=text/css href="<%=path %>/css/style_5.css ">
	<link rel=stylesheet type=text/css href="<%=path %>/css/style_5_append.css">
	<script type=text/javascript src="<%=path %>/js/common.js"></script>
	<script type=text/javascript src="<%=path %>/js/menu.js"></script>
	<script type=text/javascript src="<%=path %>/js/ajax.js"></script>
  </head>
  
  <body onkeydown="if(event.keycode==27) return false;" style="width:1003px;margin-left:auto;margin-right:auto">
	<jsp:include page="incTop.jsp"/>
	<div id=foruminfo>
	
	<c:if test="${empty sessionScope.user}">
	<div id=userinfo>
	<div id=nav><a href="<%=path %>">影视论坛</a>
	</div>
	<p>
		<form action="" name="ThisForm" method="post">
			<input onclick="this.value = ''" tabindex=1	id=userName maxlength=40 size=15 value="用户名" name=username> 
			<input tabindex=2 id=password size=10 type=password name=userPw>
			<input type="button" value="登录" onclick="doLogin()">
		</form>
	</p>
	</div>
	</c:if>
	
	<c:if test="${not empty sessionScope.user}">
<DIV id=userinfo>
<DIV id=nav>欢迎您
--- ${sessionScope.user.userName }</DIV>
<P> 
</P></DIV>		
	</c:if>
	</div>
	
	<div id=ad_text></div>
	<div class="mainbox forumlist">
		<c:forEach items="${requestScope.forumsList}" var="group" varStatus="ss">
			<span class=headactions>
			<img onclick="toggle_collapse('category_${ss.index+1 }');" id=category_1_img title=收起/展开 alt=收起/展开 
				 src="<%=path %>/images/collapsed_no.gif"></span> 
			<h3>${group.name }</h3>
		<table id=category_${ss.index+1 } cellspacing=0 cellpadding=0 summary=category1>
		  <thead class=category>
		  <tr>
		    <th>版块</th>
		    <td class=nums>主题</td>
		    <td class=nums>帖数</td>
		    <td class=lastpost>最后发表</td></tr></thead>
		    <c:forEach items="${group.child}" var="forums">
				<tbody id=forum2>
				<tr>
	    		<th ${forums.style}>
	      		<h2>${forums.name }</h2>
	      		<c:if test="${fn:length(forums.child)>0}">
	      		<p>子版块: 
	      		<c:forEach items="${forums.child}" var="sub">
	      		<a href="<%=path %>/topicview.action?fid=${sub.fid }">${sub.name }</a>&nbsp;&nbsp;
	      		</c:forEach>
	      		</p>
	      		</c:if>
	      		</th>
	    		<td class=nums>${forums.topicNum }</td>
	    		<td class=nums>${forums.threadNum }</td>
	    		<td class=lastpost>
	    		<c:if test="${fn:length(forums.topicList)>0}">
		    		<c:forEach items="${forums.topicList}" var="topic">
						<a href="<%=path %>/threadview.action?pid=${topic.pid }">${topic.subject }</a>
		    			<cite>by ${topic.author } - <fmt:formatDate value="${topic.addtime}" pattern="yyyy-MM-dd HH:mm"/></cite>	    
					</c:forEach>
	    		</c:if>
	    		<c:if test="${fn:length(forums.topicList)==0}">
	    			<cite>从未</cite>
	    		</c:if>
	    		</td></tr></tbody>		    
		    </c:forEach>
 		</table>			
		</c:forEach>
	</div>
 		
		<DIV class=legend><LABEL><IMG alt=有新帖的版块 
		src="<%=path %>/images/forum_new.gif">有新帖的版块</LABEL><LABEL><IMG 
		alt=无新帖的版块 
		src="<%=path %>/images/forum.gif">无新帖的版块</LABEL></DIV></div>
		
		<jsp:include page="incButtom.jsp"/>
  </body>
</html>
