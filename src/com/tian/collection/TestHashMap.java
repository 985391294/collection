package com.tian.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tian
 * @Date: 2020/3/14 13:29
 * @Desc:
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<Integer,Emp> empMap = new HashMap<>();
        Emp emp1 = new Emp(1,"小明",7000);
        Emp emp2 = new Emp(2,"小王",8000);
        Emp emp3 = new Emp(3,"小张",9000);
        empMap.put(1,emp1);
        empMap.put(2,emp2);
        empMap.put(3,emp3);

        System.out.println(empMap);
    }
}

class Emp{
    private Integer id;
    private String userName;
    private double salary;

    public Emp(Integer id, String userName, double salary) {
        this.id = id;
        this.userName = userName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
