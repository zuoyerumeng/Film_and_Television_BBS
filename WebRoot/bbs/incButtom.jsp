<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<DIV id=ad_footerbanner1></DIV>
<DIV id=ad_footerbanner2></DIV>
<DIV id=ad_footerbanner3></DIV>
<DIV id=footer>
<DIV class=wrap>
<DIV id=footlinks>
<%@ page import="java.util.Date" %>
<% Date currentDate = new Date();%>
<P>当前时区 GMT+8, 现在时间是  <%= currentDate %></P>
<P></P></DIV><IMG border=0 
src="<%=path %>/images/jsprun_icon.gif"></A> 

<P id=copyright>Powered by <STRONG>影视论坛</STRONG> <EM>6.0.0</EM> © 2020-2024 影视论坛 Inc. </P>
<P id=debuginfo>Processed in 0.020000 second(s).</P></DIV></DIV>