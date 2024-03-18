<%@ page language="java"  pageEncoding="UTF-8"%>
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
		<meta content="ie=5.0000" http-equiv="x-ua-compatible">
		<meta name=generator content="mshtml 11.00.9600.16428">
		<script type=text/javascript src="<%=path%>/js/common.js"></script>
		<script type=text/javascript src="<%=path%>/js/iframe.js"></script>
	</head>
	<body style="overflow-x: hidden; overflow-y: hidden; margin: 0px">
		<div style="height: 65px; width: 100%; position: absolute; left: 0px; z-index: 2; top: 0px">
			<iframe id=header style="height: 65px; width: 100%; z-index: 1; visibility: inherit"
				src="frame/admincp.jsp" frameborder=0 name=header scrolling=no></iframe>
		</div>
		<table style="table-layout: fixed" height="100%" cellspacing=0
			cellpadding=0 width="100%" border=0>
			<tbody>
				<tr>
					<td height=65 width=165></td>
					<td></td>
				</tr>
				<tr>
					<td>
						<iframe id=menu	style="overflow: auto; height: 100%; width: 100%; z-index: 1; visibility: inherit"
							src="frame/adminmenu.jsp" frameborder=0	name=menu scrolling=yes></iframe>
					</td>
					<td>
						<iframe id=main	style="overflow: auto; height: 100%; width: 100%; z-index: 1; visibility: inherit"
							src="frame/adminmain.jsp" frameborder=0	name=main scrolling=yes></iframe>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
