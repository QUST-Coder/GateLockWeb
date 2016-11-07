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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>科协实验室门禁系统-用户注册</title>
    <link href="/css/metro.min.css" rel="stylesheet">
    <link href="/css/metro-icons.min.css" rel="stylesheet">
    <link href="/css/metro-responsive.min.css" rel="stylesheet">


    <style>
        .login-form {
            width: 25rem;
            height: 20rem;
            position: fixed;
            top: 50%;
            margin-top: -9.375rem;
            left: 50%;
            margin-left: -12.5rem;
            background-color: #ffffff;
            opacity: 0;
            -webkit-transform: scale(.8);
            transform: scale(.8);
        }

    </style>
  </head>
  
<body class="bg-lightBlue">
  <script src="/js/jquery-3.1.1.min.js"></script>
  <script src="/js/metro.min.js"></script>
  <script>
      $(function(){
          var form = $(".login-form");

          form.css({
              opacity: 1,
              "-webkit-transform": "scale(1)",
              "transform": "scale(1)",
              "-webkit-transition": ".5s",
              "transition": ".5s"
          });
      });
  </script>
  <script src="/js/inquery.js"></script>
    <div class="login-form padding20 block-shadow">
        <form>
            <h1 class="text-light">注册您的指纹</h1>
            <hr class="thin"/>
            <br />
            <br />
            <div class="input-control text full-size" data-role="input">
                <label for="user_name">姓名</label>
                <input type="text" name="user_name" id="user_name">
                <button class="button helper-button clear"><span class="mif-cross"></span></button>
            </div>
            <br />
            <br />
            <br />
            <div class="input-control text full-size" data-role="input">
                <label for="user_id">学号</label>
                <input type="text" name="user_id" id="user_id">
                <button class="button helper-button clear"><span class="mif-looks"></span></button>
            </div>
            <br />
        </form>
        <div class="form-actions">
            <button  class="button primary" id="startbutton">开始录入</button>
        </div>
        <p id="status"></p>
    </div>
</body>
</html>
