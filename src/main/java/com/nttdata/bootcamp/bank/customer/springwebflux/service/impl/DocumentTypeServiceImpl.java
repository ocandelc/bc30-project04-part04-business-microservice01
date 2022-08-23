/**
 * Resumen.
 * Objeto                   : DocumentTypeServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.customer.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdata.bootcamp.bank.customer.model.dao.inte.DocumentTypeDaoInte;
import com.nttdata.bootcamp.bank.customer.model.document.DocumentType;
import com.nttdata.bootcamp.bank.customer.service.inte.DocumentTypeServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de implementación de servicio para utilizar los métodos de CRUD.
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeServiceInte {
    private static final Logger log = LoggerFactory.getLogger(DocumentTypeServiceImpl.class);

    @Autowired
    private DocumentTypeDaoInte documentTypeDaoInte;

    @Override
    public Mono<DocumentType> create(final DocumentType documentType) {

        return documentTypeDaoInte.save(documentType)
                .doFirst(() -> log.info("Begin create DocumentType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create DocumentType"));
    }

    @Override
    public Flux<DocumentType> readAll() {

        return documentTypeDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll DocumentType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll DocumentType"));
    }

    @Override
    public Mono<DocumentType> readByCodeDocumentType(String codeDocumentType) {
        return documentTypeDaoInte.readByCodeDocumentType(codeDocumentType)
                .doFirst(() -> log.info("Begin findById DocumentType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findById DocumentType"));
    }

    @Override
    public Mono<DocumentType> updateById(final String id, final DocumentType documentType) {

        return documentTypeDaoInte.save(documentType)
                .doFirst(() -> log.info("Begin updateById DocumentType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById DocumentType"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return documentTypeDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById DocumentType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById DocumentType"));
    }
}
