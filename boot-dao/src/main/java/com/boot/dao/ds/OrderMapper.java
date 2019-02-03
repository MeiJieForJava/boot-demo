package com.boot.dao.ds;

import com.boot.domain.ds.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<Order> selectByUserId(Integer userId);

    List<Order> selectByOrderIdBetween(@Param("startOrderId") Long startOrderId, @Param("endOrderId") Long endOrderId);
}