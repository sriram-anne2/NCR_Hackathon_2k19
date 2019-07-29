package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import com.ncr.tr.helios.tweatsbackoffice.entities.items.Items;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "orders")
public class Orders {

    @Id
    private String orderId;

    // This is the customerTwitterHandle in CustomerInfo.java
    private String orderedBy;
    private ArrayList<Items> orderItems;


}
