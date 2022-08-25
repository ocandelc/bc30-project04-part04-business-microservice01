/**
 * Resumen.
 * Objeto                   : DocumentServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              24/08/2022       Oscar Candela          Realizar la creación de un método nuevo.
 */
package com.nttdata.bootcamp.bank.customer.springwebflux.service.impl;

import com.nttdata.bootcamp.bank.customer.springwebflux.dao.inte.DocumentDaoInte;
import com.nttdata.bootcamp.bank.customer.springdata.document.Document;
import com.nttdata.bootcamp.bank.customer.springwebflux.service.inte.DocumentServiceInte;
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
public class DocumentServiceImpl implements DocumentServiceInte {
    private static final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Autowired
    private DocumentDaoInte documentDaoInte;

    @Override
    public Mono<Document> create(final Document document) {

        return documentDaoInte.save(document)
                .doFirst(() -> log.info("Begin create Document"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create Document"));
    }

    @Override
    public Flux<Document> readAll() {

        return documentDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll Document"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll Document"));
    }

    @Override
    public Mono<Document> readByCodeDocument(String codeDocument) {
        return documentDaoInte.readByCodeDocument(codeDocument)
                .doFirst(() -> log.info("Begin findById Document"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findById Document"));
    }

    @Override
    public Mono<Document> updateById(final String id, final Document document) {

        return documentDaoInte.save(document)
                .doFirst(() -> log.info("Begin updateById Document"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById Document"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return documentDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById Document"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById Document"));
    }
}
