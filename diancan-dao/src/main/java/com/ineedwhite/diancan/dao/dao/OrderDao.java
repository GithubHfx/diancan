package com.ineedwhite.diancan.dao.dao;

import com.ineedwhite.diancan.dao.domain.OrderDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 桌子表数据库操作
 */
public interface OrderDao {
    /**
     * 通过时间段来查找已经被预定的桌id
     * @param order_board_time
     * @param order_time_interval
     * @return
     */
    List<Integer> selectBoardIdByTime(@Param("order_board_time")String order_board_time,
                                      @Param("order_time_interval")String order_time_interval);

    /**
     * 在订单表里面插入订单
     * @param orderDo
     */
    void insertOrderInfo(@Param("Order")OrderDo orderDo);
}