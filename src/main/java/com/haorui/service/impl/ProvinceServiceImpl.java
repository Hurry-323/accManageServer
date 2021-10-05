package com.haorui.service.impl;

import com.haorui.dao.ProvinceDao;
import com.haorui.pojo.Province;
import com.haorui.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceDao provinceDao;

    //获取所有省份
    @Override
    public List<Province> findAllProvince() {
         return provinceDao.findAllProvince();
    }


}
