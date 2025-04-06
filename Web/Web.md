# Web



## Web核心介绍



### 1、Web核心介绍



![屏幕截图_11-10-2024_105820_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_105820_www.bilibili.com.jpeg)



![屏幕截图_11-10-2024_11039_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_11039_www.bilibili.com.jpeg)



## HTTP



### 2、HTTP简介



 ![屏幕截图_11-10-2024_11515_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_11515_www.bilibili.com.jpeg)



### 3、请求数据格式



![屏幕截图_11-10-2024_11113_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_11113_www.bilibili.com.jpeg)



### 4、相应数据格式



![屏幕截图_11-10-2024_111650_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_111650_www.bilibili.com.jpeg)



状态码大类



| 状态码分类 | 说明                                                         |
| ---------- | ------------------------------------------------------------ |
| 1xx        | **响应中**——临时状态码，表示请求已经接受，告诉客户端应该继续请求或者如果它已经完成则忽略它 |
| 2xx        | **成功**——表示请求已经被成功接收，处理已完成                 |
| 3xx        | **重定向**——重定向到其它地方：它让客户端再发起一个请求以完成整个处理。 |
| 4xx        | **客户端错误**——处理发生错误，责任在客户端，如：客户端的请求一个不存在的资源，客户端未被授权，禁止访问等 |
| 5xx        | **服务器端错误**——处理发生错误，责任在服务端，如：服务端抛出异常，路由出错，HTTP版本不支持等 |

状态码大全：https://cloud.tencent.com/developer/chapter/13553 



常见的响应状态码

| 状态码 | 英文描述                               | 解释                                                         |
| ------ | -------------------------------------- | ------------------------------------------------------------ |
| 200    | **`OK`**                               | 客户端请求成功，即**处理成功**，这是我们最想看到的状态码     |
| 302    | **`Found`**                            | 指示所请求的资源已移动到由`Location`响应头给定的 URL，浏览器会自动重新访问到这个页面 |
| 304    | **`Not Modified`**                     | 告诉客户端，你请求的资源至上次取得后，服务端并未更改，你直接用你本地缓存吧。隐式重定向 |
| 400    | **`Bad Request`**                      | 客户端请求有**语法错误**，不能被服务器所理解                 |
| 403    | **`Forbidden`**                        | 服务器收到请求，但是**拒绝提供服务**，比如：没有权限访问相关资源 |
| 404    | **`Not Found`**                        | **请求资源不存在**，一般是URL输入有误，或者网站资源被删除了  |
| 428    | **`Precondition Required`**            | **服务器要求有条件的请求**，告诉客户端要想访问该资源，必须携带特定的请求头 |
| 429    | **`Too Many Requests`**                | **太多请求**，可以限制客户端请求某个资源的数量，配合 Retry-After(多长时间后可以请求)响应头一起使用 |
| 431    | **` Request Header Fields Too Large`** | **请求头太大**，服务器不愿意处理请求，因为它的头部字段太大。请求可以在减少请求头域的大小后重新提交。 |
| 405    | **`Method Not Allowed`**               | 请求方式有误，比如应该用GET请求方式的资源，用了POST          |
| 500    | **`Internal Server Error`**            | **服务器发生不可预期的错误**。服务器出异常了，赶紧看日志去吧 |
| 503    | **`Service Unavailable`**              | **服务器尚未准备好处理请求**，服务器刚刚启动，还未初始化好   |
| 511    | **`Network Authentication Required`**  | **客户端需要进行身份验证才能获得网络访问权限**               |



![屏幕截图_11-10-2024_112612_www.bilibili.com](E:\md_picture\屏幕截图_11-10-2024_112612_www.bilibili.com.jpeg)



## Tomcat



### 5、简介&基本使用



![屏幕截图_13-10-2024_225814_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_225814_www.bilibili.com.jpeg)



![屏幕截图_13-10-2024_22580_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_22580_www.bilibili.com.jpeg)



![屏幕截图_13-10-2024_23020_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_23020_www.bilibili.com.jpeg)



![屏幕截图_13-10-2024_23126_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_23126_www.bilibili.com.jpeg)



![屏幕截图_13-10-2024_23148_www.bilibili.com](E:/md_picture/屏幕截图_13-10-2024_23148_www.bilibili.com.jpeg)



### 6、Tomcat配置和部署项目



![屏幕截图_14-10-2024_181046_www.bilibili.com](E:/md_picture/屏幕截图_14-10-2024_181046_www.bilibili.com.jpeg)



![屏幕截图_14-10-2024_181311_www.bilibili.com](E:/md_picture/屏幕截图_14-10-2024_181311_www.bilibili.com.jpeg)



### 7、Web项目结构



![屏幕截图_14-10-2024_182339_www.bilibili.com](E:/md_picture/屏幕截图_14-10-2024_182339_www.bilibili.com.jpeg)



### 8、创建MavenWeb项目



![屏幕截图_15-10-2024_134630_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_134630_www.bilibili.com.jpeg)



![屏幕截图_15-10-2024_13464_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_13464_www.bilibili.com.jpeg)



![屏幕截图_15-10-2024_134229_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_134229_www.bilibili.com.jpeg)



### 9、Idea集成本地Tomcat



![屏幕截图_15-10-2024_18226_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_18226_www.bilibili.com.jpeg)



![屏幕截图_15-10-2024_182222_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_182222_www.bilibili.com.jpeg)



### 10、Tomcat的Maven插件



![屏幕截图_15-10-2024_182837_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_182837_www.bilibili.com.jpeg)



图中改的<port>和<path>就可以直接用`localhost`访问项目



## Servlet



### 11、Servlet简介&快速入门



![屏幕截图_15-10-2024_203853_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_203853_www.bilibili.com.jpeg)



![屏幕截图_15-10-2024_204113_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_204113_www.bilibili.com.jpeg)



![屏幕截图_15-10-2024_204218_www.bilibili.com](E:/md_picture/屏幕截图_15-10-2024_204218_www.bilibili.com.jpeg)



### 12、Servlet方法介绍&体系结构



![屏幕截图_16-10-2024_92143_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_92143_www.bilibili.com.jpeg)



![屏幕截图_16-10-2024_92433_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_92433_www.bilibili.com.jpeg)



![屏幕截图_16-10-2024_92517_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_92517_www.bilibili.com.jpeg)



![屏幕截图_16-10-2024_92621_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_92621_www.bilibili.com.jpeg)



### 13、Servlet方法介绍&体系结构



![屏幕截图_16-10-2024_162441_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_162441_www.bilibili.com.jpeg)



![屏幕截图_16-10-2024_162526_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_162526_www.bilibili.com.jpeg)



![屏幕截图_16-10-2024_162756_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_162756_www.bilibili.com.jpeg)



非官方的HttpServlet,只说明了部分原理



```java
package com.itheima.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyHttpServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 根据请求方式的不同，进行分别的处理

        HttpServletRequest request = (HttpServletRequest) req;

        //1. 获取请求方式
        String method = request.getMethod();
        //2. 判断
        if("GET".equals(method)){
            // get方式的处理逻辑

            doGet(req,res);
        }else if("POST".equals(method)){
            // post方式的处理逻辑

            doPost(req,res);
        }
    }

    protected void doPost(ServletRequest req, ServletResponse res) {
    }

    protected void doGet(ServletRequest req, ServletResponse res) {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

```



注：protected 修饰的是子类可以看到的方法



![屏幕截图_16-10-2024_163257_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_163257_www.bilibili.com.jpeg)



### 14、urlPattern配置



![屏幕截图_16-10-2024_16625_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_16625_www.bilibili.com.jpeg)



![屏幕截图_16-10-2024_1670_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_1670_www.bilibili.com.jpeg)



![屏幕截图_16-10-2024_161527_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_161527_www.bilibili.com.jpeg)



Servlet配置了“/”会访问不到静态资源



### 15、XML配置Servlet



 ![屏幕截图_16-10-2024_163822_www.bilibili.com](E:/md_picture/屏幕截图_16-10-2024_163822_www.bilibili.com.jpeg)



## Request和Response



### 1、Request和Response介绍&Requst继承体系



![屏幕截图_17-10-2024_152959_www.bilibili.com](E:/md_picture/屏幕截图_17-10-2024_152959_www.bilibili.com.jpeg)



![屏幕截图_17-10-2024_153314_www.bilibili.com](E:/md_picture/屏幕截图_17-10-2024_153314_www.bilibili.com.jpeg)



![屏幕截图_17-10-2024_153259_www.bilibili.com](E:/md_picture/屏幕截图_17-10-2024_153259_www.bilibili.com.jpeg)



![屏幕截图_17-10-2024_153410_www.bilibili.com](E:/md_picture/屏幕截图_17-10-2024_153410_www.bilibili.com.jpeg)



### 2、Request获取请求数据-请求行&请求头&请求体



![屏幕截图_17-10-2024_153710_www.bilibili.com](E:/md_picture/屏幕截图_17-10-2024_153710_www.bilibili.com.jpeg)



注：getInputStream( )是get,getReader( )是post



### 3、Request通用方式获取请求参数



![屏幕截图_22-10-2024_83949_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_83949_www.bilibili.com.jpeg)



![屏幕截图_22-10-2024_84138_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_84138_www.bilibili.com.jpeg)



```java
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET请求逻辑
        //System.out.println("get....");

        //1. 获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            // username:zhangsan lisi
            System.out.print(key+":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

        System.out.println("------------");

        //2. 根据key获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {

            System.out.println(hobby);
        }

        //3. 根据key 获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求逻辑

        this.doGet(req,resp);
    }
        }
```



![屏幕截图_22-10-2024_84415_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_84415_www.bilibili.com.jpeg)



### 4、Idea模板创建Servlet



![屏幕截图_22-10-2024_85913_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_85913_www.bilibili.com.jpeg)



### 5、请求参数中文乱码-POST解决方案



![屏幕截图_22-10-2024_9139_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_9139_www.bilibili.com.jpeg)



 ![屏幕截图_22-10-2024_9622_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_9622_www.bilibili.com.jpeg)



### 6、Resquest请求参数中文乱码-GET解决方案



![屏幕截图_22-10-2024_93649_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_93649_www.bilibili.com.jpeg)



```java
package com.itheima.web.request;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 中文乱码问题解决方案
 */
@WebServlet("/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 解决乱码：POST，getReader()
        //request.setCharacterEncoding("UTF-8");//设置字符输入流的编码

        //2. 获取username
        String username = request.getParameter("username");
        System.out.println("解决乱码前："+username);

        //3. GET,获取参数的方式：getQueryString
        // 乱码原因：tomcat进行URL解码，默认的字符集ISO-8859-1
       /* //3.1 先对乱码数据进行编码：转为字节数组
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        //3.2 字节数组解码
        username = new String(bytes, StandardCharsets.UTF_8);*/

        username  = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        System.out.println("解决乱码后："+username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



![屏幕截图_22-10-2024_93739_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_93739_www.bilibili.com.jpeg)



### 7、Resquest请求转发



![屏幕截图_22-10-2024_9403_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_9403_www.bilibili.com.jpeg)





```java
package com.itheima.web.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 请求转发
 */
@WebServlet("/req5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo5...");
        System.out.println(request);
        //存储数据
        request.setAttribute("msg","hello");

        //请求转发
        request.getRequestDispatcher("/req6").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



![屏幕截图_22-10-2024_94249_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_94249_www.bilibili.com.jpeg)



### 8、Response设置相应数据功能介绍&完成重定向



![屏幕截图_22-10-2024_134924_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_134924_www.bilibili.com.jpeg)



![屏幕截图_22-10-2024_181637_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_181637_www.bilibili.com.jpeg)



```java
package com.itheima.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1....");

        //重定向
        /*//1.设置响应状态码 302
        response.setStatus(302);
        //2. 设置响应头 Location
        response.setHeader("Location","/request-demo/resp2");*/

        //简化方式完成重定向
        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        response.sendRedirect(contextPath+"/resp2");
        //response.sendRedirect("https://www.itcast.cn");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



![屏幕截图_22-10-2024_182129_www.bilibili.com](E:/md_picture/屏幕截图_22-10-2024_182129_www.bilibili.com.jpeg)



### 9、资源路径问题



![屏幕截图_23-10-2024_93832_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_93832_www.bilibili.com.jpeg)



```java
package com.itheima.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1....");

        //重定向
        /*//1.设置响应状态码 302
        response.setStatus(302);
        //2. 设置响应头 Location
        response.setHeader("Location","/request-demo/resp2");*/

        //简化方式完成重定向
        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        response.sendRedirect(contextPath+"/resp2");
        //response.sendRedirect("https://www.itcast.cn");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



### 10、Response相应字符&字节数据

 

![屏幕截图_23-10-2024_163157_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_163157_www.bilibili.com.jpeg)



```
package com.itheima.web.response;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字符数据的响应体
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1. 获取字符输出流
        PrintWriter writer = response.getWriter();
        //content-type
        //response.setHeader("content-type","text/html");

        writer.write("你好");
        writer.write("<h1>aaa</h1>");
        //细节：流不需要关闭

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



![屏幕截图_23-10-2024_163649_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_163649_www.bilibili.com.jpeg)



```
package com.itheima.web.response;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字节数据：设置字节数据的响应体
 */
@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 读取文件
        FileInputStream fis = new FileInputStream("d://a.jpg");

        //2. 获取response字节输出流
        ServletOutputStream os = response.getOutputStream();

        //3. 完成流的copy
       /* byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff))!= -1){
            os.write(buff,0,len);
        }*/

        IOUtils.copy(fis,os);

        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



![屏幕截图_23-10-2024_163659_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_163659_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_164158_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_164158_www.bilibili.com.jpeg)



### 11、案例-用户登录-准备环境&代码实现



![屏幕截图_23-10-2024_164412_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_164412_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_164659_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_164659_www.bilibili.com.jpeg)



详情见代码



![屏幕截图_23-10-2024_164723_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_164723_www.bilibili.com.jpeg)



### 12、案例-用户注册



![屏幕截图_23-10-2024_16590_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_16590_www.bilibili.com.jpeg)



具体见代码



![屏幕截图_23-10-2024_17054_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_17054_www.bilibili.com.jpeg)



### 13、SqlSessionFactory工具类抽取



![屏幕截图_23-10-2024_171238_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_171238_www.bilibili.com.jpeg)



```java
package com.itheima.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        //静态代码块会随着类的加载而自动执行，且只执行一次

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}

```





## 补充



### JWP令牌-介绍



![屏幕截图_7-11-2024_114944_www.bilibili.com](E:/md_picture/屏幕截图_7-11-2024_114944_www.bilibili.com.jpeg)



![屏幕截图_7-11-2024_155513_www.bilibili.com](E:/md_picture/屏幕截图_7-11-2024_155513_www.bilibili.com.jpeg)



### JWP令牌-生成和校验



![屏幕截图_7-11-2024_155632_www.bilibili.com](E:/md_picture/屏幕截图_7-11-2024_155632_www.bilibili.com.jpeg)



![屏幕截图_7-11-2024_16533_www.bilibili.com](E:/md_picture/屏幕截图_7-11-2024_16533_www.bilibili.com.jpeg)



JWP令牌只改一个数也会失效



### JWP令牌-登录后下发令牌



 ![屏幕截图_7-11-2024_161618_www.bilibili.com](E:/md_picture/屏幕截图_7-11-2024_161618_www.bilibili.com.jpeg)



1、引入工具类



![屏幕截图_7-11-2024_162925_www.bilibili.com](E:/md_picture/屏幕截图_7-11-2024_162925_www.bilibili.com.jpeg)



2、写代码



![屏幕截图_7-11-2024_162950_www.bilibili.com](E:/md_picture/屏幕截图_7-11-2024_162950_www.bilibili.com.jpeg)



