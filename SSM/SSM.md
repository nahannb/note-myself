# SSM



## 一、Spring



### 1、系统架构



![2fa3fa0070d7377fca4e200c2502d66](E:\md_picture\2fa3fa0070d7377fca4e200c2502d66.png)



![1f1dc99eab61634d0f13a21fc2e1c21](E:\md_picture\1f1dc99eab61634d0f13a21fc2e1c21.png)



### 2、核心概念



 ![微信截图_20240712221821](E:/md_picture/微信截图_20240712221821-1720794969725-1.png)



![微信截图_20240712222334](E:/md_picture/微信截图_20240712222334-1720794975754-3.png)



![微信截图_20240712222431](E:/md_picture/微信截图_20240712222431-1720794981681-5.png)



### 3、IoC入门案例



![微信截图_20240712224208](E:/md_picture/微信截图_20240712224208.png)

![微信截图_20240713142155](E:/md_picture/微信截图_20240713142155.png)



![微信截图_20240713142238](E:/md_picture/微信截图_20240713142238.png)

![微信截图_20240713142244](E:/md_picture/微信截图_20240713142244.png)



![微信截图_20240713142251](E:/md_picture/微信截图_20240713142251.png)



![微信截图_20240713142322](E:/md_picture/微信截图_20240713142322.png)

### 4、DI入门案例



![微信截图_20240713231957](E:/md_picture/微信截图_20240713231957.png)



![微信截图_20240713233707](E:/md_picture/微信截图_20240713233707.png)



```java
public class BookServiceImpl implements BookService {
    //5.删除业务层中使用new的方式创建的dao对象
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
    //6.提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
```



```xml
  <!--1.导入spring的坐标spring-context，对应版本是5.2.10.RELEASE-->

    <!--2.配置bean-->
    <!--bean标签标示配置bean
    id属性标示给bean起名字
    class属性表示给bean定义类型-->
    <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl"/>

    <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl">
        <!--7.配置server与dao的关系-->
        <!--property标签表示配置当前bean的属性
        name属性表示配置哪一个具体的属性
        ref属性表示参照哪一个bean-->
        <property name="bookDao" ref="bookDao"/>
    </bean>
```



![微信截图_20240713233945](E:/md_picture/微信截图_20240713233945.png)



### 5、bean基础配置



![微信截图_20240714014017](E:/md_picture/微信截图_20240714014017.png)



![微信截图_20240714014635](E:/md_picture/微信截图_20240714014635.png)

![微信截图_20240714015058](E:/md_picture/微信截图_20240714015058.png)



![微信截图_20240714015222](E:/md_picture/微信截图_20240714015222.png)

```xml

    <!--name:为bean指定别名，别名可以有多个，使用逗号，分号，空格进行分隔-->
    <bean id="bookService" name="service service4 bookEbi" class="com.itheima.service.impl.BookServiceImpl">
        <property name="bookDao" ref="bookDao"/>
    </bean>

    <!--scope：为bean设置作用范围，可选值为单例singloton，非单例prototype-->
    <bean id="bookDao" name="dao" class="com.itheima.dao.impl.BookDaoImpl" scope="prototype"/>
</beans>
```



### 6、bean的实例化



bean本质上就是对象，创建bean使用构造方法完成



#### 构造方法



![微信截图_20240714020846](E:/md_picture/微信截图_20240714020846.png)



#### 静态工厂



![微信截图_20240714021743](E:/md_picture/微信截图_20240714021743.png)



#### 实例工厂与FactoryBean



![微信截图_20240714115546](E:/md_picture/微信截图_20240714115546.png)



![微信截图_20240714120200](E:/md_picture/微信截图_20240714120200.png)

补充：  





![微信截图_20240714120248](E:/md_picture/微信截图_20240714120248.png)



### 7、bean的生命周期



![image-20240901203610030](E:/md_picture/image-20240901203610030.png)



init:开始bean，destory:销毁bean



![屏幕截图_1-9-2024_203718_www.bilibili.com](E:/md_picture/屏幕截图_1-9-2024_203718_www.bilibili.com.jpeg)



![屏幕截图_1-9-2024_203818_www.bilibili.com](E:/md_picture/屏幕截图_1-9-2024_203818_www.bilibili.com.jpeg)

set在init的前面



### 8、setter注入



![屏幕截图_1-9-2024_21528_www.bilibili.com](E:/md_picture/屏幕截图_1-9-2024_21528_www.bilibili.com.jpeg)



引用类型:一个方法

简单类型：基本数据类型与String



```java
public class BookDaoImpl implements BookDao {

    private String databaseName;
    private int connectionNum;
    //setter注入需要提供要注入对象的set方法
    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }
    //setter注入需要提供要注入对象的set方法
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void save() {
        System.out.println("book dao save ..."+databaseName+","+connectionNum);
    }
}
```



上面databaseName、connectionNum的值由xml文件赋



```xml
 <!--注入简单类型-->
    <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl">
        <!--property标签：设置注入属性-->
        <!--name属性：设置注入的属性名，实际是set方法对应的名称-->
        <!--value属性：设置注入简单类型数据值-->
        <property name="connectionNum" value="10"/>
        <property name="databaseName" value="mysql"/>
    </bean>

    <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"/>

    <!--注入引用类型-->
    <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl">
        <!--property标签：设置注入属性-->
        <!--name属性：设置注入的属性名，实际是set方法对应的名称-->
        <!--ref属性：设置注入引用类型bean的id或name-->
        <property name="bookDao" ref="bookDao"/>
        <property name="userDao" ref="userDao"/>
    </bean>

```



### 9、构造器注入



上代码



```java
public class BookDaoImpl implements BookDao {
    private String databaseName;
    private int connectionNum;

    public BookDaoImpl(String databaseName, int connectionNum) {
        this.databaseName = databaseName;
        this.connectionNum = connectionNum;
    }

    public void save() {
        System.out.println("book dao save ..."+databaseName+","+connectionNum);
    }
```



就是setter该为构造方法



```xml
<bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl">
        根据构造方法参数名称注入
        <constructor-arg name="connectionNum" value="10"/>
        <constructor-arg name="databaseName" value="mysql"/>
    </bean>
    <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"/>

    <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl">
        <constructor-arg name="userDao" ref="userDao"/>
        <constructor-arg name="bookDao" ref="bookDao"/>
    </bean>
```



name指的是传入构造方法的形参



```xml

    <!--解决形参名称的问题，与形参名不耦合-->
    <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl">
        <!--根据构造方法参数类型注入-->
        <constructor-arg type="int" value="10"/>
        <constructor-arg type="java.lang.String" value="mysql"/>
    </bean>
    <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"/>

    <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl">
        <constructor-arg name="userDao" ref="userDao"/>
        <constructor-arg name="bookDao" ref="bookDao"/>
    </bean>
```



![屏幕截图_1-9-2024_213244_www.bilibili.com](E:/md_picture/屏幕截图_1-9-2024_213244_www.bilibili.com.jpeg)



### 10、自动装配



![屏幕截图_1-9-2024_21357_www.bilibili.com](E:/md_picture/屏幕截图_1-9-2024_21357_www.bilibili.com.jpeg)



主要是按名称和按类型



```java
public class BookServiceImpl implements BookService{
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
```



set必须要



```xml
<bean class="com.itheima.dao.impl.BookDaoImpl"/>
    <!--autowire属性：开启自动装配，通常使用按类型装配-->
    <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl" autowire="byType"/>

```



名称看bookService中声明的名称



![屏幕截图_1-9-2024_215339_www.bilibili.com](E:/md_picture/屏幕截图_1-9-2024_215339_www.bilibili.com.jpeg)



![屏幕截图_1-9-2024_214838_www.bilibili.com](E:/md_picture/屏幕截图_1-9-2024_214838_www.bilibili.com.jpeg)



### 11、集合注入

  

```java
public class BookDaoImpl implements BookDao {

    private int[] array;

    private List<String> list;

    private Set<String> set;

    private Map<String,String> map;

    private Properties properties;




    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }




    public void save() {
        System.out.println("book dao save ...");

        System.out.println("遍历数组:" + Arrays.toString(array));

        System.out.println("遍历List" + list);

        System.out.println("遍历Set" + set);

        System.out.println("遍历Map" + map);

        System.out.println("遍历Properties" + properties);
    }
```



```xml
 <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl">
        <!--数组注入-->
        <property name="array">
            <array>
                <value>100</value>
                <value>200</value>
                <value>300</value>
            </array>
        </property>
        <!--list集合注入-->
        <property name="list">
            <list>
                <value>itcast</value>
                <value>itheima</value>
                <value>boxuegu</value>
                <value>chuanzhihui</value>
            </list>
        </property>
        <!--set集合注入-->
        <property name="set">
            <set>
                <value>itcast</value>
                <value>itheima</value>
                <value>boxuegu</value>
                <value>boxuegu</value>
            </set>
        </property>
        <!--map集合注入-->
        <property name="map">
            <map>
                <entry key="country" value="china"/>
                <entry key="province" value="henan"/>
                <entry key="city" value="kaifeng"/>
            </map>
        </property>
        <!--Properties注入-->
        <property name="properties">
            <props>
                <prop key="country">china</prop>
                <prop key="province">henan</prop>
                <prop key="city">kaifeng</prop>
            </props>
        </property>
    </bean>
```



name指的是名称

set重复了会自动过滤

集合中也可以写<ref bean=""beanId/>（但不常见）



### 12、数据源对象管理



1、先在pom配数据源



```xml
 <dependency>
            <groupId>c3p0</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.1.2</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
```



如果是数据库也要配mysql



2、再注入



```xml
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/spring_db"/>
        <property name="user" value="root"/>
        <property name="password" value="root"/>
        <property name="maxPoolSize" value="1000"/>
    </bean>
```



3、输出



```java
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);
    }
```



### 13、加载properties文件



1、先加context依赖



```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
            http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd
            ">
```



```xml
<!--    1.开启context命名空间-->
<!--    2.使用context空间加载properties文件-->
<!--    <context:property-placeholder location="jdbc.properties" system-properties-mode="NEVER"/>-->
<!--    <context:property-placeholder location="jdbc.properties,jdbc2.properties" system-properties-mode="NEVER"/>-->
<!--    classpath:*.properties  ：   设置加载当前工程类路径中的所有properties文件-->
<!--    system-properties-mode属性：是否加载系统属性-->
    <!--    <context:property-placeholder location="*.properties" system-properties-mode="NEVER"/>-->

    <!--classpath*:*.properties  ：  设置加载当前工程类路径和当前工程所依赖的所有jar包中的所有properties文件-->
    <context:property-placeholder location="classpath*:*.properties" system-properties-mode="NEVER"/>

<!--    3.使用属性占位符${}读取properties文件中的属性-->
<!--    说明：idea自动识别${}加载的属性值，需要手工点击才可以查阅原始书写格式-->
    <bean class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
```



补充：system-properties-mode指的是系统properties模块，有些系统properties是先于程序的properties的

想要加载多个properties文件可以在location后的文件名中加逗号，但最标准的还是classpath*: *.properties

3中的是为了打印properties文件



### 14、 容器



![屏幕截图_2-9-2024_111341_www.bilibili.com](E:/md_picture/屏幕截图_2-9-2024_111341_www.bilibili.com.jpeg)

![屏幕截图_2-9-2024_111417_www.bilibili.com](E:/md_picture/屏幕截图_2-9-2024_111417_www.bilibili.com.jpeg)



### 15、容器总结



![屏幕截图_2-9-2024_111541_www.bilibili.com](E:/md_picture/屏幕截图_2-9-2024_111541_www.bilibili.com.jpeg)



![屏幕截图_2-9-2024_111559_www.bilibili.com](E:/md_picture/屏幕截图_2-9-2024_111559_www.bilibili.com.jpeg)



![屏幕截图_2-9-2024_111718_www.bilibili.com](../../../../Downloads/屏幕截图_2-9-2024_111718_www.bilibili.com.jpeg)



### 16、注解开发定义bean



```java
//@Component定义bean
@Component("bookDao")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
}
```



xml中配置的文件不用写<bean ······了

应改为



```xml
<context:component-scan base-package="com.itheima"/>
```



Component中也可以不写名

如：



```java
@Component
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
```



但启动程序中要改为：



```java
BookService bookService = ctx.getBean(BookService.class);
```



### 17、纯注解开发



1、配置文件都可以不用写，但是要创一个配置类。



```java
//声明当前类为Spring配置类
@Configuration
//设置bean扫描路径，多个路径书写为字符串数组格式
@ComponentScan({"com.itheima.service","com.itheima.dao"})
public class SpringConfig {
}
```



`@ComponentScan`括号中的要么是String，要么是数组



2、然后改一下启动程序



```java
public class AppForAnnotation {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext加载Spring配置类初始化Spring容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);
        //按类型获取bean
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}

```



补充：



```java
//@Component定义bean
//@Component("bookDao")
//@Repository：@Component衍生注解
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
}
```



```java
//@Component定义bean
//@Component
//@Service：@Component衍生注解
@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
```



### 18、注解开发bean与生命周期



```java
//@Scope设置bean的作用范围
@Scope("singleton")//单例
//@Scope("prototype") 非单例
public class BookDaoImpl implements BookDao {

    public void save() {
        System.out.println("book dao save ...");
    }
 

}
```



然后是生命周期



```java
    @PostConstruct//开始
    public void init() {
        System.out.println("init ...");
    }
    //@PreDestroy设置bean的销毁方法
    @PreDestroy//结束
    public void destroy() {
        System.out.println("destroy ...");
```



最后记得close



```java
 public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao1 = ctx.getBean(BookDao.class);
        BookDao bookDao2 = ctx.getBean(BookDao.class);
        System.out.println(bookDao1);
        System.out.println(bookDao2);
        ctx.close();
    }
```



补充：

**@PostConstruct和 @PreDestroy注解位于 java.xml.ws.annotation包是Java EE的模块的一部分。J2EE已经在Java 9中被弃用，并且计划在Java 11中删除它。**



解决办法：
为pom.xml或build.gradle添加必要的依赖项

（Java 9+中的Spring @PostConstruct和@PreDestroy替代品）



```xml
<dependency>
  <groupId>javax.annotation</groupId>
  <artifactId>javax.annotation-api</artifactId>
  <version>1.3.2</version>
</dependency>
```


### 19、注解开发依赖注入



只有自动装配，因为注解是便于开发的，所以 阉割了部分内容。



```java
public class BookServiceImpl implements BookService {
    //@Autowired：注入引用类型，自动装配模式，默认按类型装配
    @Autowired
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
```



如果有不同类型的bean,要加`@Qualifier(" ")`,`@Autowired`必须要加



```java
@Service
public class BookServiceImpl implements BookService {
    //@Autowired：注入引用类型，自动装配模式，默认按类型装配
    @Autowired
    //@Qualifier：自动装配bean时按bean名称装配
    @Qualifier("bookDao")
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
```



![屏幕截图_4-9-2024_94055_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_94055_www.bilibili.com.jpeg)



如果要注入值



```java
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    //@Value：注入简单类型（无需提供set方法）
    @Value("name")
    private String name;

    public void save() {
        System.out.println("book dao save ..." + name);
    }
}
```



如果要读取properties文件



```java
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    //@Value：注入简单类型（无需提供set方法）
    @Value("${name}")
    private String name;

    public void save() {
        System.out.println("book dao save ..." + name);
    }
}
```



然后配置文件要加



```java
@Configuration
@ComponentScan("com.itheima")
//@PropertySource加载properties配置文件
@PropertySource({"jdbc.properties"})
public class SpringConfig {
}
```



### 20、注解开发管理第三方bean



如果要管理第三方bean，要专门创一个配置文件JdbcConfig



```java
//@Configuration
public class JdbcConfig {
    //1.定义一个方法获得要管理的对象
    //2.添加@Bean，表示当前方法的返回值是一个bean
    //@Bean修饰的方法，形参根据类型自动装配
    @Bean
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
   }
}
```



然后在SpringConfig开Import注解



```java
@Configuration
@ComponentScan("com.itheima")
//@Import:导入配置信息
@Import({JdbcConfig.class})
public class SpringConfig {
}
```



### 21、注解开发实现为第三方bean注入资源



先注入简单类型



```java
//@Configuration
public class JdbcConfig {
    //1.定义一个方法获得要管理的对象
    @Value("com.mysql.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/spring_db")
    private String url;
    @Value("root")
    private String userName;
    @Value("root")
    private String password;
    //2.添加@Bean，表示当前方法的返回值是一个bean
    //@Bean修饰的方法，形参根据类型自动装配
    @Bean
    public DataSource dataSource(BookDao bookDao){
        System.out.println(bookDao);
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
```



注意：

传入的bookDao是被自动装配过的，所以可以打印。（按类型装配）



### 22、注解开发总结



![屏幕截图_4-9-2024_153538_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_153538_www.bilibili.com.jpeg)



@Component与@Configuration的区别

1. **`@Component`**:

   - 用途：用于标记一个普通的 Spring 组件类。
   - 作用：Spring 容器会扫描并将其作为一个 Bean 注册到容器中。`@Component` 主要用于标记服务类、DAO 类、控制器类等。
   - 使用场景：一般用于简单的类，不需要提供其他 Bean 定义的场合。

   ```
   javaCopy code@Component
   public class MyService {
       // 业务逻辑
   }
   ```

2. **`@Configuration`**:

   - 用途：用于标记一个配置类，表示这个类是用来定义 Spring 容器中 Bean 的配置类。
   - 作用：`@Configuration` 的类通常包含一个或多个 `@Bean` 方法，用于手动定义和管理 Bean。
   - 使用场景：用于复杂的 Bean 配置场景，如手动管理数据源、事务管理器等。

   ```
   javaCopy code@Configuration
   public class AppConfig {
   
       @Bean
       public MyService myService() {
           return new MyService();
       }
   }
   ```

总结：

- 如果你的类是一个普通的组件，处理业务逻辑（如服务类、控制器类），应当使用 `@Component`。
- 如果你的类是一个配置类，用于定义多个 Bean（通过 `@Bean` 方法），应当使用 `@Configuration`。

不能随意将 `@Component` 改为 `@Configuration`，因为这两者的作用不同。简单的业务类应该使用 `@Component`，而配置类才需要使用 `@Configuration`。



`@RequiredArgsConstructor`类似与`@Autowired`



常规 @Autowired注入:



```java
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public User getUser(){
        User user = userService.getUser("1");
        return user;
    }
}

```



lombok中的**RequiredArgsConstructor注入：



```java
public class UserController {

    private final UserService userService;

    @GetMapping("/getUser")
    public User getUser(){
        User user = userService.getUser("1");
        return user;
    }
}
```



### 23、Spring整合Mybatis思路分析



![屏幕截图_13-9-2024_164422_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_164422_www.bilibili.com.jpeg)



![屏幕截图_13-9-2024_164442_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_164442_www.bilibili.com.jpeg)



### 24、Spring整合MyBatis



1、配置pom文件



```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.itheima</groupId>
  <artifactId>spring_15_spring_mybatis</artifactId>
  <version>1.0-SNAPSHOT</version>

  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.2.10.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.16</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.6</version>
    </dependency>

    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.47</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.2.10.RELEASE</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.0</version>
    </dependency>

  </dependencies>
</project>

```



2、配置SpringConfig



```java
package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itheima")
//@PropertySource：加载类路径jdbc.properties文件
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
//要么在JdbcConfig类中加@Configuration
public class SpringConfig {
}
```



3、配置JdbcConfig类



```java
package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
```



3、创建MybatisConfig类



```java
package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    //定义bean，SqlSessionFactoryBean，用于产生SqlSessionFactory对象
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.itheima.domain");
        ssfb.setDataSource(dataSource);
        return ssfb;
    }
    //定义bean，返回MapperScannerConfigurer对象
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }
}
```



4、配置启动类

 

```java
import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService accountService = ctx.getBean(AccountService.class);

        Account ac = accountService.findById(1);
        System.out.println(ac);
    }
}

```



![屏幕截图_13-9-2024_214136_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_214136_www.bilibili.com.jpeg)



![屏幕截图_13-9-2024_214151_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_214151_www.bilibili.com.jpeg)



### 25、JUnit整合



JUnit介绍：测试框架



1、导包



```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.itheima</groupId>
  <artifactId>spring_16_spring_junit</artifactId>
  <version>1.0-SNAPSHOT</version>

  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.2.10.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.16</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.6</version>
    </dependency>

    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.47</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.2.10.RELEASE</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.0</version>
    </dependency>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>5.2.10.RELEASE</version>
    </dependency>

  </dependencies>
</project>

```



 2、配置运行器



```java
package com.itheima.service;

import com.itheima.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境对应的配置类
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    //支持自动装配注入bean(测谁写谁)
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById(){
        System.out.println(accountService.findById(1));

    }

    @Test
    public void testFindAll(){
        System.out.println(accountService.findAll());
    }


}

```



### 26、AOP简介



![屏幕截图_4-9-2024_162810_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_162810_www.bilibili.com.jpeg)

![屏幕截图_4-9-2024_163158_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_163158_www.bilibili.com.jpeg)



![屏幕截图_4-9-2024_163721_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_163721_www.bilibili.com.jpeg)

### 27、AOP入门案例



1、配置pom文件



```xml
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.9.4</version>
    </dependency>
```



2、制作通知



```java
@Component
//设置当前类为切面类
@Aspect
//声明AOP
public class MyAdvice {
    //设置切入点，要求配置在方法上方
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    private void pt(){}//方法要无参数，无返回值，无实际逻辑

    //设置在切入点pt()的前面运行当前操作（前置通知）
    // @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
```



3、配置配置类



```java
@Configuration
@ComponentScan("com.itheima")
//开启注解开发AOP功能
@EnableAspectJAutoProxy
public class SpringConfig {
}
```



### 28、AOP工作流程



![屏幕截图_4-9-2024_165939_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_165939_www.bilibili.com.jpeg)



![屏幕截图_4-9-2024_172752_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_172752_www.bilibili.com.jpeg)



![屏幕截图_4-9-2024_17323_www.bilibili.com](E:/md_picture/屏幕截图_4-9-2024_17323_www.bilibili.com.jpeg)

### 29、AOP切入点表达式



![屏幕截图_5-9-2024_16158_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_16158_www.bilibili.com.jpeg)



![屏幕截图_5-9-2024_161533_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_161533_www.bilibili.com.jpeg)

![屏幕截图_5-9-2024_161551_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_161551_www.bilibili.com.jpeg)



```java
public class MyAdvice {
    //切入点表达式：
//    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
//    @Pointcut("execution(void com.itheima.dao.impl.BookDaoImpl.update())")
//    @Pointcut("execution(* com.itheima.dao.impl.BookDaoImpl.update(*))")    //no（这个不行的原因是原本BookDaoImpl.update()是没参数的，但*号强制要有参数
//    @Pointcut("execution(void com.*.*.*.update())")
//    @Pointcut("execution(* *..*(..))")
//    @Pointcut("execution(* *..*e(..))")
//    @Pointcut("execution(void com..*())")
//    @Pointcut("execution(* com.itheima.*.*Service.find*(..))")
    //执行com.itheima包下的任意包下的名称以Service结尾的类或接口中的save方法，参数任意，返回值任意
    @Pointcut("execution(* com.itheima.*.*Service.save(..))")
    private void pt(){}

    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
```



![屏幕截图_5-9-2024_16175_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_16175_www.bilibili.com.jpeg)

### 30、AOP通知类型



![屏幕截图_5-9-2024_162324_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_162324_www.bilibili.com.jpeg)



```java
public class MyAdvice {
    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
    private void pt(){}
    @Pointcut("execution(int com.itheima.dao.BookDao.select())")
    private void pt2(){}

    //@Before：前置通知，在原始方法运行之前执行
//    @Before("pt()")
    public void before() {
        System.out.println("before advice ...");
    }

    //@After：后置通知，在原始方法运行之后执行
//    @After("pt2()")
    public void after() {
        System.out.println("after advice ...");
    }

    //@Around：环绕通知，在原始方法运行的前后执行
//    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用，如果原来的函数有返回值，那这里也有
        Object ret = pjp.proceed();
        System.out.println("around after advice ...");
        return ret;
    }

//    @Around("pt2()")
    public Object aroundSelect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用
        Integer ret = (Integer) pjp.proceed();
        System.out.println("around after advice ...");
        return ret;
    }

    //@AfterReturning：返回后通知，在原始方法执行完毕后运行，且原始方法执行过程中未出现异常现象
//    @AfterReturning("pt2()")
    public void afterReturning() {
        System.out.println("afterReturning advice ...");
    }

    //@AfterThrowing：抛出异常后通知，在原始方法执行过程中出现异常后运行
    @AfterThrowing("pt2()")
    public void afterThrowing() {
        System.out.println("afterThrowing advice ...");
    }
}
```



![屏幕截图_5-9-2024_162429_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_162429_www.bilibili.com.jpeg)



![屏幕截图_5-9-2024_162451_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_162451_www.bilibili.com.jpeg)

### 31、案例-业务层接口执行效率



拿方法信息



拿类的信息：signature.getDeclaringTypeName()



拿方法的信息：signature.getName()



```java
package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProjectAdvice {
    //匹配业务层的所有方法
    @Pointcut("execution(* com.itheima.service.*Service.*(..))")
    private void servicePt(){}

    //设置环绕通知，在原始操作的运行前后记录执行时间
    @Around("ProjectAdvice.servicePt()")
    public void runSpeed(ProceedingJoinPoint pjp) throws Throwable {
        //获取执行的签名对象
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
           pjp.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println("万次执行："+ className+"."+methodName+"---->" +(end-start) + "ms");
    }

}

```





### 32、AOP通知获取数据



![屏幕截图_5-9-2024_163824_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_163824_www.bilibili.com.jpeg)



```java
public class MyAdvice {
    @Pointcut("execution(* com.itheima.dao.BookDao.findName(..))")
    private void pt(){}

    //JoinPoint：用于描述切入点的对象，必须配置成通知方法中的第一个参数，可用于获取原始方法调用的参数
//    @Before("pt()")
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("before advice ..." );
    }

//    @After("pt()")
    public void after(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("after advice ...");
    }

    //ProceedingJoinPoint：专用于环绕通知，是JoinPoint子类，可以实现对原始方法的调用
//    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));
        args[0] = 666;
        Object ret = null;
        try {
            ret = pjp.proceed(args);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return ret;
    }

    //设置返回后通知获取原始方法的返回值，要求returning属性值必须与方法形参名相同,JoinPoint jp必须在第零位
    @AfterReturning(value = "pt()",returning = "ret")
    public void afterReturning(JoinPoint jp,String ret) {
        System.out.println("afterReturning advice ..."+ret);
    }

    //设置抛出异常后通知获取原始方法运行时抛出的异常对象，要求throwing属性值必须与方法形参名相同
    @AfterThrowing(value = "pt()",throwing = "t")
    public void afterThrowing(Throwable t) {
        System.out.println("afterThrowing advice ..."+t);
    }
}
```



![屏幕截图_13-9-2024_223025_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_223025_www.bilibili.com.jpeg)



### 33、案例-百度网盘密码数据兼容处理



![屏幕截图_13-9-2024_223611_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_223611_www.bilibili.com.jpeg)



```java
package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataAdvice {
    @Pointcut("execution(boolean com.itheima.service.*Service.*(*,*))")
    private void servicePt(){}

    @Around("DataAdvice.servicePt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            //判断参数是不是字符串(如果是就让回去，不是就null)
            if(args[i].getClass().equals(String.class)){
                args[i] = args[i].toString().trim();
            }
        }
        Object ret = pjp.proceed(args);
        return ret;
    }


}

```



### 34、AOP总结



![屏幕截图_5-9-2024_165353_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_165353_www.bilibili.com.jpeg)



![屏幕截图_5-9-2024_16549_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_16549_www.bilibili.com.jpeg)



![屏幕截图_5-9-2024_165426_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_165426_www.bilibili.com.jpeg)



![屏幕截图_5-9-2024_165438_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_165438_www.bilibili.com.jpeg)



![屏幕截图_5-9-2024_165455_www.bilibili.com](E:/md_picture/屏幕截图_5-9-2024_165455_www.bilibili.com.jpeg)



### 35、Spring事务简介



事务就是没报错时，一齐执行，

有报错时，不执行



1、配置事务



```java
public interface AccountService {
    /**
     * 转账操作
     * @param out 传出方
     * @param in 转入方
     * @param money 金额
     */
    //配置当前接口方法具有事务
    @Transactional
    public void transfer(String out,String in ,Double money) ;
}
```



Spring注解事务一般注释到接口中，降低耦合。

可以添加到类中，开启所有事务。



2、设置事务管理器



```java
//配置事务管理器，mybatis使用的是jdbc事务
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

```



3、开启注解式事务驱动



```java
@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
//开启注解式事务驱动
@EnableTransactionManagement
public class SpringConfig {
}
```



### 36、Spring事务角色



![屏幕截图_9-9-2024_15331_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_15331_www.bilibili.com.jpeg)



![屏幕截图_9-9-2024_153318_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_153318_www.bilibili.com.jpeg)



### 37、spring事务属性



出现事务回滚的异常：1、er系的。2、运行时异常



在`@Transactional( )`中添加

![屏幕截图_9-9-2024_153459_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_153459_www.bilibili.com.jpeg)



![屏幕截图_9-9-2024_154728_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_154728_www.bilibili.com.jpeg)



### 补充



@Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处:
1、可以当注释用,方便阅读；
2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，因为编译器以为这个方法是你的子类中自己增加的方法



## 二、SpringMVC



### 1、SpringMVC简介



![屏幕截图_19-9-2024_18312_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_18312_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_18330_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_18330_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_18348_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_18348_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_1848_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_1848_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_18459_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_18459_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_18510_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_18510_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_18547_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_18547_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_1863_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_1863_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_1869_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_1869_www.bilibili.com.jpeg)



### 2、SpringMVC入门案例



![屏幕截图_19-9-2024_203313_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203313_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_203332_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203332_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_203338_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203338_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_203344_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203344_www.bilibili.com.jpeg)





![屏幕截图_19-9-2024_203421_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203421_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_203534_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203534_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_20361_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_20361_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_203648_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203648_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_203820_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203820_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_203827_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_203827_www.bilibili.com.jpeg)



### 3、入门案例工作流程



![屏幕截图_19-9-2024_212056_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_212056_www.bilibili.com.jpeg)



### 4、bean加载控制



![屏幕截图_19-9-2024_21388_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_21388_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_213834_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_213834_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_213857_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_213857_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_21418_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_21418_www.bilibili.com.jpeg)



### 5、PostMan工具介绍



![屏幕截图_19-9-2024_214539_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_214539_www.bilibili.com.jpeg)



![屏幕截图_19-9-2024_21492_www.bilibili.com](E:/md_picture/屏幕截图_19-9-2024_21492_www.bilibili.com.jpeg)



### 6、设置请求映射路径



![屏幕截图_20-9-2024_134833_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_134833_www.bilibili.com.jpeg)



不同的请求路径相同的模块名会报错



![屏幕截图_20-9-2024_13496_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_13496_www.bilibili.com.jpeg)



如：



![屏幕截图_20-9-2024_135241_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_135241_www.bilibili.com.jpeg)



改为：



![屏幕截图_20-9-2024_135311_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_135311_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_135338_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_135338_www.bilibili.com.jpeg)



### 7、get请求与post请求发送普通参数



![屏幕截图_20-9-2024_161533_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_161533_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_161652_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_161652_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_16172_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_16172_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_161918_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_161918_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_161926_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_161926_www.bilibili.com.jpeg)



### 8、5种类型参数传递



![屏幕截图_20-9-2024_162338_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_162338_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_162846_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_162846_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163532_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163532_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163542_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163542_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163556_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163556_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163613_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163613_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163639_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163639_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163645_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163645_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163721_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163721_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_163726_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_163726_www.bilibili.com.jpeg)



### 9、json数据传递参数



![屏幕截图_20-9-2024_164227_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164227_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164810_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164810_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164731_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164731_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164834_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164834_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164843_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164843_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164848_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164848_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164853_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164853_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164925_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164925_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_164934_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_164934_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_16503_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_16503_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_165012_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_165012_www.bilibili.com.jpeg)



### 10、日期型参数传递



![屏幕截图_20-9-2024_165545_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_165545_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_17033_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_17033_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_17039_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_17039_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_17157_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_17157_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_17149_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_17149_www.bilibili.com.jpeg)

### 11、响应



![屏幕截图_20-9-2024_17530_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_17530_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_171144_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_171144_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_171150_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_171150_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_171159_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_171159_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_171218_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_171218_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_171319_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_171319_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_171940_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_171940_www.bilibili.com.jpeg)



![屏幕截图_20-9-2024_171436_www.bilibili.com](E:/md_picture/屏幕截图_20-9-2024_171436_www.bilibili.com.jpeg)



### 12、REST风格简介



![屏幕截图_23-9-2024_204215_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_204215_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_20430_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_20430_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_204527_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_204527_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_204538_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_204538_www.bilibili.com.jpeg)



### 13、RESTful入门案例



![屏幕截图_24-9-2024_192248_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_192248_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_192255_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_192255_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_192319_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_192319_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_192418_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_192418_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_192448_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_192448_www.bilibili.com.jpeg)



### 14、RESTful快速开发



![屏幕截图_23-9-2024_20539_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_20539_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_205637_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_205637_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_205643_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_205643_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_205721_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_205721_www.bilibili.com.jpeg)



### 15、案例：基于RESTful页面数据交互（后台接口开发）



不说了直接上控制类



```java
package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println("book save ==> "+ book);
        return "{'module':'book save success'}";
    }

    @GetMapping
    public List<Book> getAll(){
        System.out.println("book getAll is running ...");
        List<Book> bookList = new ArrayList<Book>();

        Book book1 = new Book();
        book1.setType("计算机");
        book1.setName("SpringMVC入门教程");
        book1.setDescription("小试牛刀");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setType("计算机");
        book2.setName("SpringMVC实战教程");
        book2.setDescription("一代宗师");
        bookList.add(book2);

        Book book3 = new Book();
        book3.setType("计算机丛书");
        book3.setName("SpringMVC实战教程进阶");
        book3.setDescription("一代宗师呕心创作");
        bookList.add(book3);

        return bookList;
    }

}

```



### 16、案例：基于RESTful页面数据交互（页面访问处理）



![屏幕截图_24-9-2024_194237_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_194237_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_194253_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_194253_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_194343_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_194343_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_194355_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_194355_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_19447_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_19447_www.bilibili.com.jpeg)



### 17、SSM整合（整合配置）



![屏幕截图_23-9-2024_103954_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_103954_www.bilibili.com.jpeg)



感觉springboot把配置简化好多



### 18、SSM整合（功能模块开发）



![屏幕截图_23-9-2024_103954_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_103954_www.bilibili.com-1727061281660-4.jpeg)



参考项目



### 19、SSM整合（接口测试）



记得接事务



![98924595166d9c709e1695c003d6089](E:/md_picture/98924595166d9c709e1695c003d6089.png)



![fddd829b2aaa887a4715e9c5eddb7e2](E:/md_picture/fddd829b2aaa887a4715e9c5eddb7e2.png)



![d4b8b15b5a025523933a9aba117e9c0](E:/md_picture/d4b8b15b5a025523933a9aba117e9c0.png)



![faeb3d81e06de0ba569bdc68adcd4b4](E:/md_picture/faeb3d81e06de0ba569bdc68adcd4b4.png)



![72806fdbd636406a79aa2acfd51a1fe](E:/md_picture/72806fdbd636406a79aa2acfd51a1fe.png)



![983a58bd829d55ca1de9df95aa8c4a7](E:/md_picture/983a58bd829d55ca1de9df95aa8c4a7.png)



![73fb462ea2bb579e7d15b39b2404a26](E:/md_picture/73fb462ea2bb579e7d15b39b2404a26.png)



![96d00085eeb8acdd58a774ae60f282b](E:/md_picture/96d00085eeb8acdd58a774ae60f282b.png)



![2955a622ef93d131421375c33a2bde0](E:/md_picture/2955a622ef93d131421375c33a2bde0.png)



![a1e5cd91187bf780f54276063b308a7](E:/md_picture/a1e5cd91187bf780f54276063b308a7.png)



![54fae00694d992f49f38d9892690ff5](E:/md_picture/54fae00694d992f49f38d9892690ff5.png)



![11cfc4e548f472eec54d45b550ebe8f](E:/md_picture/11cfc4e548f472eec54d45b550ebe8f.png)



![3b8856ca6f0f938dea6468fabd3a0ff](E:/md_picture/3b8856ca6f0f938dea6468fabd3a0ff.png)



![96a8722fba40af802587373205312fe](E:/md_picture/96a8722fba40af802587373205312fe.png)



### 20、SSM整合-表现层与前端数据传输协议定义



![4a4e61d2e739cfef72dde27665bda00](E:/md_picture/4a4e61d2e739cfef72dde27665bda00.png)



![0f57bb62e9e3eeb69032b2ba1afc563](E:/md_picture/0f57bb62e9e3eeb69032b2ba1afc563.png)



![79905743abf675dd41b58b428299037](E:/md_picture/79905743abf675dd41b58b428299037.png)



![d139f9c7d6f3f4be41fdecbed55e56d](E:/md_picture/d139f9c7d6f3f4be41fdecbed55e56d.png)



![屏幕截图_23-9-2024_134149_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_134149_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_134224_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_134224_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_134314_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_134314_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_134338_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_134338_www.bilibili.com.jpeg)



### 21、SSM整合-表现层与前端数据传输数据协议实现



![屏幕截图_23-9-2024_144653_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_144653_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_15130_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_15130_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_15145_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_15145_www.bilibili.com.jpeg)



### 22、SSM整合-异常处理器



![屏幕截图_23-9-2024_152139_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_152139_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_152351_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_152351_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_152640_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_152640_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_152659_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_152659_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_152743_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_152743_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_152753_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_152753_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_152836_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_152836_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_193334_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_193334_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_192352_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_192352_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_192423_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_192423_www.bilibili.com.jpeg)



### 23、SSM整合-项目异常处理



![屏幕截图_23-9-2024_194156_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_194156_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_194236_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_194236_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_194320_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_194320_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_194333_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_194333_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_195559_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_195559_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_195612_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_195612_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_195619_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_195619_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_195639_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_195639_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_195646_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_195646_www.bilibili.com.jpeg)



在controller包下



![屏幕截图_23-9-2024_195730_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_195730_www.bilibili.com.jpeg)



![屏幕截图_23-9-2024_195742_www.bilibili.com](E:/md_picture/屏幕截图_23-9-2024_195742_www.bilibili.com.jpeg)



### 24、SSM整合-前后台协议联调（列表功能）



```html
<!DOCTYPE html>

<html>

    <head>

        <!-- 页面meta -->

        <meta charset="utf-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SpringMVC案例</title>

        <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

        <!-- 引入样式 -->

        <link rel="stylesheet" href="../plugins/elementui/index.css">

        <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">

        <link rel="stylesheet" href="../css/style.css">

    </head>

    <body class="hold-transition">

        <div id="app">

            <div class="content-header">

                <h1>图书管理</h1>

            </div>

            <div class="app-container">

                <div class="box">

                    <div class="filter-container">

                        <el-input placeholder="图书名称" v-model="pagination.queryString" style="width: 200px;" class="filter-item"></el-input>

                        <el-button @click="getAll()" class="dalfBut">查询</el-button>

                        <el-button type="primary" class="butT" @click="handleCreate()">新建</el-button>

                    </div>

                    <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>

                        <el-table-column type="index" align="center" label="序号"></el-table-column>

                        <el-table-column prop="type" label="图书类别" align="center"></el-table-column>

                        <el-table-column prop="name" label="图书名称" align="center"></el-table-column>

                        <el-table-column prop="description" label="描述" align="center"></el-table-column>

                        <el-table-column label="操作" align="center">

                            <template slot-scope="scope">

                                <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>

                                <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>

                            </template>

                        </el-table-column>

                    </el-table>

                    <!-- 新增标签弹层 -->

                    <div class="add-form">

                        <el-dialog title="新增图书" :visible.sync="dialogFormVisible">

                            <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

                                <el-row>

                                    <el-col :span="12">

                                        <el-form-item label="图书类别" prop="type">

                                            <el-input v-model="formData.type"/>

                                        </el-form-item>

                                    </el-col>

                                    <el-col :span="12">

                                        <el-form-item label="图书名称" prop="name">

                                            <el-input v-model="formData.name"/>

                                        </el-form-item>

                                    </el-col>

                                </el-row>


                                <el-row>

                                    <el-col :span="24">

                                        <el-form-item label="描述">

                                            <el-input v-model="formData.description" type="textarea"></el-input>

                                        </el-form-item>

                                    </el-col>

                                </el-row>

                            </el-form>

                            <div slot="footer" class="dialog-footer">

                                <el-button @click="dialogFormVisible = false">取消</el-button>

                                <el-button type="primary" @click="handleAdd()">确定</el-button>

                            </div>

                        </el-dialog>

                    </div>

                    <!-- 编辑标签弹层 -->

                    <div class="add-form">

                        <el-dialog title="编辑检查项" :visible.sync="dialogFormVisible4Edit">

                            <el-form ref="dataEditForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

                                <el-row>

                                    <el-col :span="12">

                                        <el-form-item label="图书类别" prop="type">

                                            <el-input v-model="formData.type"/>

                                        </el-form-item>

                                    </el-col>

                                    <el-col :span="12">

                                        <el-form-item label="图书名称" prop="name">

                                            <el-input v-model="formData.name"/>

                                        </el-form-item>

                                    </el-col>

                                </el-row>

                                <el-row>

                                    <el-col :span="24">

                                        <el-form-item label="描述">

                                            <el-input v-model="formData.description" type="textarea"></el-input>

                                        </el-form-item>

                                    </el-col>

                                </el-row>

                            </el-form>

                            <div slot="footer" class="dialog-footer">

                                <el-button @click="dialogFormVisible4Edit = false">取消</el-button>

                                <el-button type="primary" @click="handleEdit()">确定</el-button>

                            </div>

                        </el-dialog>

                    </div>

                </div>

            </div>

        </div>

    </body>

    <!-- 引入组件库 -->

    <script src="../js/vue.js"></script>

    <script src="../plugins/elementui/index.js"></script>

    <script type="text/javascript" src="../js/jquery.min.js"></script>

    <script src="../js/axios-0.18.0.js"></script>

    <script>
        var vue = new Vue({

            el: '#app',
            data:{
                pagination: {},
				dataList: [],//当前页要展示的列表数据
                formData: {},//表单数据
                dialogFormVisible: false,//控制表单是否可见
                dialogFormVisible4Edit:false,//编辑表单是否可见
                rules: {//校验规则
                    type: [{ required: true, message: '图书类别为必填项', trigger: 'blur' }],
                    name: [{ required: true, message: '图书名称为必填项', trigger: 'blur' }]
                }
            },

            //钩子函数，VUE对象初始化完成后自动执行
            created() {
                this.getAll();
            },

            methods: {
                //列表
                getAll() {
                    //发送ajax请求
                    axios.get("/books").then((res)=>{
                        this.dataList = res.data.data;
                    });
                },
```



前后端分离后后端就没这个了



### 25、SSM整合前后台协议联调（添加功能）



上html



```html
//弹出添加窗口
                handleCreate() {
                    this.dialogFormVisible = true;
                    this.resetForm();
                },
                
                 //添加
                handleAdd () {
                    //发送ajax请求
                    axios.post("/books",this.formData).then((res)=>{
                        this.dialogFormVisible = false;            
                        this.getAll();
                },
```



### 26、SSM整合-前后台协议联调（添加功能状态处理）



上html



```html
//列表
                getAll() {
                    //发送ajax请求
                    axios.get("/books").then((res)=>{
                        this.dataList = res.data.data;
                    });
                },

                //弹出添加窗口
                handleCreate() {
                    this.dialogFormVisible = true;
                    this.resetForm();
                },

                //重置表单
                resetForm() {
                    this.formData = {};
                },

                //添加
                handleAdd () {
                    //发送ajax请求
                    axios.post("/books",this.formData).then((res)=>{
                        console.log(res.data);
                        //如果操作成功，关闭弹层，显示数据
                        if(res.data.code == 20011){
                            this.dialogFormVisible = false;
                            this.$message.success("添加成功");
                        }else if(res.data.code == 20010){
                            this.$message.error("添加失败");
                        }else{
                            this.$message.error(res.data.msg);
                        }
                    }).finally(()=>{
                        this.getAll();
                    });
                },
```



改一下接收数据的类



```java
package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {

//    @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    public int save(Book book);

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    public int update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public int delete(Integer id);

    @Select("select * from tbl_book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from tbl_book")
    public List<Book> getAll();
}
```



### 26、SSM整合-前后台协议联调（修改功能）



```html
//弹出编辑窗口
handleUpdate(row) {
    // console.log(row);   //row.id 查询条件
    //查询数据，根据id查询
    axios.get("/books/"+row.id).then((res)=>{
        // console.log(res.data.data);
        if(res.data.code == 20041){
            //展示弹层，加载数据
            this.formData = res.data.data;
            this.dialogFormVisible4Edit = true;
        }else{
            this.$message.error(res.data.msg);
        }
    });
},

//编辑
handleEdit() {
    //发送ajax请求
    axios.put("/books",this.formData).then((res)=>{
        //如果操作成功，关闭弹层，显示数据
        if(res.data.code == 20031){
            this.dialogFormVisible4Edit = false;
            this.$message.success("修改成功");
        }else if(res.data.code == 20030){
            this.$message.error("修改失败");
        }else{
            this.$message.error(res.data.msg);
        }
    }).finally(()=>{
        this.getAll();
    });
},
```



### 28、SSM整合-前后台协议联调（删除功能）



```html
 // 删除
                handleDelete(row) {
                    //1.弹出提示框
                    this.$confirm("此操作永久删除当前数据，是否继续？","提示",{
                        type:'info'
                    }).then(()=>{
                        //2.做删除业务
                        axios.delete("/books/"+row.id).then((res)=>{
                            if(res.data.code == 20021){
                                this.$message.success("删除成功");
                            }else{
                                this.$message.error("删除失败");
                            }
                        }).finally(()=>{
                            this.getAll();
                        });
                    }).catch(()=>{
                        //3.取消删除
                        this.$message.info("取消删除操作");
                    });
                }
```



![屏幕截图_24-9-2024_20485_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_20485_www.bilibili.com.jpeg)



![屏幕截图_24-9-2024_204821_www.bilibili.com](E:/md_picture/屏幕截图_24-9-2024_204821_www.bilibili.com.jpeg)



### 29、拦截器简介



![屏幕截图_25-9-2024_9498_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_9498_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_9529_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_9529_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_95218_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_95218_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_9530_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_9530_www.bilibili.com.jpeg)



### 30、拦截器入门案例



![屏幕截图_25-9-2024_164648_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_164648_www.bilibili.com.jpeg)



注：第一个是拦截前，第二个是拦截后，第三个是完成时。



在controller包下



![屏幕截图_25-9-2024_164657_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_164657_www.bilibili.com.jpeg)



```java
package com.itheima.config;

import com.itheima.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
    }
}
```



![屏幕截图_25-9-2024_164833_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_164833_www.bilibili.com.jpeg)



用这个就不用配SpringMvcSupport了



![屏幕截图_25-9-2024_164922_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_164922_www.bilibili.com-1727254751404-6.jpeg)



![屏幕截图_25-9-2024_164930_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_164930_www.bilibili.com.jpeg)



### 31、拦截器参数



![屏幕截图_25-9-2024_172026_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_172026_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_172051_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_172051_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_172113_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_172113_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_172121_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_172121_www.bilibili.com.jpeg)



### 32、拦截器链配置



实现



```java
package com.itheima.config;

import com.itheima.controller.interceptor.ProjectInterceptor;
import com.itheima.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.itheima.controller"})
@EnableWebMvc
//实现WebMvcConfigurer接口可以简化开发，但具有一定的侵入性
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置多拦截器
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books","/books/*");
    }
}
```



![屏幕截图_25-9-2024_205110_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_205110_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_205147_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_205147_www.bilibili.com.jpeg)



![屏幕截图_25-9-2024_205222_www.bilibili.com](E:/md_picture/屏幕截图_25-9-2024_205222_www.bilibili.com.jpeg)



## 三、MyBatis



### 1、MyBatis简介



![屏幕截图_9-9-2024_211643_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_211643_www.bilibili.com.jpeg)



![屏幕截图_9-9-2024_212622_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_212622_www.bilibili.com.jpeg)

![屏幕截图_9-9-2024_212647_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_212647_www.bilibili.com.jpeg)



![屏幕截图_9-9-2024_212756_www.bilibili.com](E:/md_picture/屏幕截图_9-9-2024_212756_www.bilibili.com.jpeg)



### 2、MyBatis快速入门



![屏幕截图_10-9-2024_9218_www.bilibili.com](E:/md_picture/屏幕截图_10-9-2024_9218_www.bilibili.com.jpeg)



1、先增加MyBatis的依赖



```xml
   <!--mybatis 依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
        </dependency>

```



2、增加Mysql的驱动



```xml
   <!--mysql 驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.46</version>
        </dependency>

```



3、增加junit单元测试



```xml
 <!--junit 单元测试-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>
```



4、logback坐标信息



```xml
<!-- 添加slf4j日志api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.20</version>
        </dependency>
        <!-- 添加logback-classic依赖 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
        <!-- 添加logback-core依赖 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>1.2.3</version>
        </dependency>

```



5、从XML中配置SqlSessionFactory



```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

   
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--数据库连接信息-->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql:///mybatis?useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="1234"/>
            </dataSource>
        </environment>

    </environments>
    <mappers>
        <!--加载sql映射文件-->
       <mapper resource="com/itheima/mapper/UserMapper.xml"/>

       
    </mappers>


</configuration>
```



6、配置SQL映射文件



文件名一般为`xxxMapper.xml`



![屏幕截图_10-9-2024_9453_www.bilibili.com](E:/md_picture/屏幕截图_10-9-2024_9453_www.bilibili.com.jpeg)



resultType后面是要写对应类的地址



 7、构造User类



```java
package com.itheima.pojo;


// alt + 鼠标左键 整列编辑
public class User {

    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String addr;

    //Alt+insert
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
```



 8、加载核心配置文件



```java
/**
 * Mybatis 快速入门代码
 */
public class MyBatisDemo {

    public static void main(String[] args) throws IOException {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);
        //4. 释放资源
        sqlSession.close();

    }
}

```



###  3、解决SQL语句警告问题



往ide添加数据库即可



### 4、Mapper代理开发



![屏幕截图_12-9-2024_191548_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_191548_www.bilibili.com.jpeg)



![屏幕截图_12-9-2024_191630_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_191630_www.bilibili.com.jpeg)



Mapper文件放入文件夹



![image-20240912192010602](E:/md_picture/image-20240912192010602.png)



编译文件时要com/itheima/mapper



UserMapper.xml



```xml
<mapper namespace="test">

    <!--statement-->
    <select id="selectAll" resultType="com.itheima.pojo.User">
        select *
        from tb_user;
    </select>

    <select id="select" resultType="com.itheima.pojo.User">
        select *
        from tb_user
        where
            username = #{arg0}
          and password = #{param2}
    </select>

</mapper>
```



mabatis-config也要改一下



```xml
    <mappers>
        <!--加载sql映射文件-->
        <mapper resource="UserMapper.xml"/>


    </mappers>
```



写一下启动类



```java
public class MyBatisDemo2 {

    public static void main(String[] args) throws IOException {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);
        //4. 释放资源
        sqlSession.close();

    }
}
```



Usermapper



```java
public interface UserMapper {

    List<User> selectAll();

}
```



### 5、Mybatis核心配置文件



![屏幕截图_12-9-2024_191548_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_191548_www.bilibili.com-1726140998878-3.jpeg)



![屏幕截图_12-9-2024_193735_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_193735_www.bilibili.com.jpeg)



这个意思就是把pojo这个包里的所有类起了一个别名user(不区分大小写)



### 6、MyBatis案例-环境准备



![屏幕截图_12-9-2024_194429_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_194429_www.bilibili.com.jpeg)



### 7、查询-查询所有&结果映射



![屏幕截图_12-9-2024_194829_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_194829_www.bilibili.com.jpeg)



1、创建BrandMapper方法



```java
public interface BrandMapper {


    /**
     * 查询所有
     */
    List<Brand> selectAll();


}
```



2、创建BrandMapper.xml文件



```xml
    <?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--
        数据库表的字段名称  和  实体类的属性名称 不一样，则不能自动封装数据
            * 起别名：对不一样的列名起别名，让别名和实体类的属性名一样
                * 缺点：每次查询都要定义一次别名
                    * sql片段
                        * 缺点：不灵活
            * resultMap：
                1. 定义<resultMap>标签
                2. 在<select>标签中，使用resultMap属性替换 resultType属性

    -->
<!--
        数据库表的字段名称  和  实体类的属性名称 不一样，则不能自动封装数据
                -->
<mapper namespace="com.itheima.mapper.BrandMapper">
    <select id="selectAll" resultMap="brandResultMap">
        select *
        from tb_brand;
    </select>
    
     <!--
        sql片段
    -->
    <sql id="brand_column">
         id, brand_name as brandName, company_name as companyName, ordered, description, status
     </sql>

     <select id="selectAll" resultType="brand">
         select
             <include refid="brand_column" />
         from tb_brand;
     </select>
    
     <!--
        id：唯一标识
        type：映射的类型，支持别名
    -->
    <resultMap id="brandResultMap" type="brand">
        <!--
            id：完成主键字段的映射
                column：表的列名
                property：实体类的属性名
            result：完成一般字段的映射
                column：表的列名
                property：实体类的属性名
        -->
        <result column="brand_name" property="brandName"/>
        <result column="company_name" property="companyName"/>
    </resultMap>
```



起别名



![屏幕截图_12-9-2024_20550_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_20550_www.bilibili.com.jpeg)



3、写测试用例



![屏幕截图_12-9-2024_195844_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_195844_www.bilibili.com.jpeg)



### 8、查询-查看详情



![屏幕截图_12-9-2024_20290_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_20290_www.bilibili.com.jpeg)



1、配置BrandaMapper接口



```java
public interface BrandMapper {


    /**
     * 查看详情：根据Id查询
     */
    Brand selectById(int id);
}
```



2、配置BrandMapper.xml文件



```xml
<!--
        * 参数占位符：
            1. #{}:会将其替换为 ?，为了防止SQL注入
            2. ${}：拼sql。会存在SQL注入问题
            3. 使用时机：
                * 参数传递的时候：#{}
                * 表名或者列名不固定的情况下：${} 会存在SQL注入问题

         * 参数类型：parameterType：可以省略
         * 特殊字符处理：
            1. 转义字符：
            2. CDATA区:
    -->
   <!-- <select id="selectById"  resultMap="brandResultMap">
        select *
        from tb_brand where id = #{id};

    </select>
    -->
    <select id="selectById" resultMap="brandResultMap">
    select *
    from tb_brand
    where id
         <![CDATA[
              <
         ]]>
         #{id};

</select>
```



3、写测试用例



```java
 @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id = 1;

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5. 释放资源
        sqlSession.close();

    }
```



![屏幕截图_12-9-2024_205128_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_205128_www.bilibili.com.jpeg)



### 9、查询-条件查询



![屏幕截图_12-9-2024_205348_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_205348_www.bilibili.com.jpeg)



  

1、分析sql语句



![屏幕截图_12-9-2024_205645_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_205645_www.bilibili.com.jpeg)



2、配置BrandMapper.xml文件



```xml
<!--
        条件查询
    -->
    <select id="selectByCondition" resultMap="brandResultMap">
         select *
         from tb_brand
         where status = #{status}
           and company_name like #{companyName}
           and brand_name like #{brandName}
     </select>
```



3、配置BrandMapper接口



```java
   /**
     * 条件查询
     *  * 参数接收
     *      1. 散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *      2. 对象参数:对象的属性名称要和参数占位符名称一致
     *      3. map集合参数
     *
     * @param status
     * @param  companyName
     * @param  brandName
     * @return 
     * 
     */

    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);


    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

```



4、配置测试类



```java
@Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
       /* Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        Map map = new HashMap();
        // map.put("status" , status);
        map.put("companyName", companyName);
        // map.put("brandName" , brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法

        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();

    }
```



### 10、查询-动态条件查询



![屏幕截图_12-9-2024_212647_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_212647_www.bilibili.com.jpeg)



在BrandMapper.xml中，改写为：



```xml
<!--
        动态条件查询
            * if: 条件判断
                * test：逻辑表达式
            * 问题：
                * 恒等式（where 1=1）
                * <where> 替换 where 关键字
    -->
    <select id="selectByCondition" resultMap="brandResultMap">
        select *
        from tb_brand
        /* where 1 = 1*/
        <where>

            <if test="status != null">
                and status = #{status}
            </if>
            <if test="companyName != null and companyName != '' ">
                and company_name like #{companyName}
            </if>
            <if test="brandName != null and brandName != '' ">
                and brand_name like #{brandName}
            </if>
        </where>

    </select>
```



![屏幕截图_12-9-2024_213645_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_213645_www.bilibili.com.jpeg)



 ![屏幕截图_12-9-2024_213818_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_213818_www.bilibili.com.jpeg)



配置BrandMapper.xml文件



```xml

    <select id="selectByConditionSingle" resultMap="brandResultMap">
        select *
        from tb_brand
        <where>
            <choose><!--相当于switch-->
                <when test="status != null"><!--相当于case-->
                    status = #{status}
                </when>
                <when test="companyName != null and companyName != '' "><!--相当于case-->
                    company_name like #{companyName}
                </when>
                <when test="brandName != null and brandName != ''"><!--相当于case-->
                    brand_name like #{brandName}
                </when>

            </choose>
        </where>
    </select>

```



配置测试文件



```java

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        //brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法

        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);

        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();

    }


```



### 11、添加&修改功能



![屏幕截图_12-9-2024_21578_www.bilibili.com](E:/md_picture/屏幕截图_12-9-2024_21578_www.bilibili.com.jpeg)



1、配置BrandMapper.xml文件



```xml
    <insert id="add" useGeneratedKeys="true" keyProperty="id">
        insert into tb_brand (brand_name, company_name, ordered, description, status)
        values (#{brandName}, #{companyName}, #{ordered}, #{description}, #{status});

    </insert>
```



2、要提交事务



```java

    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 6;


        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法


        int count = brandMapper.update(brand);
        System.out.println(count);
        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

}
```



![屏幕截图_13-9-2024_103614_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_103614_www.bilibili.com.jpeg)



![屏幕截图_13-9-2024_103815_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_103815_www.bilibili.com.jpeg)



xml文件



```xml
<!--
       <set>跟动态sql有关
    -->    
<update id="update">
        update tb_brand
        <set>
            <if test="brandName != null and brandName != ''">
                brand_name = #{brandName},
            </if>
            <if test="companyName != null and companyName != ''">
                company_name = #{companyName},
            </if>
            <if test="ordered != null">
                ordered = #{ordered},
            </if>
            <if test="description != null and description != ''">
                description = #{description},
            </if>
            <if test="status != null">
                status = #{status}
            </if>
        </set>
        where id = #{id};
    </update>

```



set为自动分隔



### 12、删除功能



![屏幕截图_13-9-2024_104139_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_104139_www.bilibili.com.jpeg)



xml



```java
    <delete id="deleteById">
        delete from tb_brand where id = #{id};
    </delete>
```



方法



```java
 @Test
    public void testDeleteById() throws IOException {
        //接收参数

        int id = 6;


        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法

        brandMapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }
```



![屏幕截图_13-9-2024_104631_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_104631_www.bilibili.com.jpeg)



xml



```xml
 <!--
        mybatis会将数组参数，封装为一个Map集合。
            * 默认：array = 数组
            * 使用@Param注解改变map集合的默认key的名称
            * separator:用逗号分开
    -->

    <delete id="deleteByIds">
        delete from tb_brand where id
        in
            <foreach collection="array" item="id" separator="," open="(" close=")">
                #{id}
            </foreach>
             ;
    </delete>
```



方法



```java
    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数

        int[] ids = {5,7,8};


        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法

        brandMapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }
```



注意：要么在接口写@param，要么在xml中写array



```java
 /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);
```



### 13、参数传递



![屏幕截图_13-9-2024_105613_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_105613_www.bilibili.com.jpeg)



```java
public interface UserMapper {

    List<User> selectAll();

    @Select("select * from tb_user where id  = #{id}")
    User selectById(int id);

    /*

      MyBatis 参数封装：
        * 单个参数：
            1. POJO类型：直接使用，属性名 和 参数占位符名称 一致
            2. Map集合：直接使用，键名 和 参数占位符名称 一致
            3. Collection：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                map.put("arg0",collection集合);
                map.put("collection",collection集合);
            4. List：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                map.put("arg0",list集合);
                map.put("collection",list集合);
                map.put("list",list集合);
            5. Array：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                map.put("arg0",数组);
                map.put("array",数组);
            6. 其他类型：直接使用
        * 多个参数：封装为Map集合,可以使用@Param注解，替换Map集合中默认的arg键名
            map.put("arg0",参数值1)
            map.put("param1",参数值1)
            map.put("param2",参数值2)
            map.put("agr1",参数值2)
            ---------------@Param("username")
            map.put("username",参数值1)
            map.put("param1",参数值1)
            map.put("param2",参数值2)
            map.put("agr1",参数值2)

     */
    User select(@Param("username") String username,String password);
    User select(Collection collection);
}
```



### 14、注解开发



![屏幕截图_13-9-2024_113518_www.bilibili.com](E:/md_picture/屏幕截图_13-9-2024_113518_www.bilibili.com.jpeg)



```java
public interface UserMapper {

    List<User> selectAll();
    @Select("select * from tb_user where id  = #{id}")
    User selectById(int id);
}
```
