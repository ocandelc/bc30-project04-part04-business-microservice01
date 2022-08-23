/**
 * Resumen.
 * Objeto                   : Customer.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              17/08/2022        Mario Vásquez           Realizar la creación de un campo nuevo.
 */
package com.nttdata.bootcamp.bank.customer.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@AllArgsConstructor
@Document(collection="customer")
public class Customer
{

    @Id
    private String id;
    private String codeCustomer;
    private String staffNameFirst;
    private String staffNameSecond;
    private String staffSurnameSecond;
    private Date staffBirthday;
    private String staffCellphone;
    private String staffGeoloc;
    private String staffAddress;
    private String businessTradeName;
    private String businessTaxName;
    private String businessTaxIdentificationNumber;
    private String businessTelephone;
    private String businessGeoloc;
    private String businessAddress;
    private String state;
    private String codeCustomerType;

}

