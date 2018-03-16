package com.ineedwhite.diancan.dao.dao;

import com.ineedwhite.diancan.dao.domain.UserDo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表数据库操作
 */
public interface UserDao {
    /**
     * 插入用户信息
     * @param userDo
     */
    void insertUser(@Param("User")UserDo userDo);

    /**
     * 通过手机号查询用户信息
     * @param user_phone
     */
    UserDo selectUserByPhone(@Param("user_phone")String user_phone);

    /**
     * 通过用户ID查找用户
     * @param user_id
     * @return
     */
    UserDo selectUserByUsrId(@Param("user_id")String user_id);

    /**
     * 通过用户ID查找优惠券
     * @param user_id
     * @return
     */
    String selectCouponByUsrId(@Param("user_id")String user_id);

    /**
     * 更新用户表
     * @param user_id
     * @param accumulate_points
     * @param balance
     * @param member_level
     * @param user_coupon
     * @return
     */
    int updateUsrAcptAndBcAndmemLvlCp(@Param("user_id")String user_id,
                                      @Param("accumulate_points")String accumulate_points,
                                      @Param("balance")String balance,
                                      @Param("member_level")String member_level,
                                      @Param("user_coupon")String user_coupon);
}
