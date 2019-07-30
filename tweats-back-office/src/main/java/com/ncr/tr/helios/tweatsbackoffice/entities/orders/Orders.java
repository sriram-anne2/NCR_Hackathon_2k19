package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String orderDescription;


}
