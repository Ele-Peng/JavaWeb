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
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
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
  <div>
        <h1>Gossip ... XD</h1>
        <ul>
        <li>谈天说地不奇怪
        <li>分享讯息也可以
        <li>随意写写表心情
    	</ul>
	</div>
	<%
	String username = (String)session.getAttribute("sessionUser");
	if(username == null){
		request.setAttribute("msg", "拒绝暴力登录");
		request.getRequestDispatcher("/users/Login.jsp").forward(request, response);
		return;
	}
	 %>
	 谢天谢地<%=username %>你终于来了
	 <a href='<c:url value='/user/blabla.jsp'/>'>看看主页~~</a>
  </body>
</html>
