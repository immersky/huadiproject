<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<div class="loader"></div>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>数据可视化</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/fore/edemo-index.css"/>
</head>
<body>
<!-- 头部 -->
<header>
    <h1>院校总览</h1>
    <div class="show-time"></div>
    <script>
        var t = null;
        t = setTimeout(time, 1000); //开始运行
        function time() {
            clearTimeout(t); //清除定时器
            dt = new Date();
            var y = dt.getFullYear();
            var mt = dt.getMonth() + 1;
            var day = dt.getDate();
            var h = dt.getHours(); //获取时
            var m = dt.getMinutes(); //获取分
            var s = dt.getSeconds(); //获取秒
            document.querySelector(".show-time").innerHTML =
                "当前时间：" +
                y +
                "年" +
                mt +
                "月" +
                day +
                "日-" +
                h +
                "时" +
                m +
                "分" +
                s +
                "秒";
            t = setTimeout(time, 1000); //设定定时器，循环运行
        }
    </script>
</header>

<!-- 页面主体 -->
<section class="mainbox">
    <!-- 左侧盒子 -->
    <div class="column">
        <div class="panel bar">
            <h2>热门专业毕业月薪</h2>
            <!-- 图表放置盒子 -->
            <div class="chart"></div>
            <!-- 伪元素绘制盒子下边角 -->
            <div class="panel-footer"></div>
        </div>
        <div class="panel line">
            <h2>一线城市、新一线城市本科毕业生月薪变化
            </h2>
            <div class="chart"></div>
            <div class="panel-footer"></div>
        </div>
        <div class="panel pie">
            <h2>全国各类院校占比</h2>
            <div class="chart"></div>
            <div class="panel-footer"></div>
        </div>
    </div>
    <!-- 中间盒子 -->
    <div class="column">
        <!-- 头部 no模块 -->
        <div class="no">
            <div class="no-hd">
                <ul>
                    <li>3013</li>
                    <li>506</li>
                </ul>
            </div>
            <div class="no-bd">
                <ul>
                    <li>全国总院校数</li>
                    <li>全国开设专业总数</li>
                </ul>
            </div>
        </div>
        <!-- map模块 -->
        <div class="map">
            <div class="map1"></div>
            <div class="map2"></div>
            <div class="map3"></div>
            <div class="chart"></div>
        </div>
    </div>
    <!-- 右侧盒子 -->
    <div class="column">
        <div class="panel bar2">
            <h2>本科院校数TOP5地区</h2>
            <div class="chart"></div>
            <div class="panel-footer"></div>
        </div>
        <div class="panel line2">
            <h2>本科生毕业半年后月收入变化趋势</h2>
            <div class="chart"></div>
            <div class="panel-footer"></div>
        </div>
        <div class="panel pie2">
            <h2>双一流院校地区分布</h2>
            <div class="chart"></div>
            <div class="panel-footer"></div>
        </div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/res/js/fore/edemo-flexible.js"></script>
<script src="${pageContext.request.contextPath}/res/js/fore/edemo-echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/res/js/fore/edemo-jquery.js"></script>

<!-- 引入china.js 完成地图模块 -->
<script src="${pageContext.request.contextPath}/res/js/fore/edemo-china.js"></script>
<script src="${pageContext.request.contextPath}/res/js/fore/edemo-index.js"></script>
</body>
</html>



