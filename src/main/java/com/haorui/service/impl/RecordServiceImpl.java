package com.haorui.service.impl;

import com.haorui.dao.RecordDao;
import com.haorui.pojo.Accounts;
import com.haorui.pojo.Record;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordDao recordDao;


    //增加记录
    @Override
    public int addRecord(Record record) {
        //打印传入的record
        System.out.println(record.toString());

        //交易时间
        Date date = new Date();
        //将注册时间转换成sql支持的类型
        long javaRegTime = date.getTime();
        //转换为sql支持的datetime
        Timestamp sqlRegTime = new Timestamp(javaRegTime);
        //赋予交易时间
        record.setDateTime(sqlRegTime);

        //如果没有目标id赋予自己的id
        if(record.getOtherId() ==null) record.setOtherId(record.getAccountId());

        return recordDao.addRecord(record);
    }

    @Override
    public ResultDTO<Record> findAllRecordByAccountId(String accountId) {
        //定义返回数据类型
        ResultDTO<Record> recordResultDTO = new ResultDTO<>();
        //查询记录
        List<Record> records = recordDao.findAllRecordByAccountId(accountId);
        //判断是否查询成功
        if(records!=null){
            //成功
            recordResultDTO.setCode(8888);//查询成功，返回状态码
            recordResultDTO.setMsg("查询记录成功！");
            recordResultDTO.setDatas(records);//由于查询的数据是1个 我们使用setData
        }else{
            //失败
            recordResultDTO.setCode(1004);//查询成功，返回状态码
            recordResultDTO.setMsg("无记录！");
        }



        return recordResultDTO;
    }

    //通过accountId和otherId获取指定的record(搜索功能)
    @Override
    public ResultDTO<Record> findRecordsByAccountAndOtherId(String accountId, String otherId) {

        //定义返回数据类型
        ResultDTO<Record> recordResultDTO = new ResultDTO<>();
        //查找记录
        List<Record> records = recordDao.findRecordsByAccountAndOtherId(accountId,otherId);
        if(records!=null){
            //成功
            recordResultDTO.setCode(8888);//查询成功，返回状态码
            recordResultDTO.setMsg("查询记录成功！");
            recordResultDTO.setDatas(records);//由于查询的数据是1个 我们使用setData
        }else{
            //失败
            recordResultDTO.setCode(1004);//查询成功，返回状态码
            recordResultDTO.setMsg("无记录！");
        }

        return recordResultDTO;
    }
}
