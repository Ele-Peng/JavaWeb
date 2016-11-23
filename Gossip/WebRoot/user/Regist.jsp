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
    
    <title>My JSP 'Regist.jsp' starting page</title>
    
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
  <p style="color=red;font-weight=900"> ${msg } </p>
  <h1>会员注册</h1>
	<form method='post' action="<c:url value='/RegisterServlet'/>">
		<table bgcolor=yellow>
			<tr>
				<td>名称（2~15字符）：</td>
				<td><input type='text' name='username' size='25'
					maxlength='16'>${errors.username }
				</td>
			</tr>
			<tr>
				<td>邮件位址：</td>
				<td><input type='text' name='email' size='25' maxlength='20'>${errors.email }
				</td>
			</tr>
			<tr>
				<td>密码（6到16字符）：</td>
				<td><input type='password' name='password' size='25' maxlength='16'>${errors.password }
				</td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type='password' name='confirmedPassword' size='25' maxlength='16'>${errors.confirmedPassword }
				</td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit' value='submit'>
				</td>
			</tr>
		</table>
	</form>
  
  </body>
</html>
