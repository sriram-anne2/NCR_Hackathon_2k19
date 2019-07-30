package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import com.ncr.tr.helios.tweatsbackoffice.entities.items.Items;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    private String orderId;

    // This is the customerTwitterHandle in CustomerInfo.java
    private String orderedBy;
    private ArrayList<Items> orderItems;


}
