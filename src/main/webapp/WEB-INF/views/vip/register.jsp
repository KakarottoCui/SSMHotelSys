<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/login.css">
    <script src="${pageContext.request.contextPath}/static/common/layui/layui.js"></script>
</head>

<body id="login">

<div class="login">
    <h2> <strong><font face="仿宋" >温情小筑注册</font></strong></h2>

    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/vip/register" >

        <div class="layui-form-item">
            <input type="text" name="account"  id="account" placeholder="用户名" class="layui-input" required>
            <i class="layui-icon input-icon">&#xe66f;</i>
        </div>

        <div class="layui-form-item">
            <input type="password" name="password" id="password" placeholder="密码"  class="layui-input" required>
            <i class="layui-icon input-icon">&#xe673;</i>
        </div>

        <div class="layui-form-item">
            <input type="password" name="confirmPassword" id="confirmPassword" placeholder="确认密码"  class="layui-input" required>
            <i class="layui-icon input-icon">&#xe673;</i>
        </div>

        <div class="layui-form-item">
            <button style="width: 100%" class="layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="register" >立即注册</button>
        </div>
        <br>
        <div>
            <p style="font-family: 仿宋;color: #6f6e6e;visibility: hidden">ps:如忘记密码,请尽快联系管理人员更正密码</p>
        </div>
    </form>

</div>

</body>

</html>
