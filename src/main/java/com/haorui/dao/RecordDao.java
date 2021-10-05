package com.haorui.dao;

import com.haorui.pojo.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordDao {

    //插入记录
    @Insert("INSERT INTO records (accountId,otherId,money,dateTime,typeId) VALUES (#{accountId},#{otherId},#{money},#{dateTime},#{typeId})")
    int addRecord(Record record);

    //通过accountId获取所有的record
    @Select("SELECT accountId,otherId,money,dateTime,typeId FROM records WHERE accountId = #{accountId}")
    List<Record> findAllRecordByAccountId(String accountId);

    //通过accountId和otherId获取指定的record(搜索功能)
    @Select("SELECT accountId,otherId,money,dateTime,typeId FROM records WHERE accountId = #{accountId} AND otherId LIKE CONCAT('%',#{otherId},'%')")
    List<Record> findRecordsByAccountAndOtherId(@Param("accountId")String accountId, @Param("otherId")String otherId);

}
