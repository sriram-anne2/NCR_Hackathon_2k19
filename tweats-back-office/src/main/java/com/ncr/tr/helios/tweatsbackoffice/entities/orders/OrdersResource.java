package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import com.ncr.tr.helios.tweatsbackoffice.entities.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class OrdersResource {


    @Autowired private Processor processor;
    @Autowired private OrdersRepository ordersRepository;
    @PostMapping("/orders")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest orderRequest) {

        Orders actualOrder = processor.processRequestForOrder(orderRequest.getTwitterHandle(), orderRequest.getEmojiCode());

        if(actualOrder != null) {
            actualOrder = ordersRepository.save(actualOrder);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{actualOrder}").buildAndExpand(actualOrder).toUri();

            return ResponseEntity.created(location).build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}