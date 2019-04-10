package com.conurets.inventory.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * Created by Dost M. Soomro on 4/8/2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormDatain {

    private String entryDate;
    private long userId;
    private long locationId;
    private long itemId;
    private long companyId;
    private String userName;
    private String location;
    private String company;
    private String item_description;
    private String serialNo;
    private String qty;
    private String warranty;
    private String manufacturer;

    private String storageLocation;
    private String storageOnShelf;
    private String shelfByNo;
    private String storedInCabnet;
    private String cabnetShelfNo;
    private String spcialHandlinReq;
    private String specialHandlingNotes;
    private String approxWeight;
    private String calibrationRequired;
    private String calibratedDate;
    private String calibrationValidity;
    private String calibrationDueDate;
    private String itemNew;
    private String itemUsed;
    private String itemReconditioned;
    private String itemUseable;
    private String supplier;
    private Integer supplierId;
    private Integer supplier_Rep_Id;
    private String supplierRepresentative;
    private String supplierRepresentativeMobile;
    private String supplierRepresentativeEmail;

}
