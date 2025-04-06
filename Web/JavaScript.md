# JavaScript



## 1、JavaScript简介&引入方式



![屏幕截图_11-10-2024_103538_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_103538_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_103658_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_103658_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_103959_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_103959_www.bilibili.com.jpeg)



## 2、书写语法&输出语句



![屏幕截图_11-10-2024_162445_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_162445_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_162451_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_162451_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_162516_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_162516_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_162631_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_162631_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>



<script>
    window.alert("hello js~");//写入警告框

    document.write("hello js 2~");//写入html页面

    console.log("hello js 3");//写入浏览器的控制台
</script>
</body>
</html>
```



## 3、变量&数据类型



![屏幕截图_11-10-2024_164239_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_164239_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>



<script>

 /*   var test = 20;
    test = "张三";

    alert(test);*/

    /*
        var:
            1. 作用域：全局变量
            2. 变量可以重复定义


     */


    {
        let age = 30;
        let age2 = 20;
        //var age = 20;

    }
    alert(age);

    const PI = 3.14;
    //PI = 3;

</script>
</body>
</html>
```



![屏幕截图_11-10-2024_164613_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_164613_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_164623_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_164623_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<script>
    // number
    // var age = 20;
    // var price = 99.8;
    // alert(typeof age);
    // alert(typeof price);

    //string
    // var ch = 'a';
    // var name = '张三';
    // var addr = "北京";
    //
    // alert(typeof ch);
    // alert(typeof name);
    // alert(typeof addr);
    //
    // //boolean
    // var flag = true;
    // var flag2 = false;
    //
    // alert(typeof flag);
    // alert(typeof flag2);
    //
    // //null
    // var obj = null;
    //
    // alert(typeof obj);//object
    //
    // //undefined
    var a ;
    alert(typeof a);

</script>

</body>
</html>
```



## 4、运算符



![屏幕截图_11-10-2024_165311_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_165311_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_165336_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_165336_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<script>
    /*
        ==:
            1. 判断类型是否一样，如果不一样，则进行类型转换
            2. 再去比较其值

        ===:全等于
            1. 判断类型是否一样，如果不一样，直接返回false
            2. 再去比较其值

     */
    var age1 = 20;
    var age2 = "20";

    // alert(age1 == age2);// true
    // alert(age1 === age2);// false

    /*
        类型转换：
            * 其他类型转为number：
                1. string: 按照字符串的字面值，转为数字.如果字面值不是数字，则转为NaN。一般使用parseInt
                2. boolean: true 转为1，false转为0

            * 其他类型转为boolean：
                1. number:0和NaN转为false，其他的数字转为true
                2. string:空字符串转为false，其他的字符串转为true
                3. null:false
                4. undefined:false


     */
    // var str = +"20";
    /*var str = "20";
    alert(parseInt(str) + 1);*/

/*
    var flag = +false;
    alert(flag);*/

    // var flag = 3;
    // var flag = "";
 /*   var flag = undefined;

    if(flag){
        alert("转为true");
    }else {
        alert("转为false");
    }*/

    var str = "abc";

    //健壮性判断
    //if(str != null && str.length > 0){
    if(str){
        alert("转为true");
    }else {
        alert("转为false");
    }



</script>
</body>
</html>
```



![屏幕截图_11-10-2024_17432_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_17432_www.bilibili.com.jpeg)



## 5、流程控制语句&函数



![屏幕截图_11-10-2024_17628_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_17628_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script>
/*
    //1. if
    var count = 3;
    if (count == 3) {
        alert(count);
    }*/

/*

    //2. switch
    var num = 3;
    switch (num) {
        case 1: {
            alert("星期一");
            break;
        }

        case 2: {
            alert("星期二");
            break;
        }

        case 3: {
            alert("星期三");
            break;
        }

        case 4: {
            alert("星期四");
            break;
        }

        case 5: {
            alert("星期五");
            break;
        }

        case 6: {
            alert("星期六");
            break;
        }

        case 7: {
            alert("星期日");
            break;
        }


        default: {
            alert("输入的星期有误");
            break;
        }
    }
*/


    // 3. for
/*

    var sum = 0;
    for (let i = 1; i <= 100; i++) {
        sum += i;
    }
    alert(sum);
*/

/*
    // 4. while

    var sum = 0;
    var i = 1;
    while (i <= 100) {
        sum += i;
        i++;
    }
    alert(sum);*/


    // 5. do...while

    var sum = 0;
    var i = 1;
    do {
        sum += i;
        i++;
    }
    while (i <= 100);
    alert(sum);


</script>
</body>
</html>
```



![屏幕截图_11-10-2024_17822_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_17822_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_17830_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_17830_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_171016_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_171016_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script>
   /*function add(a,b){
       return a + b;
   }


   var result = add(1,2);

   alert(result);*/

   var add = function (a,b){
       return a + b;
   }

   var result = add(1,2);

   var result1 = add(1,2,3);
   // alert(result1)

   var result2 = add(1);
   alert(result2);

   //alert(result);

</script>
</body>
</html>
```



## 6、Array对象



![屏幕截图_11-10-2024_20475_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_20475_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_204720_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_204720_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_204730_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_204730_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>



<script>
    // 方式一
    var arr = new Array(1,2,3);

    // alert(arr);

    // 方式二
    var arr2 = [1,2,3];
    //alert(arr2);

    // 访问
    arr2[0] = 10;
    //alert(arr2)


    // 特点：JavaScript数组相当于Java中集合。变长变类型

    // 变长
    var arr3 = [1,2,3];
    arr3[10] = 10;
    //alert(arr3[10]);
    //alert(arr3[9]);

    // 变类型
    arr3[5] = "hello";
    //alert(arr3[5]);
    //alert(arr3);


    // 属性：length：数组中元素的个数
    var arr4 = [1,2,3];
/*
    for (let i = 0; i < arr4.length; i++) {
        alert(arr4[i]);
    }*/

    // 方法：
    // push:添加方法
    var arr5 = [1,2,3];
   /* arr5.push(10);
    alert(arr5);*/

    // splice:删除元素
    arr5.splice(0,1);
    alert(arr5);

</script>

</body>
</html>
```



![屏幕截图_11-10-2024_205257_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_205257_www.bilibili.com.jpeg)



## 7、String对象&自定义对象&Window对象



![屏幕截图_11-10-2024_205651_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_205651_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_20570_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_20570_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<script>
    //方式一
    var str1 = new String("abc");
    //方式二
    var str2 = "abc";
    var str3 = 'abc';


    //length
    // alert(str3.length);

    // trim():去除字符串前后两端的空白字符

    var str4 = '  abc   ';

    alert(1 + str4.trim() + 1);

</script>
</body>
</html>
```



![屏幕截图_11-10-2024_21112_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_21112_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_21251_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_21251_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_21257_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_21257_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_2134_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_2134_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_2142_www.bilibili.com](E:/md_picture/屏幕截图_11-10-2024_2142_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<script>


    var person = {
        name : "zhangsan",
        age : 23,
        eat: function (){
            alert("干饭~");
        }

    };


    alert(person.name);
    alert(person.age);

    person.eat();



</script>
</body>
</html>
```



## 8、定时器案例



![屏幕截图_12-10-2024_10955_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_10955_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JavaScript演示</title>
</head>
<body>



<input type="button" onclick="on()" value="开灯">
<img id="myImage" border="0" src="../imgs/off.gif" style="text-align:center;">
<input type="button" onclick="off()" value="关灯">


<script>

    function on(){
        document.getElementById('myImage').src='../imgs/on.gif';
    }

    function off(){
        document.getElementById('myImage').src='../imgs/off.gif'
    }
    var x = 0;

    // 根据一个变化的数字，产生固定个数的值； 2  x % 2     3   x % 3
    //定时器
    setInterval(function (){

        if(x % 2 == 0){
            on();
        }else {
            off();
        }

        x ++;

    },1000);

</script>

</body>
</html>
```



## 9、History&Location对象



![屏幕截图_12-10-2024_101643_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_101643_www.bilibili.com.jpeg)



![屏幕截图_12-10-2024_101650_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_101650_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script>
/*

    alert("要跳转了");
    location.href = "https://www.baidu.com";

*/


    //3秒跳转到首页

    document.write("3秒跳转到首页...");
    setTimeout(function (){
        location.href = "https://www.baidu.com"
    },3000);

</script>
</body>
</html>
```



![屏幕截图_12-10-2024_101857_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_101857_www.bilibili.com.jpeg)



## 10、DOM概述&Element对象获取与使用



![屏幕截图_12-10-2024_102411_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_102411_www.bilibili.com.jpeg)



![屏幕截图_12-10-2024_102515_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_102515_www.bilibili.com.jpeg)



![屏幕截图_12-10-2024_10274_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_10274_www.bilibili.com.jpeg)



![屏幕截图_12-10-2024_102719_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_102719_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<img id="light" src="../imgs/off.gif"> <br>

<div class="cls">传智教育</div>   <br>
<div class="cls">黑马程序员</div> <br>

<input type="checkbox" name="hobby"> 电影
<input type="checkbox" name="hobby"> 旅游
<input type="checkbox" name="hobby"> 游戏
<br>

<script>
    /*
    获取：使用Document对象的方法来获取
        * getElementById：根据id属性值获取，返回一个Element对象
        * getElementsByTagName：根据标签名称获取，返回Element对象数组
        * getElementsByName：根据name属性值获取，返回Element对象数组
        * getElementsByClassName：根据class属性值获取，返回Element对象数组

     */
    //1. getElementById：根据id属性值获取，返回一个Element对象
    var img = document.getElementById("light");
    // alert(img);

    //2. getElementsByTagName：根据标签名称获取，返回Element对象数组

    var divs = document.getElementsByTagName("div");
    // alert(divs.length);
   /* for (let i = 0; i < divs.length; i++) {
        alert(divs[i]);
    }*/

    //3. getElementsByName：根据name属性值获取，返回Element对象数组
    var hobbys = document.getElementsByName("hobby");
   /* for (let i = 0; i < hobbys.length; i++) {
        alert(hobbys[i]);

    }*/

    //4. getElementsByClassName：根据class属性值获取，返回Element对象数组

    var clss = document.getElementsByClassName("cls");
    for (let i = 0; i < clss.length; i++) {
        alert(clss[i]);

    }



</script>
</body>
</html>
```



![屏幕截图_12-10-2024_103313_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_103313_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<img id="light" src="../imgs/off.gif"> <br>

<div class="cls">传智教育</div>   <br>
<div class="cls">黑马程序员</div> <br>

<input type="checkbox" name="hobby"> 电影
<input type="checkbox" name="hobby"> 旅游
<input type="checkbox" name="hobby"> 游戏
<br>

<script>
    //1. getElementById：根据id属性值获取，返回一个Element对象
    var img = document.getElementById("light");
    // alert(img);
    img.src = "../imgs/on.gif";

    //2. getElementsByTagName：根据标签名称获取，返回Element对象数组
    var divs = document.getElementsByTagName("div");
    /*
        style:设置元素css样式
        innerHTML：设置元素内容
    */

    for (let i = 0; i < divs.length; i++) {
        //divs[i].style.color = 'red';
        divs[i].innerHTML = "呵呵";
    }

    //3. getElementsByName：根据name属性值获取，返回Element对象数组
    var hobbys = document.getElementsByName("hobby");
    for (let i = 0; i < hobbys.length; i++) {
        //alert(hobbys[i]);
        hobbys[i].checked = true;
    }

    //4. getElementsByClassName：根据class属性值获取，返回Element对象数组

    var clss = document.getElementsByClassName("cls");
    /*for (let i = 0; i < clss.length; i++) {
        alert(clss[i]);

    }*/



</script>
</body>
</html>
```



![屏幕截图_12-10-2024_105013_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_105013_www.bilibili.com.jpeg)



## 11、事件监听



![屏幕截图_12-10-2024_10592_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_10592_www.bilibili.com.jpeg)



![屏幕截图_12-10-2024_105910_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_105910_www.bilibili.com.jpeg)



![屏幕截图_12-10-2024_11012_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_11012_www.bilibili.com.jpeg)



![屏幕截图_12-10-2024_11018_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_11018_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="点我" onclick="on()"> <br>
<input type="button" value="再点我" id="btn">


<script>

    function on(){
        alert("我被点了");
    }


    document.getElementById("btn").onclick = function (){
        alert("我被点了");
    }


</script>
</body>
</html>
```



![屏幕截图_12-10-2024_11227_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_11227_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form id="register" action="#" >
    <input type="text" name="username" />

    <input type="submit" value="提交">
</form>

<script>
    document.getElementById("register").onsubmit = function (){
        //onsubmit 返回true，则表单会被提交，返回false，则表单不提交
        return true;
    }



</script>

</body>
</html>
```



![屏幕截图_12-10-2024_11722_www.bilibili.com](E:/md_picture/屏幕截图_12-10-2024_11722_www.bilibili.com.jpeg)



## 12、表单验证



![屏幕截图_13-10-2024_215914_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_215914_www.bilibili.com.jpeg)



![屏幕截图_13-10-2024_2230_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_2230_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="../css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="#">登录</a>
    </div>
    <form id="reg-form" action="#" method="get">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" style="display: none">用户名不太受欢迎</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>手机号</td>
                <td class="inputs"><input name="tel" type="text" id="tel">
                    <br>
                    <span id="tel_err" class="err_msg" style="display: none">手机号格式有误</span>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>


<script>

    //1. 验证用户名是否符合规则
    //1.1 获取用户名的输入框
    var usernameInput = document.getElementById("username");

    //1.2 绑定onblur事件 失去焦点
    usernameInput.onblur = checkUsername;

    function checkUsername() {
        //1.3 获取用户输入的用户名
        var username = usernameInput.value.trim();

        //1.4 判断用户名是否符合规则：长度 6~12,单词字符组成
        var reg = /^\w{6,12}$/;
        var flag = reg.test(username);

        //var flag = username.length >= 6 && username.length <= 12;
        if (flag) {
            //符合规则
            document.getElementById("username_err").style.display = 'none';
        } else {
            //不合符规则
            document.getElementById("username_err").style.display = '';
        }

        return flag;
    }


    //1. 验证密码是否符合规则
    //1.1 获取密码的输入框
    var passwordInput = document.getElementById("password");

    //1.2 绑定onblur事件 失去焦点
    passwordInput.onblur = checkPassword;

    function checkPassword() {
        //1.3 获取用户输入的密码
        var password = passwordInput.value.trim();

        //1.4 判断密码是否符合规则：长度 6~12
        var reg = /^\w{6,12}$/;
        var flag = reg.test(password);

        //var flag = password.length >= 6 && password.length <= 12;
        if (flag) {
            //符合规则
            document.getElementById("password_err").style.display = 'none';
        } else {
            //不合符规则
            document.getElementById("password_err").style.display = '';
        }

        return flag;
    }


    //1. 验证手机号是否符合规则
    //1.1 获取手机号的输入框
    var telInput = document.getElementById("tel");

    //1.2 绑定onblur事件 失去焦点
    telInput.onblur = checkTel;

    function checkTel() {
        //1.3 获取用户输入的手机号
        var tel = telInput.value.trim();

        //1.4 判断手机号是否符合规则：长度 11，数字组成，第一位是1

        //var flag = tel.length == 11;
        var reg = /^[1]\d{10}$/;
        var flag = reg.test(tel);
        if (flag) {
            //符合规则
            document.getElementById("tel_err").style.display = 'none';
        } else {
            //不合符规则
            document.getElementById("tel_err").style.display = '';
        }

        return flag;
    }


    //1. 获取表单对象
    var regForm = document.getElementById("reg-form");

    //2. 绑定onsubmit 事件
    regForm.onsubmit = function () {
        //挨个判断每一个表单项是否都符合要求，如果有一个不合符，则返回false

        var flag = checkUsername() && checkPassword() && checkTel();

        return flag;
    }

</script>
</body>
</html>
```



注：将选中的代码按ctrl+F5，就可以将代码按字段进行批量修改



## 13、正则表达式



![屏幕截图_13-10-2024_222212_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_222212_www.bilibili.com.jpeg)



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<script>

    // 规则：单词字符，6~12

    var reg = /^\w{6,12}$/;

    var str = "abcccc";

    var flag = reg.test(str);
    alert(flag);
</script>
</body>
</html>
```

