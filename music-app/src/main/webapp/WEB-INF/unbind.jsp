<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>换绑手机</title>
    <link rel="stylesheet" href="assets/css/bind.css">
    <link rel="stylesheet" href="assets/css/foot.css">
    <link rel="stylesheet" href="assets/css/header.css">
    <script src="./assets/js/jquery.js"></script>
</head>
<body>
<!-- 导航栏 -->
<header>
    <div class="top">
        <div class="left">
            <div class="logo"><a href=""></a></div>
            <div class="option">
                <div><a href="">发现音乐</a></div>
                <div><a href="">我的音乐</a></div>
                <div><a href="">朋友</a></div>
                <div><a href="">歌单</a></div>
                <div><a href="">排行榜</a></div>
            </div>
        </div>
        <div class="right">
            <div class="seek">音乐/视频/用户</div>
            <div class="loginButton" style="display:${none}">
                <a href="javascript:;">用户登陆</a>           
            </div>
              <div class="userHeader" style="display:${block};background: url('${user.getHeader()}') no-repeat ;background-size: 60px 60px">
        </div>
    </div>

</header>
<div class="bind-box">
    <div class="bind-title">
        解绑手机
    </div>
    <hr style="height:1px;border:none;border-top:1px dashed #d5d5d5;" width="95%"/>
    <div class="bind-area">
        <p>你已绑定的手机号：18435110027&nbsp;<a href="" style="color: red">获取验证码</a>
        </p>

        <p>验证码：<input type="text" name="code" style="height: 20px;width: 50px">
        </p>
        <p>
            <input type="button" value="解绑" class="submit" onclick="javascript:;">
        </p>
    </div>

</div>
<div class="zuihou">
    <div class="zuihou1">
        <div class="zuihou11"></div>
        <a href="">关于网易</a>&nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="">客户服务</a>&nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="">服务条款</a>&nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="">隐私政策</a>&nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="">版权投诉指引</a>&nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="">意见反馈</a>&nbsp;&nbsp;|
        <div class="zuihou12">
            UBDF1812版权所有2019-2099&nbsp;&nbsp;山西优逸客有限公司运营：晋网文[2019]7418-741号违法和不良信息举报电话：0351-8300110
            举报邮箱：1442286843@qq.com 不服来206教室单挑
        </div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
    </div>
</div>
</body>
</html>