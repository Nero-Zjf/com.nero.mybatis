package com.nero.mybatis;

import com.nero.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            //-------------------------使用 XML 构建 SqlSessionFactory-------------------------
            // 读取配置文件 mybatis-config.xml
            InputStream config = Resources
                    .getResourceAsStream("mybatis-config.xml");
            // 根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                    .build(config);
            //--------------------------------------------------------

            //-------------------------使用代码创建 SqlSessionFactory-------------------------------
//            // 数据库连接池信息
//            PooledDataSource dataSource = new PooledDataSource();
//            dataSource.setDriver("com.mysql.jdbc.Driver");
//            dataSource.setUsername("root");
//            dataSource.setPassword("000000");
//            dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
//            dataSource.setDefaultAutoCommit(false);
//            // 采用 MyBatis 的 JDBC 事务方式
//            TransactionFactory transactionFactory = new JdbcTransactionFactory();
//            Environment environment = new Environment("development", transactionFactory, dataSource);
//            // 创建 Configuration 对象
//            Configuration configuration = new Configuration(environment);
//            // 注册一个 MyBatis 上下文别名
//            configuration.getTypeAliasRegistry().registerAlias("user", User.class);
//            // 加入一个映射器
//            configuration.addMapper(UserMapper.class);
//            //使用 SqlSessionFactoryBuilder 构建 SqlSessionFactory
//            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(configuration);
            //--------------------------------------------------------

            // 通过 SqlSessionFactory 创建 SqlSession
            SqlSession ss = ssf.openSession();
            // SqlSession执行映射文件中定义的SQL，并返回映射结果

            // 添加一个用户
            User addmu = new User();
            addmu.setId(1);
            addmu.setName("陈恒");
            addmu.setSex("男");
            //com.nero.mybatis.mapper.UserMapper.addUser 为 UserMapper.xml中的命名空间
            ss.insert("com.nero.mybatis.mapper.UserMapper.addUser", addmu);
            // 查询一个用户
            User mu = ss.selectOne(
                    "com.nero.mybatis.mapper.UserMapper.getUserById", 1L);
            System.out.println(mu);

            // 修改一个用户
            User updatemu = new User();
            updatemu.setId(1);
            updatemu.setName("张三");
            updatemu.setSex("女");
            ss.update("com.nero.mybatis.mapper.UserMapper.updateUser", updatemu);
            // 查询所有用户
            List<User> listMu = ss
                    .selectList("com.nero.mybatis.mapper.UserMapper.getAllUser");
            for (User User : listMu) {
                System.out.println(User);
            }
            // 删除一个用户
            ss.delete("com.nero.mybatis.mapper.UserMapper.deleteUser", 1L);

            // 提交事务
            ss.commit();
            // 关闭 SqlSession
            ss.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
