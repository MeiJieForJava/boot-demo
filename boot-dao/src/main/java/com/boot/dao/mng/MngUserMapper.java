package com.boot.dao.mng;

import com.boot.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/11/13
 * Time : 20:28
 */
public interface MngUserMapper {

    List<User> userList();

}


