/**
 * Resumen.
 * Objeto                   : DocumentTypeRestController.java
 * Descripción              : Clase de controller para invocar los métodos con rest api.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              24/08/2022       Oscar Candela          Realizar la creación de un método nuevo.
 */
package com.nttdata.bootcamp.bank.customer.springwebflux.controller;

import com.nttdata.bootcamp.bank.customer.springdata.document.DocumentType;
import com.nttdata.bootcamp.bank.customer.springwebflux.service.inte.DocumentTypeServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de controladora para invocar los métodos con rest api.
 */
@RestController
@RequestMapping("/api/business-microservice01-customer/documentType")
public class DocumentTypeRestController {
    private static final Logger log = LoggerFactory.getLogger(DocumentTypeRestController.class);

    @Autowired
    private DocumentTypeServiceInte documentTypeServiceInte;

    @PostMapping()
    public Mono<DocumentType> create(@RequestBody final DocumentType documentType) {
        log.debug("Begin RestController create DocumentType");
        return documentTypeServiceInte.create(documentType);
    }

    @GetMapping
    public Flux<DocumentType> readAll() {
        log.debug("Begin RestController readAll DocumentType");
        return documentTypeServiceInte.readAll();
    }

    @GetMapping("readByCodeDocumentType/{codeDocumentType}")
    public Mono<DocumentType> readByCodeDocumentType(@PathVariable String codeDocumentType) {
        log.debug("Begin RestController readByCodeDocumentType DocumentType");
        return documentTypeServiceInte.readByCodeDocumentType(codeDocumentType);
    }

    @PutMapping("/{id}")
    public Mono<DocumentType> updateById(@RequestBody final DocumentType documentType, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById DocumentType");
        return documentTypeServiceInte.updateById(id, documentType);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById DocumentType");
        return documentTypeServiceInte.deleteById(id);
    }
}
