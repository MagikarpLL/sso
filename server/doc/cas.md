# CAS6.3版本改造记录

## 改造目标
- 由原来的war-ovelay插件的war包部署方式改为maven引入依赖，jar包启动
- 自定义并改造cas的webflow流程(暂不需要)
- 自定义前端的展示页面，可能完全更换引擎，不使用自带的thymeleaf模板
- 支持rest接口登录
- oauth2.0接口认证

## 改造记录
### war包改造
已基本修改完成  

改造方案如下：  
将原生的6.3war包拉下来，然后分析其引入的依赖，然后另外重新搭建一个maven springboot jar工程，并将原来war包的依赖逐渐引入
### Springboot初始化方面
正在进行中

目前改造方案如下:  
- 将原生的cas-server-webapp-init jar包中的CasWebApplication拷贝出来，并以springboot方式启动即可

遇到的问题如下:
- cas自带的日志与springboot框架的日志冲突，因此需要屏蔽掉springboot原生的日志框架
### Webflow 方面
正在进行中

目前改造方案如下:
- 继承cas-server-code-webflow-api 包中的AbstractCasWebflowConfigurer并自定义它，即可实现自己的webflow流程
- 登录请参考该类 DefaultLoginWebflowConfigurer  ，然后相关action都放在cas-server-support-action中，相关webflow名字都在CasWebflowConstants中


遇到的问题如下:
- loing-webflow.xml并不能移除，且原生的webflow配置需要屏蔽掉.他们现阶段的做法是，放两个webflow的xml文件到资源目录，然后通过java代码向里面添加action等流程

### 前端展示页面

### REST接口登录
引入cas-server-support-rest-authentication这个jar包

