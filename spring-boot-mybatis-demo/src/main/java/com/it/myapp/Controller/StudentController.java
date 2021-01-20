package com.it.myapp.Controller;

import com.it.myapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("getStudent/{id}")
    public String GetOneStudent(@PathVariable int id){
        return studentService.queryStudentById(id).toString();
    }

    @RequestMapping("getAllStudent")
    public String GetAllStudent(){
        return studentService.findAll().toString();
    }
    @RequestMapping("deleteOneStudent")
    public String deleteOneStudent(@RequestParam(value="id")int id){
        studentService.deleteOneUser(id);
        return "delete";
    }

}


