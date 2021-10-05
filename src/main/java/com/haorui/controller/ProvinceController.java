package com.haorui.controller;


import com.haorui.pojo.Province;
import com.haorui.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @RequestMapping(value = "/getProvinces",method = RequestMethod.GET)
    public @ResponseBody List<Province> findAllProvince(){

        List<Province> provinces = provinceService.findAllProvince();
        for(Province pv : provinces){
            System.out.println(pv.toString());
        }


        return provinceService.findAllProvince();
    }



}
