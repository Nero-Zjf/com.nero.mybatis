# mybatis基本使用demo
文档：
- Mybatis-第一个MyBatis程序
- Mybatis-SqlSessionFactory介绍及其创建方式
- Mybatis-标签-select、insert、update、delete、sql

## SqlSessionFactory创建方式demo
1. 使用 XML 构建 SqlSessionFactory
2. 使用代码创建 SqlSessionFactory

注意第2种方式需要将SQL映射放在Mapper接口上，如下所示：
```java
public interface UserMapper {
    @Insert("insert into user (id,name,sex) values(#{id},#{name},#{sex})")
    int addUser(User user);
}
```
或者将对应的Mapper.xml文件放在对应Mapper接口的相同位置上。

>Main类中演示了两种方式的创建。  

## 数据库SQL
```sql
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(2) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `birth_date` datetime NOT NULL DEFAULT '1990-01-01 00:00:00' COMMENT '出生年月日',
  `sex` int(11) NOT NULL DEFAULT '1' COMMENT '性别',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户';
```

## Main2
Main2对Customer表进行增删改查等操作，演示了一下内容：
- Mybatis-标签-select、insert、update、delete、sql
- Mybatis-传递多个参数