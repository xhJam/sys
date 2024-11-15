package com.xh.sms.service;

import com.xh.sms.bean.Student;
import com.xh.sms.dao.StudentDao;

import com.xh.sms.utils.Utils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private JdbcTemplate jdbcTemplate;
    private StudentDao studentDao = new StudentDao();
    String name = "";
    String gender = "";
    int ids = 0;
    int age = 0;

    public boolean add(JdbcTemplate jdbcTemplate, Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            name = map.get(iterator.next());
            gender = map.get(iterator.next());
            ids = Utils.byStringToInt(map.get(iterator.next()));
            age = Utils.byStringToInt(map.get(iterator.next()));

        }
        boolean b = studentDao.addStudent(jdbcTemplate, name, gender, ids, age);
        return b;
    }

    public boolean del(JdbcTemplate jdbcTemplate, Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        ids = Utils.byStringToInt(map.get(iterator.next()));
        return studentDao.delStudent(jdbcTemplate, ids);
    }

    public boolean update(JdbcTemplate jdbcTemplate, Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            ids = Utils.byStringToInt(map.get(iterator.next()));
            name = map.get(iterator.next());
            gender = map.get(iterator.next());
            age = Utils.byStringToInt(map.get(iterator.next()));
        }
        return studentDao.updateStudent(jdbcTemplate, name, gender, ids, age);
    }

    public List<Student> query(JdbcTemplate jdbcTemplate, Map<String, String> map) {
        Iterator<String> iterator = map.keySet().iterator();
        if ((ids = Utils.byStringToInt(map.get(iterator.next()))) == 1) {
            return studentDao.queryAllStudent(jdbcTemplate);
        } else {
            return studentDao.queryStudent(jdbcTemplate, ids);
        }
    }

}
