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
    <form method='post' action='<c:url value='/BlaBla'/>'>
        分享新鲜事...<br>
        <p style="color=red;font-weight=900"> ${msg } </p>
                       讯息要 140 字以内<br> ${requestScope.blablaerrors }
             <%String username = (String)session.getAttribute("sessionUser");
             	request.setAttribute("username",username);
             %>
            <textarea cols='60' rows='4' name='blabla'></textarea><br>
            <button type='submit'>送出</button>
        </form>
        <table style='text-align: left; width: 510px; height: 88px;'
                 border='0' cellpadding='2' cellspacing='2'>
            <thead>
                <tr>
                    <th><hr></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="blah" items="${requestScope.blahs}">
                <tr>
                    <td style='vertical-align: top;'>${blah.username }<br> 
                        <c:out value="${blah.blabla }"/><br>
                        <a href='BlaBla?message=${blah.date }'>删除</a>                                        
                        <hr>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <hr style='width: 100%; height: 1px;'>
  </body>
</html>
