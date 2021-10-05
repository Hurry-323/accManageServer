package com.haorui.controller;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.Record;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.AccountService;
import com.haorui.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @Autowired
    OrderService orderService;

    //登录方法
    @PostMapping("/login")
    public @ResponseBody ResultDTO<Accounts> findAccountByAccount(@RequestBody Accounts accounts){
        System.out.println(accounts.toString());
        //增加冻结验证

        return accountService.findAccountByAccount(accounts);
    }


    //查找所有账户
    @GetMapping("/findAllAccounts")
    public @ResponseBody ResultDTO<Accounts> findAllAccounts(){
        //权限验证



        return accountService.findAllAccountsDTO();
    }

    @GetMapping("/findAccountsByStatusId")
    public @ResponseBody ResultDTO<Accounts> findAccountsByStatusId(String statusId){
        //打印前端传来的数据用于测试
        System.out.println("前端传来的值"+statusId);

        return accountService.findAccountsByStatusId(statusId);
    }

    //存款
    @PostMapping("/deposit")
    public @ResponseBody ResultDTO<Double> depositByOrderNumAndAccountId(@RequestBody Map<String ,String> map){
        //前台传入的数据
        System.out.println(map);
        //获取数据中的参数
        String orderNum =map.get("orderNum");
        String accountId = map.get("accountId");
        //打印测试
        System.out.println("前端传入的orderNum"+orderNum);
        System.out.println("前端传入的accountId"+accountId);
        //返回结果
        return accountService.depositByOrderNumAndAccountId(orderNum,accountId);
    }

    //取款
    @PostMapping("/withdraw")
    public @ResponseBody ResultDTO<Double> withdrawByMoneyAndAccountId(@RequestBody Map<String ,String> map){
        //前台传入的数据
        System.out.println(map);
        //获取数据中的参数
        double money = Double.parseDouble(map.get("money"));
        String accountId = map.get("accountId");
        //打印测试
        System.out.println("前端传入的orderNum"+money);
        System.out.println("前端传入的accountId"+accountId);
        //返回结果
        return accountService.withdrawByMoneyAndAccountId(money,accountId);
    }


    //转账
    @PostMapping("/transfer")
    public  @ResponseBody ResultDTO<Double> transferByAccountIdAndOtherId(@RequestBody Record record){
        //打印前端传来的数据用于测试
        //System.out.println("前端传来的值"+record.toString());

        return accountService.transferByTwoIdAndMoney(record.getMoney(),record.getAccountId(), record.getOtherId());
    }

    //注册
    @PostMapping("/register")
    public @ResponseBody ResultDTO<Integer> register(@RequestBody Map<String, String> map){
        //打印前端传来的数据用于测试
        //System.out.println(map);


        return accountService.register(map);
    }


    //模糊搜索
    @GetMapping("/findAccountsByKey")
    public @ResponseBody ResultDTO<Accounts> findAccountsByKey(String key){
        //打印前端传来的数据用于测试
        System.out.println("前端传来的值"+key);
        if(key.equals("")) return accountService.findAllAccountsDTO();

        return accountService.findAccountsByKey(key);
    }

    //更改账户状态
    @GetMapping("/switchStatusId")
    public  @ResponseBody ResultDTO<Integer> switchStatusIdByAccountId(String accountId,String statusId){
        //打印前端传来的数据用于测试
        System.out.println("前端传来的值"+accountId+",,"+statusId);


        return accountService.switchStatusIdByAccountId(accountId,statusId);
    }

    //删除用户
    @GetMapping("/delAccount")
    public @ResponseBody ResultDTO<Integer> delAccountByAccountId(String accountId){
        //打印前端传来的数据用于测试
        System.out.println("前端传来的值"+accountId);


        return accountService.delAccountByAccountId(accountId);
    }


}
