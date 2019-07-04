<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>播放</title>
    <link rel="stylesheet" href="assets/css/play.css">
    <link rel="stylesheet" href="assets/css/header.css">
    <script src="assets/js/jquery.js"></script>
        <script src="assets/js/index.js"></script>
    <script src="assets/js/validate.js"></script>
</head>
<body class="play">


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




<div class="play-box">
    <div class="my-music-song">
        <div class="my-music-list-music ll-music">
            <div class="mymusic-title">
                <img src="${song.getSongImage() }"" alt="">
                <div class="mymusic-title-img">
                    <img src="./assets/images/30.png" alt="">
                </div>
                <div class="mymusic-title-text">${song.getSongName() }</div>
                <div class="mymusic-title-username">歌手:
                    <a href="https://www.baidu.com/s?wd=${song.getSongAuthor() }">${song.getSongAuthor() }</a>
                </div>
                <div class="mymusic-btns">
                    <div class="mymusic-btns1">
                        <img src="./assets/images/24.png" alt="">
                    </div>
                    <div class="mymusic-btns2">
                        <img src="assets/images/27.png" alt="">
                    </div>
                    <div class="mymusic-btns3">
                        <img src="./assets/images/28.png" alt="">
                    </div>
                    <div class="mymusic-btns4">
                        <img src="./assets/images/25.png" alt="">
                    </div>
                    <div class="mymusic-btns5">
                        <img src="./assets/images/29.png" alt="">
                    </div>
                    <div class="mymusic-btns6">
                        <img src="./assets/images/1.png" alt="">
                    </div>

                </div>
                
               
            </div>
            
             <div class="play-music">
                <audio controls="controls" autoplay="autoplay" preload="auto">
                    <source src="${song.getSongUrl()}" type="audio/ogg">
                </audio>
            	</div>
            <div class="mymusic-words">
                ${song.getSongWords() }
            </div>
            <div class="mymusic-comment">
                <div class="mymusic-c">
                    <div class="mymusic-comment-title">评论</div>
                    <div class="mymusic-comment-num">
                        共
                        <span>0</span>
                        条评论
                    </div>
                </div>
                <div class="mymusic-comment-text">
                    <div class="mymusic-comment-img">
                    <img src="${user.getHeader() }" alt="" style="width:100%;height:100%;">
                    </div>
                    <textarea name="comm" id="" cols="10" rows="10" class="mymusic-comment-content"></textarea>
                </div>
                <div class="mymusic-comment-icon">
                    <div class="mymusic-comment-icon-1">
                        <div class="mymusic-comment-icon-2">140</div>
                        <div class="mymusic-comment-icon-3">
                            评论
                        </div>
                    </div>
                </div>
            </div>
            <div class="mymusic-comment-t">
                精彩评论
            </div>
            <c:forEach items="${scDTOs}" var="scDTO" varStatus="stust">
					<div class="mymusic-comment-good">
						<div class="mymusic-comment-good-user">
							<img src="${scDTO.getUser().getHeader() }" alt="">
						</div>
						<div class="mymusic-comment-good-name">
							<a href="javascript:;">${scDTO.getUser().getNickName() }&nbsp;
							</a>
						</div>
						<div class="mymusic-comment-good-text">${scDTO.getSongComment().getContent()}</div>
						<div class="mymusic-comment-time">${scDTO.getSongComment().getComment_time().toString().substring(0,19)}
						</div>
						<div class="mymusic-comment-icon"></div>
						<div class="mymusic-comment-reply">
							<a href="javascript:;">回复</a>
						</div>
					</div>

			</c:forEach>
           
        </div>
    </div>
    <div class="my-music-right">

    </div>
</div>
</body>
</html>