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
    
    <script src="jquery-3.1.1.min.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	function submit(){
    	debugger
    		var str = $('#name').val();
    		alert(str);
    	}
    </script>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <form  meth>
         <input id="name" name="name" placeholder="姓名" required/>
         <input name="studentId" placeholder="学号" required/>
         <input name="passWord" type="password" placeholder="密码" required/>
		 <buttin id="submit" type="submit" onclick="submit()" >注册</button>
    </form>
  </body>
</html>
