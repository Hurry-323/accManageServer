package com.haorui.service;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.PersonInfo;
import com.haorui.pojo.ResultDTO;

public interface PersonInfoService {



    //多表联查account和关联的personInfo
    ResultDTO<Accounts> findAllInfoByAccountId(String accountId);

    //通过personalInfo修改信息
    ResultDTO<Integer> updatePersonInfoByPersonId(PersonInfo personInfo);

    //通过用户名和密码修改密码
    ResultDTO<Integer> updatePasswordByAccountIdAndPassword(String newPwd, String oldPwd, String accountId);

}
