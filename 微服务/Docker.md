# Docker



## 1、Docker课程介绍



![屏幕截图_8-11-2024_84828_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_84828_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_8491_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_8491_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_84919_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_84919_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_84943_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_84943_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_84954_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_84954_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_8501_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_8501_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_85012_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_85012_www.bilibili.com.jpeg)



## 2、Docker的安装



1.卸载旧版

首先如果系统中已经存在旧的Docker，则先卸载：

```Shell
yum remove docker \
    docker-client \
    docker-client-latest \
    docker-common \
    docker-latest \
    docker-latest-logrotate \
    docker-logrotate \
    docker-engine \
    docker-selinux 
```

2.配置Docker的yum库

首先要安装一个yum工具

```Bash
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
```

安装成功后，执行命令，配置Docker的yum源（已更新为阿里云源）：

```Bash
sudo yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo

sudo sed -i 's+download.docker.com+mirrors.aliyun.com/docker-ce+' /etc/yum.repos.d/docker-ce.repo
```

更新yum，建立缓存

```Bash
sudo yum makecache fast
```

3.安装Docker

最后，执行命令，安装Docker

```Bash
yum install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

4.启动和校验

```Bash
# 启动Docker
systemctl start docker

# 停止Docker
systemctl stop docker

# 重启
systemctl restart docker

# 设置开机自启
systemctl enable docker

# 执行docker ps命令，如果不报错，说明安装启动成功
docker ps
```

5.配置镜像加速

镜像地址可能会变更，如果失效可以百度找最新的docker镜像。

配置镜像步骤如下：

```Bash
# 创建目录
mkdir -p /etc/docker

# 复制内容
tee /etc/docker/daemon.json <<-'EOF'
{
    "registry-mirrors": [
        "http://hub-mirror.c.163.com",
        "https://mirrors.tuna.tsinghua.edu.cn",
        "http://mirrors.sohu.com",
        "https://ustc-edu-cn.mirror.aliyuncs.com",
        "https://ccr.ccs.tencentyun.com",
        "https://docker.m.daocloud.io",
        "https://docker.awsl9527.cn"
    ]
}
EOF

# 重新加载配置
systemctl daemon-reload

# 重启Docker
systemctl restart docker
```

5.配置镜像加速(阿里云已停用）

这里以阿里云镜像加速为例。

5.1.注册阿里云账号

首先访问阿里云网站:

https://www.aliyun.com/

注册一个账号。

5.2.开通镜像服务

在首页的产品中，找到阿里云的**容器镜像服务**：

![img](../../../md_picture/1734447350914-2.png)

点击后进入控制台：

![img](../../../md_picture/1734447350914-1.png)

首次可能需要选择立刻开通，然后进入控制台。

5.3.配置镜像加速

找到**镜像工具**下的**镜像****加速器**：

![img](../../../md_picture/1734447371214-7.png)

页面向下滚动，即可找到配置的文档说明：

![img](../../../md_picture/1734447371214-8.png)

具体命令如下：

```Bash
# 创建目录
mkdir -p /etc/docker

# 复制内容，注意把其中的镜像加速地址改成你自己的
tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://xxxx.mirror.aliyuncs.com"]
}
EOF

# 重新加载配置
systemctl daemon-reload

# 重启Docker
systemctl restart docker
```



## 3、快速入门·-部署MySQL



![屏幕截图_8-11-2024_8533_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_8533_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_9923_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_9923_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_9943_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_9943_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_92442_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_92442_www.bilibili.com.jpeg)



## 4、快速入门-命令解读



![屏幕截图_8-11-2024_94124_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_94124_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_95210_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_95210_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_95237_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_95237_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_95348_www.bilibili.com](E:\md_picture\屏幕截图_8-11-2024_95348_www.bilibili.com.jpeg)



## 5、Docker基础-常见命令



其中，比较常见的命令有：

| **命令**       | **说明**                       | **文档地址**                                                 |
| :------------- | :----------------------------- | :----------------------------------------------------------- |
| docker pull    | 拉取镜像                       | [docker pull](https://docs.docker.com/engine/reference/commandline/pull/) |
| docker push    | 推送镜像到DockerRegistry       | [docker push](https://docs.docker.com/engine/reference/commandline/push/) |
| docker images  | 查看本地镜像                   | [docker images](https://docs.docker.com/engine/reference/commandline/images/) |
| docker rmi     | 删除本地镜像                   | [docker rmi](https://docs.docker.com/engine/reference/commandline/rmi/) |
| docker run     | 创建并运行容器（不能重复创建） | [docker run](https://docs.docker.com/engine/reference/commandline/run/) |
| docker stop    | 停止指定容器                   | [docker stop](https://docs.docker.com/engine/reference/commandline/stop/) |
| docker start   | 启动指定容器                   | [docker start](https://docs.docker.com/engine/reference/commandline/start/) |
| docker restart | 重新启动容器                   | [docker restart](https://docs.docker.com/engine/reference/commandline/restart/) |
| docker rm      | 删除指定容器                   | [docs.docker.com](https://docs.docker.com/engine/reference/commandline/rm/) |
| docker ps      | 查看容器                       | [docker ps](https://docs.docker.com/engine/reference/commandline/ps/) |
| docker logs    | 查看容器运行日志               | [docker logs](https://docs.docker.com/engine/reference/commandline/logs/) |
| docker exec    | 进入容器                       | [docker exec](https://docs.docker.com/engine/reference/commandline/exec/) |
| docker save    | 保存镜像到本地压缩文件         | [docker save](https://docs.docker.com/engine/reference/commandline/save/) |
| docker load    | 加载本地压缩文件到镜像         | [docker load](https://docs.docker.com/engine/reference/commandline/load/) |
| docker inspect | 查看容器详细信息               | [docker inspect](https://docs.docker.com/engine/reference/commandline/inspect/) |



![屏幕截图_8-11-2024_10396_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_10396_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_11326_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_11326_www.bilibili.com.jpeg)



一定要加latest



![屏幕截图_8-11-2024_11352_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_11352_www.bilibili.com.jpeg)



这个的意思是要以命令行的形式交互



![屏幕截图_8-11-2024_103930_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_103930_www.bilibili.com.jpeg)



## 6、Docker基础-命令别名



![屏幕截图_8-11-2024_11852_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_11852_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_11836_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_11836_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_1190_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_1190_www.bilibili.com.jpeg)



## 7、Docker基础-数据卷挂载



![屏幕截图_8-11-2024_20577_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_20577_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_205731_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_205731_www.bilibili.com.jpeg)



容器是隔离环境，容器内程序的文件、配置、运行时产生的容器都在容器内部，我们要读写容器内的文件非常不方便。大家思考几个问题：

- 如果要升级MySQL版本，需要销毁旧容器，那么数据岂不是跟着被销毁了？
- MySQL、Nginx容器运行后，如果我要修改其中的某些配置该怎么办？
- 我想要让Nginx代理我的静态资源怎么办？

因此，容器提供程序的运行环境，但是**程序运行产生的数据、程序运行依赖的配置都应该与容器解耦**。



**数据卷（volume）**是一个虚拟目录，是**容器内目录**与**宿主机目录**之间映射的桥梁。

以Nginx为例，我们知道Nginx中有两个关键的目录：

- `html`：放置一些静态资源
- `conf`：放置配置文件

如果我们要让Nginx代理我们的静态资源，最好是放到`html`目录；如果我们要修改Nginx的配置，最好是找到`conf`下的`nginx.conf`文件。

但遗憾的是，容器运行的Nginx所有的文件都在容器内部。所以我们必须利用数据卷将两个目录与宿主机目录关联，方便我们操作。如图：



![屏幕截图_8-11-2024_2148_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_2148_www.bilibili.com.jpeg)



如果改了宿主机的数据卷，docker容器也会改变。



在上图中：

- 我们创建了两个数据卷：`conf`、`html`
- Nginx容器内部的`conf`目录和`html`目录分别与两个数据卷关联。
- 而数据卷conf和html分别指向了宿主机的`/var/lib/docker/volumes/conf/_data`目录和`/var/lib/docker/volumes/html/_data`目录

这样以来，容器内的`conf`和`html`目录就 与宿主机的`conf`和`html`目录关联起来，我们称为**挂载**。此时，我们操作宿主机的`/var/lib/docker/volumes/html/_data`就是在操作容器内的`/usr/share/nginx/html/_data`目录。只要我们将静态资源放入宿主机对应目录，就可以被Nginx代理了。



**小提示**：

`/var/lib/docker/volumes`这个目录就是默认的存放所有容器数据卷的目录，其下再根据数据卷名称创建新目录，格式为`/数据卷名/_data`。

**为什么不让容器目录直接指向宿主机目录呢**？

- 因为直接指向宿主机目录就与宿主机强耦合了，如果切换了环境，宿主机目录就可能发生改变了。由于容器一旦创建，目录挂载就无法修改，这样容器就无法正常工作了。
- 但是容器指向数据卷，一个逻辑名称，而数据卷再指向宿主机目录，就不存在强耦合。如果宿主机目录发生改变，只要改变数据卷与宿主机目录之间的映射关系即可。

不过，我们通过由于数据卷目录比较深，不好寻找，通常我们也**允许让容器直接与宿主机目录挂载而不使用数据卷**，具体参考2.2.3小节。



![屏幕截图_8-11-2024_21458_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_21458_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_2163_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_2163_www.bilibili.com.jpeg)



教学**演示环节**：演示一下nginx的html目录挂载

```PowerShell
# 1.首先创建容器并指定数据卷，注意通过 -v 参数来指定数据卷
docker run -d --name nginx -p 80:80 -v html:/usr/share/nginx/html nginx

# 2.然后查看数据卷
docker volume ls
# 结果
DRIVER    VOLUME NAME
local     29524ff09715d3688eae3f99803a2796558dbd00ca584a25a4bbc193ca82459f
local     html

# 3.查看数据卷详情
docker volume inspect html
# 结果
[
    {
        "CreatedAt": "2024-05-17T19:57:08+08:00",
        "Driver": "local",
        "Labels": null,
        "Mountpoint": "/var/lib/docker/volumes/html/_data",
        "Name": "html",
        "Options": null,
        "Scope": "local"
    }
]

# 4.查看/var/lib/docker/volumes/html/_data目录
ll /var/lib/docker/volumes/html/_data
# 可以看到与nginx的html目录内容一样，结果如下：
总用量 8
-rw-r--r--. 1 root root 497 12月 28 2021 50x.html
-rw-r--r--. 1 root root 615 12月 28 2021 index.html

# 5.进入该目录，并随意修改index.html内容
cd /var/lib/docker/volumes/html/_data
vi index.html

# 6.打开页面，查看效果

# 7.进入容器内部，查看/usr/share/nginx/html目录内的文件是否变化
docker exec -it nginx bash
```



教学**演示环节**：演示一下MySQL的匿名数据卷

```PowerShell
# 1.查看MySQL容器详细信息
docker inspect mysql
# 关注其中.Config.Volumes部分和.Mounts部分
```

我们关注两部分内容，第一是`.Config.Volumes`部分：

```JSON
{
  "Config": {
    // ... 略
    "Volumes": {
      "/var/lib/mysql": {}
    }
    // ... 略
  }
}
```

可以发现这个容器声明了一个本地目录，需要挂载数据卷，但是**数据卷未定义**。这就是匿名卷。

然后，我们再看结果中的`.Mounts`部分：

```JSON
{
  "Mounts": [
    {
      "Type": "volume",
      "Name": "29524ff09715d3688eae3f99803a2796558dbd00ca584a25a4bbc193ca82459f",
      "Source": "/var/lib/docker/volumes/29524ff09715d3688eae3f99803a2796558dbd00ca584a25a4bbc193ca82459f/_data",
      "Destination": "/var/lib/mysql",
      "Driver": "local",
    }
  ]
}
```

可以发现，其中有几个关键属性：

- Name：数据卷名称。由于定义容器未设置容器名，这里的就是匿名卷自动生成的名字，一串hash值。
- Source：宿主机目录
- Destination : 容器内的目录

上述配置是将容器内的`/var/lib/mysql`这个目录，与数据卷`29524ff09715d3688eae3f99803a2796558dbd00ca584a25a4bbc193ca82459f`挂载。于是在宿主机中就有了`/var/lib/docker/volumes/29524ff09715d3688eae3f99803a2796558dbd00ca584a25a4bbc193ca82459f/_data`这个目录。这就是匿名数据卷对应的目录，其使用方式与普通数据卷没有差别。

接下来，可以查看该目录下的MySQL的data文件：

```Bash
ls -l /var/lib/docker/volumes/29524ff09715d3688eae3f99803a2796558dbd00ca584a25a4bbc193ca82459f/_data
```

注意：每一个不同的镜像，将来创建容器后内部有哪些目录可以挂载，可以参考DockerHub对应的页面



![屏幕截图_8-11-2024_211133_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_211133_www.bilibili.com.jpeg)



## 8、Docker基础-本地目录挂载



![屏幕截图_8-11-2024_212917_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_212917_www.bilibili.com.jpeg)

看数据卷的详情



可以发现，数据卷的目录结构较深，如果我们去操作数据卷目录会不太方便。在很多情况下，我们会直接将容器目录与宿主机指定目录挂载。挂载语法与数据卷类似：

```Bash
# 挂载本地目录
-v 本地目录:容器内目录
# 挂载本地文件
-v 本地文件:容器内文件
```



**教学演示**，删除并重新创建mysql容器，并完成本地目录挂载：

- 挂载`/root/mysql/data`到容器内的`/var/lib/mysql`目录
- 挂载`/root/mysql/init`到容器内的`/docker-entrypoint-initdb.d`目录（初始化的SQL脚本目录）
- 挂载`/root/mysql/conf`到容器内的`/etc/mysql/conf.d`目录（这个是MySQL配置文件目录）

在课前资料中已经准备好了mysql的`init`目录和`conf`目录：

![img](../../../md_picture/1741355240395-4.png)

以及对应的初始化SQL脚本和配置文件：

![img](../../../md_picture/1741355240394-1.png)

![img](../../../md_picture/1741355240395-2.png)

其中，hm.cnf主要是配置了MySQL的默认编码，改为utf8mb4；而hmall.sql则是后面我们要用到的黑马商城项目的初始化SQL脚本。

我们直接将整个mysql目录上传至虚拟机的`/root`目录下：

![img](../../../md_picture/1741355240395-3.png)

接下来，我们演示本地目录挂载：

```Bash
# 1.删除原来的MySQL容器
docker rm -f mysql

# 2.进入root目录
cd ~

# 3.创建并运行新mysql容器，挂载本地目录
docker run -d \
  --name mysql \
  -p 3306:3306 \
  -e TZ=Asia/Shanghai \
  -e MYSQL_ROOT_PASSWORD=123 \
  -v ./mysql/data:/var/lib/mysql \
  -v ./mysql/conf:/etc/mysql/conf.d \
  -v ./mysql/init:/docker-entrypoint-initdb.d \
  mysql

# 4.查看root目录，可以发现~/mysql/data目录已经自动创建好了
ls -l mysql
# 结果：
总用量 4
drwxr-xr-x. 2 root    root   20 5月  19 15:11 conf
drwxr-xr-x. 7 polkitd root 4096 5月  19 15:11 data
drwxr-xr-x. 2 root    root   23 5月  19 15:11 init

# 查看data目录，会发现里面有大量数据库数据，说明数据库完成了初始化
ls -l data

# 5.查看MySQL容器内数据
# 5.1.进入MySQL
docker exec -it mysql mysql -uroot -p123
# 5.2.查看编码表
show variables like "%char%";
# 5.3.结果，发现编码是utf8mb4没有问题
+--------------------------+--------------------------------+
| Variable_name            | Value                          |
+--------------------------+--------------------------------+
| character_set_client     | utf8mb4                        |
| character_set_connection | utf8mb4                        |
| character_set_database   | utf8mb4                        |
| character_set_filesystem | binary                         |
| character_set_results    | utf8mb4                        |
| character_set_server     | utf8mb4                        |
| character_set_system     | utf8mb3                        |
| character_sets_dir       | /usr/share/mysql-8.0/charsets/ |
+--------------------------+--------------------------------+

# 6.查看数据
# 6.1.查看数据库
show databases;
# 结果，hmall是黑马商城数据库
+--------------------+
| Database           |
+--------------------+
| hmall              |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)
# 6.2.切换到hmall数据库
use hmall;
# 6.3.查看表
show tables;
# 结果：
+-----------------+
| Tables_in_hmall |
+-----------------+
| address         |
| cart            |
| item            |
| order           |
| order_detail    |
| order_logistics |
| pay_order       |
| user            |
+-----------------+
# 6.4.查看address表数据
+----+---------+----------+--------+----------+-------------+---------------+-----------+------------+-------+
| id | user_id | province | city   | town     | mobile      | street        | contact   | is_default | notes |
+----+---------+----------+--------+----------+-------------+---------------+-----------+------------+-------+
| 59 |       1 | 北京     | 北京   | 朝阳区    | 13900112222 | 金燕龙办公楼   | 李佳诚    | 0          | NULL  |
| 60 |       1 | 北京     | 北京   | 朝阳区    | 13700221122 | 修正大厦       | 李佳红    | 0          | NULL  |
| 61 |       1 | 上海     | 上海   | 浦东新区  | 13301212233 | 航头镇航头路   | 李佳星    | 1          | NULL  |
| 63 |       1 | 广东     | 佛山   | 永春      | 13301212233 | 永春武馆       | 李晓龙    | 0          | NULL  |
+----+---------+----------+--------+----------+-------------+---------------+-----------+------------+-------+
4 rows in set (0.00 sec)
```



![屏幕截图_8-11-2024_213621_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_213621_www.bilibili.com.jpeg)



## 9、Docker基础-Dockerfile语法



![屏幕截图_8-11-2024_214754_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_214754_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_215358_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_215358_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_215445_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_215445_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_21556_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_21556_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_215514_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_215514_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_215524_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_215524_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_215533_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_215533_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_22257_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_22257_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_22345_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_22345_www.bilibili.com.jpeg)



![屏幕截图_8-11-2024_22825_www.bilibili.com](E:/md_picture/屏幕截图_8-11-2024_22825_www.bilibili.com.jpeg)



右边第二行也是镜像。



## 10、Docker基础-自定义镜像



![屏幕截图_11-11-2024_114641_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_114641_www.bilibili.com.jpeg)



![屏幕截图_11-11-2024_115435_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_115435_www.bilibili.com.jpeg)





## 11、Docker基础-容器网络互联



![屏幕截图_11-11-2024_13575_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_13575_www.bilibili.com.jpeg)



![屏幕截图_11-11-2024_14047_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_14047_www.bilibili.com.jpeg)



![屏幕截图_11-11-2024_14259_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_14259_www.bilibili.com.jpeg)



## 12、项目部署-部署Java应用



![屏幕截图_11-11-2024_14848_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_14848_www.bilibili.com.jpeg)



![屏幕截图_11-11-2024_1494_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_1494_www.bilibili.com.jpeg)



`hmall`项目是一个maven聚合项目，使用IDEA打开`hmall`项目，查看项目结构如图：

![img](../../../md_picture/1741589190621-7.png)

我们要部署的就是其中的`hm-service`，其中的配置文件采用了多环境的方式：

![img](../../../md_picture/1741589190620-1.png)

其中的`application-dev.yaml`是部署到开发环境的配置，`application-local.yaml`是本地运行时的配置。

查看application.yaml，你会发现其中的JDBC地址并未写死，而是读取变量：

![img](../../../md_picture/1741589190620-2.png)

这两个变量在`application-dev.yaml`和`application-local.yaml`中并不相同：

![img](../../../md_picture/1741589190620-3.png)

在dev开发环境（也就是Docker部署时）采用了mysql作为地址，刚好是我们的mysql容器名，只要两者在一个网络，就一定能互相访问。

我们将项目打包：

![img](../../../md_picture/1741589190620-4.png)

结果：

![img](../../../md_picture/1741589190620-5.png)

将`hm-service`目录下的`Dockerfile`和`hm-service/target`目录下的`hm-service.jar`一起上传到虚拟机的`root`目录：

![img](../../../md_picture/1741589190620-6.png)

部署项目：

```Bash
# 1.构建项目镜像，不指定tag，则默认为latest
docker build -t hmall .

# 2.查看镜像
docker images
# 结果
REPOSITORY    TAG       IMAGE ID       CREATED          SIZE
hmall         latest    0bb07b2c34b9   43 seconds ago   362MB
docker-demo   1.0       49743484da68   24 hours ago     327MB
nginx         latest    605c77e624dd   16 months ago    141MB
mysql         latest    3218b38490ce   17 months ago    516MB

# 3.创建并运行容器，并通过--network将其加入hmall网络，这样才能通过容器名访问mysql
docker run -d --name hmall --network hmall -p 8080:8080 hmall
```

测试，通过浏览器访问：http://你的虚拟机地址:8080/search/list



![屏幕截图_11-11-2024_142257_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_142257_www.bilibili.com.jpeg)



## 13、项目部署-部署前端



![屏幕截图_11-11-2024_141542_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_141542_www.bilibili.com.jpeg)



`hmall-portal`和`hmall-admin`是前端代码，需要基于nginx部署。在课前资料中已经给大家提供了nginx的部署目录：

![img](../../../md_picture/1741589212358-22.png)

其中：

- `html`是静态资源目录，我们需要把`hmall-portal`以及`hmall-admin`都复制进去
- `nginx.conf`是nginx的配置文件，主要是完成对`html`下的两个静态资源目录做代理

我们现在要做的就是把整个nginx目录上传到虚拟机的`/root`目录下：

![img](../../../md_picture/1741589212358-23.png)

然后创建nginx容器并完成两个挂载：

- 把`/root/nginx/nginx.conf`挂载到`/etc/nginx/ng``inx.conf`
- 把`/root/nginx/html`挂载到`/usr/share/nginx/html`

由于需要让nginx同时代理hmall-portal和hmall-admin两套前端资源，因此我们需要暴露两个端口：

- 18080：对应hmall-portal
- 18081：对应hmall-admin

命令如下：

```Bash
docker run -d \
  --name nginx \
  -p 18080:18080 \
  -p 18081:18081 \
  -v /root/nginx/html:/usr/share/nginx/html \
  -v /root/nginx/nginx.conf:/etc/nginx/nginx.conf \
  --network hmall \
  nginx
```

测试，通过浏览器访问：http://你的虚拟机ip:18080

![img](../../../md_picture/1741589212358-24.png)



具体见视频吧



## 14、项目部署-DockerCompose



![屏幕截图_11-11-2024_142619_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_142619_www.bilibili.com.jpeg)



![屏幕截图_11-11-2024_142756_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_142756_www.bilibili.com.jpeg)



大家可以看到，我们部署一个简单的java项目，其中包含3个容器：

- MySQL
- Nginx
- Java项目

而稍微复杂的项目，其中还会有各种各样的其它中间件，需要部署的东西远不止3个。如果还像之前那样手动的逐一部署，就太麻烦了。

而Docker Compose就可以帮助我们实现**多个相互关联的Docker容器的快速部署**。它允许用户通过一个单独的 docker-compose.yml 模板文件（YAML 格式）来定义一组相关联的应用容器。



docker-compose.yml文件的基本语法可以参考官方文档：

https://docs.docker.com/compose/compose-file/compose-file-v3/

docker-compose文件中可以定义多个相互关联的应用容器，每一个应用容器被称为一个服务（service）。由于service就是在定义某个应用的运行时参数，因此与`docker run`参数非常相似。



![屏幕截图_11-11-2024_144229_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_144229_www.bilibili.com.jpeg)



| **docker run 参数** | **docker compose 指令** | **说明**   |
| :------------------ | :---------------------- | :--------- |
| --name              | container_name          | 容器名称   |
| -p                  | ports                   | 端口映射   |
| -e                  | environment             | 环境变量   |
| -v                  | volumes                 | 数据卷配置 |
| --network           | networks                | 网络       |



编写好docker-compose.yml文件，就可以部署项目了。常见的命令：

https://docs.docker.com/compose/reference/

基本语法如下：

```Bash
docker compose [OPTIONS] [COMMAND]
```

其中，OPTIONS和COMMAND都是可选参数，比较常见的有：

| **类型** | **参数或指令**                                               | **说明**                    |
| :------- | :----------------------------------------------------------- | :-------------------------- |
| Options  | -f                                                           | 指定compose文件的路径和名称 |
| -p       | 指定project名称。project就是当前compose文件中设置的多个service的集合，是逻辑概念 |                             |
| Commands | up                                                           | 创建并启动所有service容器   |
| down     | 停止并移除所有容器、网络                                     |                             |
| ps       | 列出所有启动的容器                                           |                             |
| logs     | 查看指定容器的日志                                           |                             |
| stop     | 停止容器                                                     |                             |
| start    | 启动容器                                                     |                             |
| restart  | 重启容器                                                     |                             |
| top      | 查看运行的进程                                               |                             |
| exec     | 在指定的运行中容器中执行命令                                 |                             |

教学演示：

```Bash
# 1.进入root目录
cd /root

# 2.删除旧容器
docker rm -f $(docker ps -qa)

# 3.删除hmall镜像
docker rmi hmall

# 4.清空MySQL数据
rm -rf mysql/data

# 5.启动所有, -d 参数是后台启动
docker compose up -d
# 结果：
[+] Building 15.5s (8/8) FINISHED
 => [internal] load build definition from Dockerfile                                    0.0s
 => => transferring dockerfile: 358B                                                    0.0s
 => [internal] load .dockerignore                                                       0.0s
 => => transferring context: 2B                                                         0.0s
 => [internal] load metadata for docker.io/library/openjdk:11.0-jre-buster             15.4s
 => [1/3] FROM docker.io/library/openjdk:11.0-jre-buster@sha256:3546a17e6fb4ff4fa681c3  0.0s
 => [internal] load build context                                                       0.0s
 => => transferring context: 98B                                                        0.0s
 => CACHED [2/3] RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo   0.0s
 => CACHED [3/3] COPY hm-service.jar /app.jar                                           0.0s
 => exporting to image                                                                  0.0s
 => => exporting layers                                                                 0.0s
 => => writing image sha256:32eebee16acde22550232f2eb80c69d2ce813ed099640e4cfed2193f71  0.0s
 => => naming to docker.io/library/root-hmall                                           0.0s
[+] Running 4/4
 ✔ Network hmall    Created                                                             0.2s
 ✔ Container mysql  Started                                                             0.5s
 ✔ Container hmall  Started                                                             0.9s
 ✔ Container nginx  Started                                                             1.5s

# 6.查看镜像
docker compose images
# 结果
CONTAINER           REPOSITORY          TAG                 IMAGE ID            SIZE
hmall               root-hmall          latest              32eebee16acd        362MB
mysql               mysql               latest              3218b38490ce        516MB
nginx               nginx               latest              605c77e624dd        141MB

# 7.查看容器
docker compose ps
# 结果
NAME                IMAGE               COMMAND                  SERVICE             CREATED             STATUS              PORTS
hmall               root-hmall          "java -jar /app.jar"     hmall               54 seconds ago      Up 52 seconds       0.0.0.0:8080->8080/tcp, :::8080->8080/tcp
mysql               mysql               "docker-entrypoint.s…"   mysql               54 seconds ago      Up 53 seconds       0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp
nginx               nginx               "/docker-entrypoint.…"   nginx               54 seconds ago      Up 52 seconds       80/tcp, 0.0.0.0:18080-18081->18080-18081/tcp, :::18080-18081->18080-18081/tcp
```



![屏幕截图_11-11-2024_143544_www.bilibili.com](E:/md_picture/屏幕截图_11-11-2024_143544_www.bilibili.com.jpeg)





