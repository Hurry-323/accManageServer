package com.haorui.service.impl;

import com.haorui.dao.AccountDao;
import com.haorui.dao.AdminDao;
import com.haorui.dao.OrderDao;
import com.haorui.dao.PersonInfoDao;
import com.haorui.pojo.*;
import com.haorui.service.AccountService;
import com.haorui.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    PersonInfoDao personInfoDao;

    @Autowired
    AdminDao adminDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    RecordService recordService;

    //查找所有账户
    @Override
    public ResultDTO<Accounts> findAllAccounts() {
        //定义返回数据
        return null;
    }

    //规范格式返回全部账户
    @Override
    public ResultDTO<Accounts> findAllAccountsDTO() {
        ResultDTO<Accounts> accountsResultDTO = new ResultDTO<>();
        //调用查询方法
        List<Accounts> accounts = accountDao.findAllAccounts();
        if (null!=accounts){
            accountsResultDTO.setCode(8888);//查询成功，返回状态码
            accountsResultDTO.setMsg("查询成功！");
            accountsResultDTO.setDatas(accounts);//由于查询的数据是多个 我们使用setDatas
            //如果是单个数据，就使用 setData
        }else{
            accountsResultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
            accountsResultDTO.setMsg("无数据！");
        }
        return accountsResultDTO;
    }

    //登录
    @Override
    public ResultDTO<Accounts> findAccountByAccount(Accounts accounts) {
        ResultDTO<Accounts> loginResultDTO = new ResultDTO<>();
        //调用查询方法
        //先查询管理员表（人数少）
        Admin admin = adminDao.findAdminByAccounts(accounts);
        if(null!=admin){
            loginResultDTO.setCode(6666);//查询成功，返回管理员
            loginResultDTO.setMsg("管理员登录成功！");
            Accounts accounts1 = new Accounts();
            accounts1.setAccountId(admin.getAdminName());
            loginResultDTO.setData(accounts1);//由于查询的数据是多个 我们使用setDatas
            return loginResultDTO;

        }else{
            Accounts accounts2 = accountDao.findAccountByIdAndPassword(accounts);
            if(accounts2 != null) {
                //激活状态
                if(accounts2.getStatusId().equals("1")){
                    loginResultDTO.setCode(8888);//查询成功，返回状态码
                    loginResultDTO.setMsg("登录成功！");
                    loginResultDTO.setData(accounts2);//由于查询的数据是1个 我们使用setData
                    //如果是n个数据，就使用 setDatas
                }else{
                    loginResultDTO.setCode(1005);//查询成功，返回状态码
                    loginResultDTO.setMsg("用户已被冻结！");
                }
            }else{
                loginResultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
                loginResultDTO.setMsg("用户不存在！");
            }
        }



        return loginResultDTO;
    }

    //实现存款方法
    @Override
    public ResultDTO<Double> depositByOrderNumAndAccountId(String orderNum,String accountId) {

        //定义返回数据
        ResultDTO<Double> resultDTO = new ResultDTO<>();
        //查找改订单号的订单金额
        double orderAmount = orderDao.findOrderAmountByOrderNum(orderNum);
        //判断订单是否存在
        if(orderAmount > 0) {
            //如果存在，进行存款
            if(accountDao.addBalanceByAccount(orderAmount,accountId)>0) {
                //存款后添加record
                //定义record对象
                Record record = new Record();
                record.setAccountId(accountId);//存款人id
                record.setMoney(orderAmount);//存款金额
                record.setTypeId("0");//0为存款
                //插入record
                int recordRes = recordService.addRecord(record);

                //存款后删除订单，避免重复存款
                //orderDao.delOrderByOrderNum(orderNum);
                resultDTO.setCode(8888);//存款成功，返回状态码
                resultDTO.setMsg("存款成功！");
                resultDTO.setData(orderAmount);//返回的是存入金额
                //由于查询的数据是1个 我们使用setData
                //如果是n个数据，就使用 setDatas
            }
        }else {
            //不存在
            resultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
            resultDTO.setMsg("订单号不存在！");
        }

        return resultDTO;
    }

    //取款
    @Override
    public ResultDTO<Double> withdrawByMoneyAndAccountId(double money, String accountId) {
        //定义返回结果
        ResultDTO<Double> resultDTO = new ResultDTO<>();
        double balance = accountDao.findBalanceById(accountId);
        if(balance < money){
            //判断余额是否大于取款金额
            resultDTO.setCode(1005);//存款成功，返回状态码
            resultDTO.setMsg("余额不足！");
            resultDTO.setData(balance);//返回的是余额
        } else if(accountDao.redBalanceByAccount(money,accountId)>0){
            //取款成功
            //取款后添加record
            //定义record对象
            Record record = new Record();
            record.setAccountId(accountId);//存款人id
            record.setMoney(money);//存款金额
            record.setTypeId("1");//1为取款
            //插入record
            recordService.addRecord(record);
            resultDTO.setCode(8888);//存款成功，返回状态码
            resultDTO.setMsg("取款成功！");
            resultDTO.setData(money);//返回的是取出金额
            //由于查询的数据是1个 我们使用setData
            //如果是n个数据，就使用 setDatas
        }else {
            //失败
            resultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
            resultDTO.setMsg("取款失败！");
        }


        return resultDTO;
    }

    //转账
    @Override
    public ResultDTO<Double> transferByTwoIdAndMoney(double money, String accountId, String otherId) {
        //定义返回结果
        ResultDTO<Double> resultDTO = new ResultDTO<>();
        //余额充足判断
        if(accountDao.findBalanceById(accountId)<money){
            resultDTO.setCode(1006);//转账失败，返回状态码
            resultDTO.setMsg("余额不足！");
            return resultDTO;
        }
        //转账成功判断
        if(accountDao.redBalanceByAccount(money,accountId)>0){
            //取款成功，执行存款
            //返回的是金额
            if(accountDao.addBalanceByAccount(money,otherId)>0){
                //取款成功
                resultDTO.setCode(8888);//转账成功，返回状态码
                resultDTO.setMsg("转账成功！");
                //转账成功，记录
                Record record = new Record();
                record.setAccountId(accountId);//存款人id
                record.setOtherId(otherId);//存款人id
                record.setMoney(money);//转账金额
                record.setTypeId("2");//2为转账
                //插入记录
                recordService.addRecord(record);
            }else{
                //存款失败
                //回退取款
                accountDao.addBalanceByAccount(money,accountId);
                resultDTO.setCode(1004);//转账成功，返回状态码
                resultDTO.setMsg("转入失败！");
            }
        }else {
            //转出失败
            resultDTO.setCode(1005);//转账失败，返回状态码
            resultDTO.setMsg("转出失败！");
        }
        resultDTO.setData(money);//返回的是金额
        return resultDTO;
    }

    //注册
    @Override
    public ResultDTO<Integer> register(Map<String, String> map){
        //定义返回结果
        ResultDTO<Integer> resultDTO = new ResultDTO<>();


        //判断accountId是否重复
        if(accountDao.findAccountIdByAccountId(map.get("accountId"))!=null||accountDao.findIdByAccountId(map.get("accountId"))!=null){
            resultDTO.setCode(1004);
            resultDTO.setMsg("用户名重复");
            //后端显示
            System.out.println("用户名重复");
            return resultDTO;

        }

        //格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(map.get("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //定义个人信息对象
        PersonInfo personInfo = new PersonInfo(map.get("realName"),birthday,map.get("sex"),map.get("cardId"),map.get("address"),map.get("telephone"),map.get("mail"));
        //判断
        //System.out.println(personInfo.toString());
        //插入个人信息
        personInfoDao.insertByPersonInfo(personInfo);

        //测试返回的自增主键
        //System.out.println("返回的自增主键:"+personInfo.getPersonId());

        //赋值Accounts对象
        Accounts accounts = new Accounts(map.get("accountId"),map.get("password"),0.0,"1",personInfo.getPersonId(),null);
        System.out.println(accounts.toString());
        //插入账户
        int regRes = accountDao.insertAccountByAccount(accounts);
        if(regRes == 1){
            //注册成功
            resultDTO.setCode(8888);//查询成功，返回状态码
            resultDTO.setMsg("注册成功！");

        }else {
            //注册失败
            resultDTO.setCode(1005);//查询成功，返回状态码
            resultDTO.setMsg("注册失败！");
            //删除插入的personInfo
            personInfoDao.delPersonInfoByPersonId(personInfo.getPersonId());
        }



        return resultDTO;
    }

    //模糊搜索用户名
    @Override
    public ResultDTO<Accounts> findAccountsByKey(String key) {
        //定义返回结果
        ResultDTO<Accounts> resultDTO = new ResultDTO<>();
        //查找返回数据
        List<Accounts> accountsList = accountDao.findAccountsByKey(key);
        if(accountsList != null){
            //查询成功
            resultDTO.setCode(8888);//查询成功，返回状态码
            resultDTO.setMsg("查找成功！");
            resultDTO.setDatas(accountsList);//赋予结果
        }else {
            //查询失败
            resultDTO.setCode(1004);//查询成功，返回状态码
            resultDTO.setMsg("查询失败！");

        }



        return resultDTO;
    }


    @Override
    public ResultDTO<Accounts> findAccountsByStatusId(String statusId) {
        //定义返回结果
        ResultDTO<Accounts> resultDTO = new ResultDTO<>();
        //查找返回数据
        List<Accounts> accountsList = accountDao.findAccountsByStatusId(statusId);
        if(accountsList != null){
            //查询成功
            resultDTO.setCode(8888);//查询成功，返回状态码
            resultDTO.setMsg("查找成功！");
            resultDTO.setDatas(accountsList);//赋予结果
        }else {
            //查询失败
            resultDTO.setCode(1004);//查询成功，返回状态码
            resultDTO.setMsg("查询失败！");

        }



        return resultDTO;
    }

    @Override
    public ResultDTO<Integer> switchStatusIdByAccountId(String accountId, String statusId) {
        //定义返回结果
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        //判断
        if(accountDao.switchStatusIdByAccountId(accountId,statusId) >0){
            //查询成功
            resultDTO.setCode(8888);//查询成功，返回状态码
            resultDTO.setMsg("更改成功！");
        }else {
            //查询失败
            resultDTO.setCode(1004);//查询成功，返回状态码
            resultDTO.setMsg("更改失败！");

        }

        return resultDTO;
    }

    @Override
    public ResultDTO<Integer> delAccountByAccountId(String accountId) {
        //定义返回结果
        ResultDTO<Integer> resultDTO = new ResultDTO<>();
        //判断
        if(personInfoDao.delPersonInfoByPersonId(accountDao.findPersonIdByAccountId(accountId))>0){
            //删除用户信息成功
            if(accountDao.delAccountByAccountId(accountId)>0){
                resultDTO.setCode(8888);//查询成功，返回状态码
                resultDTO.setMsg("删除成功！");
            }
        }else {
            //查询失败
            resultDTO.setCode(1004);//查询成功，返回状态码
            resultDTO.setMsg("删除失败！");

        }

        return resultDTO;
    }



}
