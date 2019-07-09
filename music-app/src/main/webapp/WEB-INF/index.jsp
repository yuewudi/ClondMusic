<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>优逸云音乐</title>
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="assets/css/index.css">
    <link rel="stylesheet" href="assets/css/header.css">
    <link rel="stylesheet" href="assets/css/foot.css">
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/index.js"></script>
    <script src="assets/js/validate.js"></script>
    
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

<!--登陆-->

<div class="login" style="display:${display}">
    <div class="login-top">登陆
    <div class="close">×</div>
    </div>
    <div class="login-top sign" style="display: none;">注册
    <div class="close">×</div>
    </div>

    <div class="login-bottom">
        <form action="/music/login" method="post">
            <table style="display: ${login}" style align="center"  >
                <tr>
                    <td>账号：</td>
                    <td class="hint"><input type="text" value="请输入账号" name="userNumber" class="text">
                    <span style="float:left;color: red">${erro}</span></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td class="hint" align="top"> <input type="password" value="" name="password">
                     <span style="float:left;color: red">${nopass}</span></td>
                </tr>
                <tr>
                    <td style="font-size: 10px">记住账号密码 <input type="checkbox"></td>
                    <td style="font-size: 10px;float: right;"><a href="">忘记密码？</a></td>
                </tr>
                <tr>

                    <td colspan="2" align="center">
                        <input type="button" value="注册" class="button">
                        <input type="submit" value="登陆" class="button">
                    </td>
                </tr>
            </table>
            <table style="display: ${sign}"  class="signPage" align="center" >
                <tr>
                    <td>账号：</td>
                    <td class="hint"><input type="text" value="请输入账号" name="account" class="text">
                    <span style="color:red">${already}</span>
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td class="hint"><input type="password"  name="pwd" id="pd"></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td class="hint"><input type="password"name="pwd2" ></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="注&nbsp&nbsp册" class="button signButton">
                    </td>
                </tr>
            </table>

        </form>
    </div>
</div>



<!--轮播图-->
<div class="viewPage">
    <div class="box">
        <div class="dinner">
            <div class="pageOne"><a href=""><img src="assets/images/lunbotu1" alt=""></a></div>
            <div class="pageTwo"><a href=""><img src="assets/images/lunbotu2" alt=""></a></div>
            <div class="pageThree"><a href=""><img src="assets/images/lunbotu3" alt=""></a></div>
            <div class="pageFour"><a href=""><img src="assets/images/lunbotu4" alt=""></a></div>
            <div class="btns">
                <div class="btn"></div>
                <div class="btn"></div>
                <div class="btn"></div>
                <div class="btn"></div>
            </div>
        </div>
        <div class="box-right">
            <div ></div>
        </div>

    </div>





</div>

<!--中间的板块-->

<div class="bigModel">

    <div class="midModel">
        <div class="hot">
            <div class="hotTop">
                <a href="">推荐热门</a>
                <span>
                <a href="">更多</a>
            </span>


            </div>
            <div class="hotBottom">
            	<c:forEach items="${newHotSongs8}" var="newHotSong8" varStatus="id">
                <li>
                    <div class="liTop">
                        <a href="/music/play?songId=${newHotSong8.getId()}"><img src="${newHotSong8.getSongImage()}" alt="" width="140px"></a>
                        <a href="/music/play?songId=${newHotSong8.getId()}" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="/music/play?songId=${newHotSong8.getId()}" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">${newHotSong8.getCount()}</span>
                        </div>
                    </div>
                    <p> <a href="/music/play?songId=${newHotSong8.getId()}">${newHotSong8.getSongName()}</a></p>
                </li>
		</c:forEach>
             
            </div>
        </div>
        <div class="hot new">
            <div class="hotTop">
                <a href="">新碟上架</a>
                <span>
                <a href="">更多</a>
            </span>


            </div>
            <div class="newBottom">
                <div class="inner">
                    <div class="inner-left" href="javascript:;"></div>
                    <div class="roll">
                        <ul class="roll-ul">
                         	<c:forEach items="${newSongs10}" var="newSong10" varStatus="id">
                            <li>
                                <div class="li-div">
                                    <img src="${newSong10.getSongImage()}" alt="" width="104px" height="100px">
                                    <a href="/music/play?songId=${newSong10.getId()}" class="li-a-one"></a>
                                    <a href="/music/play?songId=${newSong10.getId()}" class="li-a-two"></a>
                                </div>
                                <p><a href="/music/play?songId=${newSong10.getId()}">${newSong10.getSongName()}</a></p>
                                <p><a href="https://www.baidu.com/s?wd=${newSong10.getSongAuthor()}">${newSong10.getSongAuthor()}</a></p>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="inner-right" href="javascript:;"></div>
                </div>
            </div>
        </div>
        <div class="topN hot">
            <div class="hotTop">
                <a href="">榜单</a>
                <span>
                <a href="/music/rank">更多</a>
            </span>


            </div>
            <div class="tonN-bottom">
                <div class="soaring">
                    <div class="soaring-top">
                        <div>
                            <img src="assets/images/soaring.jpg" alt="">
                        </div>
                        <div class="soaring-top-right">
                            <a href=""><h3>云音乐飙升榜</h3></a>
                            <a href=""></a>
                            <a href=""></a>
                        </div>
                    </div>
                    <div class="soaring-bottom">
                       	<c:forEach items="${newHotSongs10}" var="newHotSong10" varStatus="id">
                        <li >
                         <c:if test="${id.count<=3}"><span  class="one">${id.count}</span></c:if>
                             <c:if test="${id.count>3}"><span  >${id.count}</span></c:if>
                            <a href="/music/play?songId=${newHotSong10.getId()}">${newHotSong10.getSongName()}</a>
                        </li>
                      </c:forEach>
                    </div>

                </div>
                <div class="newSong soaring">
                    <div class="soaring-top">
                        <div>
                            <img src="assets/images/newSong.jpg" alt="">
                        </div>
                        <div class="soaring-top-right">
                            <a href=""><h3>云音乐新歌榜</h3></a>
                            <a href=""></a>
                            <a href=""></a>
                        </div>
                    </div>
                    <div class="soaring-bottom">
                      	<c:forEach items="${newSongs10}" var="newSong10" varStatus="id">
                        <li >
                         <c:if test="${id.count<=3}"><span  class="one">${id.count}</span></c:if>
                             <c:if test="${id.count>3}"><span  >${id.count}</span></c:if>
                            <a href="/music/play?songId=${newSong10.getId()}">${newSong10.getSongName()}</a>
                        </li>
                      </c:forEach>
                    </div>
                </div>
                <div class="original soaring">
                    <div class="soaring-top">
                        <div>
                            <img src="assets/images/original.jpg" alt="">
                        </div>
                        <div class="soaring-top-right">
                            <a href=""><h3>云音乐原创榜</h3></a>
                            <a href=""></a>
                            <a href=""></a>
                        </div>
                    </div>
                    <div class="soaring-bottom">
                        	<c:forEach items="${originalSongs}" var="originalSong" varStatus="id">
                        <li >
                         <c:if test="${id.count<=3}"><span  class="one">${id.count}</span></c:if>
                             <c:if test="${id.count>3}"><span  >${id.count}</span></c:if>
                            <a href="/music/play?songId=${originalSong.getId()}">${originalSong.getSongName()}</a>
                        </li>
                      </c:forEach>

                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="bigModel-right"></div>


</div>


<!--底部-->
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
            UBDF1812版权所有2019-2099&nbsp;&nbsp;山西优逸客有限公司运营：晋网文[2019]7418-741号违法和不良信息举报电话：0351-8300110
            举报邮箱：1442286843@qq.com 不服来206教室单挑
        </div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
        <div class="zuihou13"></div>
    </div>
</div>



</body>
</html>
