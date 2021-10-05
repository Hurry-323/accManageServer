package com.haorui.service.impl;

import com.haorui.dao.OrderDao;
import com.haorui.pojo.Order;
import com.haorui.pojo.ResultDTO;
import com.haorui.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;


}
