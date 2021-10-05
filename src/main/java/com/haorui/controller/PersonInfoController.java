package com.haorui.controller;


import com.haorui.pojo.Accounts;
import com.haorui.pojo.PersonInfo;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/personInfo")
public class PersonInfoController {

    @Autowired
    PersonInfoService personInfoService;


    //根据accountId查找个人信息
    @GetMapping("/findPersonInfoByAccountId")
    public @ResponseBody ResultDTO<Accounts> findPersonInfoByAccountId(String accountId){

        System.out.println(accountId);
        //ResultDTO<Accounts> resultDTO = new ResultDTO<>();
        //resultDTO = personInfoService.findAllInfoByAccountId(accountId);
        //System.out.println(resultDTO.toString());

        return personInfoService.findAllInfoByAccountId(accountId);
    }

    //修改个人信息
    @PostMapping("/editInfo")
    public @ResponseBody ResultDTO<Integer> editPersonInfo(@RequestBody PersonInfo personInfo){

        System.out.println("前端传来的数据"+personInfo.toString());

        //处理时间格式,无需处理


        return personInfoService.updatePersonInfoByPersonId(personInfo);
    }

    //修改密码
    @PostMapping("/editPassword")
    public @ResponseBody ResultDTO<Integer> editPersonInfo(@RequestBody Map<String ,String> map){

        System.out.println("前端传来的数据"+map);



        return personInfoService.updatePasswordByAccountIdAndPassword(map.get("newPassword"),map.get("password"),map.get("accountId"));
    }
}
