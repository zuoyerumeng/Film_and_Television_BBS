<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String imgPath = path+"/images";
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
	<script type=text/javascript src="<%=path %>/js/iframe.js"></script>
	<script>
	var collapsed = getcookie('collapse');
	function collapse_change(menucount) {
		if($('menu_' + menucount).style.display == 'none') {
			$('menu_' + menucount).style.display = '';collapsed = collapsed.replace('[' + menucount + ']' , '');
			$('menuimg_' + menucount).src = '<%=imgPath%>/menu_reduce.gif';
		} else {
			$('menu_' + menucount).style.display = 'none';collapsed += '[' + menucount + ']';
			$('menuimg_' + menucount).src = '<%=imgPath%>/menu_add.gif';
		}
		setcookie('collapse', collapsed, 2592000);
	}
	</script>	
  </head>
  
  <body>
	<table class=leftmenulist style="margin-bottom: 5px" cellspacing=0 cellpadding=0 width=146 align=center border=0>
	  <tbody>
	  <tr class=leftmenutext>
	    <td>
	      <div align=center>
	      <a href="<%=path %>" target=_blank>论坛首页</a>&nbsp;&nbsp;
	      <a href="javascript:void()">后台首页</a></div></td></tr></tbody></table>
	      
	<div id=forums>
	<table class=leftmenulist style="margin-bottom: 5px" cellspacing=0 cellpadding=0 
		   width=146 align=center border=0>
	  <tbody>
	  <tr class=leftmenutext>
	    <td><a onclick=collapse_change(1) href="#"><img 
	      id=menuimg_1 border=0 src="<%=imgPath %>/menu_reduce.gif"></a>&nbsp;
	        <a onclick=collapse_change(1) href="#">分区管理</a></td></tr>
	  <tbody id=menu_1>
	  <tr class=leftmenutd>
	    <td>
	      <table class=leftmenuinfo cellspacing=0 cellpadding=0 border=0>
	        <tbody>
	        <tr>
	          <td><a href="<%=path %>/toAddForums.action?type=group" 
	            target=main>分区添加</a></td></tr> 
	        <tr>
	          <td><a href="<%=path %>/forumsMana.action?type=group" 
	            target=main>分区管理</a>
	          </td></tr></tbody></table></td></tr></tbody></table>
	            
	<table class=leftmenulist style="margin-bottom: 5px" cellspacing=0 cellpadding=0 
		   width=146 align=center border=0>
	  <tbody>
	  <tr class=leftmenutext>
	    <td><a onclick=collapse_change(2) href="#"><img 
	      id=menuimg_2 border=0 src="<%=imgPath %>/menu_reduce.gif"></a>&nbsp;
	        <a onclick=collapse_change(2) href="#">版块管理</a></td></tr>
	  <tbody id=menu_2>
	  <tr class=leftmenutd>
	    <td>
	      <table class=leftmenuinfo cellspacing=0 cellpadding=0 border=0>
	        <tbody>
	        <tr>
	          <td><a href="<%=path %>/toAddForums.action?type=forum" 
	            target=main>版块添加</a></td></tr> 
	        <tr>
	          <td><a href="<%=path %>/forumsMana.action?type=forum" 
	            target=main>版块管理</a>
	          </td></tr></tbody></table></td></tr></tbody></table>
	          
	<table class=leftmenulist style="margin-bottom: 5px" cellspacing=0 cellpadding=0 
		   width=146 align=center border=0>
	  <tbody>
	  <tr class=leftmenutext>
	    <td><a onclick=collapse_change(3) href="#"><img 
	      id=menuimg_3 border=0 src="<%=imgPath %>/menu_reduce.gif"></a>&nbsp;
	        <a onclick=collapse_change(3) href="#">子版块管理</a></td></tr>
	  <tbody id=menu_3>
	  <tr class=leftmenutd>
	    <td>
	      <table class=leftmenuinfo cellspacing=0 cellpadding=0 border=0>
	        <tbody>
	        <tr>
	          <td><a href="<%=path %>/toAddForums.action?type=sub" 
	            target=main>子版块添加</a></td></tr> 
	        <tr>
	          <td><a href="<%=path %>/forumsMana.action?type=sub" 
	            target=main>子版块管理</a></td></tr></tbody></table></td></tr></tbody></table>
	            
	<table class=leftmenulist style="margin-bottom: 5px" cellspacing=0 cellpadding=0 
		   width=146 align=center border=0>
	  <tbody>
	  <tr class=leftmenutext>
	    <td><a onclick=collapse_change(4) href="#"><img 
	      id=menuimg_4 border=0 src="<%=imgPath %>/menu_reduce.gif"></a>&nbsp;
	        <a onclick=collapse_change(4) href="#">主题管理</a></td></tr>
	  <tbody id=menu_4>
	  <tr class=leftmenutd>
	    <td>
	      <table class=leftmenuinfo cellspacing=0 cellpadding=0 border=0>
	        <tbody>
	        <tr>
	          <td><a href="<%=path %>/topicMana.action" 
	            target=main>主题管理</a></td></tr></tbody></table></td></tr></tbody></table>
	            
	<table class=leftmenulist style="margin-bottom: 5px" cellspacing=0 cellpadding=0 
		   width=146 align=center border=0>
	  <tbody>
	  <tr class=leftmenutext>
	    <td><a onclick=collapse_change(5) href="#"><img 
	      id=menuimg_5 border=0 src="<%=imgPath %>/menu_reduce.gif"></a>&nbsp;
	        <a onclick=collapse_change(5) href="#">会员管理</a></td></tr>
	  <tbody id=menu_5>
	  <tr class=leftmenutd>
	    <td>
	      <table class=leftmenuinfo cellspacing=0 cellpadding=0 border=0>
	        <tbody>
	        <tr>
	          <td><a href="<%=path %>/userMana.action" 
	            target=main>会员管理</a></td></tr></tbody></table></td></tr></tbody></table>
	            
	            </div>	      
  </body>
</html>
