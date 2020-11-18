package com.example.homework.bean.impl;

import com.example.homework.aop.ISchool;
import com.example.homework.bean.Klass;
import com.example.homework.bean.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School implements ISchool {
    
    // 通过类型自动装配
    @Autowired(required = true) //primary
            Klass class1;

    //通过名称自动装配
    @Resource(name = "student100")
    Student student100;
    
    @Override
    public void ding(){
    
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        
    }
    
}
