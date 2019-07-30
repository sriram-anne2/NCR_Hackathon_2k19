package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import com.ncr.tr.helios.tweatsbackoffice.entities.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersResource {


    @Autowired private Processor processor;
    @PostMapping("/orders")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest orderRequest) {

        Orders actualOrder = processor.processRequestForOrder(orderRequest.getTwitterHandle(), orderRequest.getEmojiCode());

        if(actualOrder != null) {
            return ResponseEntity.created().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
