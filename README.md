# Spring RestTemplate 封装，并制作Spring starter

## 使用方式

1. 下载源码

下载源码 并install，或者推送到私库引入使用

2. 引入依赖

```xml
        <dependency>
            <groupId>cn.darkjrong</groupId>
            <artifactId>httpclient-spring-boot-starter</artifactId>
            <version>1.0.0</version>
        </dependency>
```

3. 配置参数(application.properties)  yml配置

```yaml
http-client:
  #连接池的最大连接数，0代表不限；如果取0，需要考虑连接泄露导致系统崩溃的后果
  maxTotalConnect: 1000
  #每个路由的最大连接数,如果只调用一个地址,可以将其设置为最大连接数
  maxConnectPerRoute: 200
  # 指客户端和服务器建立连接的超时时间,ms , 最大约21秒,因为内部tcp在进行三次握手建立连接时,默认tcp超时时间是20秒
  connectTimeout: 3000
  # 指客户端从服务器读取数据包的间隔超时时间,不是总读取时间,也就是socket timeout,ms
  readTimeout: 5000
  # 从连接池获取连接的timeout,不宜过大,ms
  connectionRequestTimout: 200
  # 重试次数
  retryTimes: 3
  charset: UTF-8
  # 长连接保持时间 单位s,不宜过长
  keepAliveTime: 10
  # 针对不同的网址,长连接保持的存活时间,单位s,如果是频繁而持续的请求,可以设置小一点,不建议设置过大,避免大量无用连接占用内存资源
  keepAliveTargetHost:
    www.baidu.com: 5
```
4. API 注入
```java
    
    @Autowired
    private RestTemplateUtils restTemplateUtils;
   

```



















