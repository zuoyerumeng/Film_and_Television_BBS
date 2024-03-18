<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>贴子浏览</title>
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
  </head>
  <body>

<jsp:include page="../incTop.jsp"/>

<DIV id=foruminfo>
<DIV id=nav><A id=forumlist 
href="<%=path %>">九重天动漫论坛</A> » <A 
href="<%=path %>/topicview.action?fid=${forums.fid }"">${forums.name }</A> 
» ${topic.subject }</DIV></DIV>
<DIV id=ad_text></DIV><!-- 短消息 -->
<DIV id=append_parent></DIV>
<DIV id=ajaxwaitid></DIV>
<DIV class=pages_btns>
<SPAN 
class=pageback><A title=返回列表 
href="<%=path %>/topicview.action?fid=${forums.fid }"">返回列表</A></SPAN> 
<SPAN 
onmouseover="$('newspecial').id = 'newspecialtmp';this.id = 'newspecial';showMenu(this.id)" 
id=newspecial class=postbtn>
<c:if test="${not empty sessionScope.user}">
	<SPAN id=newspecial class=postbtn><A title=发新话题 
	href="<%=path %>/toAddThread.action?fid=${forums.fid }"><IMG 
	alt=发新话题 src="<%=path%>/images/newtopic_zh_CN.gif"></A></SPAN> 
</c:if>
</SPAN> </DIV>
<FORM method=post name=modactions><INPUT type=hidden value=b29e1c42 
name=formhash> 
<DIV class="mainbox viewthread"><SPAN class=headactions>您是第${topic.view }位阅读者
</SPAN>
<H1>${topic.subject }</H1><INS></INS>
<TABLE id=pid1 cellSpacing=0 cellPadding=0 summary=pid1>
  <TBODY>
  <TR>
    <TD class=postauthor><A name=lastpost></A><CITE><LABEL></LABEL> 
      ${threadsMain.author }</CITE>
      <DIV class=avatar><IMG class=avatar alt="" 
      src="<%=path%>/images/noavatar.gif"></DIV>
      <DL class=profile></DL>
      <P></P>
      </TD>
    <TD class=postcontent>
      <DIV class=postinfo><STRONG id=postnum_1>1 # </STRONG><EM 
      onclick="$('postmessage_1').className='t_bigfont'">大</EM> <EM 
      onclick="$('postmessage_1').className='t_msgfont'">中</EM> <EM 
      onclick="$('postmessage_1').className='t_smallfont'">小</EM> 发表于 <fmt:formatDate value="${threadsMain.addtime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;
      </DIV>
      <DIV id=ad_thread2_0></DIV>
      <DIV class="postmessage defaultpost">
      <DIV id=ad_thread3_0></DIV>
      <DIV id=ad_thread4_0></DIV>
      <H2>${threadsMain.subject }</H2>
      <DIV id=postmessage_1 class=t_msgfont>${threadsMain.content } </DIV></DIV>
      <DIV></DIV></TD></TR>
  <TR>
    <TD class=postauthor>
      </TD>
    <TD class=postcontent>
      </DIV></TD></TR></TBODY></TABLE></DIV></FORM>
      
      <c:forEach items="${requestScope.threadsList}" var="threads" varStatus="ss">
			<div class="mainbox viewthread">
			<table id="pid2" summary="pid2" cellspacing="0" cellpadding="0">
				<tr>
					<td class="postauthor">
						<cite>
						${threads.author }
						</cite>
						<div class="avatar"><img class="avatar" src="<%=path%>/images/noavatar.gif" alt="" ></div>
					</td>
					<td class="postcontent" >
						<div class="postinfo">
							<strong title="" id="postnum_2">
								${ss.index+2 } #
							</strong>
							<em onclick="$('postmessage_2').className='t_bigfont'">大</em>
							<em onclick="$('postmessage_2').className='t_msgfont'">中</em>
							<em	onclick="$('postmessage_2').className='t_smallfont'">小</em>
							发表于 <fmt:formatDate value="${threads.addtime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;
						</div>
						<div id="ad_thread2_1"></div>
						<div class="postmessage defaultpost">
							<div id="ad_thread3_1"></div><div id="ad_thread4_1"></div>
								<div id="postmessage_2" class="t_msgfont">${threads.content }</div>
						</div>
						</div>
					</td>
				</tr>
				<tr>
					<td class="postauthor">
					</td>
					<td class="postcontent">
						<div class="postactions" style="height: 100%">
							<p>
								<strong onclick="scroll(0,0)" title="顶部">TOP</strong>
							</p>
							<div id="ad_thread1_1"></div>
						</div>
					</td>
				</tr>
			</table></div>
			</c:forEach>
<DIV class=pages_btns><SPAN 
class=pageback><A title=返回列表 
href="<%=path %>/topicview.action?fid=${forums.fid }">返回列表</A></SPAN> 
<c:if test="${not empty sessionScope.user}">
	<SPAN id=newspecial class=postbtn><A title=发新话题 
	href="<%=path %>/toAddThread.action?fid=${forums.fid }"><IMG 
	alt=发新话题 src="<%=path%>/images/newtopic_zh_CN.gif"></A></SPAN> 
</c:if>
</DIV>
<c:if test="${not empty sessionScope.user}">
<FORM id=postform method=post action="<%=path %>/replace.action">
<DIV id=quickpost class=box>
<H4>快速回复主题</H4>
<DIV class=postform>
<DIV>

<FCK:editor instanceName="content"  basePath="/fckeditor" width="780" height="200" value="请输入内容" toolbarSet="Basic">
</FCK:editor>  
</DIV>
<P></P>

<P class=btns>
<input type="hidden" name="fid" value="${forums.fid }">
<input type="hidden" name="pid" value="${topic.pid }">
<BUTTON tabIndex=3 id=postsubmit type=submit name=replysubmit 
value="replysubmit">发表回复</BUTTON> </P></DIV>

</DIV></FORM></c:if>
</DIV>

<jsp:include page="../incButtom.jsp" />
  </body>
</html>
