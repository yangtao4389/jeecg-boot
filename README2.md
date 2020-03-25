### 目录说明
-config：配置文件  
-modules：模块组件  
-- cas  
-- demo  
    mock里面全部都是模拟数据，以api开头
    "/api/user/info",
    "/api/permission",
    "/api/user",
    "/api/service",
    "/api/role",
    "/api/permission/no-pager",
    "/api/report/getMonthCountInfo",
    "/api/report/getCntrNoCountInfo",
    "/api/report/getCabinetCountInfo",
    "/api/report/getYearCountInfo",
    "/api/area",
    "/api/asynTreeList",
    "/api/json/{filename}",
    "/api/queryDiskInfo",
    "/api/list/search/projects",
    "/api/workplace/activity",
    "/api/workplace/teams",
    "/api/workplace/radar",
    "/api/task/process",
    
    "/big/screen/index1",
    "/big/screen/html",
    "/big/screen/index2",
    "/test/jeecgDemo/add",
    "/test/jeecgDemo/delete",
    "/test/jeecgDemo/list",
    "/test/jeecgDemo/redis/{id}",
    "/test/jeecgDemo/mpList",
    "/test/jeecgDemo/sqlList",
    "/test/jeecgDemo/exportXls",
    "/test/jeecgDemo/html",
    "/test/jeecgDemo/importExcel",
    "/test/jeecgDemo/edit",
    "/test/jeecgDemo/deleteBatch",
    "/test/jeecgDemo/queryById",
    "/test/jeecgDemo/redisSet",
    "/test/jeecgDemo/redisGet",
    "/test/jeecgDemo/redisSetObj",
    "/test/jeecgDemo/redisGetObj",
    "/test/jeecgDemo/testOnlineAdd",
    "/test/jeecgOrderMain/add",
    "/test/jeecgOrderMain/delete",
    "/test/jeecgOrderMain/queryOrderCustomerListByMainId",
    "/test/jeecgOrderMain/queryOrderTicketListByMainId",
    "/test/jeecgOrderMain/exportXls",
    "/test/jeecgOrderMain/importExcel",
    "/test/jeecgOrderMain/deleteBatch",
    "/test/jeecgOrderMain/queryById",
    "/test/jeecgOrderMain/edit",
    "/test/jeecgOrderMain/list",
    "/test/order/add",
    "/test/order/delete",
    "/test/order/listOrderCustomerByMainId",
    "/test/order/listOrderTicketByMainId",
    "/test/order/orderList",
    "/test/order/deleteBatchCustomer",
    "/test/order/deleteBatchTicket",
    "/test/order/edit",
    "/test/order/deleteBatch",
    "/test/order/queryById",
    "/test/order/editCustomer",
    "/test/order/addTicket",
    "/test/order/deleteCustomer",
    "/test/order/addCustomer",
    "/test/order/editTicket",
    "/test/order/deleteTicket",
    "/test/joaDemo/add",
    "/test/joaDemo/delete",
    "/test/joaDemo/exportXls",
    "/test/joaDemo/importExcel",
    "/test/joaDemo/edit",
    "/test/joaDemo/deleteBatch",
    "/test/joaDemo/queryById",
    "/test/joaDemo/list",
    "/test/jeecgDemo/hello",
-- message  
    "/message/sysMessage/add",
    "/message/sysMessage/delete",
    "/message/sysMessage/exportXls",
    "/message/sysMessage/importExcel",
    "/message/sysMessage/edit",
    "/message/sysMessage/deleteBatch",
    "/message/sysMessage/queryById",
    "/message/sysMessage/list",
    "/message/sysMessageTemplate/add",
    "/message/sysMessageTemplate/delete",
    "/message/sysMessageTemplate/sendMsg",
    "/message/sysMessageTemplate/exportXls",
    "/message/sysMessageTemplate/importExcel",
    "/message/sysMessageTemplate/edit",
    "/message/sysMessageTemplate/deleteBatch",
    "/message/sysMessageTemplate/queryById",
    "/message/sysMessageTemplate/list",
    "/webSocketApi/sendAll",
    "/webSocketApi/sendUser",
-- monitor 监视，主要添加了一个redis状态监控   
    controller： 只监控了redis
    "/actuator/redis/info",
    "/actuator/redis/keysSize",
    "/actuator/redis/memoryInfo",
    "/actuator/redis/queryDiskInfo",
-- ngalain   整合angular？？
    "/sys/ng-alain/getDictItemsByTable/{table}/{key}/{value}",
    "/sys/ng-alain/getAppData", 就是菜单栏
    "/sys/ng-alain/getDictItems/{dictCode}",
    
-- oss
    "/oss/file/delete",
    "/oss/file/upload",
    "/oss/file/queryById",
    "/oss/file/list",
-- quartz  定时器
    "/sys/quartzJob/add",
    "/sys/quartzJob/delete",
    "/sys/quartzJob/pause",
    "/sys/quartzJob/resume",
    "/sys/quartzJob/exportXls",
    "/sys/quartzJob/importExcel",
    "/sys/quartzJob/deleteBatch",
    "/sys/quartzJob/queryById",
    "/sys/quartzJob/edit",
    "/sys/quartzJob/list",  
      
-- shiro  权限验证，可以过滤到某些url  
    web/TestWebController 中有：用于测试？？
    "/login",
    "/require_auth",
    "/require_role",
    "/401",
    "/require_permission",
    "/article",

-- system  系统功能  
  用户    
  角色  
  权限  
  数据字典 SysDict 用于将后端的数据（0,1）显示成前端的 （失败，成功） 等  
  数据快照  SysDataLog  
  
  "/sys/duplicate/check",
  "/sys/login",
  "/sys/loginfo",
  "/sys/logout",
  "/sys/visitInfo",
  "/sys/selectDepart",
  "/sys/sms",
  "/sys/phoneLogin",
  "/sys/getCheckCode",
  "/sys/mLogin",
  "/sys/getEncryptedString",
  "/sys/annountCement/add",
  "/sys/annountCement/delete",
  "/sys/annountCement/listByUser",
  "/sys/annountCement/doReovkeData",
  "/sys/annountCement/doReleaseData",
  "/sys/annountCement/exportXls",
  "/sys/annountCement/importExcel",
  "/sys/annountCement/deleteBatch",
  "/sys/annountCement/queryById",
  "/sys/annountCement/edit",
  "/sys/annountCement/list",
  "/sys/sysAnnouncementSend/add",
  "/sys/sysAnnouncementSend/delete",
  "/sys/sysAnnouncementSend/editByAnntIdAndUserId",
  "/sys/sysAnnouncementSend/readAll",
  "/sys/sysAnnouncementSend/deleteBatch",
  "/sys/sysAnnouncementSend/queryById",
  "/sys/sysAnnouncementSend/edit",
  "/sys/sysAnnouncementSend/list",
  "/sys/sysAnnouncementSend/getMyAnnouncementSend",
  "/sys/category/add",
  "/sys/category/delete",
  "/sys/category/checkCode",
  "/sys/category/loadTreeRoot",
  "/sys/category/loadOne",
  "/sys/category/loadTreeChildren",
  "/sys/category/loadTreeData",
  "/sys/category/loadDictItem",
  "/sys/category/loadAllData",
  "/sys/category/exportXls",
  "/sys/category/importExcel",
  "/sys/category/edit",
  "/sys/category/deleteBatch",
  "/sys/category/queryById",
  "/sys/category/rootList",
  "/sys/category/childList",
  "/sys/dataLog/queryDataVerList",
  "/sys/dataLog/queryCompareList",
  "/sys/dataLog/list",
  "/sys/sysDepart/add",
  "/sys/sysDepart/delete",
  "/sys/sysDepart/queryTreeList",
  "/sys/sysDepart/queryIdTree",
  "/sys/sysDepart/searchBy",
  "/sys/sysDepart/exportXls",
  "/sys/sysDepart/importExcel",
  "/sys/sysDepart/edit",
  "/sys/sysDepart/deleteBatch",
  "/sys/dict/add",
  "/sys/dict/delete",
  "/sys/dict/getDictItems/{dictCode}",
  "/sys/dict/getDictText/{dictCode}/{key}",
  "/sys/dict/loadTreeData",
  "/sys/dict/loadDict/{dictCode}",
  "/sys/dict/loadDictItem/{dictCode}",
  "/sys/dict/treeList",
  "/sys/dict/deletePhysic/{id}",
  "/sys/dict/deleteList",
  "/sys/dict/exportXls",
  "/sys/dict/importExcel",
  "/sys/dict/edit",
  "/sys/dict/deleteBatch",
  "/sys/dict/list",
  "/sys/dict/back/{id}",
  "/sys/dictItem/add",
  "/sys/dictItem/delete",
  "/sys/dictItem/edit",
  "/sys/dictItem/deleteBatch",
  "/sys/dictItem/list",
  "/sys/fillRule/add",
  "/sys/fillRule/delete",
  "/sys/fillRule/testFillRule",
  "/sys/fillRule/exportXls",
  "/sys/fillRule/importExcel",
  "/sys/fillRule/edit",
  "/sys/fillRule/deleteBatch",
  "/sys/fillRule/queryById",
  "/sys/fillRule/list",
  "/sys/fillRule/executeRuleByCode/{ruleCode}",
  "/sys/fillRule/executeRuleByCodeBatch",
  "/sys/log/delete",
  "/sys/log/deleteBatch",
  "/sys/log/list",
  "/sys/permission/add",
  "/sys/permission/delete",
  "/sys/permission/list",
  "/sys/permission/queryTreeList",
  "/sys/permission/queryListAsync",
  "/sys/permission/getSystemSubmenu",
  "/sys/permission/edit",
  "/sys/permission/deleteBatch",
  "/sys/permission/getSystemMenuList",
  "/sys/permission/getUserPermissionByToken",
  "/sys/permission/queryRolePermission",
  "/sys/permission/saveRolePermission",
  "/sys/permission/getPermRuleListByPermId",
  "/sys/permission/addPermissionRule",
  "/sys/permission/editPermissionRule",
  "/sys/permission/deletePermissionRule",
  "/sys/permission/queryPermissionRule",
  "/sys/position/add",
  "/sys/position/delete",
  "/sys/position/exportXls",
  "/sys/position/importExcel",
  "/sys/position/edit",
  "/sys/position/deleteBatch",
  "/sys/position/queryById",
  "/sys/position/list",
  "/sys/role/add",
  "/sys/role/delete",
  "/sys/role/queryTreeList",
  "/sys/role/datarule/{permissionId}/{roleId}",
  "/sys/role/queryall",
  "/sys/role/datarule",
  "/sys/role/checkRoleCode",
  "/sys/role/exportXls",
  "/sys/role/importExcel",
  "/sys/role/edit",
  "/sys/role/deleteBatch",
  "/sys/role/queryById",
  "/sys/role/list",
  "/sys/sysUserAgent/add",
  "/sys/sysUserAgent/delete",
  "/sys/sysUserAgent/queryByUserName",
  "/sys/sysUserAgent/exportXls",
  "/sys/sysUserAgent/importExcel",
  "/sys/sysUserAgent/edit",
  "/sys/sysUserAgent/deleteBatch",
  "/sys/sysUserAgent/queryById",
  "/sys/sysUserAgent/list",
  "/sys/user/add",
  "/sys/user/delete",
  "/sys/user/queryUserRole",
  "/sys/user/queryUserRoleMap",
  "/sys/user/frozenBatch",
  "/sys/user/changPassword",
  "/sys/user/updatePassword",
  "/sys/user/checkOnlyUser",
  "/sys/user/generateUserId",
  "/sys/user/queryUserByDepId",
  "/sys/user/queryByIds",
  "/sys/user/userRoleList",
  "/sys/user/addSysUserRole",
  "/sys/user/deleteUserRole",
  "/sys/user/departUserList",
  "/sys/user/queryByOrgCode",
  "/sys/user/register",
  "/sys/user/querySysUser",
  "/sys/user/passwordChange",
  "/sys/user/appUserList",
  "/sys/user/exportXls",
  "/sys/user/importExcel",
  "/sys/user/edit",
  "/sys/user/deleteBatch",
  "/sys/user/queryById",
  "/sys/user/list",
  "/sys/user/userDepartList",
  "/sys/user/deleteUserRoleBatch",
  "/sys/user/queryByOrgCodeForAddressList",
  "/sys/user/editSysDepartWithUser",
  "/sys/user/deleteUserInDepart",
  "/sys/user/deleteUserInDepartBatch",
  "/sys/user/getCurrentUserDeparts",
  "/sys/user/phoneVerification",
  "/sys/user/getUserSectionInfoByToken",
  "/sys/common/upload",
  "/sys/common/403",
  "/sys/common/download/**",
  "/sys/common/pdf/pdfPreviewIframe",
  "/sys/common/view/**",
  

不可追踪的链接：在线表单开发  这一点很烦
"/online/cgreport/param/listByHeadId",
"/online/cgreport/param/list",
"/online/cgreport/param/add",
"/online/cgreport/param/edit",
"/online/cgreport/param/delete",
"/online/cgreport/param/queryById",
"/online/cgreport/param/deleteBatch",
"/online/cgform/api/form/{code}",
"/online/cgform/api/exportXls/{code}",
"/online/cgform/api/doButton",
"/online/cgform/api/addAll",
"/online/cgform/api/getColumns/{code}",
"/online/cgform/api/getData/{code}",
"/online/cgform/api/getFormItemBytbname/{table}",
"/online/cgform/api/importXls/{code}",
"/online/cgform/api/codeGenerate",
"/online/cgform/api/getFormItem/{code}",
"/online/cgform/api/form/{code}",
"/online/cgform/api/form/{code}/{id}",
"/online/cgform/api/getQueryInfo/{code}",
"/online/cgform/api/editAll",
"/online/cgform/api/crazyForm/{name}",
"/online/cgform/api/getTreeData/{code}",
"/online/cgform/api/subform/list/{table}/{mainId}",
"/online/cgform/api/getEnhanceJs/{code}",
"/online/cgform/api/crazyForm/{name}",
"/online/cgform/api/subform/{table}/{mainId}",
"/online/cgform/api/form/{code}/{id}",
"/online/cgform/api/form/table_name/{tableName}/{dataId}",
"/online/cgform/api/doDbSynch/{code}/{synMethod}",
"/online/cgform/api/checkOnlyTable",
"/online/cgreport/item/listByHeadId",
"/online/cgreport/item/list",
"/online/cgreport/item/add",
"/online/cgreport/item/edit",
"/online/cgreport/item/delete",
"/online/cgreport/item/queryById",
"/online/cgreport/item/deleteBatch",
"/online/cgform/button/list/{code}",
"/online/cgform/button/add",
"/online/cgform/button/delete",
"/online/cgform/button/edit",
"/online/cgform/button/deleteBatch",
"/online/cgform/button/queryById",
"/online/cgform/field/add",
"/online/cgform/field/list",
"/online/cgform/field/listByHeadCode",
"/online/cgform/field/listByHeadId",
"/online/cgform/field/edit",
"/online/cgform/field/deleteBatch",
"/online/cgform/field/delete",
"/online/cgform/field/queryById",
"/online/cgreport/api/exportXls/{reportId}",
"/online/cgreport/api/getColumns/{code}",
"/online/cgreport/api/getData/{code}",
"/online/cgreport/api/getQueryInfo/{code}",
"/online/cgreport/api/getRpColumns/{code}",
"/online/cgreport/api/getParamsInfo/{code}",
"/online/cgform/head/queryTables",
"/online/cgform/head/enhanceJs/{code}",
"/online/cgform/head/enhanceJs/{code}",
"/online/cgform/head/enhanceJava/{formId}",
"/online/cgform/head/enhanceSql/{formId}",
"/online/cgform/head/add",
"/online/cgform/head/list",
"/online/cgform/head/delete",
"/online/cgform/head/rootFile",
"/online/cgform/head/enhanceSql/{formId}",
"/online/cgform/head/enhanceJava/{formId}",
"/online/cgform/head/removeRecord",
"/online/cgform/head/enhanceJs/{code}",
"/online/cgform/head/enhanceButton/{formId}",
"/online/cgform/head/edit",
"/online/cgform/head/queryById",
"/online/cgform/head/transTables/{tbnames}",
"/online/cgform/head/deleteBatch",
"/online/cgform/head/enhanceJava/{formId}",
"/online/cgform/head/enhanceSql/{formId}",
"/online/cgform/head/fileTree",
"/online/cgform/head/queryByTableNames",
"/online/cgform/head/tableInfo",
"/online/cgform/head/copyOnline",
"/online/cgform/index/listByHeadId",
"/online/cgform/index/list",
"/online/cgform/index/add",
"/online/cgform/index/edit",
"/online/cgform/index/delete",
"/online/cgform/index/queryById",
"/online/cgform/index/deleteBatch",
"/online/cgreport/head/add",
"/online/cgreport/head/edit",
"/online/cgreport/head/parseSql",
"/online/cgreport/head/list",
"/online/cgreport/head/delete",
"/online/cgreport/head/editAll",
"/online/cgreport/head/queryById",
"/online/cgreport/head/deleteBatch",


swagger api文档相关
"/swagger-resources/configuration/security",
"/swagger-resources/configuration/ui",
"/swagger-resources",
"/v2/api-docs-ext",

全局失败处理
"/error",
"/error",

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
### 查看全局总共哪些api接口：
http://127.0.0.1:18080/jeecg-boot//test/jeecgDemo/hello



###  对于api文档接口的扫描
org.jeecg.config.Swagger2Config
这里只是指定了org.jeecg.modules下面的api文档接口

### 构造器处理
sql查询  org.jeecg.common.system.query.QueryGenerator


### 全局异常连接
JeecgBootExceptionHandler
@RestControllerAdvice给类，@ExceptionHandler给方法
* 全局异常处理
* 全局数据绑定
* 全局数据预处理
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

### X-Access-Token 在哪里定义？还是是默认的？
jeecg-boot\jeecg-boot-base-common\src\main\java\org\jeecg\common\util\TokenUtilsc.java  这个是无效的，没有被引用
jeecg-boot\jeecg-boot-base-common\src\main\java\org\jeecg\common\util\RestDesformUtil.java  也没用 先注释
来源于：
jeecg-boot\jeecg-boot-module-system\src\main\java\org\jeecg\modules\shiro\authc\aop\JwtFilter.java
这里做了相应注释


### @Configuration 与 @Bean
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration给类注解，@Bean给方法，共同构成配置文件。

### aop目录全部都是拦截器

### 未解决
* 验证token后，抛出了异常，但返回的是json数据，还有地址，这里不知道怎么去处理的。


### 研究定时器怎么用



### mybatis中的save update 是怎么实现的？？ 数据的unique怎么处理
unique通过mysql本身的unique来处理
saveUpdate无效，根本用不了

### actuator监控 url监控等
 <!--  监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
配置：
```yaml
# 监控
management:
# 暴露所有接口出来  如果不开启，默认只有/actuator/info  /actuator/health
  endpoints:
    web:
      exposure:
        include: "*"

```



### 研究websocket

### 使用多张表来统计数据
主要是备份的作用





### 部署 
* 使用docker  
自带docker文件。。。

* 提示错误：
FATAL: kernel too old
解决方法：https://blog.csdn.net/J080624/article/details/104276720
参考：http://elrepo.org/tiki/tiki-index.php

* 修改application-prod.yml 为linux环境


