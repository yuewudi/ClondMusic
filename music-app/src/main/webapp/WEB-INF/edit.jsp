<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>编辑个人资料</title>
<link rel="stylesheet" href="assets/css/edit.css">
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
	//保存方法
	function submit() {
		var nickName = $("input[name = 'nickName']").val();
		var description = $("textarea[name='description']").val();
		var sex = $("input[name = 'sex']:checked").val();
		$.ajax({
			type : "POST",
			url : "/music/save",
			async:true,
			cache : false,
			
			data : {
				nickName : nickName,
				description : description,
				sex : sex,
			},
			success : function(data) {
			        $(".data").html("保存成功")
			    }
		});

	}

</script>


</head>
<body>
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

	<div class="edit-box">
		<div class="edit-title">个人设置</div>
		<hr style="height: 1px; border: none; border-top: 1px dashed #d5d5d5;"
			width="95%" />
		<div class="edit-area">
			<div class="head-img"
				style="background: url(${user.getHeader()}) no-repeat center center /100% auto;	background-size:140px 140px;">
				<div class="replace">
					<a href="uploadImage">更换头像</a>
				</div>
			</div>
			<p>
				昵称：<input type="text" name="nickName" value="${user.getNickName()}"
					style="height: 20px; width: 200px">
			</p>
			<p>
				<span style="vertical-align: top;">介绍：</span><textarea name="description"
					style="width: 80px; height: 80px; width: 200px; resize: none;">${user.getDescription()}</textarea>
			</p>
			<p>
				性别：<input type="radio" value="true" name="sex"
					<c:if test="${user.isSex() == true  }">
				checked</c:if>>男
				<input type="radio" value="false" name="sex"
					<c:if test="${user.isSex() == false  }">
				checked</c:if>>女
			</p>
			<p>
				<input type="button" value="保存" class="submit"
					onclick="return submit()"><span class="data"></span>
			</p>


		</div>
		<div class="edit-title">绑定设置</div>
		<hr style="height: 1px; border: none; border-top: 1px dashed #d5d5d5;"
			width="95%" />
		<div class="edit-area">

			<c:if test="${user.getPhone() == 0  }">
				<p>
					您还未绑定手机号&nbsp;<a href="/music/bind" style="color: red">绑定</a>
				</p>
			</c:if>
			<c:if test="${user.getPhone() != 0  }">
				<p>
					你已绑定手机号：${user.getPhone() }&nbsp;<a href="/music/bind"
						style="color: red">换绑</a>
				</p>
			</c:if>




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