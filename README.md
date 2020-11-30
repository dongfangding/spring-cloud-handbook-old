[TOC]

# 项目架构

## 基本项目架构依赖

> [https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E](https://github.com/alibaba/spring-cloud-alibaba/wiki/版本说明)
>
> 主要项目架构是**spring-boot + spring-cloud + spring-cloud-alibaba**
>
> 然后就是一些工具集，第三方框架

| 依赖                 | 版本          | 作用           |
| -------------------- | ------------- | -------------- |
| spring-boot          | 2.2.5.RELEASE | 基础框架       |
| spring-cloud         | Hoxton.SR5    | 提供组件pom    |
| spring-cloud-alibaba | 2.2.1.RELEASE | 提供组件pom    |
| mybatis-plus         | 3.3.0         | 简化数据库操作 |
| lombok               | 1.18.10       | 代码生成插件   |
| druid                | 1.1.17        | 连接池         |
| mysql                | 8.0.15        | 数据库         |
| swagger              | 2.9.2         | 文档输出       |
| commons-lang3        | 3.9           | 工具集         |
| hutool               | 5.0.6         | 工具集         |

**pom.xml 如下**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <packaging>pom</packaging>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.5.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.ddf.cloud</groupId>
    <artifactId>handbook</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-cloud-handbook</name>
    <description>spring-cloud使用手册</description>
 
    <properties>
        <java.version>1.8</java.version>
        <spring-boot.version>2.2.8.RELEASE</spring-boot.version>
        <spring-cloud-alibaba.version>2.2.1.RELEASE</spring-cloud-alibaba.version>
        <spring-cloud.version>Hoxton.SR3</spring-cloud.version>
        <mybatis.version>3.3.0</mybatis.version>
        <p6spy.version>3.8.2</p6spy.version>
        <commons-lang3.version>3.9</commons-lang3.version>
        <hutool.version>5.0.6</hutool.version>
        <druid.version>1.1.17</druid.version>
        <lombok.version>1.18.10</lombok.version>
        <mysql.version>8.0.15</mysql.version>
        <swagger.version>2.9.2</swagger.version>
        <swagger-ui.version>2.9.2</swagger-ui.version>
        <swagger-annotation-models-version>1.5.21</swagger-annotation-models-version>
    </properties>
 
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
 
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
 
 
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring-cloud-alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
 
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-devtools</artifactId>
                <scope>runtime</scope>
                <optional>true</optional>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
                <scope>runtime</scope>
            </dependency>
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
            </dependency>
 
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>${mybatis.version}</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-autoconfigure</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-starter-jdbc</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
 
            <dependency>
                <groupId>p6spy</groupId>
                <artifactId>p6spy</artifactId>
                <version>${p6spy.version}</version>
            </dependency>
 
            <dependency>
                <groupId>org.apache.commons</groupId>
                <artifactId>commons-lang3</artifactId>
                <version>${commons-lang3.version}</version>
            </dependency>
 
            <dependency>
                <groupId>cn.hutool</groupId>
                <artifactId>hutool-all</artifactId>
                <version>${hutool.version}</version>
            </dependency>
 
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid-spring-boot-starter</artifactId>
                <version>${druid.version}</version>
            </dependency>
 
            <dependency>
                <groupId>io.swagger</groupId>
                <artifactId>swagger-annotations</artifactId>
                <version>${swagger-annotation-models-version}</version>
            </dependency>
 
            <dependency>
                <groupId>io.swagger</groupId>
                <artifactId>swagger-models</artifactId>
                <version>${swagger-annotation-models-version}</version>
            </dependency>
 
            <!-- 引入swagger -->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>${swagger.version}</version>
                <exclusions>
                    <exclusion>
                        <groupId>io.swagger</groupId>
                        <artifactId>swagger-annotations</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>io.swagger</groupId>
                        <artifactId>swagger-models</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
 
            <!-- 引入swagger-ui -->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>${swagger-ui.version}</version>
            </dependency>
 
        </dependencies>
    </dependencyManagement>
 
</project>
 
```

 

## 使用技术点预览

| 技术列表     | 包含功能点                                                   |
| ------------ | ------------------------------------------------------------ |
| spring-boot  | 基础功能、统一异常、统一返回体（由于openfeign的使用，不能统一拦截处理，否则会包装两层） |
| mybatis-plus | 字段填充、乐观锁、强制禁用逻辑删除、分页插件                 |
| druid        | 基本连接池、回收连接、慢sql日志、WallFilter、内置监控界面、白名单 |
| nacos        | 服务发现与配置中心                                           |
| openfeign    | 超时配置（提供默认超时配置Bean、具体服务超时、接口超时）     |
|              |                                                              |
|              |                                                              |
|              |                                                              |
|              |                                                              |

## 项目模块分解

| 模块                  | 功能                                                         |
| --------------------- | ------------------------------------------------------------ |
| spring-cloud-handbook | 顶级父模块                                                   |
| common-api            | api模块包                                                    |
| common-handbook       | 通用基础包，该包主要包含了基于spring-cloud提供了一些通用功能，力求在不同的项目中都会包含的功能 |
| common-handbook-core  | common-handbook的子包，具体负责提供基础通用功能              |
|                       |                                                              |
|                       |                                                              |
|                       |                                                              |
| service-user-center   | 用户服务模块，属于实际应用模块，包含实际开发演示             |
| service-order         | 订单服务模块，属于实际应用模块，包含实际开发演示             |

 

# 组件安装和配置

## Nacos

> 用户服务注册发现和配置中心
>
> 请参考spring-cloud-alibaba github主页
>
> https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md
>
> nacos自己的Wiki
>
> https://github.com/alibaba/spring-cloud-alibaba/wiki/Nacos-config

### 安装

> https://github.com/alibaba/nacos/releases
>
> https://github.com/alibaba/Nacos 这个页面最下面有一个`Download`下提供了百度云的下载，上面那个下载太难了

### 运行

`Nacos`默认端口号为8848， 提供可视化界面，访问地址为http://${nacos-host}:${nacos-port}/nacos，如http:://localhost:8848/nacos，登录用户名和密码都为`nacos`

### 概念

> https://nacos.io/zh-cn/docs/concepts.html

#### 命名空间

默认保留空间为public, 命名空间可以用来隔离不同环境的服务和配置文件。了解了nacos作为配置中心实现的多环境配置文件是通过`${spring.profiles.active}`来实现的，命名空间并不是作为配置文件技术上的实现隔离，更偏向于视图。比如我有个服务，我要注册指定一个视图即命名空间，然后在`nacos`的控制台上就可以在指定的命名空间下找到对应的服务。如下图，指定服务注册到`dev`视图下，这个经过测试，`nacos`的服务列表控制台的`namespace`如果要生效，比如配置配置中心，并且需要对服务进行配置文件的设置后才会生效，否则只会在`public`视图下，所以我理解下来`namespace`更像是个分类，方便对界面上多而杂的服务进行快速区分，而配置中心的文件规则才会真正让程序来识别的资源隔离技术。

**注意**

> nacos 1.3 版本以上才提供命名空间的自定义命名，低版本的是随机生成的一串字符串，而且在配置文件是使用的正事这个命名空间ID，而不是命名空间名

![新建命名空间](https://vipkshttps4.wiz.cn/ks/share/resources/581c88a2-8001-4020-87a9-fb85b53ffcbf/51e1b9ed-802c-4b70-9747-8fcf442dfa1e/index_files/image-20200710143628678_2.png)

 

![](https://vipkshttps4.wiz.cn/ks/share/resources/581c88a2-8001-4020-87a9-fb85b53ffcbf/51e1b9ed-802c-4b70-9747-8fcf442dfa1e/index_files/image-20200710143130591.png)

 

**1.3版本的nacos命名空间新增界面，允许自定义输入命名空间ID**

 

#### 分组

概念上同命名空间差不多，只不过同一个命名空间下可以又具体细分为不同的分组，除了按照上面命名空间的应用隔离之外，还可以使用默认的命名空间然后通过不同的分组来隔离不同的应用，默认为`DEFAULT_GROUP`

**推荐使用命名空间来隔离应用，至于分组名称，可以按照个人意愿统一重新建立个分组，当然也可以直接使用默认分组**

 

### 配置

#### 注册中心

> 这里讲述作为注册中心的相关配置， 在实际项目中由于项目本身数量和环境数量都会比较多，因此会配合前面提到的命名空间来综合使用

##### 依赖

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

 

##### 新建命名空间

> 可选，但推荐使用，不是服务注册的步骤

在控制台操作建立命名空间， `dev`和`prod`， 注意前面提到的`1.3`版本后才提供自定义命名空间ID,否则会是一长串字符

##### 配置服务注册

> 注意一定要使用bootstrap-${profile}的形式来配置文件名,不要在使用`springboot`的那一套`application-${profile}`，经过测试这一套虽然配置都会生效，但是对`nacos`的配置中心无效

在`bootstrap.yml中指定${spring.profiles.active}`

`bootstrap.yml`

```yaml
spring:
  profiles:
    active: dev
```

在对应的`profile`文件上配置`nacos`或者其它信息

`bootstrap-dev.yml`

```yaml
spring:
  cloud:
    nacos:
      username: nacos                      ## nacos控制台的用户名
      password: nacos                      ## nacos控制台的用户名
      discovery:
        namespace: dev                    # 注意是命名空间ID，而不是命名空间名，用来做环境
        server-addr: 127.0.0.1:8848        # nacos服务主机
        group: DEFAULT_GROUP            # 分组，这里采用了默认分组
```

##### 服务发现与消费

> 将`@EnableDiscoveryClient`注解加入到配置类中

```java
@SpringBootApplication(scanBasePackages = GlobalConst.GLOBAL_BASE_PACKAGE)
@EnableDiscoveryClient
public class UserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
 
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
 
```

如果只是要服务发现，只需要使用`EnableDiscoveryClient`即可，但一般我们使用微服务时，大部分服务不仅提供服务也会要消费服务，而消费服务一般都会注入`RestTemplate`来使用，当然也会使用到`openfeign`，但`openfeign`是基于`ribbon`的，我们还是要把`RestTemplate`注入到容器中；

`    @LoadBalanced`的注解有两个作用，没加之前服务之间的调用是通过服务的地址进行接口直连调用的，而加入了注解之后，调用的时候只需要使用`spring.application.name`调用，而且如果服务有多个实例，可以提供负载均衡的功能。

简单举个例子，上述我们当前服务名叫`user-center`，比如我们有一个`get`接口`/user/testProperties`，现在如果有另外一个服务想要调用这个接口，就可以使用注入的`RestTemplate`来操作

简单示例如下

```java
@Autowired
private RestTemplate restTemplate;
 
public void callUserCenterTestProperties() {
    restTemplate.getForObject("http://user-center/user/testProperties", String.class);
}
```

 

#### 配置中心

##### 新建命名空间

同上述注册中心新建命名空间，一般这个时候已经在前面建立过了

##### 配置中心

搭配着命名空间进行隔离后，在命名空间`dev`下新建配置

`DataId`规则`${spring.application.name}-${profile}.${file-extension:properties}`,

![](https://vipkshttps4.wiz.cn/ks/share/resources/581c88a2-8001-4020-87a9-fb85b53ffcbf/51e1b9ed-802c-4b70-9747-8fcf442dfa1e/index_files/f72efc31-3f81-4213-b954-cd198dd1d5d5.png)

##### 对应配置文件

> 注意一定要使用bootstrap-${profile}的形式来配置文件名,不要在使用`springboot`的那一套`application-${profile}`，经过测试这一套虽然配置都会生效，但是对`nacos`的配置中心无效

在`bootstrap.yml中指定${spring.profiles.active}`

`bootstrap.yml`

```yaml
spring:
  profiles:
    active: dev
```

在对应的`profile`文件上配置`nacos`或者其它信息

`bootstrap-dev.yml`

```yaml
spring:
  application:
    name: "user-center"
  cloud:
    nacos:
      username: nacos                #  nacos控制台登录用户名
      password: nacos                #  nacos控制台登录密码
      discovery:
        namespace: dev
        server-addr: 127.0.0.1:8848
        group: DEFAULT_GROUP
      config:
        namespace: dev                # 命名空间id,注意要对应控制台新建配置时所选择的命名空间
        file-extension: yaml          # 新建配置时，配置文件的扩展名，对应在Nacos控制台新建配置时选择的配置格式
        config-retry-time: 1000 
        refresh-enabled: true         # 是否开启配置文件动态刷新，默认true,配合@RequestScope实现配置热更新
        server-addr: 127.0.0.1:8848 # nacos服务器地址
        group: DEFAULT_GROUP        # 分组
```

如上配置内容，对应的则是在`nacos`服务端有一个命名空间，id为`dev`，然后去读取配置文件`user-center-dev.yaml`

 

> 项目启动完成之后，即先在项目中做好配置，然后再在配置中心新建配置，也是可以的。

 

##### 共享配置

> 有时候我们会希望将某些配置文件单独定义一份，然后由其它配置文件来引用，在整个微服务集合中，有多个服务需要用到一份相同的配置，那么我们就可以在配置中心单独定义一个配置文件，然后其它需要该配置文件的就可以引入过来了

在命名空间下`dev`新建一个配置`shard-config-demo.yaml`，这个配置可以不用遵守之前`dataid`的规则

![](https://vipkshttps4.wiz.cn/ks/share/resources/581c88a2-8001-4020-87a9-fb85b53ffcbf/51e1b9ed-802c-4b70-9747-8fcf442dfa1e/index_files/5856da0b-54c7-43d9-91af-58bafb852538.png)

 

调整之前的`bootstrap-dev.yaml`,增加`shared-configs`

```yaml
spring:
  application:
    name: "user-center"
  cloud:
    nacos:
      username: nacos                #  nacos控制台登录用户名
      password: nacos                #  nacos控制台登录密码
      discovery:
        namespace: dev
        server-addr: 127.0.0.1:8848
        group: DEFAULT_GROUP
      config:
        namespace: dev                # 命名空间id,注意要对应控制台新建配置时所选择的命名空间
        file-extension: yaml          # 新建配置时，配置文件的扩展名，对应在Nacos控制台新建配置时选择的配置格式
        config-retry-time: 1000 
        refresh-enabled: true         # 是否开启配置文件动态刷新，默认true,配合@RequestScope实现配置热更新
        server-addr: 127.0.0.1:8848 # nacos服务器地址
        group: DEFAULT_GROUP        # 分组
        shared-configs:
          - dataId: shard-config-demo.yaml
            group: DEFAULT_GROUP
            refresh: true            # 是否开启动态刷新，这个默认是false
```

 

**注意**

针对共享配置的动态刷新默认是关闭的，配置中心的主配置文件的动态刷新默认是开启的，关于动态刷新详见后面一章

 

##### 动态刷新

> 关于动态刷新，即将属性配置到`nacos`配置中心后，在配置中心更改对应的配置文件，系统无需重启即可获取最新的配置值，需要注意的是，这个是有间隔时间的，按文档来说是1S。

假如在配置中心中我们配置了如下属性

```yaml
customs:
  global-properties:
    author: dongfang.ding13344--3311
  user:
    name: ddf13344--3311
```

关于取属性存在下面几种方式

* @Value
* 直接从`org.springframework.core.env.Environment`对象中取
* 将属性注入到某个对象中，通过对象访问

如下代码

```java
@RestController
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
@RequestMapping("user")
@RequestScope
public class AuthUserController {
 
    private final GlobalProperties globalProperties;
 
    private final Environment environment;
 
    @Value("${customs.user.name}")
    private String userName;
 
    @GetMapping("testProperties")
    public String testProperties() {
        return MessageFormat.format("author: {0}, 注入userName: {1}, 从环境变量中取userName: {2}," +
                        "从共享配置文件中读取userName: {3}",
                globalProperties.getAuthor(),
                userName,
                environment.getProperty("customs.user.name"),
                environment.getProperty("customs.shard-config.user.name")
        );
    }
}
 
```

**说明**

1. `globalProperties`对应的是将属性注入到某个对象中，通过对象访问
2. `environment`对应的是直接从环境变量中取值
3. userName对应的是使用注解`@Value`

**结论**

1. 注意看控制器上有一个注解`@RequestScope`，这个是`spring-cloud`的原生注解，用来支持配置中心配置动态更新的

2. 读取配置文件如上面的三种方式，如果采用从`environment`中直接读取的话，是不需要这个注解的。但是如果采用另外两种方式，如`GlobalProperties`，则需要在该类上使用`RequestScope`。而使用@Value的由于没有一个对象来存，只能谁用谁自己加`@RequestScope`了。

3. 共享配置如果开启动态刷新后，是否需要`@RequestScope`的规则和主配置是一样的

 

## OpenFeign

> https://github.com/OpenFeign/feign
>
> openfeign提供了一种面向`Rest`的通过接口来访问服务的一种方式，如果只使用`RestTemplate`则会造成大量不可维护和不统一的接口地址散落，而且不利用复用；
>
> 使用openfeign,可以将已暴露从rest接口再封装成接口，通过在接口上配置的访问路径，达到代码访问接口，实现访问服务，如果需要更改访问地址的话，调用方是不需要关心的.

**非常重要的一个概念**

`spring-cloud`微服务体系是基于`Rest`的，即`http`协议，而`dubbo`等`rpc`框架是基于`rmi`的，两者本质上有很大的不同；通俗的理解，使用`dubbo`的时候我们一般定义接口之后，然后服务提供者对接口进行实现之后，调用方只要引用接口就可以直接调用服务提供方提供的功能了；如果我们没有把接口暴露成外部接口，除了服务内部通过注册中心发现并调用外，该服务不会暴露成`http`接口可以被外部调用。

但是`rest`就不一样了，如果一个服务想要被另外一个服务所消费，那么对应的服务提供者并且把接口做`@RequestMapping`映射，把接口暴露在外之后，服务内部也是通过这种方式调用的。所以在使用上来说是稍微麻烦一些的。

从成型逻辑上是先有的业务接口，然后实现，然后映射成`rest`接口。然后如果这个接口需要内部`openfeign`调用，就要在抽一层接口，然后在接口上将访问路径指向暴露的`rest`接口访问路径。后面会详细解释这一块。

### 依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

 

### 前置准备

加入用户模块要查询全部用户列表（简单演示，不考虑分页）

1. 编写用户接口

   ```java
   public interface AuthUserService {
      /**
       * 查询全部用户列表
       * @return
       */
      List<AuthUser> listAll();
   }
   ```
   
2. 编写用户接口实现，省略查询

   ```java
   @Service
   @RequiredArgsConstructor(onConstructor=@__(@Autowired))
   public class AuthUserServiceImpl implements AuthUserService {
   
       private final AuthUserDao authUserDao;
   
       /**
           * 查询全部用户列表
           *
           * @return
           */
       @Override
       public List<AuthUser> listAll() {
           return authUserDao.listAll();
       }
   }
   ```

   

3. 编写用户控制器代码，暴露rest接口

   ```java
   @RestController
   @RequiredArgsConstructor(onConstructor=@__(@Autowired))
   @RequestMapping("user")
   public class AuthUserController {
    
       private final AuthUserService authUserService;
    
       @GetMapping("listAll")
       public ResponseData<List<AuthUser>> listAll() {
           return ResponseData.success(authUserService.listAll());
       }
   }
   ```

   

**总结**

如上代码是一个很简单的查询代码，而`openfeign`就是基于上述实现才能做到暴露服务调用接口的，必须要先暴露对外接口（当然也不是一定如此，也可以不写控制器，`openfeign`自己即作为暴露的接口，然后对这个接口做实现，然后将实现的类映射成`RestController`，这个在后面一个章节单独说一下吧，优劣本人也说不好）

### 声明服务

> 当前服务，我们配置了context-path为user-center, spring.application.name为user-center

1. 声明`feign`接口，使用`@FeignClient`来标识这是一个`feign`调用的接口，`name`的值为当前服务名user-center, `path`的值不一定为context-path，可以理解为前缀，每个接口如果有一个共同的前缀都可以加到`path`属性中,最后一个属性`contextId`需要注意，目前如果针对同一个服务如果声明了两个接口类，就会报错

   ```
   The bean 'user-center.FeignClientSpecification' could not be registered. A bean with that name has already been defined and overriding is disabled.
 
   Action:
 
   Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
   ```

   实际上这是很正常的需求，因为同一个服务我们会声明不同模块的接口，必然会有多个，解决方法有两个，一个就是报错控制台提示的将属性`spring.main.allow-bean-definition-overriding`设置为true,

   还有一种就是每个接口使用不同的`contextId`区分，两个有啥区别，我也不知道，只是感觉一看到重写就觉得怪怪的，很奇怪，以前版本记得是没这个问题的

 

   **接口上的路径规则**， 注意看接口上我们使用了`springmvc` 的注解`GetMapping`，看`openfeign`的文档说的是使用`RequestLine`，不过既然兼容`springmvc`的，那就用熟悉的；这个路径的规则对应的就是你想要这个接口去访问自己暴露的哪个`rest`接口，这个路径是随便填乱创造的，必须要和对应的控制器对应起来，如我们现在配置的`path`和接口的`GetMapping`,对应的就是这个接口实际上是要去调用`/user-center/user/listAll`接口

 

   **参数的规则**， 如果我们声明的接口是有参数的，则和使用`springmvc`是一样的用法，同样是使用`RequestBody`， `RequestParam`， `PathVariable`，但是有一点需要注意

   在使用控制器如果我们要使用 `RequestParam`，我们如果不使用`name`属性的时候，默认接收的参数名就是当前方法声明的形参的变量名，但是在声明`feign`接口的时候，这个属性是不能省略的，不写会出问题

   即在`springmvc`中如果有代码如下，

   ```java
   @GetMapping("/user/getById")
   public ResponseData<List<AuthUser>> getById(@RequestParam String id) {
 
   }
   ```

   对应在`feign`接口中必须是如下格式

   ```java
   @GetMapping("/user/getById")
   public ResponseData<List<AuthUser>> getById(@RequestParam(name = "id") String id);
   ```

 

   **声明的feign接口如下**

   ```java
   package com.ddf.cloud.handbook.api.sdk.usercenter;
 
 
   @FeignClient(name = ApiConstant.USER_CENTER_SERVICE_NAME, path = ApiConstant.USER_CENTER_SERVER_CONTEXT, contextId = "authUserService")
   public interface AuthUserOutService {
 
       /**
        * 查询全部用户列表
        * @return
        */
       @GetMapping("/user/listAll")
       ResponseData<List<AuthUser>> listAll();
 
   }
 
   ```

   **注意上述代码将包名也放出来了，后面有大用**

 

### 消费服务

1. 在消费者服务配置类使用注解`@EnableFeignClients`开启`feign`调用，注意默认扫描的是当前主启动类所在的包路径，这个规则可能并不能满足实际上我们`feign`接口所在的包，所以需要使用`basePackages`来指定一下我们服务实际所在的包
2. 声明`RestTemplate`和`@LoadBalanced`，只有声明了`@LoadBalanced`之后才能通过服务名去调用以及完成负载均衡
3. 配置注册中心，发现服务`@EnableDiscoveryClient`，如果是`Eureka`对应的则是`@EnableEurekeClient`，好像是这么写的，记不清楚了，也懒得再查，反正不用了
4. 注入接口，完成调用

  **对应代码如下**

```yaml
@SpringBootApplication(scanBasePackages = GlobalConst.GLOBAL_BASE_PACKAGE)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ddf.cloud.handbook.api")
public class OrderApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
 
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
 
```

注入调用

```java
@RestController
@RequestMapping("order")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class OrderController {
 
    private final AuthUserOutService authUserOutService;
 
    @GetMapping("listAllUser")
    public ResponseData<List<AuthUser>> listAllUser() {
        return authUserOutService.listAll();
    }
 
}
 
```

### 超时控制

超时是所有跨应用接口调用共同面对的一个问题，`feign`的默认超时时间是1000ms, 如果不满足我们实际情况的时候我们就要对这个配置进行修改

1. 向容器中注入`Request.Options`对象， `feign`在完成超时配置的时候会去判断自定义注入这个`bean`，如果存在的话就会用我们自己注入的这个，我们可以在项目的`common`模块中注入这个对象以提供所有服务的相对比较实际的默认超时时间

   ```java
   @Bean
   @Primary
   public Request.Options options() {
       return new Request.Options(10, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true);
   }
   ```

 

2. 经过1之后，如果服务将上面的`bean`纳入容器管理，则实现了全局服务默认的超时处理，但是如果自定义的默认还是不满足当前服务，就可以使用配置文件来覆盖服务, default指配置了当前服务默认使用这个配置，`config`属性是一个Map结构，key也可以为具体服务名，如果服务名与当前服务匹配的话，优先级是高于`default`的

   ```yaml
   feign:
     client:
       config:
         default:
           readTimeout: 5000
           connectTimeout: 5000
         某个服务的名称作为Key,如(user-center):
             readTimeout: 6000
            connectTimeout: 6000
   ```

   **优先级问题**

   配置文件匹配的具体服务名的配置 > 配置文件的default的配置 >  > 注入`bean`

3. 即使经过了上述配置之后，针对某些接口来说依然觉得这个配置的粒度还是比较粗的，如果我们想要配置某个具体`feign`接口的超时，又需要如何去做呢？

   参考了仓库有人提的issue https://github.com/OpenFeign/feign/pull/970

   1. 重载接口，提供一个默认接收超时配置的接口，超时处理让调用方去抉择

      ```java
      @FeignClient(name = ApiConstant.USER_CENTER_SERVICE_NAME, path = ApiConstant.USER_CENTER_SERVER_CONTEXT, contextId = "authUserService")
      public interface AuthUserSdkService {
 
          /**
           * 查询全部用户列表
           * @param options 控制超时参数
           * @return
           */
          @GetMapping("/user/listAll")
          ResponseData<List<AuthUser>> listAll(Request.Options options);
 
          /**
           * 查询全部用户列表
           * @return
           */
          @GetMapping("/user/listAll")
          ResponseData<List<AuthUser>> listAll();
 
      }
      ```

   2. 如果项目中最终采用了这几种方案的组合，其实看下来就会发现，我们需要定义一批超时对象，以供我们选择，如默认的，或者取出来直接用的，那么我们就可以在项目的通用包模块下单独定义一个配置类，专门用来定义`Request.Options`，统一定义，谁用谁注入，然后传入接口中，举个例子如下

      ```java
      @Configuration
      public class FeignConfiguration {
 
          /**
           *
           * feign的默认超时时间只有1000ms,这里向容器中注入一个默认的超时时间， 客户端也可以使用配置      *    的形式来覆盖这个默认的
           */
          @Bean
          @Primary
          public Request.Options options() {
              return new Request.Options(10, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true);
          }
 
          /**
           *
           * feign的接口可以接受一个入参对象(Request.Options),这样就可以自定义每个接口的超时时间了，这里预定义几个参数
           * 参考 https://github.com/OpenFeign/feign/pull/970
           *
           * @return
           */
          @Bean
          public Request.Options oneSecondsOptions() {
              return new Request.Options(1, TimeUnit.SECONDS, 1, TimeUnit.SECONDS, true);
          }
              
          /**
             *
             * feign的接口可以接受一个入参对象(Request.Options),这样就可以自定义每个接口的超时时间了，这里预定义几个参数
             * 参考 https://github.com/OpenFeign/feign/pull/970
             *
             * @return
             */
          @Bean
          public Request.Options fiveSecondsOptions() {
              return new Request.Options(5, TimeUnit.SECONDS, 5, TimeUnit.SECONDS, true);
          }
      
          /**
             *
             * feign的接口可以接受一个入参对象(Request.Options),这样就可以自定义每个接口的超时时间了，这里预定义几个参数
             * 参考 https://github.com/OpenFeign/feign/pull/970
             *
             * @return
             */
          @Bean
          public Request.Options thirtySecondsOptions() {
              return new Request.Options(30, TimeUnit.SECONDS, 30, TimeUnit.SECONDS, true);
          }
      }
      ```

 ### 自动注入

**问题**

可以看到在消费服务的时候，需要使用`@EnableFeignClients`来引入暴露服务包名，但是一般在开发环境中，我们会存在很多不同模块的`feign`的调用接口，而这部分接口并不关注具体实现，因此我们的实践方法都会是将这些`api`接口调用模块单独抽到一个模块里维护，当服务之间互相调用的时候，只要引入对应模块的`api`包即可。但是现在我们提供了模块包之后，却还需要使用方，显示的使用注解`@EnableFeignClients`，将接口所属的包路径给配置出来，我们就在想能不能在模块包中完成这部分的功能

* 在api模块包中提供一个配置类，将接口所在的包路径给扫描进去

  ```java
  package com.ddf.cloud.handbook.api.config;
  
  import com.ddf.cloud.handbook.api.constant.ApiConstant;
  import org.springframework.cloud.openfeign.EnableFeignClients;
  import org.springframework.context.annotation.Configuration;
  
  /**
   * <p>feign接口的自动装配类
   *
   * 如果引入该模块的服务主启动类所在的包路径正好能够扫描到该类，则该类配置成自动装配就是多余的。
   * 但是从通用性上来说，还是要配置一下自动状态
   *
   * </p >
   *
   * @author Snowball
   * @version 1.0
   * @date 2020/07/28 09:33
   */
  @Configuration
  @EnableFeignClients(basePackages = ApiConstant.FEIGN_API_BASE_PACKAGES)
  public class FeignAutoConfiguration {
  }
  
  ```

* 在`api`模块resource下新建文件夹`META-INF`,然后新建文件`spring.factories`，最后在配置自动配置类的地方加上我们自己的配置类，内容如下

  ```
  ## 自动装配类
  org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    com.ddf.cloud.handbook.api.config.FeignAutoConfiguration
  ```

* 经过上述配置，当使用方引入了我们的模块之后，模块内部的配置类就会生效，自动完成接口配置的装配功能。当然正如自动配置类上的注释所说，如果你引入服务的模块已经显示的将整个项目的包扫描路径给扩大了范围，直接已经包含了自动配置类所在的路径时，最后一步配置文件就是多余的了。

  打个比方，api自动配置类所在包为com.test.test1.test2， 应用所在包为com.test.test1.app。

  然后由于你自己开发的相关服务都遵循了一定规则的前缀，你直接在app应用主启动类上指定了包扫描路径为

  com.test，那么配置自动状态自然是多余的了，但是配置类是一定要在的。

### 动态代理
TODO
可以自定义指定超时时间，需要每个方法都要重载一遍，有点太麻烦了， 使用动态代理，生成代理，通过在代理类中获取对象信息，然后在拼接参数，最终在代理类中调用，但是服务提供者还是会有两个方法还是麻烦，到时候要细想一下


## spring-cloud-gateway

> spring-cloud-gateway是spring基于spring-boot和webflux、netty实现的新一代网关，但是说实话，由于对webflux的完全不熟悉，一些原来很简单的功能在使用spring-cloud-gateway上时用的非常费劲
>
> 官方文档传送门，说实话想看的内容几乎都看不到，就在那里说一堆很少用到的断言
>
> https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.3.RELEASE/reference/html

### 依赖

> 项目一定要排除依赖spring-webmvc,spring-boot-starter-tomcat啊之类的,spring-cloud-gateway使用netty作为容器
>
> 作为曾经踩过的坑，备注在此 https://blog.csdn.net/yichen0429/article/details/98203775

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

由于使用了nacos作为服务注册发现和配置中心，所以还需要引入nacos的依赖，这一部分看具体自己选型，不是gateway本身的依赖

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
 
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

 

### 启动报错汇总

> 由于spring-cloud-gateway抛弃了熟悉的webmvc而使用了webflux，启动 的时候错误百出，一不小心，就报各种各样的错，还是单独汇总出来一下

```java
org.springframework.context.ApplicationContextException: Unable to start web server; nested exception is org.springframework.context.ApplicationContextException: Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.
 
```

```java
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.core.convert.ConversionService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Qualifier(value=webFluxConversionService)}
 
```

上述两个错误，使用`mavenhelper`工具分析一下到底哪个`jar`包依赖了`springmvc`，将包排除即可解决

 

```java
java.lang.ClassCastException: org.springframework.core.io.buffer.DefaultDataBufferFactory cannot be cast to org.springframework.core.io.buffer.NettyDataBufferFactory
 
```

上面这个错误，启动正常，表现形式为网关工作转发正常，目标服务返回数据也正常，但是网关会无法解析返回的数据，检查下项目是否依赖了`spring-boot-starter-tomcat`，排除即可

 

```java
Caused by: java.lang.ClassNotFoundException: javax.servlet.Servlet
```

上述错误，基本是在已经排除了`web`容器之后，但是我们项目里可能注册了一些`servlet`， 因为排除依赖之后，没有`servlet`环境了，所以报错了。如`druid`数据库连接池，我们配置了`stat-view-servlet`

 

### 服务启动

使用`@EnableDiscoveryClient`注解来发现同一注册中心内的服务

```java
@SpringBootApplication(scanBasePackages = GlobalConst.GLOBAL_BASE_PACKAGE)
@EnableDiscoveryClient
public class GatewayApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
```

 

### 路由配置

> https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.3.RELEASE/reference/html/#the-path-route-predicate-factory

```yaml
server:
  port: 8888
spring:
  cloud:
    gateway:
      routes:
        - id: user-center
          uri: lb://user-center
          predicates:
            - Path=/user-center/**
        - id: order
          uri: lb://order
          predicates:
            - Path=/order/**
```

`routes`是一个list,用于配置路由规则集合

`id`不重复即可，无特殊要求，一般用服务名即可，方便辨识

`predicates` 断言，用来与当前请求路径进行匹配，如果匹配成功，则转发请求到对应的`uri`上

`uri` 当`predicates` 匹配成功后，网关则将请求转发到配置的`uri`上，在整个微服务架构中，这里一般我们都是通过服务名去进行访问的，因此这里配置服务名，加上`lb`的意思就提供负载均衡

如上述配置

访问`http://${host}:8888/user-center/user/listAll`，则网关会将请求转发到服务`user-center`，然后调用`/user-center/user/listAll`，注意`user-center`转发的时候是不会舍弃的，这个时候就需要注意，我们对应的服务是否有这个路径；

比如`user-center`服务配置了`context-path`为`user-center`， 方法的控制层路径为`/user/listAll`，那么路径转发过来的时候由于我们配置了`user-center`,那么路径就能够完全匹配到，接口就可以被正常访问；

**注意注意注意**

> https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.3.RELEASE/reference/html/#the-stripprefix-gatewayfilter-factory

还有一种情况，比如我们的服务没有配置`context-path`，那么最终转发到具体服务的时候就没有`user-center`这部分，就需要我们配置的时候舍弃这部分，这个时候**`StripPrefix`**这个参数的作用就出来了，这个参数可以舍弃路径中的分段，从左边开始计算，比如**`StripPrefix=1`**,这转发的时候路径就变成了`/user/listAll`， 如果**`StripPrefix=2`**，则转发的时候路径就变成了`/listAll`，配置内容示例如下

```yaml
server:
  port: 8888
spring:
  cloud:
    gateway:
      routes:
        - id: user-center
          uri: lb://user-center
          predicates:
            - Path=/user-center/**
          filters:
            - StripPrefix=1
```

 
