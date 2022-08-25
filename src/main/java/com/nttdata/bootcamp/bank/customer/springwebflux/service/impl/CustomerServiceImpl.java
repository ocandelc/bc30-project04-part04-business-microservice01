/**
 * Resumen.
 * Objeto                   : CustomerServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.customer.springwebflux.service.impl;

import com.nttdata.bootcamp.bank.customer.springwebflux.dao.inte.CustomerDaoInte;
import com.nttdata.bootcamp.bank.customer.springdata.document.Customer;
import com.nttdata.bootcamp.bank.customer.springwebflux.service.inte.CustomerServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de implementación de servicio para utilizar los métodos de CRUD.
 */
@Service
public class CustomerServiceImpl implements CustomerServiceInte
{

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDaoInte customerDaoInte;

    @Override
    public Mono<Customer> create(final Customer customer) {

        return customerDaoInte.save(customer)
                .doFirst(() -> log.info("Begin create Customer"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create Customer"));
    }

    @Override
    public Flux<Customer> readAll() {

        return customerDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll Customer"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll Customer"));
    }

    @Override
    public Mono<Customer> readByCodeCustomer(String codeCustomer) {
        return customerDaoInte.readByCodeCustomer(codeCustomer)
                .doFirst(() -> log.info("Begin findById Customer"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findById Customer"));
    }

    @Override
    public Mono<Customer> updateById(final String id, final Customer customer) {

        return customerDaoInte.save(customer)
                .doFirst(() -> log.info("Begin updateById Customer"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById Customer"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return customerDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Customer"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Customer"));
    }

}