<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/header.jsp" %>
<head>
    <script src="${pageContext.request.contextPath}/res/js/fore/fore_login.js"></script>
    <link href="${pageContext.request.contextPath}/res/css/fore/fore_login.css" rel="stylesheet">
    <style rel="stylesheet">
        #baseNavigator {
            padding: 22px 0;
            width: 1190px;
            height: 44px;
            margin: auto;
        }

        #baseNavigator img {
            width: 190px;
            margin-top: 8px;
        }

        #nav {
            width: auto;
            height: 32px;
            font-family: "Microsoft YaHei UI", Tahoma, serif;
            font-size: 12px;
            position: relative !important;
            background: #f2f2f2;
            z-index: 999;
            border-bottom: 1px solid #e5e5e5;
        }
    </style>
    <title>高考志愿推荐平台-登录</title>
</head>
<body>
<nav id="baseNavigator">
<%--    <a href="${pageContext.request.contextPath}" target="_self">--%>
<%--        <img src="${pageContext.request.contextPath}/res/images/fore/WebsiteImage/tmallLogoA.png"/>--%>
<%--    </a>--%>
</nav>
<div class="content">
    <div class="contentMain"></div>
    <div class="loginDiv">
        <div class="loginMessage">
        </div>
        <div class="pwdLogin">
            <span class="loginTitle">密码登录</span>
            <form method="post" class="loginForm">
                <div class="loginInputDiv">
                    <label for="name" class="loginLabel"><img
                            src="${pageContext.request.contextPath}/res/images/fore/WebsiteImage/2018-04-27_235518.png"
                            width="38px" height="39px" title="帐号名"/></label>
                    <input type="text" name="name" id="name" class="loginInput" placeholder="账号名">
                </div>
                <div class="loginInputDiv">
                    <label for="password" class="loginLabel"><img
                            src="${pageContext.request.contextPath}/res/images/fore/WebsiteImage/2018-04-27_235533.png"
                            width="38px" height="39px" title="登录密码"/></label>
                    <input type="password" name="password" id="password" class="loginInput">
                </div>
                <input type="submit" class="loginButton" value="登 录">
            </form>
            <div class="loginLinks">
                <a href="${pageContext.request.contextPath}/register">注册</a>
            </div>
            <div class="error_message">
                <p id="error_message_p"></p>
            </div>
        </div>
    </div>
</div>

<link href="${pageContext.request.contextPath}/res/css/fore/fore_foot_special.css" rel="stylesheet"/>
</body>
