<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <title>系统登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="<%=path %>/css/reset.css">
        <link rel="stylesheet" href="<%=path %>/css/supersized.css">
        <link rel="stylesheet" href="<%=path %>/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>系统登录</h1>
            <form action="<%=path %>/login/do" method="post">
                <input type="text" name="username" class="username" placeholder="请输入您的用户名！">
                <input type="password" name="password" class="password" placeholder="请输入您的用户密码！">
                <button type="submit" class="submit_button">登录</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="<%=path %>/js/jquery.min.js" ></script>
        <script src="<%=path %>/js/supersized.3.2.7.min.js" ></script>
        <script src="<%=path %>/js/supersized-init.js" ></script>
        <script src="<%=path %>/js/scripts.js" ></script>
    </body>
</html>