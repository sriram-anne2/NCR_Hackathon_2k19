package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import com.ncr.tr.helios.tweatsbackoffice.entities.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin()
public class OrdersResource {


    @Autowired
    private Processor processor;

    @Autowired
    private OrdersRepository ordersRepository;

    @PostMapping("/orders")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest orderRequest) throws MessagingException {
        Orders actualOrder = null;

        if (orderRequest != null) {
            actualOrder = processor.processRequestForOrder(orderRequest.getEmojiCode(), orderRequest.getTwitterHandle());
        }
        if (actualOrder != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(actualOrder.getOrderId()).toUri();
            ResponseEntity<Orders> responseEntity = new ResponseEntity<Orders>(actualOrder, HttpStatus.CREATED);

            return responseEntity;
        } else {
            return ResponseEntity.badRequest().body(actualOrder);
        }
    }


    @GetMapping("/orders")
    public List<Orders> retrieveOrders() {
        return ordersRepository.findAll();
    }
}
