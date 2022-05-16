<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>房间列表</title>
    <link rel="stylesheet" href="../../views/static/common/layui/css/layui.css">
    <link rel="stylesheet" href="../../views/static/admin/css/style.css">
    <script src="../../views/static/common/layui/layui.js"></script>
    <script src="../../views/static/common/jquery-3.3.1.min.js"></script>
    <script src="../../views/static/common/vue.min.js"></script>

</head>
<body>
<div id="app">
    <!--顶栏-->
    <header>
        <div style="float:left;"><img src="../../views/static/admin/img/tubiao.png" width="152" height="55"/></div>
        <div style="float: right">
            <i class="layui-icon  layui-anim layui-anim-rotate layui-anim-loop"
               style="font-size: 30px; color: #969baa;">&#xe614;</i>&nbsp; &nbsp; &nbsp;
        </div>
    </header>

    <div class="main" id="app">
        <!--左栏-->
        <div class="left">
            <ul class="cl">
                <!--顶级分类-->
                <li v-for="vo,index in menu" :class="{hidden:vo.hidden}">
                    <a href="javascript:;" :class="{active:vo.active}" @click="onActive(index)">
                        <i class="layui-icon" v-html="vo.icon"></i>
                        <span v-text="vo.name"></span>
                        <i class="layui-icon arrow" v-show="vo.url.length==0">&#xe61a;</i> <i v-show="vo.active"
                                                                                              class="layui-icon active">&#xe623;</i>
                    </a>
                    <!--子级分类-->
                    <div v-for="vo2,index2 in vo.list">
                        <a href="javascript:;" :class="{active:vo2.active}" @click="onActive(index,index2)"
                           v-text="vo2.name"></a>
                        <i v-show="vo2.active" class="layui-icon active">&#xe623;</i>
                    </div>
                </li>
            </ul>
        </div>
        <!--右侧-->
        <div class="right">
            <div class="layui-row">
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>房间列表</legend>
                </fieldset>

                <%--搜索--%>
                <form method="post" action="${pageContext.request.contextPath}/vip/home/find">
                    <div class="layui-col-lg4" style="float: right">
                        <div>
                            <span style="color: red; font-weight: bold"> &nbsp;${error}</span>
                        </div>
                        <div class="layui-input-inline" style="width:320px ;float: left">
                            <input type="number" name="findByNum" placeholder="输入房间号进行查询" class="layui-input key" required>
                        </div>
                        <div style="float: right">
                            <button type="submit" class="layui-btn " style="width: 100px">查询</button>
                        </div>
                    </div>
                </form>

            </div>

            <%--表格--%>
            <table class="layui-table layui-form">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>房间号</th>
                    <th>房间类型</th>
                    <th>价格</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${list}" var="h">
                    <tr class="id84">
                        <td>${h.id}</td>
                        <td style="font-weight: bold">${h.num}</td>
                        <td style="width: 18%">${h.h_Type}</td>
                        <td>${h.price}</td>
                        <td style="font-size: 15px">${h.state}</td>
                        <td style="width: 17%">
                            <a href="${pageContext.request.contextPath}/vip/home/show?id=${h.id}">详细信息</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/vip/home/appoint?id=${h.id}">预约</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>

<script>
    $("td:contains('空房')").css("color", "rgb(76,119,229)");
    $("td:contains('预约中')").css("color", "rgba(44,116,193,0.93)");
    $("td:contains('已预约')").css("color", "rgba(193,46,46,0.93)");
    $("td:contains('已入住')").css("color", "rgba(193,46,46,0.93)");
    $("td:contains('未打扫')").css("color", "#bdb68a");
</script>

<script src="../../views/static/vip/js/config.js"></script>
<script src="../../views/static/admin/js/script.js"></script>
</body>
</html>
