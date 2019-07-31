package com.ncr.tr.helios.tweatsbackoffice.entities.processor;

import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerInfo;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerService;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.FavOrders;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.OrderService;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ProcessorImpl implements Processor {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public Orders processRequestForOrder(String emojiUnicode, String twitterHandle) throws MessagingException {
        // check customer service
        CustomerInfo c1 = customerService.getCustomerByHandle(twitterHandle);

        if(emojiUnicode == null || twitterHandle == null) {
            return null;
        }
        // if valid create order w/ order service.

        for (FavOrders favOrders : c1.getFavOrders()) {
            if (emojiUnicode.equalsIgnoreCase(favOrders.getEmojiUnicode())) {
                Orders order = new Orders();
                order.setOrderDescription(favOrders.getFavOrderDescription());
                order.setOrderedBy(c1.getCustomerTwitterHandle());
                order.setOrderTotalPrice(favOrders.getFavOrderTotalPrice());
                Orders finalOrder = orderService.addOrders(order);
                try {
                    sendEmailConfirmation(c1.getCustomerName(), finalOrder);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return finalOrder;
                // in addOrders we call save method for db.
            }
        }

        return null;
    }

    public void sendEmailConfirmation(String customerName) throws MessagingException {

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);


        helper.setTo("johnnewsome3013@gmail.com");
        helper.setCc("ncrsilverplus@gmail.com");
        helper.setBcc("mathdude2@gmail.com");
        helper.setSubject(customerName + "'s Incorrect Order");
        helper.setText("We could not find your order \n Please add this order to your favorites.");

        javaMailSender.send(mimeMailMessage);

    }

    public void sendEmailConfirmation(String customerName, Orders orders) throws MessagingException{

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);


        helper.setTo("johnnewsome3013@gmail.com");
        helper.setCc("ncrsilverplus@gmail.com");
        helper.setBcc("mathdude2@gmail.com");
        helper.setSubject(customerName + "'s Recent Order " + orders.getOrderId());
        String curDate = new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(new Date());
        helper.setText("Ordered By: " + orders.getOrderedBy() + "\n Order Id: " + orders.getOrderId() + " \n Date: " + curDate +
                " \n Your Order: " + orders.getOrderDescription() + " \n You Paid: $" +orders.getOrderTotalPrice());


        javaMailSender.send(mimeMailMessage);
    }


}
