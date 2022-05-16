<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登陆</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/login.css">
    <script src="${pageContext.request.contextPath}/static/common/layui/layui.js"></script>
</head>

<body id="login">

<div class="login">
    <h2> <strong><font face="仿宋" >温情小筑登录</font></strong></h2>

    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/vip/login" >

        <div class="layui-form-item">
            <input type="text" name="username"  id="username" placeholder="用户名" class="layui-input" required>
            <i class="layui-icon input-icon">&#xe66f;</i>
        </div>

        <div class="layui-form-item">
            <input type="password" name="password" id="password" placeholder="密码"  class="layui-input" required>
            <i class="layui-icon input-icon">&#xe673;</i>
        </div>

        <div class="layui-form-item">
            <button style="width: 100%" class="layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="login" >立即登录</button>
        </div>

        <br>
        <div>
            <span style="font-family: 仿宋;color: #6f6e6e">若没有账号，请先</span><a style="font-family: 仿宋;color: #0f75f3;font-size: larger;font-weight: bold;" href="/jump/vip_register">注册</a>
            <p style="font-family: 仿宋;color: #6f6e6e">ps:如忘记密码,请尽快联系管理人员更正密码</p>
        </div>
    </form>

</div>

</body>

</html>
