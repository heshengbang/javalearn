## 常见问题总结

### 谈谈对HashMap的看法
### lru算法
### slf4j的使用
### TreeSet的源码及红黑树
### mybatis是如何防止SQL注入的
### mysql常用版本及其对应的驱动版本
### 做过的项目中是如何处理登录安全与资源权限控制
### Hashtable
### WebService底层是什么协议在支撑
### Web系统中每次request都是一个线程吗
### SpringMVC是如何将JSP及Controller处理为URI的
### 在你现在开发的项目中如何做的数据库连接池管理？
### hibernate和ibatis各自的优劣是什么，区别在哪里？
### 不同的数据库如何作兼容？
### 基本的SQL语句编写能力，查找不同表中相同的数据条目？

### 如何防止XSS攻击
**跨站脚本攻击(Cross Site Scripting)**，缩写为XSS。恶意攻击者往Web页面里插入恶意Script代码，当用户浏览该页之时，嵌入其中Web里面的Script代码会被执行，从而达到恶意攻击用户的目的。
- 攻击者对含有漏洞的服务器发起XSS攻击（注入JS代码）。
- 诱使受害者打开受到攻击的服务器URL。
- 受害者在Web浏览器中打开URL，恶意脚本执行。

总结一句话，服务器无条件信任用户提交的数据，导致XSS攻击，XSS攻击可以让攻击者获取到用户Cookie，也可以执行一些违背用户意愿的操作。

防止XSS攻击从以下三个方面出发：
- 编码，对用户输入的数据进行HTML Entity编码，特殊字符进行转义处理
- 过滤，移除用户上传的DOM属性，如onerror等，移除用户上传的style节点，script节点，iframe节点等
- 校正，避免直接对HTML Entity编码，使用DOM Prase转换，校正不配对的DOM标签

### JSP之间如何实现数据传输
JSP之间是无法直接相互传递数据的，只能通过间接的手段。分别可以用URL，Form表单，Cookie，Session。

### JSP中定义全局变量与局部变量
JSP在运行过程中实际会被解析为一个Servlet类，因此全局变量和局部变量有所不同
- 定义全局变量用<%! %>，此方式定义的变量，解析过程中会生成一个对象的成员变量，存放在堆上
- 定义局部变量用<% %>，此方式定义的变量，解析过程中会被解析为一个方法中定义的局部变量，存放在栈上

### spring 事务管理
[spring 事务管理](http://baixin.ink/2016/03/25/spring-transaction/)
Spring事务管理器的核心接口是org.springframework.transaction.PlatformTransactionManager，将事务管理的职责委托给Hibernate或者JTA等持久化机制所提供的相关平台框架的事务来实现。
常见的平台框架实现的Spring事务管理核心接口有以下几个：
* JDBC事务，使用DataSourceTransactionManager处理事务，DataSourceTransactionManager实际上是通过java.sql.Connection来管理事务，Connection是通过DataSource获取到的。
```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
       <property name="dataSource" ref="dataSource" />
</bean>
```
* Hibernate是通过HibernateTransactionManager处理事务，HibernateTransactionManager的实现细节是它将事务管理的职责委托给org.hibernate.Transaction对象，而后者是从Hibernate Session中获取到的。
```xml
<bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
    <property name="sessionFactory" ref="sessionFactory" />
</bean>
```
* Java持久化API事务（JPA）使用JpaTransactionManager处理事务，JpaTransactionManager只需要装配一个JPA实体管理工厂（javax.persistence.EntityManagerFactory接口的任意实现）。JpaTransactionManager将与由工厂所产生的JPA EntityManager合作来构建事务。
```xml
<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
    <property name="sessionFactory" ref="sessionFactory" />
</bean>
```
* Java原生API事务，在没有使用到上面三种事务管理时，亦或者跨越了多个数据源（两个以上），则可以使用JtaTransactionManager。JtaTransactionManager将事务管理的责任委托给`javax.transaction.UserTransaction`和`javax.transaction.TransactionManager`对象。
```xml
<bean id="transactionManager" class="org.springframework.transaction.jta.JtaTransactionManager">
    <property name="transactionManagerName" value="java:/TransactionManager" />
</bean>
```

事务的五个维度：传播行为，隔离级别，事务超时，只读，回滚规则

事务的配置分两种方式：编程式事务和声明式事务
- 编程式事务有两种实现方式：TransactionTemplate，PlatformTransactionManager
- [声明式事务有五种实现方式](http://www.blogjava.net/robbie/archive/2009/04/05/264003.html)：每个Bean都有一个代理，所有Bean共享一个代理基类，使用拦截器，使用tx标签配置的拦截器，全注解 

### 简述spring bean的生命周期？
1. Spring对Bean进行实例化，调用构造函数
2. Spring将值和Bean的应用注入进Bean对应的属性中，调用各个属性的set方法
3. 如果Bean实现了BeanNameAware接口，Spring将Bean的ID传递给setBeanName()接口方法
4. 如果Bean实现了BeanFactoryAware接口，Spring将调用setBeanFactory()接口方法，将BeanFactory容器实例传入
5. 如果Bean实现了ApplicationContextAware接口，Spring将调用setApplicationContext()接口方法，将应用上下文应用传入
6. 如果Bean实现了BeanPostProcessor接口，Spring将调用他们的postProcessBeforeInitialization()接口方法
7. 如果Bean实现了InitializingBean接口，Spring将调用它们的afterPropertiesSet()接口方法。如果Bean使用了init-method声明了该初始化方法，该方法也会被调用
8. 如果Bean实现了BeanPostProcessor接口，Spring将调用它们的postProcessAfterInitialization()接口方法
9. 到目前，Bean已经准备就绪，可以被应用程序使用，它们将一直存在应用上下文，直到应用上下文被销毁
10. 如果Bean实现了DisposableBean接口，spring将调用它的destroy()接口方法。同样的，如果Bean使用了destroy-method声明了销毁方法，该方法也会被调用

注意，Spring Bean默认是单例的且使用的是饿汉模式即启动容器的时候就给所有的Bean生成一个实例，如果要使用懒汉模式可以配置default-lazy-init="true"，进一步的如果根本不需要使用单例模式的话可以设置scope="prototype"
见项目中的spring模块中的LifeCycleApp测试实例。在Spring 2.5之后，开发者有三种选择来控制Bean的生命周期行为：
* InitializingBean和DisposableBean回调接口
* 自定义的init()以及destroy方法
* 使用@PostConstruct以及@PreDestroy注解
开发者也可以在Bean上联合这些机制一起使用
> 如果Bean配置了多个生命周期机制，而且每个机制配置了不同的方法名字，那么每个配置的方法会按照后面描述的顺序来执行。然而，如果配置了相同的名字，比如说初始化回调为init()，在不止一个生命周期机制配置为这个方法的情况下，这个方法只会执行一次。

如果一个Bean配置了多个生命周期机制，并且含有不同的方法名，执行的顺序如下：
* 包含@PostConstruct注解的方法
* 在InitializingBean接口中的afterPropertiesSet()方法
* 自定义的init()方法

销毁方法的执行顺序和初始化的执行顺序相同：
* 包含@PreDestroy注解的方法
* 在DisposableBean接口中的destroy()方法
* 自定义的destroy()方法

### 跨域问题
[跨域资源共享 CORS 详解](http://www.ruanyifeng.com/blog/2016/04/cors.html),
[HTTP访问控制（CORS）](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS),
[详解js跨域问题](https://segmentfault.com/a/1190000000718840),
所谓跨域问题就是指不同的域之间通信的问题，地址A访问地址B，如果A和B之间有不同就属于跨域问题。造成域不同的情况分三种，协议、域名、端口。
* 协议就是指http/https/ftp/ssh之类的。https://www.example.com和http://www.example.com 就会有跨域问题。
* 域名的不同也包括二级域名不同造成的跨域。http://a.example.com和http://b.example.com 也会有跨域问题。
* 端口不同造成的跨域。http://www.example.com:8000和http://www.example.com

目前业内对于跨域问题的解决方案是CORS，即跨域资源共享(Cross-Origin Resource Sharing)，它定义了必须在访问跨域资源时，浏览器与服务器应该如何沟通。
CORS背后的基本思想就是使用自定义的HTTP头部让浏览器与服务器进行沟通，从而决定请求/响应是应该成功还是失败。
解决跨域问题的常见方法：jsonp/cors/document.domain/document.name

跨域问题通常和CSRF这个问题牵扯在一起,需要进一步了解。CSRF跨站点请求伪造(Cross—Site Request Forgery)，攻击者盗用被攻击者的信息发送非法请求以获取信息。
CSRF攻击攻击原理及过程如下：
1. 用户C打开浏览器，访问受信任网站A，输入用户名和密码请求登录网站A
2. 在用户信息通过验证后，网站A产生Cookie信息并返回给浏览器，此时用户登录网站A成功，可以正常发送请求到网站A；
3. 用户未退出网站A之前，在同一浏览器中，打开一个TAB页访问网站B；
4. 网站B接收到用户请求后，返回一些攻击性代码，并发出一个请求要求访问第三方站点A；
5. 浏览器在接收到这些攻击性代码后，根据网站B的请求，在用户不知情的情况下携带Cookie信息，向网站A发出请求。网站A并不知道该请求其实是由B发起的，所以会根据用户C的Cookie信息以C的权限处理该请求，导致来自网站B的恶意代码被执行。

目前防御 CSRF 攻击主要有三种策略：验证 HTTP Referer 字段；在请求地址中添加 token 并验证；在 HTTP 头中自定义属性并验证。

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

### start()-run()与直接执行run()有什么区别
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