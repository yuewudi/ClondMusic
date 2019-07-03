<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>上传头像</title>
<link rel="stylesheet" href="assets/css/bind.css">
<link rel="stylesheet" href="assets/css/foot.css">
<link rel="stylesheet" href="assets/css/header.css">
<style type="text/css">
#box-1 {
	width: 200px;
	height: 200px;
	margin: auto;
	border: 1px solid gray;
	border-radius: 50%;
}
#box-2 {
	width: 45px;
	height: 400px;
	padding-top:10px;
	margin: auto;

}

img {
	width: 100%;
	height: 100%;
	margin: auto;
	border-radius: 50%;
}
</style>
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
	$(function() {
		//在input file内容改变的时候触发事件
		$('#choose-file').change(function() {
			//获取input file的files文件数组;
			//$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
			//这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
			var file = $('#choose-file').get(0).files[0];
			//创建用来读取此文件的对象
			var reader = new FileReader();
			//使用该对象读取file文件
			reader.readAsDataURL(file);
			//读取文件成功后执行的方法函数
			reader.onload = function(e) {
				//读取成功后返回的一个参数e，整个的一个进度事件
				console.log(e);
				//选择所要显示图片的img，要赋值给img的src就是e中target下result里面
				//的base64编码格式的地址
				$('#show-img').get(0).src = e.target.result;
				$(".tip").html("")
				$("#upload").show();
			}
		});

		//隐藏input file控件
		$("#choose-file").hide();
		$("#upload").hide();
		$(".tip").html("点击头像框选择图片预览后上传")
		$("#box-1").bind('click', function() {
			//当点击头像框时，就会弹出文件选择对话框
			$("#choose-file").click();

		});

	});
	
	function upload() {
		var formData = new FormData($("#uploadForm")[0]);
		 $.ajax({  
		        type : "POST",  
		        url : "/music/getHeader",  
		        data : formData,
		        async: false,  
		        cache: false,  
		        contentType: false,  
		        processData: false,
		        success : function(msg) {  
		            if(msg=="t"){
		            $(".msg").html("成功");
		            setTimeout(function(){
		            	window.location.href="edit"
		            },1000)
		            } else{
		            	 $(".msg").html("失败");
		            }
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


	<div class="bind-box">
	    <div class="bind-title">
      更换头像
    </div>
        <hr style="height:1px;border:none;border-top:1px dashed #d5d5d5;" width="95%"/>
		<div id="box-1">
			<img id="show-img" src="" alt="" />
		</div>
	<p class="tip" align="center"></p>
		<div id="box-2">
			<form id="uploadForm" enctype="multipart/form-data">
				<input id="choose-file" type="file" name="file" accept="image/*"  multiple/> 
			</form>
					<button id="upload" type="button" onclick="return upload()">上传</button>
						<p class="msg"></p>
		</div>
	
	</div>




	<!--底部-->
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