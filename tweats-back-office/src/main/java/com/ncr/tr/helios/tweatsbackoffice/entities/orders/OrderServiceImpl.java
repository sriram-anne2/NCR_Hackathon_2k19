package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired private OrdersRepository ordersRepository;


    @Override
    public Orders getOrdersByTwitterHandle(String twitterHandle) {
        return null;
    }

    @Override
    public Orders addOrders(Orders order) {
        return ordersRepository.save(order);
    }
}
