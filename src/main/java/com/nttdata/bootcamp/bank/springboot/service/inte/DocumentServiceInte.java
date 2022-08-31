/**
 * Resumen.
 * Objeto                   : DocumentServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              24/08/2022       Oscar Candela          Realizar la creación de un método nuevo.
 */
package com.nttdata.bootcamp.bank.springboot.service.inte;

import com.nttdata.bootcamp.bank.springboot.document.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface DocumentServiceInte {
    Mono<Document> create(final Document document);

    Flux<Document> readAll();

    Mono<Document> readByCodeDocument(String codeDocument);

    Mono<Document> updateById(final String id, final Document document);

    Mono<Void> deleteById(final String id);
}
