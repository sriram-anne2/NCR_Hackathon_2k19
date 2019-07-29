package com.ncr.tr.helios.tweatsbackoffice.entities.items;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "items")
public class Items {
    @Id
    private String itemId;
    public String itemName;
    private float itemPrice;

}
