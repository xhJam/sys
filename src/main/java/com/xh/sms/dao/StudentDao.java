package com.xh.sms.dao;

import com.xh.sms.bean.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao implements StudentDaoInf {

//    private Student student = new Student();

    public boolean addStudent(JdbcTemplate jdbcTemplate, String name, String gender, int ids, int age) {
        if (ids <= 10000) {
            return false;
        }
        String sql = "insert into students values(null,?,?,?,?)";
        int update = jdbcTemplate.update(sql, name, gender, ids, age);
        return update > 0;

    }

    @Override
    public boolean delStudent(JdbcTemplate jdbcTemplate, int ids) {
        String sql = "delete from students where ids=?";
        int update = jdbcTemplate.update(sql, ids);
        return update > 0;
    }

    @Override
    public boolean updateStudent(JdbcTemplate jdbcTemplate, String name, String gender, int ids, int age) {
        String sql = "update students set name=?,gender=?,age=? where ids=?";
        int update = jdbcTemplate.update(sql, name, gender, age, ids);
        return update > 0;
    }

    @Override
    public List<Student> queryStudent(JdbcTemplate jdbcTemplate, int ids) {
        String sql = "select * from students where ids=?";
        List<Student> query = jdbcTemplate.queryForObject(sql, new RowMapper<List<Student>>() {
            @Override
            public List<Student> mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setIds(rs.getInt("ids"));
                student.setAge(rs.getInt("age"));
                return List.of(student);
            }
        }, ids);
        return query;
    }

    @Override
    public List<Student> queryAllStudent(JdbcTemplate jdbcTemplate) {
        String sql = "select * from students";
        List<Student> query = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setIds(rs.getInt("ids"));
                student.setAge(rs.getInt("age"));
                return student;
            }
        });
        return query;
    }
}
