### 目录说明
-config：配置文件  
-modules：模块组件  
-- cas  
-- demo  
-- message  
-- monitor 监视，主要添加了一个redis状态监控   
-- ngalain  
-- quartz  
-- shiro  权限验证，可以过滤到某些url  
-- system  系统功能  
  用户    
  角色  
  权限  
  数据字典 SysDict 用于将后端的数据（0,1）显示成前端的 （失败，成功） 等  
  数据快照  SysDataLog  
  


### 请求记录处理
放入在jeecg\modules\ngalain\aop\LogRecordAspect.java  
但好像没起作用


### 逻辑删除
只要在这里定义了  private String delFlag; 就可以
system\entity\SysRole.java

### sql日志配置
application-dev.yml中：
logging:
  level:
    org.jeecg.modules.system.mapper : debug
在logback-spring.xml的配置无效。。


### 注册处理
只需要用户名+密码+注册码就可以  
密码接口需要改善一下
### 通过自定义密码接口来修改密码
common\util\PasswordUtil.java

### 定义两个用户
admin superuser
rhadmin rhaxadmin 


### 注意打包次序
先将 jeecg-boot-parent  通过maven install
然后再将主文件夹  jeecg-boot-module-system 通过maven package  

### 对于api的扫描
还没找到在哪里定义  但必须是要org.jeecg下面的才可以


###  对于api文档接口的扫描
org.jeecg.config.Swagger2Config
这里只是指定了org.jeecg.modules下面的api文档接口




### 部署 
* 使用docker  
自带docker文件。。。

* 提示错误：
FATAL: kernel too old
解决方法：https://blog.csdn.net/J080624/article/details/104276720
参考：http://elrepo.org/tiki/tiki-index.php

* 修改application-prod.yml 为linux环境


