package com.ncr.tr.helios.tweatsbackoffice;

import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerInfo;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerRepository;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.FavOrders;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TweatsBackOfficeApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    OrdersRepository ordersRepository;

    public static void main(String[] args) {
        SpringApplication.run(TweatsBackOfficeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Database initialization I guess? clearing all previous states?
        customerRepository.deleteAll();
        ordersRepository.deleteAll();

        CustomerInfo c1 = new CustomerInfo();
        c1.setCustomerName("John Newsome");
        c1.setCustomerTwitterHandle("@JohnNewsome88");
        c1.setCustomerPhone("404-867-5309");
        c1.setCustomerEmail("johnnewsome3013@gmail.com");

        //setup favorite order salad + chicken emoji.
        FavOrders favOrders1 = new FavOrders();
        favOrders1.setEmojiUnicode("saladUnicode + chickenUnicode");
        favOrders1.setFavOrderDescription("Garden Salad with greek dressing, red onions, spinach, and chicken");
        favOrders1.setFavOrderTotalPrice(11.00);
        List<FavOrders> favOrdersList = new ArrayList<>();
        favOrdersList.add(favOrders1);
        c1.setFavOrders(favOrdersList);
        // GOTO: OrderService
        customerRepository.save(c1);

        //now lets see if it works
        customerRepository.findAll().forEach(System.out::println);

    }

}
