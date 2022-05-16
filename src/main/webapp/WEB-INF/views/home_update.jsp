<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>信息修改</title>
    <link rel="stylesheet" href="../views/static/common/layui/css/layui.css">
    <link rel="stylesheet" href="../views/static/admin/css/style.css">
    <script src="../views/static/common/layui/layui.js"></script>
    <script src="../views/static/common/jquery-3.3.1.min.js"></script>
    <script src="../views/static/common/vue.min.js"></script>

    <script language="javascript">
        function sumbit_sure(){
            var gnl=confirm("是否确定修改?");
            if (gnl==true){
                return true;
            }else{
                return false;
            }
        }
    </script>

</head>
<body>
<div id="app">
    <!--顶栏-->
    <header>
        <div style="float:left;"><img src="../views/static/admin/img/tubiao.png" width="152" height="55" /></div>
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
            <fieldset class="layui-elem-field layui-field-title">
                <legend>信息修改</legend>
            </fieldset>


            <form class="layui-form " action="${pageContext.request.contextPath}/home/update2" enctype="multipart/form-data"  method="post"  onsubmit="return sumbit_sure()" >

                <div class="layui-form-item">
                    <label class="layui-form-label">房间号</label>
                    <div class="layui-input-block">
                        <input type="text" name="Num" required   value="${h.num}" autocomplete="off" class="layui-input" >
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间类型</label>
                    <div class="layui-input-block">
                        <input type="text" name="H_Type" required  value="${h.h_Type}"  autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">价格</label>
                    <div class="layui-input-block">
                        <input type="text" name="Price" required  value="${h.price}"  autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-block">
                        <input type="radio" name="State" value="空房" title="空房" checked>
                        <input type="radio" name="State" value="预约中" title="预约中">
                        <input type="radio" name="State" value="已预约" title="已预约">
                        <input type="radio" name="State" value="已入住" title="已入住">
                        <input type="radio" name="State" value="未打扫" title="未打扫" >
                     </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间描述</label>
                    <div class="layui-input-inline">
                    <textarea name="Text" class="layui-input"  style="height:250px " autocomplete="off"  required >${h.text}
                    </textarea>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">图片</label>
                        <div   class="layui-input-inline">
                            <input type="file" name="file" >
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="submit" class="layui-btn" value="确认修改" />
                        <input type="button" class="layui-btn layui-btn-danger"  value="取消修改" onclick="javascript:history.go(-1);"/>
                        <input name="id" value="${h.id}" type="hidden"/>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<script src="../views/static/admin/js/config.js"></script>
<script src="../views/static/admin/js/script.js"></script>
</body>
</html>
