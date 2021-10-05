package com.haorui.dao;


import com.haorui.pojo.Province;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceDao {

    //查找所有省份
    @Select("SELECT * FROM provinceInfo")
    List<Province> findAllProvince();



}
