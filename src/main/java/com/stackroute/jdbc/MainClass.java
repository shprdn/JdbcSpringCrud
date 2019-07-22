package com.stackroute.jdbc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {


        //loading ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
       EmployeeDao employeeDao = context.getBean("edao",EmployeeDao.class);


       //calling EmployeeDao method to create table
        employeeDao.createTable();


        //calling EmployeeDao method to update table by inserting elements
        employeeDao.updateTable(new Employee(1,"Armaan Malik",24,"Male"));
        employeeDao.updateTable(new Employee(2,"Amaal Malik",28,"Male"));
        employeeDao.updateTable(new Employee(3,"ShahRukh Khan",52,"Male"));


        //deleting specific row based on Id
        employeeDao.deleteRow(2);


        //listing the rows getAllEmployeesRowMapper
       List<Employee> list = employeeDao.getAllEmployeesRowMapper();
       for(Employee e:list)
       {
           System.out.println(e);
       }
    }
}