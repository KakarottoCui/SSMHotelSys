<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加房间 </title>
    <link rel="stylesheet" href="../views/static/common/layui/css/layui.css">
    <link rel="stylesheet" href="../views/static/admin/css/style.css">
    <script src="../views/static/common/layui/layui.js"></script>
    <script src="../views/static/common/jquery-3.3.1.min.js"></script>
    <script src="../views/static/common/vue.min.js"></script>

    <script language="javascript">
        function sumbit_sure(){
            var gnl=confirm("是否确定提交?");
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
                <legend>添加房间</legend>
            </fieldset>

            <form class="layui-form " action="${pageContext.request.contextPath}/home/add"  enctype="multipart/form-data" method="post" onsubmit="return sumbit_sure()" >

                <div class="layui-form-item">
                    <label class="layui-form-label"></label>
                    <div class="layui-input-block">
                        <img class="pic_url" src="../views/static/common/image/tubiao.png" width="264" height="137" />
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="Num" placeholder="请填写房间号" autocomplete="off" class="layui-input" required>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间类型</label>
                    <div class="layui-input-inline">
                        <select name="H_Type" class="layui-input" autocomplete="off" required >
                            <option value=""></option>
                            <option value="豪华大床房">豪华大床房</option>
                            <option value="高级大床房">高级大床房</option>
                            <option value="普通大床房">普通大床房</option>
                            <option value="豪华套房">豪华套房</option>
                            <option value="标准套房">标准套房</option>
                            <option value="高级三人间">高级三人间</option>
                            <option value="普通三人间">普通三人间</option>
                            <option value="豪华双床房">豪华双床房</option>
                            <option value="高级双床房">高级双床房</option>
                            <option value="普通双床房">普通双床房</option>
                            <option value="豪华圆床房">豪华圆床房</option>
                            <option value="豪华水床房">豪华水床房</option>
                            <option value="高级电脑房">高级电脑房</option>
                            <option value="大床钟点房（四小时）">大床钟点房（四小时）</option>
                            <option value="双床终点房（四小时）">双床终点房（四小时）</option>
                            <option value="大床钟点房（三小时）">大床钟点房（三小时）</option>
                            <option value="双床终点房（三小时）">双床终点房（三小时）</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">价格</label>
                    <div class="layui-input-inline">
                        <input type="text" name="Price" placeholder="请输入价格" autocomplete="off" class="layui-input" required>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-inline">
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
                        <textarea name="Text" class="layui-input" style="height:250px " autocomplete="off"  required>请填写房间相关信息......
                        </textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">图片</label>
                    <div   class="layui-input-inline">
                        <input type="file" name="file" >
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" type="submit">立即提交</button>
                        <button class="layui-btn layui-btn-danger" type="reset">清空内容</button>
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
