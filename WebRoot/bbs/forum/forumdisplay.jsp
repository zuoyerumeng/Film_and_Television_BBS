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
		<title>${forums.name }</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta content="ie=7.0000" http-equiv="x-ua-compatible">
		<meta name=generator content="mshtml 11.00.9600.16428">
		<meta name=mssmarttagspreventparsing content=true>
		<meta content=yes http-equiv=msthemecompatible>
		<meta content=ie=7 http-equiv=x-ua-compatible>

		<link rel=stylesheet type=text/css href="<%=path%>/css/style_5.css ">
		<link rel=stylesheet type=text/css
			href="<%=path%>/css/style_5_append.css">
		<script type=text/javascript src="<%=path%>/js/common.js"></script>
		<script type=text/javascript src="<%=path%>/js/menu.js"></script>
		<script type=text/javascript src="<%=path%>/js/ajax.js"></script>
	</head>

	<body>
<jsp:include page="../incTop.jsp" />

<DIV id=foruminfo>
<DIV id=nav>
<P><A id=forumlist href="<%=path %>">九重天动漫论坛</A>  » 
${forums.name }</P>
</DIV></DIV>
<DIV id=ad_text></DIV>
<DIV class=pages_btns><SPAN class=pageback><A title=返回首页 
href="<%=path %>/bbs/jump.jsp">返回首页</A></SPAN> 
<c:if test="${not empty sessionScope.user}">
	<SPAN id=newspecial class=postbtn><A title=发新话题 
	href="<%=path %>/toAddThread.action?fid=${forums.fid }"><IMG 
	alt=发新话题 src="<%=path%>/images/newtopic_zh_CN.gif"></A></SPAN> 
</c:if></DIV>
<DIV id=headfilter>
  </DIV>
<DIV class="mainbox threadlist">
<H1>${forums.name}</H1>
<FORM method=post name=moderate 
action=topicadmin.jsp?action=moderate&amp;fid=4><INPUT type=hidden 
value=forumdisplay name=fromWhere> <INPUT type=hidden 
value=forumdisplay.jsp?fid=4&amp;page=1 name=pageInfo> 
<TABLE id=forum_4 cellSpacing=0 cellPadding=0 summary=forum_4>
  <THEAD class=category>
  <TR>
    <TH class=caption colSpan=3>标题</TH>
    <TD class=author>作者</TD>
    <TD class=nums>回复/查看</TD>
    <TD class=lastpost>最后发表</TD></TR></THEAD>
  <TBODY>
  <c:forEach items="${requestScope.topicList}" var="topic" varStatus="ss">
	<TR id=normalthread_1>
	    <TD class=folder><A title=新窗口打开 
	      href="<%=path %>/threadview.action?pid=${topic.pid }" 
	      target=_blank><IMG src="<%=path%>/images/${topic.style}.gif"></A></TD>
        <TD class=icon>&nbsp;</TD>  
	    <TH class=common><LABEL></LABEL><SPAN id=thread_1><A 
	      href="<%=path %>/threadview.action?pid=${topic.pid }">${topic.subject }</A>&nbsp;&nbsp;&nbsp;</SPAN> 
	    </TH>
		 <TD class=author><cite>${topic.author }</cite><EM><fmt:formatDate value="${topic.addtime}" pattern="yyyy-MM-dd"/> </EM></TD>
		    <TD class=nums><STRONG>${topic.replies }</STRONG> / <EM>${topic.view }</EM></TD>
		    <TD class=lastpost><EM><fmt:formatDate value="${topic.lastsub.addtime}" pattern="yyyy-MM-dd HH:mm"/></EM><CITE>by ${topic.lastsub.author }</CITE></TD></TR>	    
  </c:forEach>
  </TBODY></TABLE></FORM></DIV>
<DIV class=pages_btns>
<c:if test="${not empty sessionScope.user}">
	<SPAN id=newspecial class=postbtn><A title=发新话题 
	href="<%=path %>/toAddThread.action?fid=${forums.fid }"><IMG 
	alt=发新话题 src="<%=path%>/images/newtopic_zh_CN.gif"></A></SPAN> 
</c:if>
</DIV>

<DIV class=legend>
<LABEL><IMG alt=有新回复 src="<%=path%>/images/folder_new.gif">有新回复</LABEL>
<LABEL><IMG alt=无新回复 src="<%=path%>/images/folder_common.gif">无新回复</LABEL>
</DIV>

</DIV>

<jsp:include page="../incButtom.jsp" />
	</body>
</html>
