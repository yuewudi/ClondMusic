<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>优逸云音乐</title>
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
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
                <li>
                    <div class="liTop">
                        <img src="assets/images/hot1.jpg" alt="">
                        <a href="" class="liTopa"></a>
                        <div class="liTopBottom">
                            <a href="" class="liTopBottoma"></a>
                            <span class="listen"></span>
                            <span class="playNum">5500万</span>
                        </div>
                    </div>
                    <p>华语速爆新歌</p>
                </li>
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
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                        </ul>
                        <ul class="roll-ul">
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                        </ul>
                        <ul class="roll-ul">
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                        </ul>
                        <ul class="roll-ul">
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new2.jpg" alt="">
                                    <a href=""></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">A Brand New Day (BTS WORLD OST Part.2) </a></p>
                                <p><a href="">BTS (防弹少年团)</a></p>
                            </li>
                            <li>
                                <div class="li-div">
                                    <img src="assets/images/new1.jpg" alt="">
                                    <a href="" class="li-a-one"></a>
                                    <a href="" class="li-a-two"></a>
                                </div>
                                <p><a href="">那就这样吧</a></p>
                                <p><a href="">蔡程昱</a></p>
                            </li>
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
                        <li >
                            <span class="one">1</span>
                            <a href="">你走以后</a>
                        </li>
                        <li >
                            <span class="one">2</span>
                            <a href="">生活该有的样子</a>
                        </li>
                        <li >
                            <span class="one">3</span>
                            <a href="">没一杯茶</a>
                        </li>
                        <li>
                            <span>4</span>
                            <a href="">Why You So Beautiful</a>
                        </li>
                        <li>
                            <span>5</span>
                            <a href="">形容</a>
                        </li>
                        <li>
                            <span>6</span>
                            <a href="">i`m with you</a>
                        </li>
                        <li>
                            <span>7</span>
                            <a href="">多在乎平庸的生活拥抱你</a>
                        </li>
                        <li>
                            <span>8</span>
                            <a href="">Summerdfsdfsdfsdfsdfsdfsd</a>
                        </li>
                        <li>
                            <span>9</span>
                            <a href="">晚安</a>
                        </li>
                        <li>
                            <span>10</span>
                            <a href="">祝你爱我到天荒地老</a>
                        </li>

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
                        <li >
                            <span class="one">1</span>
                            <a href="">你走以后</a>
                        </li>
                        <li >
                            <span class="one">2</span>
                            <a href="">生活该有的样子</a>
                        </li>
                        <li >
                            <span class="one">3</span>
                            <a href="">没一杯茶</a>
                        </li>
                        <li>
                            <span>4</span>
                            <a href="">Why You So Beautiful</a>
                        </li>
                        <li>
                            <span>5</span>
                            <a href="">形容</a>
                        </li>
                        <li>
                            <span>6</span>
                            <a href="">i`m with you</a>
                        </li>
                        <li>
                            <span>7</span>
                            <a href="">多在乎平庸的生活拥抱你</a>
                        </li>
                        <li>
                            <span>8</span>
                            <a href="">Summerdfsdfsdfsdfsdfsdfsd</a>
                        </li>
                        <li>
                            <span>9</span>
                            <a href="">晚安</a>
                        </li>
                        <li>
                            <span>10</span>
                            <a href="">祝你爱我到天荒地老</a>
                        </li>

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
                        <li >
                            <span class="one">1</span>
                            <a href="">你走以后</a>
                        </li>
                        <li >
                            <span class="one">2</span>
                            <a href="">生活该有的样子</a>
                        </li>
                        <li >
                            <span class="one">3</span>
                            <a href="">没一杯茶</a>
                        </li>
                        <li>
                            <span>4</span>
                            <a href="">Why You So Beautiful</a>
                        </li>
                        <li>
                            <span>5</span>
                            <a href="">形容</a>
                        </li>
                        <li>
                            <span>6</span>
                            <a href="">i`m with you</a>
                        </li>
                        <li>
                            <span>7</span>
                            <a href="">多在乎平庸的生活拥抱你</a>
                        </li>
                        <li>
                            <span>8</span>
                            <a href="">Summerdfsdfsdfsdfsdfsdfsd</a>
                        </li>
                        <li>
                            <span>9</span>
                            <a href="">晚安</a>
                        </li>
                        <li>
                            <span>10</span>
                            <a href="">祝你爱我到天荒地老</a>
                        </li>

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