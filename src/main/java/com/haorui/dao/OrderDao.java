package com.haorui.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface OrderDao {

    //通过订单号查订单金额
    @Select("SELECT orderAmount FROM orders WHERE orderNum = #{orderNum}")
    double findOrderAmountByOrderNum(String orderNum);

    //通过订单号删除订单
    @Delete("DELETE FROM orders WHERE orderNum = #{orderNum}")
    int delOrderByOrderNum(String orderNum);


}
