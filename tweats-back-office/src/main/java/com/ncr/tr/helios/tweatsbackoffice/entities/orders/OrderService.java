package com.ncr.tr.helios.tweatsbackoffice.entities.orders;


public interface OrderService {

    Orders getOrdersByTwitterHandle(String twitterHandle);

    Orders addOrders(String favOrderDescription, String twitterHandle);
}
