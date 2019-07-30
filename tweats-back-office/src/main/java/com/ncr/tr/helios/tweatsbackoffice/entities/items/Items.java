package com.ncr.tr.helios.tweatsbackoffice.entities.items;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    @Id
    private String itemId;
    public String itemName;
    private double itemPrice;

}
