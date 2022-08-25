/**
 * Resumen.
 * Objeto                   : DocumentDaoInte.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              24/08/2022       Oscar Candela          Realizar la creación de un método nuevo.
 */
package com.nttdata.bootcamp.bank.customer.springwebflux.dao.inte;

import com.nttdata.bootcamp.bank.customer.springdata.document.Customer;
import com.nttdata.bootcamp.bank.customer.springdata.document.CustomerType;
import com.nttdata.bootcamp.bank.customer.springdata.document.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DocumentDaoInte extends ReactiveMongoRepository<Document, String> {
    Mono<Document> readByCodeDocument(String codeDocument);
}
