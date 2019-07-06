<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <span class="nickname">${user.getNickName()}</span>
                <c:if test="${vipStatus == 0 }"><span class="vip-icon">vip</span></c:if>
				<c:if test="${vipStatus!= 0  }"><span class="vip-icon" style="color:red">vip</span></c:if>
                <div class="vip-enable">
                				<c:if test="${vipStatus == 0 }">当前未开通</c:if>
						<c:if test="${vipStatus!= 0  }">${endTime}到期,您可以续费</c:if>
                
                </div>

            </div>
        </div>
    </div>
    <div class="recharge">

        <div class="types">
            <div class="type active">
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
                    <span class="price">75</span>
                    <span>元</span>
                </p>
                <p class="desc">12.5元/月</p>
                <hr style="height:1px;border:none;border-top:1px dashed #d5d5d5;" width="80%"/>
                <p class="month">6个月</p>
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
                <form name=vip1pay action="/music/gopay" method=post target="_blank">
                <div class="pay-desc">
                    <p>支持使用支付宝支付,您需要支付：</p>
                    <div class="pay-icon">
                        <img alt="支付宝支付" src="assets/images/zfb.png" width="18px">
                    </div>
                    <span class="pay-price">15</span>
                    <span>元</span> 
                </div>
                  <input type="hidden" name="userId" value="${user.getId() }">
               <input type="hidden" name="amount" value="15">
               <input type="hidden" name="subject" value="优逸云音乐会员1个月">
               <input type="hidden" name="body" value="30天内可以畅听全站歌曲">
                <input type="submit" value="去支付" class="pay-button">
            </form>
            </div>
        <div class="pay">
                        <form name=vip3pay action="/music/gopay" method=post target="_blank">
					<div class="pay-desc">
		        <p>支持使用支付宝支付,您需要支付：</p>
						<div class="pay-icon">
							<img src="assets/images/zfb.png" alt="支付宝支付" width="18px">
						</div>
						<span class="pay-price">40</span> <span>元</span> <span>(已省<span
							style="color: red">5元</span>)
						</span>
					</div>
					 <input type="hidden" name="userId" value="${user.getId() }">
				<input type="hidden" name="amount" value="40">
               <input type="hidden" name="subject" value="优逸云音乐会员3个月">
               <input type="hidden" name="body" value="90天内可以畅听全站歌曲">
                <input type="submit" value="去支付" class="pay-button">
                </form>
		</div>
        <div class="pay">
                        <form name=vip6pay action="/music/gopay" method=post target="_blank">
		<div class="pay-desc">
         <p>支持使用支付宝支付,您需要支付：</p>
                <div class="pay-icon">

                    <img src="assets/images/zfb.png" alt="支付宝支付" width="18px">
                </div>
                <span class="pay-price">75</span>
                <span>元</span>
                 <span>(已省<span style="color: red">15元</span>)</span>
            </div>
             <input type="hidden" name="userId" value="${user.getId() }">
            <input type="hidden" name="amount" value="75">
               <input type="hidden" name="subject" value="优逸云音乐会员6个月">
               <input type="hidden" name="body" value="180天内可以畅听全站歌曲">
                <input type="submit" value="去支付" class="pay-button">
                </form>
        </div>
        <div class="pay">
                        <form name=vip12pay action="/music/gopay" method=post target="_blank">
<div class="pay-desc">
        <p>支持使用支付宝支付,您需要支付：</p>
                <div class="pay-icon">
          
                    <img src="assets/images/zfb.png" alt="支付宝支付" width="18px">
                </div>
                <span class="pay-price">138</span>
                <span>元</span>
                 <span>(已省<span style="color: red">42元</span>)</span>
        </div>
         <input type="hidden" name="userId" value="${user.getId() }">
<input type="hidden" name="amount" value="138">
               <input type="hidden" name="subject" value="优逸云音乐会员12个月">
               <input type="hidden" name="body" value="360天内可以畅听全站歌曲">
                <input type="submit" value="去支付" class="pay-button">
                </form>
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