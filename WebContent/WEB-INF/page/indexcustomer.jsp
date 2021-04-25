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

    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
	<link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>

</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="./index.html">智慧养老院</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">尊敬的：${sessionScope.user_session.username }</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','${ctx }/user/myupdate')">个人信息</a></dd>
              <%-- <dd><a onclick="x_admin_show('购物车','${ctx }/mall/cart')">购物车</a></dd> --%>
              <dd><a onclick="x_admin_show('切换帐号','${ctx}/user/logout">切换帐号</a></dd>
              <dd><a href="${ctx}/user/logout">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a>欢迎登录</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
         
            
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>预约床位</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/bed/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>床位列表</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="${ctx }/bed/mybed">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>已预约床位</cite>
                        </a>
                    </li >
                </ul>
            </li>
            
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>预约陪护</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/bed/yuyue">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>发起预约</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="${ctx }/bed/yuyuelist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>预约历史</cite>
                        </a>
                    </li >
                </ul>
            </li>
            
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>意见投诉</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${ctx }/message/add">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>发起投诉</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="${ctx }/message/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>我的投诉</cite>
                        </a>
                    </li >
                </ul>
            </li>
            
            
            
            
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='${ctx}/mall/product' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">Copyright ©2019 智慧养老院</div>  
    </div>
    <!-- 底部结束 -->
 
</body>
</html>