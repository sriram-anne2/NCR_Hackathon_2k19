package com.ncr.tr.helios.tweatsbackoffice.entities.processor;

import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerInfo;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerService;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.FavOrders;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.OrderService;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcessorImpl implements Processor {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;


    @Override
    public Orders processRequestForOrder(String emojiUnicode, String twitterHandle) {
        // check customer service
        CustomerInfo c1 = customerService.getCustomerByHandle(twitterHandle);

        // if valid create order w/ order service.

        for (FavOrders favOrders : c1.getFavOrders()) {

            if (emojiUnicode.equalsIgnoreCase(favOrders.getEmojiUnicode())) {
                Orders order = new Orders();
                order.setOrderDescription(favOrders.getFavOrderDescription());
                order.setOrderedBy(c1.getCustomerTwitterHandle());
                return orderService.addOrders(order);
                // in addOrders we call save method for db.
            }
        }

        return null;
    }


}
