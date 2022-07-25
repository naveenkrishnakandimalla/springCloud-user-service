package com.dailycoding.user.service;

import com.dailycoding.user.VO.Department;
import com.dailycoding.user.VO.ResponseTemplateVO;
import com.dailycoding.user.entity.User;
import com.dailycoding.user.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        LOGGER.info("Inside the User Service of save User Method");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartmentId(Long userId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();

        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
