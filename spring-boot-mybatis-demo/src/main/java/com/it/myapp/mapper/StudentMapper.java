package com.it.myapp.mapper;

import com.it.myapp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> findAll();

    Student queryStudentById(int id);


    void deleteOneUser(int id);

}
