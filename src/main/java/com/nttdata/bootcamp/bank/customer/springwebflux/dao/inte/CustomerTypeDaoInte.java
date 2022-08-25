/**
 * Resumen.
 * Objeto                   : CustomerTypeDaoInte.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.customer.springwebflux.dao.inte;


import com.nttdata.bootcamp.bank.customer.springdata.document.Customer;
import com.nttdata.bootcamp.bank.customer.springdata.document.CustomerType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerTypeDaoInte extends ReactiveMongoRepository<CustomerType, String> {

    Mono<CustomerType> readByCodeCustomerType(String codeCustomerType);

}
