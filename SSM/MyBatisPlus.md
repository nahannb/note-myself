# MyBatisPlus



## 1、MybatisPlus入门案例



![屏幕截图_25-9-2024_21118_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21118_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21740_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21740_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21842_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21842_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21857_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21857_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_2197_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_2197_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21928_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21928_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21934_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21934_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_211926_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_211926_www.bilibili.com.jpeg)





![屏幕截图_25-9-2024_212015_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_212015_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_212030_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_212030_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_212052_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_212052_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_212057_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_212057_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21214_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21214_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_212116_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_212116_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_212122_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_212122_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_212149_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_212149_www.bilibili.com.jpeg)



## 2、MyBatisPlus简介



![屏幕截图_25-9-2024_213341_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_213341_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21356_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21356_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_213556_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_213556_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_21366_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_21366_www.bilibili.com.jpeg)



## 3、标准CRUD制作



![屏幕截图_25-9-2024_213928_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_213928_www.bilibili.com.jpeg)



```java
package com.itheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setName("黑马程序员");
        user.setPassword("itheima");
        user.setAge(12);
        user.setTel("4006184000");
        userDao.insert(user);
    }

    @Test
    void testDelete(){
        userDao.deleteById(1401856123725713409L);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setName("Tom888");
        user.setPassword("tom888");
        userDao.updateById(user);
    }

    @Test
    void testGetById(){
        User user = userDao.selectById(2L);
        System.out.println(user);
    }


    @Test
    void testGetAll() {
        List<User> userList = userDao.selectList(null);
        System.out.println(userList);
    }

```



![屏幕截图_26-9-2024_103354_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_103354_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_10344_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_10344_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_103520_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_103520_www.bilibili.com.jpeg)



## 4、标准分页功能制作



![屏幕截图_26-9-2024_104423_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_104423_www.bilibili.com.jpeg)



1、开拦截器



```java
package com.itheima.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConfig {
    @Bean
    public MybatisPlusInterceptor mpInterceptor(){
        //1.定义Mp拦截器
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        //2.添加具体的拦截器
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpInterceptor;
    }
}
```



2、分页查询具体实现



```java
 @Test
    void testGetByPage(){
        //IPage对象封装了分页操作相关的数据
        IPage page  = new Page(2,3);
        userDao.selectPage(page,null);
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());//当前页的数据
    }
```



3、启动日志



```yml
# 开启mp的日志（输出到控制台）
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```



![屏幕截图_26-9-2024_10549_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_10549_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_105417_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_105417_www.bilibili.com.jpeg)



## 5、条件查询的三种格式



![屏幕截图_26-9-2024_11332_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_11332_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_11344_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_11344_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_11353_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_11353_www.bilibili.com.jpeg)



1、如果想关闭main的启动日志



可以在



![image-20240926111658612](E:/md_picture/image-20240926111658612.png)



```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
</configuration>
```



2、如果想把logo关掉



yml里写上



```yml
main:
    banner-mode: off
# mp日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    banner: false
```



3、查询



```java
@Test
    void testGetAll() {
        //方式一：按条件查询
//        QueryWrapper qw = new QueryWrapper();
//        qw.lt("age",18);
//        List<User> userList = userDao.selectList(qw);
//        System.out.println(userList);

        //方式二：lambda格式按条件查询
//        QueryWrapper<User> qw = new QueryWrapper<User>();
//        qw.lambda().lt(User::getAge, 10);
//        List<User> userList = userDao.selectList(qw);
//        System.out.println(userList);

        //方式三：lambda格式按条件查询
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.lt(User::getAge, 10);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);




        //并且与或者关系
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //并且关系：10到30岁之间
//        //lqw.lt(User::getAge, 30).gt(User::getAge, 10);
//        //或者关系：小于10岁或者大于30岁
//        lqw.lt(User::getAge, 10).or().gt(User::getAge, 30);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

}
```



![屏幕截图_26-9-2024_111359_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_111359_www.bilibili.com.jpeg)



## 6、条件查询null判定



![屏幕截图_26-9-2024_14402_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_14402_www.bilibili.com.jpeg)



代码:



```java
        //模拟页面传递过来的查询数据
//        UserQuery uq = new UserQuery();
//        uq.setAge(10);
//        uq.setAge2(30);

        //null判定
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.lt(User::getAge, uq.getAge2());
//        if( null != uq.getAge()) {
//            lqw.gt(User::getAge, uq.getAge());
//        }
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //先判定第一个参数是否为true，如果为true连接当前条件
////        lqw.lt(null != uq.getAge2(),User::getAge, uq.getAge2());
////        lqw.gt(null != uq.getAge(),User::getAge, uq.getAge());
//        lqw.lt(null != uq.getAge2(),User::getAge, uq.getAge2())
//           .gt(null != uq.getAge(),User::getAge, uq.getAge());
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

```



![屏幕截图_26-9-2024_144619_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_144619_www.bilibili.com.jpeg)



## 7、查询投影



```java
        //查询投影
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.select(User::getId,User::getName,User::getAge);
//        QueryWrapper<User> lqw = new QueryWrapper<User>();
//        lqw.select("id","name","age","tel");
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

//        QueryWrapper<User> lqw = new QueryWrapper<User>();
//        lqw.select("count(*) as count, tel");
//返回的是字段的个数
//        lqw.groupBy("tel");
//分组查询
//        List<Map<String, Object>> userList = userDao.selectMaps(lqw);
//        System.out.println(userList);

```



![屏幕截图_26-9-2024_145935_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_145935_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_145613_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_145613_www.bilibili.com.jpeg)



## 8、查询条件设置



![屏幕截图_26-9-2024_152737_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_152737_www.bilibili.com.jpeg)



```java
//条件查询
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //等同于=
//        lqw.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
//        User loginUser = userDao.selectOne(lqw);
//        System.out.println(loginUser);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //范围查询 lt le gt ge eq between
//between 记得是前大于等于后小于等于 前面的是带等号右边是不带等号的
//        lqw.between(User::getAge,10,30);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //模糊匹配 like
//        lqw.likeLeft(User::getName,"J");
//左%
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);
```



![屏幕截图_26-9-2024_153259_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_153259_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_153329_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_153329_www.bilibili.com.jpeg)



## 9、映射匹配兼容性



![屏幕截图_26-9-2024_15134_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15134_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15213_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15213_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15218_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15218_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15330_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15330_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15336_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15336_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_1541_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_1541_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15451_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15451_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15523_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15523_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15540_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15540_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15545_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15545_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15554_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15554_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15810_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15810_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15820_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15820_www.bilibili.com.jpeg)



## 10、id生成策略





![屏幕截图_26-9-2024_151227_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_151227_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_151234_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_151234_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_151342_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_151342_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_15193_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_15193_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_152144_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_152144_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_152152_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_152152_www.bilibili.com.jpeg)





![屏幕截图_26-9-2024_152158_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_152158_www.bilibili.com.jpeg)



## 11、多数据操作（删除与查询）



![屏幕截图_26-9-2024_154857_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_154857_www.bilibili.com.jpeg)



```java
    @Test
    void testDelete(){
        //删除指定多条数据
//        List<Long> list = new ArrayList<>();
//        list.add(1402551342481838081L);
//        list.add(1402553134049501186L);
//        list.add(1402553619611430913L);
//        userDao.deleteBatchIds(list);
        //查询指定多条数据
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(3L);
//        list.add(4L);
//        userDao.selectBatchIds(list);


        userDao.deleteById(2L);
//        System.out.println(userDao.selectList(null));
    }

```



![屏幕截图_26-9-2024_155038_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_155038_www.bilibili.com.jpeg)



## 12、逻辑删除



![屏幕截图_26-9-2024_1601_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_1601_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_165056_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_165056_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_165859_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_165859_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_16594_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_16594_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_165920_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_165920_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_165939_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_165939_www.bilibili.com.jpeg)



## 13、乐观锁



int的最大范围是11位数字



![屏幕截图_26-9-2024_172050_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_172050_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_173939_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_173939_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_174019_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174019_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_174027_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174027_www.bilibili.com.jpeg)



4、数据修改



```java
@Test
    void testUpdate(){
//        User user = new User();
//        user.setId(3L);
//        user.setName("Jock666");
//        user.setVersion(1);
//        userDao.updateById(user);

//        //1.先通过要修改的数据id将当前数据查询出来
//        User user = userDao.selectById(3L);
//        //2.将要修改的属性逐一设置进去
//        user.setName("Jock888");
//        userDao.updateById(user);



        //1.先通过要修改的数据id将当前数据查询出来
        User user = userDao.selectById(3L);     //version=3

        User user2 = userDao.selectById(3L);    //version=3

        user2.setName("Jock aaa");
        userDao.updateById(user2);              //version=>4


        user.setName("Jock bbb");
        userDao.updateById(user);               //verion=3?条件还成立吗？

    }

```



![屏幕截图_26-9-2024_17410_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_17410_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_174118_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174118_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_174125_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174125_www.bilibili.com.jpeg)



## 14、代码生成器



![屏幕截图_26-9-2024_174729_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174729_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_174826_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174826_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_174840_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174840_www.bilibili.com.jpeg)



![屏幕截图_26-9-2024_174941_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_174941_www.bilibili.com.jpeg)

先导依赖



```xml
 <!--代码生成器-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.4.1</version>
        </dependency>

        <!--velocity模板引擎-->
        <dependency>
            <groupId>org.apache.velocity</groupId>
            <artifactId>velocity-engine-core</artifactId>
            <version>2.3</version>
        </dependency>

```



![image-20240926180916745](E:/md_picture/image-20240926180916745.png)



```java
package com.itheima;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class CodeGenerator {
    public static void main(String[] args) {
        //1.获取代码生成器的对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //设置数据库相关配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatisplus_db?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        autoGenerator.setDataSource(dataSource);

        //设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/mybatisplus_04_generator/src/main/java");    //设置代码生成位置
        globalConfig.setOpen(false);    //设置生成完毕后是否打开生成代码所在的目录
        globalConfig.setAuthor("黑马程序员");    //设置作者
        globalConfig.setFileOverride(true);     //设置是否覆盖原始生成的文件
        globalConfig.setMapperName("%sDao");    //设置数据层接口名，%s为占位符，指代模块名称
        globalConfig.setIdType(IdType.ASSIGN_ID);   //设置Id生成策略
        autoGenerator.setGlobalConfig(globalConfig);

        //设置包名相关配置
        PackageConfig packageInfo = new PackageConfig();
        packageInfo.setParent("com.aaa");   //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageInfo.setEntity("domain");    //设置实体类包名
        packageInfo.setMapper("dao");   //设置数据层包名
        autoGenerator.setPackageInfo(packageInfo);

        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("tbl_user");  //设置当前参与生成的表名，参数为可变参数
        strategyConfig.setTablePrefix("tbl_");  //设置数据库表的前缀名称，模块名 = 数据库表名 - 前缀名  例如： User = tbl_user - tbl_
        strategyConfig.setRestControllerStyle(true);    //设置是否启用Rest风格
        strategyConfig.setVersionFieldName("version");  //设置乐观锁字段名
        strategyConfig.setLogicDeleteFieldName("deleted");  //设置逻辑删除字段名
        strategyConfig.setEntityLombokModel(true);  //设置是否启用lombok
        autoGenerator.setStrategy(strategyConfig);
        //2.执行生成操作
        autoGenerator.execute();
    }
}

```



然后就会生成代码



![屏幕截图_26-9-2024_1835_www.bilibili.com](E:/md_picture/屏幕截图_26-9-2024_1835_www.bilibili.com.jpeg)



## @Mapper与@MapperScan



`Mapper` 继承了 MyBatis-Plus 提供的 `BaseMapper<Patient>`，并且没有添加 `@Mapper` 注解。这是因为你已经在主启动类中使用了 `@MapperScan` 注解，它负责自动扫描并注册指定包路径下的所有 Mapper 接口。因此，`PatientInformationMapper` 不再需要显式地使用 `@Mapper` 注解。

原理解释：

1. **`@MapperScan` 的作用**：

在你的启动类中，使用了如下代码：

```
javaCopy code@MapperScan("com.example.patient.mapper")
@SpringBootApplication
public class HisPatientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HisPatientApplication.class, args);
    }
}
```

- `@MapperScan("com.example.patient.mapper")` 告诉 Spring 自动扫描 `com.example.patient.mapper` 包下的所有接口，并将它们注册为 MyBatis 的 Mapper Bean。
- 由于 `@MapperScan` 会自动扫描并注册这些 Mapper 接口，`PatientInformationMapper` 已经被自动识别为一个 MyBatis Mapper，因此无需再手动添加 `@Mapper` 注解。

2. **MyBatis-Plus 的 `BaseMapper`**：

- `BaseMapper` 是 MyBatis-Plus 提供的一个通用 Mapper 接口，它封装了基本的增删改查操作（CRUD）。通过继承 `BaseMapper<Patient>`，`PatientInformationMapper` 自动具备了这些常见操作的方法。
- 由于 `@MapperScan` 已经扫描了这个包路径，Spring 在启动时会自动为这些 Mapper 创建代理对象，从而实现数据库操作。因此，你无需显式地在每个 Mapper 上再加 `@Mapper` 注解。

3. **不用 `@Mapper` 的原因**：

- **简化配置**：使用 `@MapperScan` 可以批量处理一个包下的所有 Mapper 接口，使得你不用在每个 Mapper 上都添加 `@Mapper` 注解，减少冗余代码。
- **自动扫描**：Spring 会在启动时根据 `@MapperScan` 的配置自动扫描 `com.example.patient.mapper` 包下的所有接口，识别它们为 MyBatis Mapper 接口并注册到 Spring 容器中。因此，这些 Mapper 接口能够正常工作，即使它们没有显式地使用 `@Mapper` 注解。

什么时候需要 `@Mapper`？

如果你没有使用 `@MapperScan` 注解，那么就需要在每个 MyBatis Mapper 接口上显式地添加 `@Mapper` 注解，才能让 Spring 知道这是一个 MyBatis 的 Mapper 并将其注册到容器中。例如：

```
javaCopy code@Mapper
public interface PatientInformationMapper extends BaseMapper<Patient> {
}
```

总结

- 因为你在主类中使用了 `@MapperScan` 来扫描 Mapper 所在的包，Spring 会自动处理该包下的所有 Mapper 接口，所以 `PatientInformationMapper` 不需要再手动加 `@Mapper` 注解。
- `@MapperScan` 提供了批量扫描的能力，简化了项目中的 Mapper 配置



## deleteby()和remove()



`remove(patientInformationLambdaUpdateWrapper)` 和 `deleteById(patientId)` 是两种删除数据库记录的方法，具体区别如下：

1. **`remove(patientInformationLambdaUpdateWrapper)`**：

- **用法**：这是使用 **条件删除** 的方式。

- **LambdaUpdateWrapper**：你通过 `LambdaUpdateWrapper` 指定了一个查询条件，例如 `patientId`，来删除符合该条件的记录。

- **灵活性**：你可以根据多个条件来删除记录，条件可以非常复杂，例如通过 `eq`、`like` 等方法来构建多个条件。

- **应用场景**：当你需要根据多个字段的值或者复杂的逻辑来删除数据时，适合使用这种方式。

- 示例

  ：

  ```
  javaCopy codeLambdaUpdateWrapper<Patient> wrapper = new LambdaUpdateWrapper<>();
  wrapper.eq(Patient::getId, patientId).eq(Patient::getIsVip, true);
  remove(wrapper);
  ```

  该代码将删除符合 

  ```
  id
  ```

   和 

  ```
  isVip
  ```

   两个条件的记录。

2. **`deleteById(patientId)`**：

- **用法**：这是使用 **主键删除** 的方式。

- **删除依据**：只需要传递主键（通常是 `id` 字段），就可以删除对应主键的记录。

- **简单直接**：这个方法的好处在于简单直接，只需要提供主键值即可，无法指定额外的条件。

- **应用场景**：当你只需要根据 `id` 删除单条记录时，这是最快速和直接的方式。

- 示例

  ：

  ```
  java
  
  
  Copy code
  deleteById(patientId);
  ```

  该代码会根据 

  ```
  patientId
  ```

   删除对应的记录。