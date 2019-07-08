<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>上传歌曲</title>
    <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="assets/css/uploadSong.css">
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
<script type="text/javascript">
	var songTime;
	$(function() {
		$('#songFile')
				.change(
						function() {
							//获取input file的files文件数组;
							//$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
							//这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
							var file = $('#songFile').get(0).files[0];
							//创建用来读取此文件的对象
							var reader = new FileReader();
							//使用该对象读取file文件
							reader.readAsDataURL(file);
							//读取文件成功后执行的方法函数
							reader.onload = function(e1) {
								//读取成功后返回的一个参数e，整个的一个进度事件
								console.log(e1);
								//选择所要显示音乐，要赋值给img的src就是e中target下result里面
								//的base64编码格式的地址
								$('#player')
										.html(
												'<audio id="song" controls="controls" controlsList="nodownload" src='+e1.target.result+'/>');
								var time;
								$("#song").on("canplay", function() {
									time = $('#song').get(0).duration;
									//分钟
									var minute = time / 60;
									var minutes = parseInt(minute);
									if (minutes < 10) {
										minutes = "0" + minutes;
									}
									//秒
									var second = time % 60;
									var seconds = Math.floor(second);
									if (seconds < 10) {
										seconds = "0" + seconds;
									}
									songTime=minutes+"："+seconds;
								})

							}
						});

		$('#songImgFile').change(function() {
			//获取input file的files文件数组;
			//$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
			//这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
			var file = $('#songImgFile').get(0).files[0];
			//创建用来读取此文件的对象
			var reader = new FileReader();
			//使用该对象读取file文件
			reader.readAsDataURL(file);
			//读取文件成功后执行的方法函数
			reader.onload = function(e2) {
				//读取成功后返回的一个参数e，整个的一个进度事件
				console.log(e2);
				//选择所要显示音乐，要赋值给img的src就是e中target下result里面
				//的base64编码格式的地址
				$('#show-img').get(0).src = e2.target.result;
				$('#show-img').show();
			}
		});

	});
	//上传方法
	var songUrl;
	var songImage;
	function upload() {
		var songFileInput = $('#songFile').get(0).files[0];
		var songImgFileInput = $('#songImgFile').get(0).files[0];
		if (songFileInput) {
			if (songImgFileInput) {
				var formData = new FormData($("#uploadForm")[0]);
				$.ajax({
					type : "POST",
					url : "getSong",
					data : formData,
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(data) {
						if (data == "f") {
							alert("上传失败");

						} else {
							var obj = JSON.parse(data);
							alert("上传成功，请继续完善歌曲信息");
							songUrl = obj.songUrl;
							songImage = obj.songImage;
							$("#upload").hide();
							$("#publish").show();
						}
					}
				});

			} else {
				alert("你还没有上传封面")
			}
		} else {
			alert("你还没有上传歌")
		}

	}
	//返回重新上传
	function back() {
		$("#publish").hide();
		$("#upload").show();
	}
	//发布
	function publish() {
		var songName = $("input[name = 'songName']").val();
		var songAuthor = $("input[name = 'songAuthor']").val();
		var typeId = $("select[name = 'typeId']").val();
		var songWords = $("textarea[name='songWords']").val();
		var description = $("textarea[name='description']").val();
		$.ajax({
			type : "POST",
			url : "/music/addSong",
			async : true,
			cache : false,

			data : {
				songName : songName,
				songAuthor : songAuthor,
				typeId : typeId,
				songUrl : songUrl,
				songImage : songImage,
				songWords : songWords,
				description : description,
				songTime : songTime
			},
			success : function(data) {
				alert(data);			
				window.location.href="/music/index"
			}
		});
	}
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


	<div class="upload-box">
		<div id="upload">
			<div class="upload-title">上传歌曲</div>
			<hr
				style="height: 1px; border: none; border-top: 1px dashed #d5d5d5;"
				width="95%" />
			<div class="upload-area">
				<form id="uploadForm" enctype="multipart/form-data">
					<p>
						歌曲： <input id="songFile" type="file" name="songFile"
							accept="audio/*" multiple>
					</p>
					<div id="player"></div>
					<p>
						封面： <input id="songImgFile" type="file" name="songImgFile"
							accept="image/*" multiple />
					</p>
					<div id="img"></div>
					<img id="show-img" width="200px" height="200px"
						style="display: none; border: 2px solid gray" />
				</form>

				<p>
					<input type="button" value="下一步" class="submit"
						onclick="return upload()"><span class="data"></span>
				</p>
			</div>
		</div>
		<div id="publish">
			<div class="upload-title">完善歌曲信息</div>
			<hr
				style="height: 1px; border: none; border-top: 1px dashed #d5d5d5;"
				width="95%" />
			<div class="upload-area">
				<p>
					歌名：<input type="text" name="songName"
						style="height: 20px; width: 200px">
				</p>
				<p>
					歌手：<input type="text" name="songAuthor"
						style="height: 20px; width: 200px">
				</p>
				<p>
					类别：<select name="typeId" style="height: 20px; width: 200px">
						<option value=0>无分类</option>
						<c:forEach items="${types}" var="type">
							<option value=${type.getId() }>${type.getTypeName() }</option>
						</c:forEach>

					</select>
				</p>
				<p>
					<span style="vertical-align: top;">歌词：</span>
					<textarea name="songWords"
						style="height: 200px; width: 200px; resize: none;"></textarea>
				</p>
				<p>
					<span style="vertical-align: top;">描述：</span>
					<textarea name="description"
						style="height: 80px; width: 200px; resize: none;"></textarea>
				</p>
				<p>
					<input type="button" value="上一步" class="submit"
						onclick="return back()"> <input type="button" value="发布"
						class="submit" onclick="return publish()"><span
						class="data"></span>
				</p>


			</div>
		</div>
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