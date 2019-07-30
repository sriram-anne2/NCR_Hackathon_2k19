package com.ncr.tr.helios.tweatsbackoffice;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerInfo;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerRepository;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.FavOrders;
import com.ncr.tr.helios.tweatsbackoffice.entities.items.Items;
import com.ncr.tr.helios.tweatsbackoffice.entities.items.ItemsRepository;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.Orders;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.OrdersRepository;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;

@SpringBootApplication
public class TweatsBackOfficeApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    OrdersRepository ordersRepository;

    public static void main(String[] args) {
        SpringApplication.run(TweatsBackOfficeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Database initialization I guess? clearing all previous states?
        customerRepository.deleteAll();
        itemsRepository.deleteAll();
        ordersRepository.deleteAll();

        Items items1 = new Items();
        Items items2 = new Items();
        Items items3 = new Items();
        Items items4 = new Items();
        Items items5 = new Items();
        Items items6 = new Items();

        Orders orders = new Orders();

        CustomerInfo customer1 = new CustomerInfo();
        FavOrders favOrders1 = new FavOrders();
        FavOrders favOrders2 = new FavOrders();

        CustomerInfo customer2 = new CustomerInfo();
        FavOrders favOrders3 = new FavOrders();
        //FavOrders favOrders2 = new FavOrders();

        CustomerInfo customer3 = new CustomerInfo();
        FavOrders favOrders4 = new FavOrders();

        // Adding 6 items to our inventory
        items1.setItemId("1");
        items1.setItemName("pizza");
        items1.setItemPrice(5.00);
        items2.setItemId("2");
        items2.setItemName("coke");
        items2.setItemPrice(2.00);
        items3.setItemId("3");
        items3.setItemName("brownie");
        items3.setItemPrice(1.50);
        items4.setItemId("4");
        items4.setItemName("milkshake");
        items4.setItemPrice(2.75);
        items5.setItemId("5");
        items5.setItemName("hamburger");
        items5.setItemPrice(4.50);
        items6.setItemId("6");
        items6.setItemName("cake");
        items6.setItemPrice(3.00);

        // setting pizza, brownie and milkshake as fav1
        favOrders1.setEmojiUnicode("pizzaunicode + brownieunicode + milkshakeunicode");
        ArrayList<Items> favOrderItems1 = new ArrayList();
        favOrderItems1.add(items1);
        favOrderItems1.add(items3);
        favOrderItems1.add(items4);
        favOrders1.setFavOrderItems(favOrderItems1);

        // setting coke and brownie as fav2
        favOrders2.setEmojiUnicode("cokeunicode + brownieunicode");
        ArrayList<Items> favOrderItems2 = new ArrayList<>();
        favOrderItems2.add(items2);
        favOrderItems2.add(items3);
        favOrders2.setFavOrderItems(favOrderItems2);

        //setting cake and burger as fav3
        favOrders3.setEmojiUnicode("cakeunicode + burgerunicode");
        ArrayList<Items> favOrderItems3 = new ArrayList<>();
        favOrderItems3.add(items6);
        favOrderItems3.add(items5);
        favOrders3.setFavOrderItems(favOrderItems3);

        // settting pizza as fav4
        favOrders4.setEmojiUnicode("pizza");
        ArrayList<Items> favOrderItems4 = new ArrayList<>();
        favOrderItems4.add(items1);
        favOrders4.setFavOrderItems(favOrderItems4);

        // adding both favorites to an array list to be added as a fav order list to each customer
        ArrayList<FavOrders> cust1FavOrders = new ArrayList<>();
        cust1FavOrders.add(favOrders1);
        cust1FavOrders.add(favOrders2);

        ArrayList<FavOrders> cust2FavOrders = new ArrayList<>();
        cust2FavOrders.add(favOrders3);
        cust2FavOrders.add(favOrders2);

        ArrayList<FavOrders> cust3FavOrders = new ArrayList<>();
        cust3FavOrders.add(favOrders4);



        //Setting customer information
        customer1.setCustomerTwitterHandle("@mathdude2");
        customer1.setCustomerEmail("mathdude2@gmail.com");
        customer1.setCustomerId("2400");
        customer1.setCustomerName("Sriram Anne");
        customer1.setCustomerPhone("404-409-9193");
        customer1.setFavOrders(cust1FavOrders);

        customer2.setCustomerTwitterHandle("@badPingPongZach");
        customer2.setCustomerEmail("zachary@gmail.com");
        customer2.setCustomerId("4190");
        customer2.setCustomerName("Zachary Maciejiewski");
        customer2.setCustomerPhone("1-800-209-9876");
        customer2.setFavOrders(cust2FavOrders);

        customer3.setCustomerTwitterHandle("@smellysnaffinturtle12");
        customer3.setCustomerEmail("asheton.harrell@gmail.com");
        customer3.setCustomerId("3066");
        customer3.setCustomerName("Asheton Harrel");
        customer3.setCustomerPhone("404-404-4040");
        customer3.setFavOrders(cust3FavOrders);

        // saving all entries till now
        itemsRepository.save(items1);
        itemsRepository.save(items2);
        itemsRepository.save(items3);
        itemsRepository.save(items4);
        itemsRepository.save(items5);
        itemsRepository.save(items6);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        //now lets see if it works
        customerRepository.findAll().forEach(System.out::println);

        // CustomerInfo(customerId=2400, customerTwitterHandle=@mathdude2, customerName=Sriram Anne,
        // customerPhone=404-409-9193, customerEmail=mathdude2@gmail.com,
        // favOrders=
            // [FavOrders(emojiUnicode=pizzaunicode + brownieunicode + milkshakeunicode,
                // favOrderItems=[Items(itemId=1, itemName=pizza, itemPrice=5.0),
                // Items(itemId=3, itemName=brownie, itemPrice=1.5),
                // Items(itemId=4, itemName=milkshake, itemPrice=2.75)]),
            // FavOrders(emojiUnicode=cokeunicode + brownieunicode,
                // favOrderItems=[Items(itemId=2, itemName=coke, itemPrice=2.0),
                // Items(itemId=3, itemName=brownie, itemPrice=1.5)])])
    }

}
