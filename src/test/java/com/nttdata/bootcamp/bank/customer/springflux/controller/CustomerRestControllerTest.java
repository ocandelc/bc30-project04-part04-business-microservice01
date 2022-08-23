package com.nttdata.bootcamp.bank.customer.springflux.controller;

import com.nttdata.bootcamp.bank.customer.model.document.Customer;
import com.nttdata.bootcamp.bank.customer.service.inte.CustomerServiceInte;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;

@SpringBootTest
public class CustomerRestControllerTest {

    @MockBean
    private CustomerServiceInte customerServiceInte;

    @Test
    void readAllTest() {

        Flux<Customer> fluxLocation = customerServiceInte.readAll();

        Mockito.verify(customerServiceInte).readAll();

     }

}
