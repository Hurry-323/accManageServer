package com.haorui.service;


import com.haorui.pojo.Record;
import com.haorui.pojo.ResultDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordService {

    //添加记录
    int addRecord(Record record);

    //获取记录
    ResultDTO<Record> findAllRecordByAccountId(String accountId);

    //通过accountId和otherId获取指定的record(搜索功能)
    ResultDTO<Record> findRecordsByAccountAndOtherId(String accountId,String otherId);

}
