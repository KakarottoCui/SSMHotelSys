<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>退出登陆</title>
    <link rel="stylesheet" href="../../views/static/common/layui/css/layui.css">
    <link rel="stylesheet" href="../../views/static/admin/css/style.css">
    <script src="../../views/static/common/layui/layui.js"></script>
    <script src="../../views/static/common/jquery-3.3.1.min.js"></script>
    <script src="../../views/static/common/vue.min.js"></script>

    <style type="text/css">
        .divForm{
            position: absolute;/*绝对定位*/
            width: 300px;
            height: 200px;

            top: 50%;
            left: 50%;
            margin-top: -150px;
            margin-left: -150px;
        }
    </style>

</head>
<body>
<div id="app">
    <!--顶栏-->
    <header>
        <div style="float:left;"><img src="../../views/static/admin/img/tubiao.png" width="152" height="55" /></div>
        <div style="float: right">
            <i  class="layui-icon  layui-anim layui-anim-rotate layui-anim-loop" style="font-size: 30px; color: #969baa;">&#xe614;</i>&nbsp; &nbsp; &nbsp;
        </div>
    </header>

    <div class="main" id="app">
        <!--左栏-->
        <div class="left">
            <ul class="cl" >
                <!--顶级分类-->
                <li v-for="vo,index in menu" :class="{hidden:vo.hidden}">
                    <a href="javascript:;"  :class="{active:vo.active}"  @click="onActive(index)">
                        <i class="layui-icon" v-html="vo.icon"></i>
                        <span v-text="vo.name"></span>
                        <i class="layui-icon arrow" v-show="vo.url.length==0">&#xe61a;</i> <i v-show="vo.active" class="layui-icon active">&#xe623;</i>
                    </a>
                    <!--子级分类-->
                    <div v-for="vo2,index2 in vo.list">
                        <a href="javascript:;" :class="{active:vo2.active}" @click="onActive(index,index2)" v-text="vo2.name"></a>
                        <i v-show="vo2.active" class="layui-icon active">&#xe623;</i>
                    </div>
                </li>
            </ul>
        </div>
        <!--右侧-->
        <div class="right">

            <div class="divForm">
                <br><br>
            <h2 >是&nbsp;否&nbsp;退&nbsp;出&nbsp;登&nbsp;陆？</h2>
                <br><br>
                <a class="layui-btn layui-btn-sm layui-btn-normal" href="/vip"  type="button" >
                    &nbsp; &nbsp;是&nbsp;&nbsp;</a>

                <a class="layui-btn layui-btn-sm layui-btn-danger" href="/jump/vip_index" type="button"  >
                    &nbsp; &nbsp;否&nbsp;&nbsp;</a>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function shut(){
        window.opener=null;
        window.open('','_self');
        window.close();
    }
</script>

<script src="../../views/static/vip/js/config.js"></script>
<script src="../../views/static/admin/js/script.js"></script>
</body>
</html>
