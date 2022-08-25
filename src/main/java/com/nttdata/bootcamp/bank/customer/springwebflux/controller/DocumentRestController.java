/**
 * Resumen.
 * Objeto                   : DocumentRestController.java
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

import com.nttdata.bootcamp.bank.customer.springdata.document.Document;
import com.nttdata.bootcamp.bank.customer.springwebflux.service.inte.DocumentServiceInte;
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
@RequestMapping("/api/business-microservice01-customer/document")
public class DocumentRestController {

    private static final Logger log = LoggerFactory.getLogger(DocumentRestController.class);

    @Autowired
    private DocumentServiceInte documentServiceInte;

    @PostMapping()
    public Mono<Document> create(@RequestBody final Document document) {
        log.debug("Begin RestController create Document");
        return documentServiceInte.create(document);
    }

    @GetMapping
    public Flux<Document> readAll() {
        log.debug("Begin RestController readAll Document");
        return documentServiceInte.readAll();
    }

    @GetMapping("readByCodeDocument/{codeDocument}")
    public Mono<Document> readByCodeDocument(@PathVariable String codeDocument) {
        log.debug("Begin RestController readByCodeDocument Document");
        return documentServiceInte.readByCodeDocument(codeDocument);
    }

    @PutMapping("/{id}")
    public Mono<Document> updateById(@RequestBody final Document document, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Document");
        return documentServiceInte.updateById(id, document);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Document");
        return documentServiceInte.deleteById(id);
    }
}
