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
| spring-boot          | 2.2.8.RELEASE | 基础框架       |
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
> https://github.com/alibaba/Nacos这个页面最下面有一个`Download`下提供了百度云的下载，上面那个下载太难了

### 运行

`Nacos`默认端口号为8848， 提供可视化界面，访问地址为http://${nacos-host}:${nacos-port}/nacos，如http:://localhost:8848/nacos，登录用户名和密码都为`nacos`

### 依赖

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

 

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

##### 新建命名空间

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
            refresh: true			# 是否开启动态刷新，这个默认是false
```

)

```yaml
spring:
  application:
    name: "user-center"
  cloud:
    nacos:
      username: nacos                #  nacos控制台登录用户名
      password: nacos                #  nacos控制台登录密码
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
            refresh: true			# 是否开启动态刷新，这个默认是false
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

   