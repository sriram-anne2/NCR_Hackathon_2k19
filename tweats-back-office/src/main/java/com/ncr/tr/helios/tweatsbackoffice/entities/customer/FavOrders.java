package com.ncr.tr.helios.tweatsbackoffice.entities.customer;

import com.ncr.tr.helios.tweatsbackoffice.entities.items.Items;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Data
@Document(collection = "customer_fav_orders")
public class FavOrders {

    private String emojiUnicode;
    private ArrayList<Items> favOrderItems;

}
