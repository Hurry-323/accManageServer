package com.haorui.service;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.ResultDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AccountService {

    //查找所有账户
    ResultDTO<Accounts> findAllAccounts();

    //以DTO格式输出所有账户
    ResultDTO<Accounts> findAllAccountsDTO();


    //通过账户信息查找账户
    ResultDTO<Accounts> findAccountByAccount(Accounts accounts);

    //通过订单号和账户Id存款
    ResultDTO<Double> depositByOrderNumAndAccountId(String orderNum,String accountId);

    //通过订单号和账户Id存款
    ResultDTO<Double> withdrawByMoneyAndAccountId(double money,String accountId);

    //通过订单号和账户Id转账
    ResultDTO<Double> transferByTwoIdAndMoney(double money,String accountId,String otherId);

    //添加用户
    ResultDTO<Integer> register(Map<String ,String > map);

    //关键字找账户
    ResultDTO<Accounts> findAccountsByKey(String key);

    //更改用户状态
    ResultDTO<Integer> switchStatusIdByAccountId(String accountId,String statusId);

    //删除账户
    ResultDTO<Integer> delAccountByAccountId(String accountId);

    //查找指定状态账户
    ResultDTO<Accounts> findAccountsByStatusId(String statusId);
}
