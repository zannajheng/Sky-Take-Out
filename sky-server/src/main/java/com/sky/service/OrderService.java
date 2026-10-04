package com.sky.service;

import com.sky.dto.*;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

public interface OrderService {

    /*
    用户下单
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 订单支付
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    /*
    历史订单查询
     */
    PageResult page(OrdersPageQueryDTO ordersPageQueryDTO);

    /*
    查询订单详情
     */
    OrderVO details(Long orderId);

    /*
    取消订单
     */
    void userCancelById(Long orderId) throws Exception;

    /*
    再来一单
     */
    void repetition(Long id);

    /*
    条件查询订单
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    /*
    各个状态的订单数量统计
     */
    OrderStatisticsVO statistics();

    /*
    接单
     */
    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    /*
    拒单
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO) throws Exception;
}
