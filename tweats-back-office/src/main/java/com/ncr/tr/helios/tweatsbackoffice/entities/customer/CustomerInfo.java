package com.ncr.tr.helios.tweatsbackoffice.entities.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "customer_info")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {

    @Id
    private String customerId;

    private String customerTwitterHandle;
    private String customerName;
    private String customerPhone;
    private String customerEmail;

    private ArrayList<String> favOrders;
}
