package com.haorui.service;


import com.haorui.pojo.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {

    //查找所有省份
    List<Province> findAllProvince();



}
