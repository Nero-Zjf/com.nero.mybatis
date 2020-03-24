package com.nero.mybatis;

import com.nero.mybatis.domain.Customer;
import com.nero.mybatis.mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws IOException {
        // 读取配置文件 mybatis-config.xml
        InputStream config = Resources
                .getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder()
                .build(config);

        SqlSession sqlSession = ssf.openSession();
        //addCustomer
//        Customer customerAdd = new Customer(23231,"eerddf", "test", "432423423555"
//        , "1322555", "nero", new Date(), 1, new Date());
//        sqlSession.insert("com.nero.mybatis.mapper.CustomerMapper.addCustomer", customerAdd);
//        System.out.println(customerAdd);

        //addCustomer2
        Customer customerAdd2 = new Customer("nero", new Date(), 1);
        sqlSession.
                insert("com.nero.mybatis.mapper.CustomerMapper.addCustomer2", customerAdd2);
        System.out.println(customerAdd2);
        //updCustomer
        customerAdd2.setName("update");
        sqlSession.update("com.nero.mybatis.mapper.CustomerMapper.updCustomer", customerAdd2);
        System.out.println(customerAdd2);
        //getCustomerById
        Customer reCust = sqlSession.selectOne("com.nero.mybatis.mapper.CustomerMapper.getCustomerById", customerAdd2.getCustId());
        System.out.println(reCust);

        //getCustomerByNameSex
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> custList = mapper.getCustomerByNameSex(customerAdd2.getName(), customerAdd2.getSex());
        System.out.println(custList);

        //delCustomerById
        sqlSession.update("com.nero.mybatis.mapper.CustomerMapper.delCustomerById", customerAdd2.getCustId());

        sqlSession.commit();
        sqlSession.close();
    }
}
