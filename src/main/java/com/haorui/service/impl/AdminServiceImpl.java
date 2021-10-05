package com.haorui.service.impl;

import com.haorui.dao.AdminDao;
import com.haorui.pojo.Accounts;
import com.haorui.pojo.Admin;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public ResultDTO<Admin> updatePasswordByName(Accounts accounts, String password) {
        //创建返回对象
        ResultDTO<Admin> resultDTO = new ResultDTO<>();

        if(adminDao.findAdminByAccounts(accounts)!=null){
            if(adminDao.updatePasswordByName(password,accounts.getAccountId())>0){
                resultDTO.setCode(8888);//查询成功，返回状态码
                resultDTO.setMsg("修改成功！");
            }
        }else {
            resultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
            resultDTO.setMsg("修改失败！");
        }



        return resultDTO;
    }
}
