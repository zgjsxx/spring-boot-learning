package com.it.myapp.service;

import com.it.myapp.entity.Student;
import com.it.myapp.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    public Student queryStudentById(int id)
    {
        return studentMapper.queryStudentById(id);
    }
    public List<Student> findAll()
    {
        return studentMapper.findAll();
    }
    public void deleteOneUser(int id)
    {
        studentMapper.deleteOneUser(id);
    }


}