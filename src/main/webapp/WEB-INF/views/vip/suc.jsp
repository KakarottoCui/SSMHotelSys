<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>温馨提示</title>
    <style type="text/css">
        html {
            background: #eee
        }

        body {
            background: #fff;
            color: #333;
            font-family: "微软雅黑", "Microsoft YaHei", sans-serif;
            margin: 2em auto;
            padding: 1em 2em;
            max-width: 700px;
            -webkit-box-shadow: 10px 10px 10px rgba(0, 0, 0, .13);
            box-shadow: 10px 10px 10px rgba(0, 0, 0, .13);
            opacity: .8
        }

        h1 {
            border-bottom: 1px solid #dadada;
            clear: both;
            color: #666;
            font: 24px "微软雅黑", "Microsoft YaHei",, sans-serif;
            margin: 30px 0 0 0;
            padding: 0;
            padding-bottom: 7px
        }

        #error-page {
            margin-top: 50px
        }

        h3 {
            text-align: center
        }

        #error-page p {
            font-size: 9px;
            line-height: 1.5;
            margin: 25px 0 20px
        }

        #error-page code {
            font-family: Consolas, Monaco, monospace
        }

        ul li {
            margin-bottom: 10px;
            font-size: 9px
        }

        a {
            color: #21759B;
            text-decoration: none;
            margin-top: -10px
        }

        a:hover {
            color: #D54E21
        }

        .button {
            background: #f7f7f7;
            border: 1px solid #ccc;
            color: #555;
            display: inline-block;
            text-decoration: none;
            font-size: 9px;
            line-height: 26px;
            height: 28px;
            margin: 0;
            padding: 0 10px 1px;
            cursor: pointer;
            -webkit-border-radius: 3px;
            -webkit-appearance: none;
            border-radius: 3px;
            white-space: nowrap;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-box-shadow: inset 0 1px 0 #fff, 0 1px 0 rgba(0, 0, 0, .08);
            box-shadow: inset 0 1px 0 #fff, 0 1px 0 rgba(0, 0, 0, .08);
            vertical-align: top
        }

        .button.button-large {
            height: 29px;
            line-height: 28px;
            padding: 0 12px
        }

        .button:focus, .button:hover {
            background: #fafafa;
            border-color: #999;
            color: #222
        }

        .button:focus {
            -webkit-box-shadow: 1px 1px 1px rgba(0, 0, 0, .2);
            box-shadow: 1px 1px 1px rgba(0, 0, 0, .2)
        }

        .button:active {
            background: #eee;
            border-color: #999;
            color: #333;
            -webkit-box-shadow: inset 0 2px 5px -3px rgba(0, 0, 0, .5);
            box-shadow: inset 0 2px 5px -3px rgba(0, 0, 0, .5)
        }

        table {
            table-layout: auto;
            border: 1px solid #333;
            empty-cells: show;
            border-collapse: collapse
        }

        th {
            padding: 4px;
            border: 1px solid #333;
            overflow: hidden;
            color: #333;
            background: #eee
        }

        td {
            padding: 4px;
            border: 1px solid #333;
            overflow: hidden;
            color: #333
        }

        .text-right {
            text-align: right;
        }
    </style>
    <script src="../../views/static/common/jquery-3.3.1.min.js"></script>
</head>
<body id="error-page">
<div class="row">
    <input id="url" type="hidden" value="${url}">
    <div class="panel-body">
        <h1>:)</h1><h4 class="success">${result}</h4>
        <h4 class="detail"></h4>
        <h4 class="jump">
            页面自动 <a id="href" href="javascript:back()">跳转</a> 等待时间： <b id="wait">3</b>
        </h4>
        <p class="text-right">--温情小筑--</p>
        <p class="text-right">联系电话：178********</p>
    </div>
</div>
<script type="text/javascript">
    (function () {
        var wait = document.getElementById('wait');
        var interval = setInterval(function () {
            var time = --wait.innerHTML;
            if (time <= 0) {
                back();
                clearInterval(interval);
            }
            ;
        }, 1000);
    })();

    function back() {
        var url = $("#url").val();
        if (url === '' || url === null || url === undefined) {
            window.history.go(-1);
        } else {
            window.location.href = "${pageContext.request.contextPath}" + url;
        }
    }
</script>
</body>
</html>
