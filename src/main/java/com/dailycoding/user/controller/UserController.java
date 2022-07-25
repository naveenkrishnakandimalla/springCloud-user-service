package com.dailycoding.user.controller;


import com.dailycoding.user.VO.ResponseTemplateVO;
import com.dailycoding.user.entity.User;
import com.dailycoding.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        LOGGER.info("Inside the saveUser method of user Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartmentId(@PathVariable("id") Long userId) {
        return userService.getUserWithDepartmentId(userId);
    }


}
