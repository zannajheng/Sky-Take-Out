package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    /**
     * 向订单表插入1条数据
     * @param orders
     */
    void insert(Orders orders);
}
