package com.boot.service.user.impl;

import com.boot.dao.mng.MngUserMapper;
import com.boot.dao.pop.UnionPopDetailMapper;
import com.boot.domain.mng.MngUser;
import com.boot.domain.pop.UnionPopDetail;
import com.boot.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/11/13
 * Time : 11:23
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private MngUserMapper mngUserMapper;

    @Resource
    private UnionPopDetailMapper unionPopDetailMapper;

    public List<MngUser> userList() {
        return mngUserMapper.userList();
    }


    public List<UnionPopDetail> detailList() {
        return unionPopDetailMapper.detailList();
    }
}
