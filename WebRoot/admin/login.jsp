<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>九重天动漫论坛后台管理---用户登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<LINK rel=stylesheet type=text/css href="<%=path %>/css/blue.css">
		<LINK rel=stylesheet type=text/css href="<%=path %>/css/login.css">
		<link rel=stylesheet type=text/css href="<%=path%>/css/style_5_append.css">
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>			
		<script type="text/javascript">
			function doLogin()
			{                           
			     if(document.ThisForm.userName.value=="")
				 {
				 	alert("请输入用户名");
					document.ThisForm.userName.focus();
					return false;
				 }
				 if(document.ThisForm.userPw.value=="")
				 {
				 	alert("请输入密码");
					document.ThisForm.userPw.focus();
					return false;
				 }
				 loginService.adminLogin(document.ThisForm.userName.value,document.ThisForm.userPw.value,callback);
			}
			
			function callback(data)
			{
			    if(data=="no")
			    {
			        alert("用户名或密码错误");
			    }
			    if(data=="yes")
			    {
			        alert("通过验证,系统登录成功");
			        window.location.href="<%=path%>/admin/index.jsp";
			    }
			}	
		</script>
	</head>

	<body>
		<DIV id=l_logo>
			<IMG border=0 src="<%=path %>/images/login_logo.jpg" width=568 height=68>
			</A>
		</DIV>
		<DIV id=l_cbox>
			<DIV id=l_box>
				<FORM id=ThisForm method=post name=ThisForm>
					<INPUT value=CheckLogin type=hidden name=Action>
					<INPUT type=hidden name=ComeUrl>
					<TABLE border=0 cellSpacing=0 cellPadding=0 width=250 align=center
						valign="top">
						<TBODY>
							<TR>
								<TD height=50 align=right style="color: black;">
									用户名：
								</TD>
								<TD>
									&nbsp;&nbsp;
									<INPUT name=userName>
								</TD>
							</TR>
							<TR>
								<TD height=50 align=right style="color: black;">
									密码：
								</TD>
								<TD>
									&nbsp;&nbsp;
									<INPUT type=password name=userPw>
								</TD>
							</TR>
							<TR>
								<TD height=50 colSpan=2 align=middle >
									<INPUT id=en class=l_btn value=登录 type="button" name=en style="color: black;" onclick="doLogin()">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<INPUT id=set class=l_btn value=重置 type="reset" name=set style="color: black;">
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</FORM>
			</DIV>
		</DIV>
	</body>
</html>
