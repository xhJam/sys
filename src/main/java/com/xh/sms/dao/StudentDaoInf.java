package com.xh.sms.dao;

import com.xh.sms.bean.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface StudentDaoInf {
    boolean addStudent(JdbcTemplate jdbcTemplate, String name, String gender, int ids, int age);

    boolean delStudent(JdbcTemplate jdbcTemplate, int ids);

    boolean updateStudent(JdbcTemplate jdbcTemplate, String name, String gender, int ids, int age);

    List<Student> queryStudent(JdbcTemplate jdbcTemplate, int ids);

    List<Student> queryAllStudent(JdbcTemplate jdbcTemplate);
}
