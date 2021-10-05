package com.haorui.dao;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountDao {

    //查找所有账户
    @Select("SELECT * FROM accounts")
    List<Accounts> findAllAccounts();

    //查找指定状态账户
    @Select("SELECT * FROM accounts WHERE statusId =#{statusId}")
    List<Accounts> findAccountsByStatusId(String statusId);

    //通过账户id和密码查找账户（登录用）
    @Select("SELECT accountId,password,balance,statusId,personId " +
            "FROM accounts WHERE accountId = #{accountId} AND password = #{password}")
    Accounts findAccountByIdAndPassword(Accounts accounts);

    //入账
    @Update("UPDATE accounts SET balance = balance + #{orderAmount} WHERE accountId = #{accountId}")
    int addBalanceByAccount(@Param("orderAmount")Double orderAmount,@Param("accountId")String accountId);

    //出账
    @Update("UPDATE accounts SET balance = balance - #{money} WHERE accountId = #{accountId}")
    int redBalanceByAccount(@Param("money")Double money,@Param("accountId")String accountId);

    //通过账户id查找账户余额
    @Select("SELECT balance FROM accounts WHERE accountId = #{accountId}")
    double findBalanceById(String accountId);

    //插入账户
    @Insert("INSERT INTO accounts(accountId,password,balance,statusId,personId) VALUE(#{accountId},#{password},#{balance},#{statusId},#{personId})")
    int insertAccountByAccount(Accounts accounts);

    //查找用户名是否存在
    @Select("SELECT accountId FROM accounts WHERE accountId =#{accountId}")
    Accounts findAccountIdByAccountId(String accountId);

    //查找管理员是否存在
    @Select("SELECT Id FROM admin WHERE adminName =#{accountId}")
    Admin findIdByAccountId(String accountId);

    //通过关键字查找用户
    @Select("SELECT accountId,password,balance,statusId,personId " +
            "FROM accounts WHERE accountId LIKE #{key}")
    List<Accounts> findAccountsByKey(String key);

    //根据accountId切换状态
    @Update("UPDATE accounts SET statusId = #{statusId} WHERE accountId =#{accountId}")
    int switchStatusIdByAccountId(@Param("accountId")String accountId,@Param("statusId") String statusId);

    //根据accountId删除
    @Delete("DELETE FROM accounts WHERE accountId = #{accountId}")
    int delAccountByAccountId(String accountId);

    //根据accountId查找personId
    @Select("SELECT personId FROM accounts WHERE accountId = #{accountId}")
    int findPersonIdByAccountId(String accountId);
}
