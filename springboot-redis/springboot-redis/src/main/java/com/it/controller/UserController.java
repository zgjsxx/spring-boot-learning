package com.it.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.dao.UserDao;
import com.it.entity.User;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/save")
    public String save(){

        User user = new User();
        user.setId("1");
        user.setName("zhangsan");
        user.setAge(20);
        userDao.save(user);

        userDao.save("name", "lisi");

        System.out.println("保存成功");
        return "ok";
    }
    @RequestMapping("/find")
    public String find(){

        User byId = userDao.getById("1");
        System.out.println(byId);

        String byKey = userDao.getByKey("name");
        System.out.println(byKey);

        return "ok";
    }
}