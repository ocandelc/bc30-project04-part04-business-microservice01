package com.nttdata.bootcamp.bank.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMicroserviceCustomerApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootMicroserviceCustomerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceCustomerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Init Customer");
    }

}
