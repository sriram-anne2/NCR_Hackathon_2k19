package com.ncr.tr.helios.tweatsbackoffice.entities.processor;

import com.ncr.tr.helios.tweatsbackoffice.entities.orders.Orders;

import javax.mail.MessagingException;

public interface Processor {


    Orders processRequestForOrder(String emojiUnicode, String twitterHandle) throws MessagingException;

}
