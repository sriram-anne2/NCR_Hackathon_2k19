package com.ncr.tr.helios.tweatsbackoffice.entities.processor;

import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerInfo;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerService;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.FavOrders;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.OrderService;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


@Service
@Slf4j
public class ProcessorImpl implements Processor {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;


    @Override
    public void processRequestForOrder(String emojiUnicode, String twitterHandle, long recipientId) {
        // check customer service
        CustomerInfo c1 = customerService.getCustomerByHandle(twitterHandle);

        // if valid create order w/ order service.

        Orders order = null;
        for (FavOrders favOrders : c1.getFavOrders()) {

            if (emojiUnicode.equalsIgnoreCase(favOrders.getEmojiUnicode())) {
                order = new Orders();
                order.setOrderDescription(favOrders.getFavOrderDescription());
                order.setOrderedBy(c1.getCustomerTwitterHandle());
                orderService.addOrders(order);
            }
        }

        try {
            sendConfirmationOrErrorDirectMessage(order, recipientId);
        } catch (TwitterException e) {
            log.error("Cannot send direct message to sender, exception {}", e);
        }
    }

    private void sendConfirmationOrErrorDirectMessage(Orders order, long recipientId) throws TwitterException {

        Twitter sender = TwitterFactory.getSingleton();
        DirectMessage dm;
        if (order != null) {
            dm = sender.sendDirectMessage(recipientId, "Your order has been confirmed!");
            log.info("Message to be sent to recipientId {} , {}", recipientId, dm);
        } else {
            dm = sender.sendDirectMessage(recipientId, "Your order cannot be processed, please try again or contact support");
            log.info("Message to be sent to recipientId {} , {}", recipientId, dm);
        }
    }
}
