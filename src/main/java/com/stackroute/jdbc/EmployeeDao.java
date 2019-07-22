package com.stackroute.jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeDao {
  //JdbcTemplate reference object
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //method to create the table EmployeeDetails
    public void createTable() {
        String query = "create table EmployeeDetails(id int(30)," +
                " name varchar(30), age int(20), gender varchar(30))";
        jdbcTemplate.execute(query);
    }

    //method to insert list of employees in EmployeeDetails
    public void updateTable(Employee e) {
        String query = "insert into EmployeeDetails values(?,?,?,?)";
        jdbcTemplate.update(query, new Object[]{e.getId(), e.getName(), e.getAge(), e.getGender()});
    }

    //method to delete a specific row based on id
    public void deleteRow(int id) {
        String query = "delete from EmployeeDetails where id= ?";
        jdbcTemplate.update(query, id);
    }

    //method to read EmployeeDetails table using RowMapper using List
    public List<Employee> getAllEmployeesRowMapper() {
        return jdbcTemplate.query("select * from EmployeeDetails", new RowMapper<Employee>() {

            //overriding the only method RowMapper interface has
            @Override
            public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setAge(rs.getInt(3));
                e.setGender(rs.getString(4));
                return e;
            }
        });

    }
}