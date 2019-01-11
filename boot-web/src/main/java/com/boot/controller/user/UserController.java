package com.boot.controller.user;

import com.boot.common.entity.JsonDataResponse;
import com.boot.domain.mng.MngUser;
import com.boot.domain.pop.UnionPopDetail;
import com.boot.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "/userList")
    public JsonDataResponse<List<MngUser>> userList() {
        List<MngUser> users = userService.userList();
//        List<UnionPopDetail> users = new ArrayList<>();
        logger.info("size:{}", users.size());
        JsonDataResponse<List<MngUser>> response = JsonDataResponse.success();
        response.setData(users);
        return response;
    }


    @PostMapping(value = "/detailList")
    public JsonDataResponse<List<UnionPopDetail>> detailList() {
        List<UnionPopDetail> users = userService.detailList();
//        List<UnionPopDetail> users = new ArrayList<>();
        logger.info("size:{}", users.size());
        JsonDataResponse<List<UnionPopDetail>> response = JsonDataResponse.success();
        response.setData(users);
        return response;
    }

}
