package com.ncr.tr.helios.tweatsbackoffice;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerInfo;
import com.ncr.tr.helios.tweatsbackoffice.entities.customer.CustomerRepository;
import com.ncr.tr.helios.tweatsbackoffice.entities.items.ItemsRepository;
import com.ncr.tr.helios.tweatsbackoffice.entities.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

        CustomerInfo customer1 = new CustomerInfo();

    }

}
