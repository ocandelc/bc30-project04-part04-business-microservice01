package com.nttdata.bootcamp.bank.springboot.dao.inte;

import com.nttdata.bootcamp.bank.springboot.document.Customer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Date;

@ExtendWith(SpringExtension.class)
public class CustomerDaoInteTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoInteTest.class);

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        logger.debug("INICIO TEST");

        closeable = MockitoAnnotations.openMocks(this);

        Customer object01 = new Customer(
                "62f5ca72c0458d7de760aa70",
                "Christian",
                "Franklin",
                "Gómez",
                "Condori",
                new Date(),
                "991-696-400",
                "010101",
                "Calle Las Magnolias",
                "",
                "",
                "",
                "",
                "",
                "",
                "1",
                "C-0000000001");


        Mono<Customer> monoObjectTest = Mono.just(object01);

        Mono<Customer> monoObjectDatabase = customerDaoInte.readByCodeCustomer("C-0000000001");

        Mockito.when(monoObjectDatabase).thenReturn(monoObjectTest);

    }

    @AfterEach
    void tearDown() throws Exception {
        logger.debug("FIN TEST");

        closeable.close();
    }

    @Mock
    CustomerDaoInte customerDaoInte;

    @Test
    @Order(1)
    public void createCustomerTest() {
        Customer object03 = new Customer(
                "7308ecf0e2d3133e313973de",
                "C-0000000006",
                "Test 02",
                "Test",
                "Test",
                new Date(),
                "991-696-400",
                "010101",
                "Calle Test",
                "",
                "",
                "",
                "",
                "",
                "",
                "1",
                "CT-0000000003");

        Mono<Customer> monoObjectDatabase = customerDaoInte.save(object03);

        Mockito.verify(customerDaoInte).save(object03);
    }

    @Test
    @Order(2)
    public void readByCodeCustomerTest() {

        Mono<Customer> monoObjectDatabase = customerDaoInte.readByCodeCustomer("C-0000000001");

        Mockito.verify(customerDaoInte).readByCodeCustomer("C-0000000001");

    }

    @Test
    @Order(3)
    public void updateCustomerTest() {
        Customer object01 = new Customer(
                "62f5ca72c0458d7de760aa70",
                "Christian",
                "Franklin",
                "Gómez",
                "Condori",
                new Date(),
                "991-696-401",
                "010101",
                "Calle Las Magnolias",
                "",
                "",
                "",
                "",
                "",
                "",
                "1",
                "C-0000000001");

        Mono<Customer> monoObjectDatabase = customerDaoInte.save(object01);

        Mockito.verify(customerDaoInte).save(object01);
    }

    @Test
    @Order(4)
    public void deleteCustomerTest() {

        Mono<Void> monoObjectDatabase = customerDaoInte.deleteById("C-0000000002");

        Mockito.verify(customerDaoInte).deleteById("C-0000000002");
    }

    @Test
    @Order(5)
    public void readByCodeCustomerStepVerifierTest() {

        Mono<Customer> objectDatabase = customerDaoInte.readByCodeCustomer("C-0000000001");

        Customer object01 = new Customer(
                "62f5ca72c0458d7de760aa70",
                "Christian",
                "Franklin",
                "Gómez",
                "Condori",
                new Date(),
                "991-696-400",
                "010101",
                "Calle Las Magnolias",
                "",
                "",
                "",
                "",
                "",
                "",
                "1",
                "C-0000000001");
        Mono<Customer> objectTest = Mono.just(object01);

        StepVerifier.create(customerDaoInte.readByCodeCustomer("C-0000000001")).recordWith(ArrayList::new)
                .expectNextCount(1)
                .consumeRecordedWith(r -> {
                    Assertions.assertEquals("C-0000000001", "C-0000000001");
                })
                .verifyComplete();;

    }

}
