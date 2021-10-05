package com.haorui.service.impl;

import com.haorui.dao.PersonInfoDao;
import com.haorui.pojo.Accounts;
import com.haorui.pojo.PersonInfo;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    PersonInfoDao personInfoDao;

    //多表联查account和关联的personInfo
    @Override
    public ResultDTO<Accounts> findAllInfoByAccountId(String accountId) {

        ResultDTO<Accounts> resultDTO = new ResultDTO<>();

        Accounts accounts = personInfoDao.findAllInfoByAccountId(accountId);

        if(accounts!=null){

            resultDTO.setCode(8888);
            resultDTO.setData(accounts);
            resultDTO.setMsg("查询成功！");
        }else{
            resultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
            resultDTO.setMsg("无数据！");
        }




        return resultDTO;
    }

    //更改用户信息
    @Override
    public ResultDTO<Integer> updatePersonInfoByPersonId(PersonInfo personInfo) {
        //创建返回对象
        ResultDTO<Integer> resultDTO = new ResultDTO<>();

        int result = personInfoDao.updatePersonInfoByPersonId(personInfo);

        if(result>0){

            resultDTO.setCode(8888);//查询成功，返回状态码
            resultDTO.setData(result);//数据库变动条数
            resultDTO.setMsg("修改成功！");
        }else{
            resultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
            resultDTO.setMsg("修改失败！");
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<Integer> updatePasswordByAccountIdAndPassword(String newPwd, String oldPwd, String accountId) {
        //创建返回对象
        ResultDTO<Integer> resultDTO = new ResultDTO<>();

        int result = personInfoDao.updatePasswordByAccountIdAndPassword(newPwd,oldPwd,accountId);

        if(result>0){
            resultDTO.setCode(8888);//查询成功，返回状态码
            resultDTO.setData(result);//数据库变动条数
            resultDTO.setMsg("修改成功! 请重新登录");
        }else{
            resultDTO.setCode(1004);//查询成功，但是没有查询到数据，返回状态码
            resultDTO.setMsg("修改失败用户名或密码错误");
        }

        return resultDTO;
    }
}
