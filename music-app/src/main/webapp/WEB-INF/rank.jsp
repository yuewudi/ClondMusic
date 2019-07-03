<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>排行榜</title>
    <link rel="stylesheet" href="./assets/css/rank.css">
    <link rel="stylesheet" href="./assets/css/header.css">
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
<!--排行榜-->
<div class="rank-box">
    <div class="rank">
        <!--榜单-->
        <div class="rank-one">
            <div class="rank-feature">
                <div class="rank-feature-text">云音乐特色榜</div>
            </div>
            <ul class="rank-feature-list">
                <li class="rank-feature-li-1 li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/6.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">云音乐飙升榜</div>
                    <div class="rank-feature-t2">每天更新</div>
                </li>
                <li class="rank-feature-li li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/7.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">云音乐新歌榜</div>
                    <div class="rank-feature-t2">每天更新</div>
                </li>
                <li class="rank-feature-li li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/8.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">网易原创歌曲榜</div>
                    <div class="rank-feature-t2">每周四更新</div>
                </li>
                <li class="rank-feature-li li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/9.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">云音乐热搜榜</div>
                    <div class="rank-feature-t2">每周四更新</div>
                </li>
            </ul>
            <div class="rank-media">
                <div class="rank-media-text">全球媒体榜</div>
            </div>
            <ul class="rank-feature-list">
                <li class="rank-feature-li li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/10.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">江小白YOLO音乐说唱榜</div>
                    <div class="rank-feature-t2">每周五更新</div>
                </li>
                <li class="rank-feature-li li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/11.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">云音乐古典音乐榜</div>
                    <div class="rank-feature-t2">每周五更新</div>
                </li>
                <li class="rank-feature-li li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/12.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">云音乐电音榜</div>
                    <div class="rank-feature-t2">每周五更新</div>
                </li>
                <li class="rank-feature-li li">
                    <div class="rank-feature-img">
                        <img src="./assets/images/13.jpg" alt="正在加载">
                    </div>
                    <div class="rank-feature-t1">抖音排行榜</div>
                    <div class="rank-feature-t2">每周四更新</div>
                </li>
            </ul>
        </div>
        <!--榜单中的歌曲-->
        <div class="rank-two view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/15.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/24.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/27.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/29.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                                <!--<div class="rank-13-12"></div>-->
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                                <!--<div class="rank-13-12"></div>-->
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                                <!--<div class="rank-13-12"></div>-->
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                                <!--<div class="rank-13-12"></div>-->
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                                <!--<div class="rank-13-12"></div>-->
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                                <!--<div class="rank-13-12"></div>-->
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
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
                                <div class="mymusic-comment-img"></div>
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
                            <div class="mymusic-comment-t">精彩评论</div>
                            <div class="mymusic-comment-good">
                                <div class="mymusic-comment-good-user">
                                    <img src="./assets/images/23.jpg" alt="">
                                </div>
                                <div class="mymusic-comment-good-name">
                                    <a href="javascript:;">是老旧么&nbsp;:</a>
                                </div>
                                <div class="mymusic-comment-good-text">有些人表面上看上去一本正经，其实耳机里听的都是法老的歌</div>
                                <div class="mymusic-comment-time">6月15日 00:35</div>
                                <div class="mymusic-comment-icon"></div>
                                <div class="mymusic-comment-reply">
                                    <a href="javascript:;">回复</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="rank-three view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/16.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/(MHCA%7BFI1P%5D%5BH$5J54F5%25UJ.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/FMB_N(482JEJ5H6BNUG5L~6.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/M)DY%5DDYY5~IK(82PM@%60_K~Q.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="rank-four view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/17.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/(MHCA%7BFI1P%5D%5BH$5J54F5%25UJ.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/FMB_N(482JEJ5H6BNUG5L~6.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/M)DY%5DDYY5~IK(82PM@%60_K~Q.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="rank-five view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/18.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/(MHCA%7BFI1P%5D%5BH$5J54F5%25UJ.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/FMB_N(482JEJ5H6BNUG5L~6.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/M)DY%5DDYY5~IK(82PM@%60_K~Q.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="rank-six view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/19.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/(MHCA%7BFI1P%5D%5BH$5J54F5%25UJ.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/FMB_N(482JEJ5H6BNUG5L~6.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/M)DY%5DDYY5~IK(82PM@%60_K~Q.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="rank-seven view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/20.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/(MHCA%7BFI1P%5D%5BH$5J54F5%25UJ.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/FMB_N(482JEJ5H6BNUG5L~6.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/M)DY%5DDYY5~IK(82PM@%60_K~Q.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="rank-eight view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/21.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/(MHCA%7BFI1P%5D%5BH$5J54F5%25UJ.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/FMB_N(482JEJ5H6BNUG5L~6.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/M)DY%5DDYY5~IK(82PM@%60_K~Q.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="rank-nine view">
            <div class="rank-title">
                <div class="rank-title-img">
                    <img src="./assets/images/22.jpg" alt="">
                </div>
                <div class="rank-title-name">云音乐飙升榜</div>
                <div class="rank-title-create">最近更新: &nbsp;06月19日</div>
                <div class="rank-title-create1">(每天更新)</div>
                <div class="rank-title-img1">
                    <img src="./assets/images/(MHCA%7BFI1P%5D%5BH$5J54F5%25UJ.png" alt="">
                </div>
                <div class="rank-title-img2">
                    <img src="./assets/images/FMB_N(482JEJ5H6BNUG5L~6.png" alt="">
                </div>
                <div class="rank-title-img3">
                    <img src="./assets/images/M)DY%5DDYY5~IK(82PM@%60_K~Q.png" alt="">
                </div>
                <div class="rank-title-img4">
                    <img src="./assets/images/1.png" alt="">
                </div>
            </div>
            <div class="rank-list">
                <div class="rank-list1">
                    <div class="rank-11">
                        <div class="rank-11-1">歌曲列表</div>
                        <div class="rank-11-2">100首歌</div>
                        <div class="rank-11-3">播放:
                            <span>12334324</span>次
                        </div>
                    </div>
                    <div class="rank-12">
                        <div class="rank-12-1"></div>
                        <div class="rank-12-2">标题</div>
                        <div class="rank-12-3">时长</div>
                        <div class="rank-12-4">歌手</div>
                        <div class="rank-13">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                        <div class="rank-14">
                            <div class="rank-13-1">
                                <div class="rank-13-11">1</div>
                            </div>
                            <div class="rank-13-2">图图小淘气</div>
                            <div class="rank-13-3">02:53</div>
                            <div class="rank-13-4">Dantez</div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        var li = $(".li")
        var view = $(".view")
        var lit = $(".rank-two")
        var num=0
        li.click(function () {

            num = li.index(this)

            li.css("background","#fff")
            li.eq(num).css("background","#dcdcdc")

            view.css("display","none")
            view.eq(num).css("display","block")

        })
    })
</script>
</body>
</html>