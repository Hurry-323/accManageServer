package com.haorui.dao;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.PersonInfo;
import org.apache.ibatis.annotations.*;

public interface PersonInfoDao {

    //通过accountId查找personInfo
    @Select("SELECT * FROM personInfo WHERE personId = (SELECT personId FROM accountId WHERE accountId = #{accountId})")
    PersonInfo findPersonInfoByAccountId(String accountId);

    //通过personalInfo修改信息
    @Update("UPDATE personInfo SET realName=#{realName},birthday=#{birthday}," +
            "sex=#{sex},cardId=#{cardId},address=#{address}," +
            "telephone=#{telephone},mail=#{mail} WHERE personId =#{personId}")
    int updatePersonInfoByPersonId(PersonInfo personInfo);

    //多表联查account和关联的personInfo
    //@Select("select * from accounts right join personInfo on accounts.personId = personInfo.personId where accounts.accountId =#{accountId}")
    //@ResultMap()
    Accounts findAllInfoByAccountId(String accountId);

    //通过用户名和密码修改密码
    @Update("UPDATE accounts SET password=#{newPwd} WHERE accountId =#{accountId} AND password =#{oldPwd}")
    int updatePasswordByAccountIdAndPassword(@Param("newPwd")String newPwd,@Param("oldPwd")String oldPwd,@Param("accountId")String accountId);

    //注册
    @Insert("INSERT INTO personInfo (realName,birthday,sex,cardId,address,telephone,mail) " +
            "VALUE (#{realName},#{birthday},#{sex},#{cardId},#{address},#{telephone},#{mail})")
        @SelectKey(statement="select last_insert_id()",before=false,keyProperty="personId",resultType=Integer.class,keyColumn="personId")
    void insertByPersonInfo(PersonInfo personInfo);

    //根据personId删除数据
    @Delete("DELETE FROM personInfo WHERE personId =#{personId}")
    int delPersonInfoByPersonId(int personId);


}
