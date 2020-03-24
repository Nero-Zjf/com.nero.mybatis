package com.nero.mybatis.domain;

import java.util.Date;

/**
 * 客户
 */
public class Customer {
    private long custId;
    private String name;
    private Date birthDate;
    private int sex;

    public Customer() {

    }

    public Customer(String name, Date birthDate, int sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
    }

//    public Customer(long custId,String name, Date birthDate, int sex) {
//        this.custId = custId;
//        this.name = name;
//        this.birthDate = birthDate;
//        this.sex = sex;
//    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "{" +
                "\"custId\":" + custId +
                ", \"name\":\"" + name + '\"' +
                ", \"birthDate\":" + birthDate +
                ", \"sex\":" + sex +
                '}';
    }
}
