/**
 * Resumen.
 * Objeto                   : CustomerTypeServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.customer.service.impl;

import com.nttdata.bootcamp.bank.customer.model.dao.inte.CustomerTypeDaoInte;
import com.nttdata.bootcamp.bank.customer.model.document.CustomerType;
import com.nttdata.bootcamp.bank.customer.service.inte.CustomerTypeServiceInte;
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
public class CustomerTypeServiceImpl implements CustomerTypeServiceInte
{
    private static final Logger log = LoggerFactory.getLogger(CustomerTypeServiceImpl.class);

    @Autowired
    private CustomerTypeDaoInte customerTypeDaoInte;

    @Override
    public Mono<CustomerType> create(final CustomerType customerType) {

        return customerTypeDaoInte.save(customerType)
                .doFirst(() -> log.info("Begin create CustomerType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create CustomerType"));
    }

    @Override
    public Flux<CustomerType> readAll() {

        return customerTypeDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll CustomerType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll CustomerType"));
    }

    @Override
    public Mono<CustomerType> readByCodeCustomerType(String codeCustomerType) {
        return customerTypeDaoInte.readByCodeCustomerType(codeCustomerType)
                .doFirst(() -> log.info("Begin findById CustomerType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findById CustomerType"));
    }

    @Override
    public Mono<CustomerType> updateById(final String id, final CustomerType customerType) {

        return customerTypeDaoInte.save(customerType)
                .doFirst(() -> log.info("Begin updateById CustomerType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById CustomerType"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return customerTypeDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById CustomerType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById CustomerType"));
    }

}