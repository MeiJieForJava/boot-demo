package com.boot.service.user.impl;

import com.boot.dao.ds.OrderMapper;
import com.boot.dao.mng.MngUserMapper;
import com.boot.dao.pop.UnionPopDetailMapper;
import com.boot.domain.ds.Order;
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

    @Resource
    private OrderMapper orderMapper;

    public List<MngUser> userList() {
        return mngUserMapper.userList();
    }


    public List<UnionPopDetail> detailList() {
        return unionPopDetailMapper.detailList();
    }


    public List<Order> orderList(){
       return orderMapper.selectByUserId(1);
//        orderMapper.selectByOrderIdBetween(1L,5L);
    }
}
