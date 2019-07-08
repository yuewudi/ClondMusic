<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="assets/css/friend.css">
 	<link rel="stylesheet" href="assets/css/header.css">
    <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
    <script type="text/javascript" src="assets/js/jquery.js"></script>
        <script src="assets/js/index.js"></script>
    <script src="assets/js/validate.js"></script>
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
    <script type="text/javascript">
        $(document).ready(function(){
                $(".pinglun").click(function (){
                    var i = $(".pinglun").index(this)
               $(".shipingpinglun").eq(i).slideToggle();
                    }
                )
            });

    </script>
</head>
<body>
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
                <div><a href="">热门排行榜</a></div>
            </div>
        </div>
        <div class="right">
            <div class="seek">音乐/视频/用户</div>
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













<div class="denglu">
<div class="denglu-left">

<c:forEach items="${mvs}" var="mv" varStatus="vs" >  
 <div class="yemian">
         <div class="usermp4">
        <img src="${users.get(vs.index).getHeader()}" class="touxiang">
        <div class="xingming">${users.get(vs.index).getNickName()}</div>

        <div class="time">${mv.getMv_time().toString().substring(0,19)}</div>
        <div class="ganyan">${mv.getDescription()}</div>
    <video controls class="shiping0">
        <source src="${mv.getMvUrl()}"  type="video/mp4">
        您的浏览器不支持 HTML5 video 标签。
    </video>
        <a href="javascript:;" class="pinglun">评论(13)</a>
    </div>
    
        <div class="shipingpinglun">
        <div class="pinglunkuang">
            <textarea class="kaung" placeholder="评论"></textarea>
            <input value="评论" type="button" class="butt">
        </div>
        <c:forEach items="${mcss.get(vs.index)}" var="mc" varStatus="vs0" >  
        <div class="lishipinglun">
            <img src="${mcuserss.get(vs.index).get(vs0.index).getHeader()}" class="pinglunHead">
            <div class="pinglunName">${mcuserss.get(vs.index).get(vs0.index).getNickName()}</div>
            <div class="pinglunName">${mc.getContent()}</div>
            <div class="pinglunName">${mc.getComment_time().toString().substring(0,19)}</div>
        </div>
        </c:forEach>  
        <div class="lishipinglun0"></div>   
    </div>
        </div>
</c:forEach>
    
    </div>















    <div class="denglu-right">
        <div class="user">
            <div class="userImage"></div>
            <div class="userName"><b>一百一十一号听众</b></div>
            <a href="" class="shi1">上传</a>
            <a href="" class="shi1">评论</a>
            <a href="" class="shi1">收藏</a>
        </div>

    </div>
    </div>
    <div class="clearfloat"></div>
<div class="clearfloat"></div>

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
            UBDF1812版权所有©2019-2099&nbsp;&nbsp;山西优逸客有限公司运营：晋网文[2019]7418-741号违法和不良信息举报电话：0351-8300110 举报邮箱：1442286843@qq.com 不服来206教室单挑
        </div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
    </div>
</div>

</body>
</html>

