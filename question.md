## 常见问题总结

### 当你将一个自定义对象放入HashMap中时，需要注意什么？保证哈希值的唯一性的原理是什么？
### lru算法
### JSP中定义全局变量与局部变量
### JSP之间如何实现数据传输
### 跨域问题
### slf4j的使用
### TreeSet的源码及红黑树
### mybatis是如何防止SQL注入的
### 如何防止XSS攻击
### mysql常用版本及其对应的驱动版本
### 做过的项目中是如何处理登录安全与资源权限控制
### Hashtable
### WebService底层是什么协议在支撑
### Web系统中每次request都是一个线程吗
### SpringMVC是如何将JSP及Controller处理为URI的
### 在你现在开发的项目中如何做的数据库连接池管理？
### spring中常用的配置事务的方式有哪些？哪个更好一点？为什么？
### hibernate和ibatis各自的优劣是什么，区别在哪里？
### 不同的数据库如何作兼容？
### 简述spring bean的生命周期？
### 基本的SQL语句编写能力，查找不同表中相同的数据条目？
### 数据库的四种事务隔离级别，Oracle、MySQL、postgresql三大关系型数据库的默认事务隔离级别是什么？
读未提交（Read uncommitted）、读提交（Read committed）、重复读（Repeatable read）、序列化（Serializable）
* 读未提交不能避免任何问题，是最低级的事务隔离级别
* 读提交只能避免脏读
* 重复读可以避免脏读、不可重复读
* 序列化可以避免脏读、不可重复读、幻读

SQL Server、Oracle默认隔离级别是读提交（Read committed），Mysql的默认隔离级别就是重复读（Repeatable read），
Postgresql默认事务隔离级别也是读提交（Read committed）但考虑到在Postgresql中读未提交和读提交被合并为读提交，因此单独说明。

### J2EE的class loader加载顺序
* Bootstrap ClassLoader启动类加载器，负责加载JDK核心的库中的类
* Extension ClassLoader扩展类加载器，负责加载扩展库中的类jre/lib/ext
* App ClassLoader系统类加载器，负责加载应用程序的Class path目录下的所有jar和class文件
* 自定义类加载器，这个不在Java默认的类加载器范畴内，但是也是一种类加载器，用于加载用户根据自己业务需求获取的Class文件

值得注意的是，扩展类加载器和系统类加载器、自定义类加载器都是继承自ClassLoader类的，但是Bootstrap ClassLoader不用继承，因为它是单独的一个类
底层由C++编写，已经融入到JVM中

### 常见的设计模式及其应用场景（单例模式、工厂模式、门面模式），Java代码编写实现？
见子模块base中的pattern包

### ArrayList/LinkedList的区别
* ArrayList底层使用动态数组，增删慢查询快，因为数组需要重新分配，此外由于ArrayList会预留一部分可扩展空间，因此其空间浪费较多
* LinkedList底层使用链表，增删快查询慢，LinkedList的插入和删除只需要移动指向标识，所以空间复杂度是固定的
* LinkedList不支持高效的随机元素访问

### HashMap和Hashtable的区别
* HashMap是线程不安全的，Hashtable是线程安全的
* 在不考虑多线程的情况下，使用HashMap效率更高一点，考虑多线程的情况下也应当使用ConcurrentHashMap，它与HashMap有共同的父类AbstractMap
* Hashtable是一个过时的类，现在通常情况下不会再使用了

### sleep和wait的区别？深层次的原因？
* sleep是Thread的方法，wait是Object的方法
* sleep被调用时，不会释放对象锁，wait调用时会释放对象锁
* sleep在被调用时会预设时间，到点儿后会自动进入Runnable队列，wait需要对象调用notify/notifyAll方法才会被唤醒进入可运行队列

线程的五种状态：新建状态 就绪态 运行态 阻塞态 死亡状态

### start()-run()与直接执行run()的区别在哪里？哪个更好？应用场景？
start()是启动一个线程，run()是运行一个函数。单独运行run()方法毫无意义，最多就是为了运行一个函数而运行一个函数，通常认为start()更好一点

### 消费者-生产者，简述其基本内容，并编码实现？
消费者模式可以用三种方式实现：BlockingQueue/lock/Objectsynch，其中最简单也是最高效的是BlockingQueue。详见threadPractice中的ecosphere包中

### 折半查找
见子模块base BinarySearch 两种写法，递归和循环

### Hibernate中，load与get获取一条数据的区别在哪里？各自的优点和应用场景是什么？
get()和load()都会使用缓存，都是首先从一级缓存Session中查找，当找不到的时候再去二级缓存中查找，当查询不到的时候get()返回的是null，
而load()则根据配置是否lazy进行不同处理，如果为lazy则直接返回代理对象，在调用对象的非ID属性时就会去获取对象真正的值并加以填充，如果发现对象不存在则报ObjectNotFoundException
如果不为lazy则去数据库中取具体值，并将其放到二级缓存，如果下一次再在二级缓存中拿到就放到一级缓存，当load()的配置为lazy时与get几乎没区别

### 分布式服务中，session如何实现同步，讲讲基本的实现原理？
[集群/分布式环境下5种session处理策略](http://blog.csdn.net/u010028869/article/details/50773174?ref=myread)
* 粘性session
* 服务器session复制
* session共享机制
* session持久化到数据库
* terracotta实现session复制

### 讲讲你对线程池的理解？（线程池是什么？怎么用？原理？优点和缺点？）
线程池大致上分三种，单线程线程池，固定大小线程池，可变大小线程池
详见Java核心技术 卷一 p680

### 你现在开发的项目中如何实现单点登录的？
[单点登录的三种实现方式](https://www.jianshu.com/p/613e44d4a464)
* 以Cookie作为凭证媒介
* 通过JSONP实现
* 通过页面重定向的方式,使用独立登录系统

### Object的常见方法有哪些？
`clone equals finalize getClass hashCode notify notifyAll wait toString`

### Nginx 教程 （1）：基本概念
[基本概念](http://blog.jobbole.com/113555/)

### 工作流引擎activiti
[Activiti工作流引擎使用详解](http://blog.csdn.net/m0_37327416/article/details/71743368)

### 归并排序
见子模块base的algorithm包，MergeSort

### 冒泡排序
见子模块base的algorithm包，BubbleSort

### 快速排序
见子模块base的algorithm包，QuickSort

### 筛选法找素数
见子模块base的algorithm包，Sieve

### ArrayList在For循环中进行增删是否会出问题
目前for循环有两种形式，一种是for int i=0，另一种是forEach
两种循环对于获取ArrayList的数据都不会有问题，但是在对ArrayList内容进行增删有区别
第一种for int i = 0,如果是使用for(int i=0;i<list.size();i++)则可能导致无限循环添加，因为list.size()是在不断变动的，如果是删除，则不会删除所有数据
第二种forEach，则添加或删除都会导致ConcurrentModifiedException，因为ArrayList实现了List而List来源于Collection接口，Collection接口是Iterator的子接口，
因此ArrayList可以使用forEach进行循环，forEach底层是使用的迭代器来对List迭代的，如果增加或者删除元素会导致迭代器的索引产生混乱，从而报错ConcurrentModifiedException

### 如何解决前后端密码明文传输问题
* https = http+ssl
* js加密

### 不用框架，如何用Java代码完成连接数据库并CRUD
* 确保数据库已经启动
* 使用FileInputStream获取配置文件
* 使用Property类导入配置，分别获得url和用户名密码和驱动
* 通过DriverManager获得一个Connection
* 使用Connection获得一个Statement
* 通过Statement去执行sql语句
* 通过ResultSet获得sql执行的结果
* 关闭查询结果流(ResultSet)
* 关闭连接

### JAVA常见的包有哪些，线程相关的包
* java.lang java语言包，包含提供利用 Java 编程语言进行程序设计的基础类
* java.util java工具包，包含 collection 框架、遗留的 collection 类、事件模型、日期和时间设施、国际化和各种实用工具类（字符串标记生成器、随机数生成器和位数组）。
* java.net java网络功能包，为实现网络应用程序提供类。
* java.sql java数据库连接包，提供使用 JavaTM 编程语言访问并处理存储在数据源（通常是一个关系数据库）中的数据的 API。
* java.io java输入输出包，通过数据流、序列化和文件系统提供系统输入和输出。
* java.security安全包，为安全框架提供类和接口。

### JDK8的新特性
[Java8的新特性](http://www.heshengbang.men/2018/01/JAVA-8新特性/)

### JAVA内存模型
参考：[Java内存模型](http://www.importnew.com/19612.html)
[全面理解Java内存模型](http://blog.csdn.net/suifeng3051/article/details/52611310)
 主要包括线程栈，堆内存两部分。
 * 线程栈存放方法局部变量，成员变量的拷贝，对象在方法上的引用
 * 堆内存存放成员变量，方法
 
### 连表查询
* 内连接查询
* 外连接查询：外连接查询包括左查询，右查询，全查询
* 交叉连接查询

### 如何优化mysql
* 硬件上，CPU，内存，硬盘驱动，操作系统
* 软件上，mysql的启动项优化，mysql的缓存调优，优化表结构，增加索引