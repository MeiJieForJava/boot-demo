package com.boot.dao.ds;


import com.boot.domain.ds.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    List<OrderItem> selectByUserId(Integer userId);

    List<OrderItem> selectByOrderIdBetween(@Param("startOrderId") Long startOrderId, @Param("endOrderId") Long endOrderId);
}