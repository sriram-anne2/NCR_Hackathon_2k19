package com.ncr.tr.helios.tweatsbackoffice;

import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerInfo;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerRepository;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.FavOrders;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.Orders;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
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

        Orders o1 = new Orders();
        o1.setOrderedBy("@AshetonHarrell");
        o1.setOrderDescription("Double steak bowl with guacamole, cheese, mild salsa, hot salsa, brown rice");
        o1.setOrderTotalPrice(10.45);
        Orders o2 = new Orders();
        o2.setOrderedBy("@StevenKing");
        o2.setOrderDescription("Four mini chicken quesadillas");
        o2.setOrderTotalPrice(5.54);
        Orders o3 = new Orders();
        o3.setOrderedBy("RamAnne");
        o3.setOrderDescription("Grilled chicken and mashed potatoes");
        o3.setOrderTotalPrice(8.56);
        Orders o4 = new Orders();
        o4.setOrderedBy("@KevinPerry");
        o4.setOrderDescription("Lamb gyro with hummus");
        o4.setOrderTotalPrice(8.99);

        List<Orders> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);

        ordersRepository.saveAll(orders);


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
