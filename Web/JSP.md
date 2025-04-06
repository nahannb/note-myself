# JSP



## 1、JSP概述&快速入门&原理



![屏幕截图_23-10-2024_181948_www.bilibili.com](E:\md_picture\屏幕截图_23-10-2024_181948_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_182215_www.bilibili.com](E:\md_picture\屏幕截图_23-10-2024_182215_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_182526_www.bilibili.com](E:\md_picture\屏幕截图_23-10-2024_182526_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_18273_www.bilibili.com](E:\md_picture\屏幕截图_23-10-2024_18273_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_182920_www.bilibili.com](E:\md_picture\屏幕截图_23-10-2024_182920_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_195810_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_195810_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_20112_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_20112_www.bilibili.com.jpeg)



## 2、JSP脚本



![屏幕截图_23-10-2024_20321_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_20321_www.bilibili.com.jpeg)



![屏幕截图_23-10-2024_20546_www.bilibili.com](E:/md_picture/屏幕截图_23-10-2024_20546_www.bilibili.com.jpeg)



代码：



```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a> <a href="#">删除</a></td>
        </tr>

    </c:forEach>

</table>

<script>
    document.getElementById("add").onclick = function (){
        location.href = "/brand-demo/addBrand.jsp";
    }

</script>
</body>
</html>
```



## 3、JSP缺点



![屏幕截图_24-10-2024_112037_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_112037_www.bilibili.com.jpeg)



![屏幕截图_24-10-2024_112117_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_112117_www.bilibili.com.jpeg)



## 4、EL表达式



![屏幕截图_24-10-2024_112556_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_112556_www.bilibili.com.jpeg)



```java
package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private  BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 调用BrandService完成查询
        List<Brand> brands = service.selectAll();

        //2. 存入request域中
        request.setAttribute("brands",brands);

        //3. 转发到brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



## 5、JSTL-if&foreach



![屏幕截图_24-10-2024_113334_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_113334_www.bilibili.com.jpeg)



![屏幕截图_24-10-2024_113414_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_113414_www.bilibili.com.jpeg)



```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改品牌</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/brand-demo/updateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${brand.id}">

    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description} </textarea><br>
    状态：
    <c:if test="${brand.status == 0}">

        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>

    <c:if test="${brand.status == 1}">

        <input type="radio" name="status" value="0" >禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>


    <input type="submit" value="提交">
</form>
</body>
</html>
```



```java
package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService service = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));


        //2. 调用service 完成修改
        service.update(brand);


        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



## 6、MVC模式和三层架构



![屏幕截图_24-10-2024_15948_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_15948_www.bilibili.com.jpeg)



![屏幕截图_24-10-2024_151220_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_151220_www.bilibili.com.jpeg)



![屏幕截图_24-10-2024_151448_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_151448_www.bilibili.com.jpeg)



![屏幕截图_24-10-2024_151715_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_151715_www.bilibili.com.jpeg)



## 7、案例-准备环境



![屏幕截图_24-10-2024_151838_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_151838_www.bilibili.com.jpeg)



![屏幕截图_24-10-2024_151854_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_151854_www.bilibili.com.jpeg)



具体示例见代码



![屏幕截图_24-10-2024_15193_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_15193_www.bilibili.com.jpeg)



## 8、案例-查询所有



![屏幕截图_24-10-2024_153555_www.bilibili.com](E:/md_picture/屏幕截图_24-10-2024_153555_www.bilibili.com.jpeg)



## 9、案例-添加



![屏幕截图_25-10-2024_85551_www.bilibili.com](E:/md_picture/屏幕截图_25-10-2024_85551_www.bilibili.com.jpeg)



```java
package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));


        //2. 调用service 完成添加
        service.add(brand);


        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



```java
package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.add(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }



    /**
     * 根据id查询
     * @return
     */
    public Brand selectById(int id){
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }


    /**
     * 修改
     * @param brand
     */
    public void update(Brand brand){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.update(brand);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
}

```



```java
package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 修改
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void update(Brand brand);

}

```



## 10、案例-修改-回显数据



![屏幕截图_25-10-2024_85812_www.bilibili.com](E:/md_picture/屏幕截图_25-10-2024_85812_www.bilibili.com.jpeg)



![屏幕截图_25-10-2024_9044_www.bilibili.com](E:/md_picture/屏幕截图_25-10-2024_9044_www.bilibili.com.jpeg)



## 11、案例-修改-修改数据



![屏幕截图_25-10-2024_92458_www.bilibili.com](E:/md_picture/屏幕截图_25-10-2024_92458_www.bilibili.com.jpeg)



```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改品牌</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/brand-demo/updateServlet" method="post">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${brand.id}">

    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description} </textarea><br>
    状态：
    <c:if test="${brand.status == 0}">

        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>

    <c:if test="${brand.status == 1}">

        <input type="radio" name="status" value="0" >禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>


    <input type="submit" value="提交">
</form>
</body>
</html>
```



```java
package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService service = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));


        //2. 调用service 完成修改
        service.update(brand);


        //3. 转发到查询所有Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
```



