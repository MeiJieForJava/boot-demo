package com.boot.controller.user;

import com.boot.common.entity.JsonDataResponse;
import com.boot.domain.user.User;
import com.boot.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/11/13
 * Time : 10:17
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Resource
    private UserService userService;

    @GetMapping(value = "/list")
    public JsonDataResponse<List<User>> userList() {
        List<User> users = userService.userList();
//        List<User> users = new ArrayList<>();
        logger.info("size:{}", users.size());
        JsonDataResponse<List<User>> response = JsonDataResponse.success();
        response.setData(users);
        return response;
    }

}
