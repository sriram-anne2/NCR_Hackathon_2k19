package com.ncr.tr.helios.tweatsbackoffice.entities.customer;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection = "customer_fav_orders")
public class FavOrders {

    private String emojiUnicode;
    private String favOrderDescription;
}
