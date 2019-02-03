package com.boot.service.user;

import com.boot.domain.ds.Order;
import com.boot.domain.mng.MngUser;
import com.boot.domain.pop.UnionPopDetail;

import java.util.List;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/11/13
 * Time : 10:59
 */
public interface UserService {

    List<MngUser> userList();

    List<UnionPopDetail> detailList();

    public List<Order> orderList();
}
