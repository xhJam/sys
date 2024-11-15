package com.xh.sms.controller;

import com.xh.sms.bean.Student;
import com.xh.sms.service.StudentService;

import com.xh.sms.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Iterator;


import java.util.List;
import java.util.Map;


@Controller
public class StudentController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    String key1 = "";
    String key2 = "";
    String key3 = "";
    String key4 = "";
    private StudentService studentService = new StudentService();

    @GetMapping(value = "/login")
    public String go() {
        return "index";
    }


    @PostMapping(value = "/add")
    public String add(@RequestParam(required = false) Map<String, String> info) {
        boolean confirm = Utils.checkAllPreliminary(info);//基本数据校验
        if (!confirm) {
            return "redirect:/error.html";
        }

        if (studentService.add(jdbcTemplate, info)) {
            return "index";
        } else {
            return "redirect:/error.html";
        }

    }

    @PostMapping(value = "/del")
    public String del(@RequestParam Map<String, String> info) {
        boolean confirm = Utils.checkAllPreliminary(info);//基本数据校验
        if (!confirm) {
            return "redirect:/error.html";
        }
        if (studentService.del(jdbcTemplate, info)) {
            return "redirect:/success.html";
        } else {
            return "redirect:/error.html";
        }
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam Map<String, String> info) {
        boolean confirm = Utils.checkAllPreliminary(info);//基本数据校验
        if (!confirm) {
            return "redirect:/error.html";
        }
        if (studentService.update(jdbcTemplate, info)) {
            return "redirect:/success.html";
        } else {
            return "redirect:/error.html";
        }
    }

    @PostMapping(value = "/query")
    public String query(@RequestParam Map<String, String> info, Model model) {
        boolean confirm = Utils.checkAllPreliminary(info);//基本数据校验
        if (!confirm) {
            return "redirect:/error.html";
        }
        List<Student> students = studentService.query(jdbcTemplate, info);
        System.out.println("students = " + students);
        model.addAttribute("students", students);
        if (students.size() > 0) {
            return "index";
        } else {
            return "redirect:/error.html";
        }
    }
}