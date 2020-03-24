package com.nero.mybatis.mapper;

import com.nero.mybatis.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int addCustomer(Customer customer);

    int addCustomer2(Customer customer);

    int updCustomer(Customer customer);

    int delCustomerById(long custId);

    Customer getCustomerById(long custId);

    List<Customer> getCustomerByNameSex(String name, int sex);
}
