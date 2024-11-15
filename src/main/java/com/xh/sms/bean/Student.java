package com.xh.sms.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student {
    private int id;
    private String name;
    private String gender;
    private int ids;
    private int age;


}
