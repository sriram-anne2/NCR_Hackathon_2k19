package com.ncr.tr.helios.tweatsbackoffice;

import com.ncr.tr.helios.tweatsbackoffice.customer.Customer;
import com.ncr.tr.helios.tweatsbackoffice.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TweatsBackOfficeApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TweatsBackOfficeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        repository.deleteAll();

        Customer c1 = new Customer();
        Customer c2 = new Customer();

        c1.setName("Asheton Harrell");

        c2.setName("Ram Anne");

        repository.save(c1);
        repository.save(c2);

        System.out.println("Here are saved customers");
        repository.findAll().stream().forEach(System.out::println);

    }

}
