<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>我的主页</title>
<link rel="stylesheet" href="assets/css/myhome.css">
<link rel="stylesheet" href="assets/css/foot.css">
<link rel="stylesheet" href="assets/css/header.css">
    <script src="assets/js/jquery.js"></script>
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
<script>
	$(document).ready(
			function() {
				$("#listen-top-all").hide();
				$("#listen-top-week").hide().show();
				$(".tab").click(
						function() {
							$(".tab").eq($(this).index()).addClass("onshow")
									.siblings().removeClass("onshow");
							if ($(this).index() == 0) {
								$("#listen-top-all").hide();
								$("#listen-top-week").hide().show();
							} else {
								$("#listen-top-week").hide();
								$("#listen-top-all").hide().show();
							}

						});
			});
</script>
</head>
<body>
	<!-- 导航栏 -->
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
	<div class="home-box">
		<div class="mine">
			<img src="${user.getHeader()}" alt="" class="head">
			<div class="message">
				<div class="message-title">
					<span class="nickname">${user.getNickName()}</span> <span
						class="lv">Lv.${user.getGrade() }</span> <span class="sex">
						<c:if test="${user.isSex() eq 'true' }"><span style=" color: dodgerblue">♂</span></c:if>
						<c:if test="${user.isSex() eq 'false' }"><span style=" color: pink">♀</span></c:if></span> <a class="edit"
						href="/music/edit">编辑个人资料</a>
					<div class="hr"></div>
					<div class="message-no">账号：${user.getAccount() }</div>
					<div class="message-phone">
						手机：
						<c:if test="${user.getPhone() == 0  }">暂未添加</c:if>
						<c:if test="${user.getPhone() != 0  }">${user.getPhone() }</c:if>
					</div>
					<div class="message-introduce">个人介绍：${user.getDescription() }
					</div>
				</div>
			</div>
		</div>
		<div class="my-title">
			<span>听歌排行</span> <span class="total">累积听歌${playRecordSongs.size()}首</span> <span
				class="time"><a href="javascript:;" class="tab onshow">最近一周</a>&nbsp;|&nbsp;<a
				href="javascript:;" class="tab">所有时间</a></span>
		</div>
		<div class="table-position">
			<div class="song-table" id="listen-top-week">
				<c:forEach items="${playRecordSongsInWeek}"
					var="playRecordSongInWeek" varStatus="id">
					<div class="song">
						<span class="song-no">${id.count}.</span> <a class="song-name"
							href="/music/play?songId=${playRecordSongInWeek.getId()}">${playRecordSongInWeek.getSongName()}</a> <span
							class="singer">-${playRecordSongInWeek.getSongAuthor()}</span> <span
							class="count">${playRecordSongInWeek.getCount()}次</span>
					</div>
				</c:forEach>

			</div>
			<div class="song-table" id="listen-top-all">
				<c:forEach items="${playRecordSongs}" var="playRecordSong" varStatus="id">
					<div class="song">
						<span class="song-no">${id.count}.</span> <a class="song-name"
							href="/music/play?songId=${playRecordSong.getId()}">${playRecordSong.getSongName()}</a> <span class="singer">-${playRecordSong.getSongAuthor()}</span>

						<span class="count">${playRecordSong.getCount()}次</span>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="my-title">
			<span>我上传的歌</span>   <a href="uploadSong" style="float:right;font-size:12px">去上传>></a>
		</div>
		<div class="song-table" id="upload">
			<c:forEach items="${uploadSongs}" var="uploadSong" varStatus="id">
					<div class="song">
						<span class="song-no">${id.count}.</span> <a class="song-name"
							href="/music/play?songId=${uploadSong.getId()}">${uploadSong.getSongName()}</a> <span class="singer">-${uploadSong.getSongAuthor()}</span>
					</div>
				</c:forEach>
		</div>
		<div class="my-title">
			<span>我收藏的歌</span>
		</div>
		<div class="song-table" id="favorite">
			<c:forEach items="${collectSongs}" var="collectSong" varStatus="id">
			<div class="song">
				<span class="song-no">${id.count}.</span> <a class="song-name" href="/music/play?songId=${collectSong.getId()}">${collectSong.getSongName()}</a>
				<span class="singer">-${collectSong.getSongAuthor()}</span>

			</div>
		</c:forEach>
		</div>
		<br>
	</div>
	<div class="zuihou">
		<div class="zuihou1">
			<div class="zuihou11"></div>
			<a href="">关于网易</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="">客户服务</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="">服务条款</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="">隐私政策</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="">版权投诉指引</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="">意见反馈</a>&nbsp;&nbsp;|
			<div class="zuihou12">
				UBDF1812版权所有2019-2099&nbsp;&nbsp;山西优逸客有限公司运营：晋网文[2019]7418-741号违法和不良信息举报电话：0351-8300110
				举报邮箱：1442286843@qq.com 不服来206教室单挑</div>
			<div class="zuihou13"></div>
			<div class="zuihou13"></div>
			<div class="zuihou13"></div>
			<div class="zuihou13"></div>
		</div>
	</div>
</body>
</html>