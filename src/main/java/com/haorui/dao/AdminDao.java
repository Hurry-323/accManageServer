package com.haorui.dao;

import com.haorui.pojo.Accounts;
import com.haorui.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdminDao {

    //管理员登录
    @Select("SELECT adminName from admin " +
            "WHERE adminName = #{accountId} AND adminPassword = #{password}")
    Admin findAdminByAccounts(Accounts accounts);

    //修改密码
    @Update("UPDATE admin SET adminPassword=#{password} WHERE adminName = #{name}")
    int updatePasswordByName(@Param("password") String password, @Param("name") String name);


}
