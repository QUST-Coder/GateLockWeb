<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>科协实验室门禁系统-用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
  <a>用户注册</a>
    <form action="<c:url value='/UserRegistServlet'/>" accept-charset="UTF-8" method="post">
         <input name="name" placeholder="姓名" required/>
         <input name="studentId" placeholder="学号" required/>
         <input name="passWord" type="password" placeholder="密码" required/>
		 <input type="submit" />
	      ${sessionScope.result}
    </form>
    
  </body>
</html>
