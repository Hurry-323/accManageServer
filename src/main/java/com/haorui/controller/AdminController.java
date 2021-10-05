package com.haorui.controller;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.Admin;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/updatePassword")
    public @ResponseBody ResultDTO<Admin> updatePassword(@RequestBody Map<String,String> map){
        //打印
        System.out.println(map);

        Accounts accounts = new Accounts();
        accounts.setAccountId(map.get("adminName"));
        accounts.setPassword(map.get("adminPassword"));







        return adminService.updatePasswordByName(accounts,map.get("newPassword"));
    }


}
