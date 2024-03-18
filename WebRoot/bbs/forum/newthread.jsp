<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
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
	<link rel=stylesheet type=text/css href="<%=path%>/css/style_5.css ">
	<link rel=stylesheet type=text/css href="<%=path%>/css/style_5_append.css">
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>		
	<script type=text/javascript src="<%=path%>/js/common.js"></script>
	<script type=text/javascript src="<%=path%>/js/menu.js"></script>
	<script type=text/javascript src="<%=path%>/js/ajax.js"></script>
	<script type="text/javascript">
		function check()
		{
			if(document.postform.subject.value=="")
	        {
	            alert("请输入标题");
	            return false;
	        }
	        document.postform.submit();
		}
	</script>
  </head>
  <body>

<jsp:include page="../incTop.jsp"/>

<DIV id=nav><A href="<%=path %>/bbs/jump.jsp">九重天动漫论坛</A>  » <A 
href="<%=path %>/toAddThread.action?fid=${forums.fid }">${forums.name }</A> 
» 发新话题</DIV>
<BR>
<FORM id=postform  method=post name="postform" action="<%=path %>/threadAdd.action"><INPUT 
id=formhash type=hidden value=A6GhdAQF name=formhash> <INPUT type=hidden 
name=isblog> <INPUT type=hidden value=1 name=frombbs> 
<DIV class="mainbox formbox">
<H1>发新话题</H1>
<TABLE id=newpost cellSpacing=0 cellPadding=0 summary=post>
  <THEAD>
  <TR>
    <TH>用户名</TH>
    <TD>${sessionScope.user.userName } [<A 
      href="">退出登录</A>]</TD></TR></THEAD>
  <TBODY>
  <TR>
    <TH style="BORDER-BOTTOM-WIDTH: 0px"><LABEL for=subject>标题</LABEL></TH>
    <TD style="BORDER-BOTTOM-WIDTH: 0px"><INPUT tabIndex=3 id=subject size=45 
      name=subject></TD></TR>
  <TR>
    <TH style="BORDER-BOTTOM-WIDTH: 0px"><LABEL for=content>內容</LABEL></TH>
    <TD style="BORDER-BOTTOM-WIDTH: 0px">
<FCK:editor instanceName="content"  basePath="/fckeditor" width="500" height="200" value="请输入内容" toolbarSet="Basic">
	                            </FCK:editor>    
    </TD></TR>
  <TBODY>
  <TR class=btns>
    <TH>&nbsp;</TH>
    <TD>
    <input type="hidden" name="fid" value="${forums.fid }">
    <BUTTON 
      tabIndex=300 id=postsubmit type=submit name=topicsubmit 
      value="true">发新话题</BUTTON>&nbsp;&nbsp; 
      &nbsp;    </TD></TR></TBODY></TABLE>
</DIV><BR></FORM>

</DIV>
<jsp:include page="../incButtom.jsp" />
  </body>
</html>
