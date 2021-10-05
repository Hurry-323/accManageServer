package com.haorui.service;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.Admin;
import com.haorui.pojo.ResultDTO;

public interface AdminService {



    ResultDTO<Admin> updatePasswordByName(Accounts accounts,String password);


}
