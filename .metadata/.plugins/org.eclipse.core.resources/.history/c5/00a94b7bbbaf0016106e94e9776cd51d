<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <body>
    <div>
        <h1>Gossip ... XD</h1>
        <ul>
        <li>谈天说地不奇怪
        <li>分享讯息也可以
        <li>随意写写表心情
    	</ul>
	</div>
	<div>
	<a href='<c:url value='Regist.jsp'/>'>还不是会员？</a>
	<p style="color=red;font-weight=900"> ${msg } </p>
	<form method='post' action="<c:url value='LoginServlet'/>">
		<table bgcolor= yellow>
			<tr>
				<td colspan='2'>会员登入</td>
			</tr>
			<tr>
				<td>名称：</td>
				<td><input type='text' name='username' value="${user.username }"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type='password' name='password' value="${user.password }"></td>
			</tr>
			<tr>
				<td align='center'><input type='submit' value='submit'></td>
			</tr>
		</table>
	</form>
    </div>
  </body>
</html>
