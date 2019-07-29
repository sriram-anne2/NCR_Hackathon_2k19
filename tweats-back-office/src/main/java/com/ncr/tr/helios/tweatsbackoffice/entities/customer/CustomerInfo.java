package com.ncr.tr.helios.tweatsbackoffice.entities.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "customer_info")
public class CustomerInfo {

    @Id
    private String customerId;

    private String customerTwitterHandle;
    private String customerName;
    private String customerPhone;
    private String customerEmail;

    private ArrayList<FavOrders> favOrders;
}
