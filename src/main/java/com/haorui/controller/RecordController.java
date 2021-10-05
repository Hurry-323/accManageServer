package com.haorui.controller;


import com.haorui.pojo.Record;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    //查找此用户所有交易记录
    @GetMapping("/findAllRecordsByAccountId")
    public @ResponseBody ResultDTO<Record> findAllRecords(String accountId){

        return recordService.findAllRecordByAccountId(accountId);
    }

    //搜索相关交易对象的交易记录
    @GetMapping("/findRecordsByKey")
    public @ResponseBody ResultDTO<Record> findRecordsByKey(String accountId,String key){


        return recordService.findRecordsByAccountAndOtherId(accountId,key);
    }

}
