<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>智慧养老院</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
	<link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">智慧养老院-家属注册</div>
        <div id="darkbannerwrap"></div>
        ${requestScope.message}
        <form method="post" class="layui-form" action="${ctx}/register">
        
            <input name="username" placeholder="姓名" value=""  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
             <input name="loginname" placeholder="用户名" value=""  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
             <input name="phone" placeholder="联系方式" value=""  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
             <input name="address" placeholder="家庭住址" value=""  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            
            
            <br>
            <input value="注册" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr15">
            <input value="返回登陆" lay-submit lay-filter="" onclick="location.href='${ctx}/'" style="width:100%;" type="button">
            <hr class="hr20" >
        </form>
    </div>



    
  
</body>
</html>