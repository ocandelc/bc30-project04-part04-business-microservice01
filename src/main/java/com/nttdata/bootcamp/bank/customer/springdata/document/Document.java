/**
 * Resumen.
 * Objeto                   : Document.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 19/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 Bootcamp-30              24/08/2022        Oscar Candela           Realizar la creación de un método nuevo.*/
package com.nttdata.bootcamp.bank.customer.springdata.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@AllArgsConstructor
@org.springframework.data.mongodb.core.mapping.Document(collection="document")
public class Document {
    @Id
    private String id;
    private String state;
    private String codeDocumentType;
    private String codeClient;
    private String codeDocument;
    private String number;
}
