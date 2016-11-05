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
    
    <title>科协实验室门禁系统-管理员登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
  <a>管理员登录</a>
    <form action="<c:url value='/LoginServlet'/>" accept-charset="UTF-8" method="post">

         <input name="id" placeholder="管理员帐号" required/>
         <input name="passWord" type="password" placeholder="管理员密码" required/>
		 <input type="submit" />
    </form>
      		${sessionScope.adminresult}
    
  </body>
</html>
