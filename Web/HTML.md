# HTML



## 1、HTML介绍&快速入门



![屏幕截图_27-9-2024_11208_www.bilibili.com](E:\md_picture\屏幕截图_27-9-2024_11208_www.bilibili.com.jpeg)



![屏幕截图_27-9-2024_11135_www.bilibili.com](E:\md_picture\屏幕截图_27-9-2024_11135_www.bilibili.com.jpeg)



![屏幕截图_27-9-2024_134934_www.bilibili.com](E:\md_picture\屏幕截图_27-9-2024_134934_www.bilibili.com.jpeg)



![屏幕截图_27-9-2024_135017_www.bilibili.com](E:\md_picture\屏幕截图_27-9-2024_135017_www.bilibili.com.jpeg)



## 2、基础标签

![屏幕截图_9-10-2024_134938_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_134938_www.bilibili.com.jpeg)



```html
<!-- html5 标识-->
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 页面的字符集-->
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>我是标题 h1</h1>
<h2>我是标题 h2</h2>
<h3>我是标题 h3</h3>
<h4>我是标题 h4</h4>
<h5>我是标题 h5</h5>
<h6>我是标题 h6</h6>

<hr>
<!--
    html 表示颜色：
        1. 英文单词：red,pink,blue...
        2. rgb(值1,值2,值3)：值的取值范围：0~255  rgb(255,0,0)
        3. #值1值2值3：值的范围：00~FF
-->
<font face="楷体" size="5" color="#ff0000">传智教育</font>

<hr>

刚察草原绿草如茵，沙柳河水流淌入湖。藏族牧民索南才让家中，茶几上摆着馓子、麻花和水果，炉子上刚煮开的奶茶香气四溢……<br>

6月8日下午，习近平总书记来到青海省海北藏族自治州刚察县沙柳河镇果洛藏贡麻村，走进牧民索南才让家中，看望慰问藏族群众。

<hr>
<p>
刚察草原绿草如茵，沙柳河水流淌入湖。藏族牧民索南才让家中，茶几上摆着馓子、麻花和水果，炉子上刚煮开的奶茶香气四溢……
</p>
<p>
6月8日下午，习近平总书记来到青海省海北藏族自治州刚察县沙柳河镇果洛藏贡麻村，走进牧民索南才让家中，看望慰问藏族群众。
</p>
<hr>

沙柳河水流淌<br>

<b>沙柳河水流淌</b><br>
<i>沙柳河水流淌</i><br>
<u>沙柳河水流淌</u><br>

<hr>
<center>
<b>沙柳河水流淌</b>
</center>
</body>
</html>
```



![屏幕截图_9-10-2024_172148_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_172148_www.bilibili.com.jpeg)



## 3、图片音频视频标签



![屏幕截图_9-10-2024_17285_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_17285_www.bilibili.com.jpeg)



```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--
    资源路径：
        1. 绝对路径：完整路径
        2. 相对路径：相对位置关系
            xxx/html/02-图片音频视频.html
            xxx/html/a.jpg

            ./a.jpg  &  a.jpg


            xxx/html/02-图片音频视频.html
            xxx/html/img/a.jpg

            ./img/a.jpg


            xxx/html/02-图片音频视频.html
            xxx/img/a.jpg

            ../img/a.jpg
    尺寸单位：
        1. px：像素
        2. 百分比：
-->

<img src="../img/a.jpg" width="300" height="400">
<img src="https://th.bing.com/th/id/R33674725d9ae34f86e3835ae30b20afe?rik=Pb3C9e5%2b%2b3a9Vw&riu=http%3a%2f%2fwww.desktx.com%2fd%2ffile%2fwallpaper%2fscenery%2f20180626%2f4c8157d07c14a30fd76f9bc110b1314e.jpg&ehk=9tpmnrrRNi0eBGq3CnhwvuU8PPmKuy1Yma0zL%2ba14T0%3d&risl=&pid=ImgRaw" width="300" height="400">

<audio src="b.mp3" controls></audio>

<video src="c.mp4" controls width="500" height="300"></video>



</body>
</html>
```



![屏幕截图_9-10-2024_191025_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_191025_www.bilibili.com.jpeg)



## 4、超链接标签&列表标签



![屏幕截图_9-10-2024_191341_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_191341_www.bilibili.com.jpeg)



![屏幕截图_9-10-2024_191359_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_191359_www.bilibili.com.jpeg)



## 5、表格标签&布局标签



![屏幕截图_9-10-2024_191717_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_191717_www.bilibili.com.jpeg)



![屏幕截图_9-10-2024_192541_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_192541_www.bilibili.com.jpeg)



![屏幕截图_9-10-2024_192557_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_192557_www.bilibili.com.jpeg)



## 6、表单标签



![屏幕截图_9-10-2024_19363_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_19363_www.bilibili.com.jpeg)



![屏幕截图_9-10-2024_19300_www.bilibili.com](E:/md_picture/屏幕截图_9-10-2024_19300_www.bilibili.com.jpeg)



```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<!--
form：
    action:指定表单数据提交的URL
        * 表单项数据要想被提交，则必须指定其name属性
    method：指定表单提交的方式
        1. get：默认值
            * 请求参数会拼接在URL后边
            * url的长度有限制 4KB
        2. post：
            * 请求参数会在http请求协议的请求体中
            * 请求参数无限制的
-->

    <form action="#" method="post">
        <input type="text" name="username">
        <input type="submit">

    </form>


</body>
</html>
```



## 7、表单项标签



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="#" method="post">
    <input type="hidden" name="id" value="123">


<!--
for指的是点击与id相同的字段，也能产生input的效果
-->
    

    <label for="username">用户名：</label>
    <input type="text" name="username" id="username"><br>

    <label for="password">密码：</label>
    <input type="password" name="password" id="password"><br>

    性别：
    <input type="radio" name="gender" value="1" id="male"> <label for="male">男</label>
    <input type="radio" name="gender" value="2" id="female"> <label for="female">女</label>
    <br>

    爱好：
    <input type="checkbox" name="hobby" value="1"> 旅游
    <input type="checkbox" name="hobby" value="2"> 电影
    <input type="checkbox" name="hobby" value="3"> 游戏
    <br>

    头像：
    <input type="file"><br>

    城市:
    <select name="city">
        <option>北京</option>
        <option value="shanghai">上海</option>
        <option>广州</option>
    </select>
    <br>

    个人描述：
    <textarea cols="20" rows="5" name="desc"></textarea>
    <br>
    <br>
    <input type="submit" value="免费注册">
    <input type="reset" value="重置">
    <input type="button" value="一个按钮">


</form>


</body>
</html>
```



