<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>充值会员</title>
    <link href="assets/css/vip.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/foot.css">
    <link rel="stylesheet" href="assets/css/header.css">
    <script src="./assets/js/jquery.js"></script>
    <script>
        $(document).ready(function() {
            $(".type").click(function() {
                $(".type").eq($(this).index()).addClass("active").siblings().removeClass("active");
                $(".pay").hide().eq($(this).index()).show();
            });
        });
    </script>
</head>
<body>
<!-- 导航栏 -->
<script>
        $(function () {
            $('.uh').hover(function () {
                $('.pull').css("display","block")
            },function () {
                $('.pull').css("display","none")
                }
            )


            $('.pull').hover(function () {
                $('.pull').css("display","block")
            },function () {
                $('.pull').css("display","none")
            })
        })


    </script>

<header>
    <div class="top">
        <div class="left">
            <div class="logo"><a href=""></a></div>
            <div class="option">
                <div><a href="/music/index">发现音乐</a></div>
                <div><a href="/music/myMusic?userid=${user.getId() }">我的音乐</a></div>
                <div><a href="/music/MV">发现视频</a></div>
                <div><a href="/music/rank">热门排行榜</a></div>
            </div>
        </div>
        <div class="right">
            <a href="/music/search" class="seek" >音乐/视频/用户</a>
            <div class="loginButton" style="display:${none}">
                <a href="javascript:;">用户登陆</a>           
            </div>
           <div class="uh" style="display:${block}">

               <a style="color:none"><img class="userHeader"  src="${user.getHeader()}"></img></a>
            </div>
            	

    	</div>
    	
    	<div class="pull">
            <div class="loginOut" >
                <a  href="/music/myHome">我的主页</a>
            </div>

            <div class="loginOut" >
                <a href="/music/vip">VIP会员</a>
            </div>
            <div class="loginOut" >
                <a href="/music/edit">个人设置</a>
            </div>
            <div class="loginOut" >
                <a href="/music/loginOut">退出</a>
            </div>
        </div>
    	
	</div>

</header>
<div class="vip-box">


    <div class="mine">
        <img alt="" class="head" src="${user.getHeader()}">
        <div class="message">
            <div class="message-title">
                <span class="nickname">${user.getNickName()}</span><span class="vip-icon">vip</span>

                <div class="vip-enable">
                    当前未开通
                </div>

            </div>
        </div>
    </div>
    <div class="recharge">

        <div class="types">
            <div class="type active">
                <p class="line-one">
                    <span class="price">4.8</span>
                    <span>元每月</span>
                    <span class="old">11元</span>
                </p>
                <p class="desc">特惠仅限本月</p>


                <hr style="height:1px;border:none;border-top:1px dashed #d5d5d5;" width="80%"/>
                <p class="month">连续包月</p>
            </div>
            <div class="type">
                <p class="line-one">
                    <span class="price">15</span>
                    <span>元</span>
                </p>
                <p class="desc">&nbsp;</p>


                <hr style="height:1px;border:none;border-top:1px dashed #d5d5d5;" width="80%"/>
                <p class="month">1个月</p>
            </div>
            <div class="type">
                <p class="line-one">
                    <span class="price">40</span>
                    <span>元</span>
                </p>
                <p class="desc">13.33元/月</p>
                <hr style="height:1px;border:none;border-top:1px dashed #d5d5d5;" width="80%"/>
                <p class="month">3个月</p>
            </div>
            <div class="type">
                <p class="line-one">
                    <span class="price">138</span>
                    <span>元</span>


                </p>
                <p class="desc">11.5元/月</p>
                <hr style="height:1px;border:none;border-top:1px dashed #d5d5d5;" width="80%"/>
                <p class="month">12个月</p>
            </div>
        </div>
            <p class="pay-title">支付方式</p>
        <div class="pay-box">
            <div class="pay">
                <img class="pay-ma" src="assets/images/ma1.png" alt="">
                <div class="pay-desc">
                    <p>使用微信、支付宝扫码支付</p>
                    <div class="pay-icon">
                        <img alt="微信支付" src="assets/images/wx.png" width="18px">
                        <img alt="支付宝支付" src="assets/images/zfb.png" width="18px">
                    </div>
                    <span class="pay-price">4.8</span>
                    <span>元</span>
                    <span>(已省<span style="color: red">6.2元</span>)</span>
                </div>
            </div>
        <div class="pay">
            <img class="pay-ma" src="assets/images/ma2.png" alt="">            <div class="pay-desc">
                <p>使用微信、支付宝扫码支付</p>
                <div class="pay-icon">
                    <img src="assets/images/wx.png" alt="微信支付" width="18px">
                    <img src="assets/images/zfb.png" alt="支付宝支付" width="18px">
                </div>
                <span class="pay-price">15</span>
                <span>元</span>
            </div>
        </div>
        <div class="pay">
            <img class="pay-ma" src="assets/images/ma3.png" alt="">            <div class="pay-desc">
                <p>使用微信、支付宝扫码支付</p>
                <div class="pay-icon">
                    <img src="assets/images/wx.png" alt="微信支付" width="18px">
                    <img src="assets/images/zfb.png" alt="支付宝支付" width="18px">
                </div>
                <span class="pay-price">40</span>
                <span>元</span>
            </div>
        </div>
        <div class="pay">
            <img class="pay-ma" src="assets/images/ma4.png" alt="">            <div class="pay-desc">
                <p>使用微信、支付宝扫码支付</p>
                <div class="pay-icon">
                    <img src="assets/images/wx.png" alt="微信支付" width="18px">
                    <img src="assets/images/zfb.png" alt="支付宝支付" width="18px">
                </div>
                <span class="pay-price">138</span>
                <span>元</span>
        </div>
        </div>
    </div>
    <div class="vip-img"></div>
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
            UBDF1812版权所有2019-2099&nbsp;&nbsp;山西优逸客有限公司运营：晋网文[2019]7418-741号违法和不良信息举报电话：0351-8300110 举报邮箱：1442286843@qq.com 不服来206教室单挑
        </div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
    </div>
</div>
</body>

</html>