<%@ page language="java" pageEncoding="UTF-8"%>
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
		<link id=css rel=stylesheet type=text/css href="<%=path %>/css/admincp.css">
		<script type=text/javascript src="<%=path %>/js/common.js"></script>
		<script type=text/javascript src="<%=path %>/js/menu.js"></script>	
		<script>
		var menus = new Array('forums', 'users', 'posts', 'extends', 'others', 'safety', 'tools', 'home');
		function togglemenu(id) {
			if(parent.menu) {
				for(k in menus) {
					if(parent.menu.document.getElementById(menus[k])) {
						parent.menu.document.getElementById(menus[k]).style.display = menus[k] == id ? '' : 'none';
					}
				}
			}
		}
		function sethighlight(n) {
			var lis = document.getElementsByTagName('li');
			for(var i = 0; i < lis.length; i++) {
				lis[i].id = '';
			}
			lis[n].id = 'menuon';
		}
		</script>
	</head>
	<body>
		<table class=topmenubg cellspacing=0 cellpadding=0 width="100%"	border=0>
			<tbody>
				<tr>
					<td rowspan=2 width=160>
						<div class=logo>
							<img class=logoimg border=0 alt=九重天动漫论坛 src="<%=path %>/images/logo.gif">
							<span class=editiontext>九重天动漫论坛 
								<span class=editionnumber>6.0.0</span>
								<br>系统设置
							</span>
						</div>
					</td>
					<td>
						
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
