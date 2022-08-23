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
 */
package com.nttdata.bootcamp.bank.customer.controller;

import com.nttdata.bootcamp.bank.customer.model.document.Document;
import com.nttdata.bootcamp.bank.customer.service.inte.DocumentServiceInte;
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
@RequestMapping("/api/document")
public class DocumentRestController {

    private static final Logger log = LoggerFactory.getLogger(DocumentRestController.class);

    @Autowired
    private DocumentServiceInte documentServiceInte;

    @PostMapping("create")
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

    @PutMapping("updateById/{id}")
    public Mono<Document> updateById(@RequestBody final Document document, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Document");
        return documentServiceInte.updateById(id, document);
    }

    @DeleteMapping("deleteById/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Document");
        return documentServiceInte.deleteById(id);
    }
}
