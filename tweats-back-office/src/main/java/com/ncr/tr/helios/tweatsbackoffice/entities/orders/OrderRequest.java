package com.ncr.tr.helios.tweatsbackoffice.entities.orders;


import lombok.Data;

@Data
public class OrderRequest {

    private String twitterHandle;
    private String emojiCode;
}
