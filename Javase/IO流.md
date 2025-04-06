# I/O流



![image-20240522094927908](E:\md_picture\image-20240522094927908.png)



![a1c182d20afe6c0a0fcc03d83fc1a80](E:\md_picture\a1c182d20afe6c0a0fcc03d83fc1a80.png)



![39534dc7561e7cda2fd5b54b65e824c](E:\md_picture\39534dc7561e7cda2fd5b54b65e824c.png)



![6e6302e60702d6f7e6af5e537724ebb](E:\md_picture\6e6302e60702d6f7e6af5e537724ebb.png)

![image-20240528083124087](E:\md_picture\image-20240528083124087.png)



![image-20240528083205702](E:\md_picture\image-20240528083205702.png)



![image-20240528083214514](E:\md_picture\image-20240528083214514.png)



## 一、常见方法1：判断文件类型、获取文件信息



![f639fdca909807169d7028a28219852](E:\md_picture\f639fdca909807169d7028a28219852.png)



![ec0bf254e0b08529d83164a37379bc4](E:\md_picture\ec0bf254e0b08529d83164a37379bc4.png)



![c72cac7057b3aec102366b6680343b8](E:\md_picture\c72cac7057b3aec102366b6680343b8.png)



![0549d321cc2380e3c01dca65be23d3b](E:\md_picture\0549d321cc2380e3c01dca65be23d3b.png)



![image-20240528084102632](E:\md_picture\image-20240528084102632.png)



## 二、常见方法2：创建文件、删除文件



![image-20240528084443773](E:\md_picture\image-20240528084443773.png)

//warning:担心这个路径是乱写的，所以抛异常提醒



![image-20240528085009308](E:\md_picture\image-20240528085009308.png)

//warnjing:如果该文件存在，则创建失败，返回false



![image-20240528085215611](E:\md_picture\image-20240528085215611.png)



putout:



![95c9da7c5b42b0344ca0576466645ed](E:\md_picture\95c9da7c5b42b0344ca0576466645ed.png)



![image-20240528085331695](E:\md_picture\image-20240528085331695.png)



## 三、遍历文件夹



![image-20240528090843779](E:\md_picture\image-20240528090843779.png)



![image-20240528091146469](E:\md_picture\image-20240528091146469.png)



## 四、字符集



![image-20240528093005699](E:\md_picture\image-20240528093005699.png)



![image-20240528093225903](E:\md_picture\image-20240528093225903.png)



![image-20240528093718900](E:\md_picture\image-20240528093718900.png)



![image-20240528093837125](E:\md_picture\image-20240528093837125.png)



### 1、字符集的解码、操作



![image-20240528095041368](E:\md_picture\image-20240528095041368.png)

![image-20240528094546160](E:\md_picture\image-20240528094546160.png)



//warning:担心把编码名称写错，所以报错



![image-20240528094914231](E:\md_picture\image-20240528094914231.png)



putout:



![image-20240528094951269](E:\md_picture\image-20240528094951269.png)



## 五、I/O流



![微信截图_20240529082255](E:\md_picture\微信截图_20240529082255.png)

![微信截图_20240529082358](E:\md_picture\微信截图_20240529082358.png)



![微信截图_20240529082547](E:\md_picture\微信截图_20240529082547.png)



![微信截图_20240529082749](E:\md_picture\微信截图_20240529082749.png)



![微信截图_20240529082824](E:\md_picture\微信截图_20240529082824.png)



![微信截图_20240529083043](E:\md_picture\微信截图_20240529083043.png)



### 1、字节流



#### FileInputStream 



![微信截图_20240529083716](E:\md_picture\微信截图_20240529083716.png)



![微信截图_20240529083738](E:\md_picture\微信截图_20240529083738.png)



![微信截图_20240529084521](E:\md_picture\微信截图_20240529084521.png)



![微信截图_20240529085504](E:\md_picture\微信截图_20240529085504.png)



![微信截图_20240529091505](E:\md_picture\微信截图_20240529091505.png)



//warning:rs2那里如果没有加0，len2就会输出66c因为byte存储数据的结构为队列



//warning:这里的len2指的是读取buffer的字节



![微信截图_20240529092508](E:\md_picture\微信截图_20240529092508.png)



想不乱码，解决方案一：定义一个与文件一样大的字节数组，一次性读取完文件的全部字节。



![微信截图_20240529093553](E:\md_picture\微信截图_20240529093553.png)



![微信截图_20240529093712](E:\md_picture\微信截图_20240529093712.png)



![微信截图_20240529093911](E:\md_picture\微信截图_20240529093911.png)



![微信截图_20240529094127](E:\md_picture\微信截图_20240529094127.png)

#### FileOutputStream



![微信截图_20240529094545](E:\md_picture\微信截图_20240529094545.png)