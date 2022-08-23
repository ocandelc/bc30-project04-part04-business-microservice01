/**
 * Resumen.
 * Objeto                   : DocumentTypeServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.customer.service.inte;

import com.nttdata.bootcamp.bank.customer.model.document.DocumentType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface DocumentTypeServiceInte {
    Mono<DocumentType> create(final DocumentType documentType);

    Flux<DocumentType> readAll();

    Mono<DocumentType> readByCodeDocumentType(String codeDocumentType);

    Mono<DocumentType> updateById(final String id, final DocumentType documentType);

    Mono<Void> deleteById(final String id);
}
