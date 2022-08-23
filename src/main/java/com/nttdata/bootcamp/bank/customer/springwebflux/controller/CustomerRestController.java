/**
 * Resumen.
 * Objeto                   : CustomerRestController.java
 * Descripción              : Clase de controller para invocar los métodos con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              19/08/2022        Mario Vásquez           Realizar la creación de un método nuevo.
 */
package com.nttdata.bootcamp.bank.customer.controller;

import com.nttdata.bootcamp.bank.customer.model.document.Customer;
import com.nttdata.bootcamp.bank.customer.service.inte.CustomerServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de controladora para invocar los métodos con rest api.
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerRestController
{

    private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);

    @Autowired
    private CustomerServiceInte customerServiceInte;

    @PostMapping("create")
    public Mono<Customer> create(@RequestBody final Customer customer) {
        log.debug("Begin RestController create Customer");
        return customerServiceInte.create(customer);
    }

    @GetMapping
    public Flux<Customer> readAll() {
        log.debug("Begin RestController readAll Customer");
        return customerServiceInte.readAll();
    }

    @GetMapping("readByCodeCustomer/{codeCustomer}")
    public Mono<Customer> readByCodeCustomer(@PathVariable String codeCustomer) {
        log.debug("Begin RestController readByCodeCustomer Customer");
        return customerServiceInte.readByCodeCustomer(codeCustomer);
    }

    @PutMapping("updateById/{id}")
    public Mono<Customer> updateById(@RequestBody final Customer customer, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Customer");
        return customerServiceInte.updateById(id, customer);
    }

    @DeleteMapping("deleteById/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Customer");
        return customerServiceInte.deleteById(id);
    }

}