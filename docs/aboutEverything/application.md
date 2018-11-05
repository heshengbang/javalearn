- 服务发布和反向代理
	- nginx

- 网关
	- zuul

- 服务支撑
	- spring boot
	- spring cloud
	- spring security oauth 2.0
	- mybatis

- 服务发现
	- Eureka
	- dubbo
	
- 数据库
	- Oracle
	- hbase
	
- 缓存
	- redis

- mq
	- rabbit
	- kafka
	
- swagger
- fastdfs
- elasticjob
- es
_________

- 为什么要使用微服务架构
	- 单体应用的弊端
	- 微服务架构的优势（协作开发、服务的部署发布、服务的运维、服务的后期维护、服务重用）


- 单体应用如何拆分
	- 按照业务逻辑或实际的组织架构


- 单体应用拆分为多个服务后，相互之间怎么知道彼此的存在？
	- 服务注册与发现：Eureka、Zookeeper+Dubbo、consul、SmartStack
	- 建立一个服务注册与发现中心，一切应用都被注册到该中心，服务间通信就去该中心查找对应的服务的连接信息，然后通信


- 服务间如何通信？
	- Feign构建通信客户端

- 如何访问服务？

- 服务挂了怎么办？
	- 分布式部署，负债均衡

- 服务调用怎么鉴权？
	- OAuth2.0

