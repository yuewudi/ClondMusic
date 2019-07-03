$(function () {
	
	
	//轮播图
    var num=0;
    var a = $(".box a");
    var btn = $(".btn");
    var viewPage = $(".viewPage");
    function move() {
        num++;
        if(num==a.length){
            num=0;
        }
        a.css("opacity",0);
        a.eq(num).animate({"opacity":.8},1000)
        btn.css("background","#fff")
        btn.eq(num).css("background","#ff0000")

        viewPage.css("background","url(assets/images/lunboback"+(num+1)+")")


    }
    var anima = setInterval(move,5000)

    a.mouseenter(function () {
        clearInterval(anima)
    })
    a.mouseleave(function () {
        anima=setInterval(move,5000)
    })

    btn.click(function () {
        num = btn.index(this);

        a.css("opacity",0);
        a.eq(num).css("opacity",1,2000)

        btn.css("background","#fff")
        btn.eq(num).css("background","#ff0000")
        viewPage.css("background","url(assets/images/lunboback"+(num+1)+")")

    })


    var ul = $(".roll-ul");
    var left = $(".inner-left")

    var right = $(".inner-right")
    var ulWidth =ul.width();

    var sum = 0;
    var emp=0;
    var length = ul.length;
     function move2 () {
        console.log(2);
        sum++;//2
         length--;
        if(sum==ul.length-1){
            sum = 0;
        }
       //  emp=ul.eq(sum-1).width();
         ul.eq(length).animate({left:ul.eq(sum).width()-ulWidth},2000);
         console.log(ul.eq(sum).width());
         ul.eq(sum-1).animate({left:ul.eq(sum).width()},2000);
         ul.eq(length-1).css("left",-(ul.eq(sum).width()));
         console.log(sum);
         console.log(length);

     }
    left.click(
        move2
        )



        //弹出登陆框
    var login = $(".loginButton");
    var input = $(".text");
    var loginView = $(".login");
     login.click(function(){
             loginView.css("display","block")
     }
     )


    var delDef;
    input.focus(function () {
         varDef = $(this).val()
            $(this).val("")
    })
    input.blur(function () {
        if($(this).val()==""){
            $(this).val(varDef)
        }else{
            varDef = $(this).val()
            $(this).val(varDef)
        }
    })


    //登陆的form表单验证
    $("form").validate(
        {
            rules:{
                userNumber:{
                    required: true,
                    minlength: 5
                },
                account:{
                    required: true,
                    minlength: 5
                },
                password:{
                    required: true,
                    minlength: 5
                },
                pwd:{
                    required: true,
                    minlength: 5
                },
                pwd2:{
                    required: true,
                    minlength: 5,
                    equalTo:"#pd"
                }

            },
            messages:{
                userNumber:{
                    required: "用户名不能为空",
                    minlength: "用户名不能少于5个字符"
                },
                account:{
                    required: "用户名不能为空",
                    minlength: "用户名不能少于5个字符"
                },
                password:{
                    required: "密码不能为空",
                    minlength: "密码不能少于5个字符"
                },
                pwd:{
                    required: "密码不能为空",
                    minlength: "密码不能少于5个字符"
                },
                pwd2: {
                    required: "密码不能为空",
                    minlength: "密码不能少于5 个字符",
                    equalTo:"两次密码不一致"
                }
            }
        }
    )

    
    //注册按钮
     $(".button:first").click(function () {
         $(".login-top:first").css("display","none")
        $(".sign").css("display","block")
         $(".signPage").css("display","block")
         $("table:first").css("display","none")

     })

     
     //登陆关闭
     $(".close").click(function () {
        $(".login").css("display","none")
    })


})