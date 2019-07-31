package com.ncr.tr.helios.tweatsbackoffice.entities.processor;

import com.ncr.tr.helios.tweatsbackoffice.entities.orders.Orders;

public interface Processor {


    Orders processRequestForOrder(String emojiUnicode, String twitterHandle);

}
