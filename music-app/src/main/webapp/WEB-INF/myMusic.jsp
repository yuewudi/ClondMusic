<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>我的音乐</title>
    <link rel="stylesheet" href="assets/css/mymusic.css">
    <link rel="stylesheet" href="assets/css/header.css">
    <script src="assets/js/jquery.js"></script>
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



<!--我的音乐-->
<div class="my">
    <div class="my-music">
        <!--音乐列表-->
        <div class="my-music-list">
   
            <!--我的歌单-->
            <div class="my-music-list-list">	
                <a href="javascript:;">收藏的歌曲</a>
                <div class="my-music-list-create">
                    <a href="javascript:;">搜索</a>
                </div>
            </div>
        </div>

        <!--歌单中的歌曲-->
        <div class="my-music-song">
            <div class="my-music-list-music ll-music">
            <div class="mymusic-title">
                <img src="assets/images/109951164082027968 (1).jpg" alt="">
                <div class="mymusic-title-img">
                    <img src="assets/images/26.png" alt="">
                </div>
                <div class="mymusic-title-text">我喜欢的音乐</div>
                <div class="mymusic-title-userimg">
                    <img src="${user.getHeader() }" alt="">
                </div>
                <div class="mymusic-title-username">
                    <a href="javascript:;">${user.getNickName() }</a>
                </div>
                <div class="mymusic-title-datetime">2017-02-16 &nbsp;创建</div>
                <div class="mymusic-btns">
                    <div class="mymusic-btns1">
                        <img src="assets/images/24.png" alt="">
                    </div>
                    <div class="mymusic-btns2">
                        <img src="assets/images/27.png" alt="">
                    </div>
                    <div class="mymusic-btns3">
                        <img src="assets/images/28.png" alt="">
                    </div>
                    <div class="mymusic-btns4">
                        <img src="assets/images/25.png" alt="">
                    </div>
                    <div class="mymusic-btns5">
                        <img src="assets/images/29.png" alt="">
                    </div>
                    <div class="mymusic-btns6">
                        <img src="assets/images/1.png" alt="">
                    </div>

                </div>
            </div>
            <div class="mymusic-list">
                <div class="mymusic-list-text">歌曲列表</div>
                <span>${songs.size() }首歌</span>
                <div class="mymusic-list-text1">播放:
                    <strong>74</strong>
                    次
                </div>
            </div>
            <div class="mymusic-song">
                <div class="mymusic-song-list">
                    <div class="mymusic-song-1"></div>
                    <div class="mymusic-song-2">歌曲标题</div>
                    <div class="mymusic-song-3">时长</div>
                    <div class="mymusic-song-4">歌手</div>
                    <div class="mymusic-song-5">描述</div>
                </div>
                
                <ul class="mymusic-1">
                <c:forEach items="${songs}" var="song" varStatus="stust">
                
                	<li class="mymusic-li-one">
                        <div class="mymusic-li-1">
                            <div class="mymusic-li-2">${stust.count }</div>
                            <img src="assets/images/2.png" alt="">
                        </div>
                        <a href="/music/play?songId=${song.getId() }"><div class="mymusic-li-3">${song.getSongName() }</div></a>
                        <div class="mymusic-li-4">${song.getSongTime() }</div>
                        <a href=""><div class="mymusic-li-5">${song.getSongAuthor() }</div></a>
                        <a href=""><div class="mymusic-li-6">${song.getDescription() }</div></a>
                    </li>
                
                </c:forEach>
                    
                </ul>

            </div>
        </div>
        </div>
    </div>
</div>
<!--新建歌单-->
<div class="create">
    <div class="create-title">
        <div class="create-title-text">新建歌单</div>
    </div>
    <div class="create-name">歌单名:</div>
    <input class="create-name-blank">
    <div class="create-text">可通过"收藏"将音乐添加到歌单中</div>
    <div class="create-btn1">
        <div class="create-btn1-text">新建</div>
    </div>
    <div class="create-btn2">
        <div class="create-btn2-text" onclick="c()">取消</div>
    </div>
    <script>
        function c(){
            var close = document.querySelector(".create");

            close.style.display = "none";
        }
    </script>
</div>
<script>
    $(function () {
        var a = $(".ll");
        var b = $(".ll-music");
        var num = 0;

        a.click(function () {
            num = a.index(this)

            a.css("background","#fff");
            a.eq(num).css("background","#f0f0f0")

            b.css("display","none")
            b.eq(num).css("display","block");
        })
    })
</script>
</body>
</html>