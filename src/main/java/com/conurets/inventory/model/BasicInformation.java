package com.conurets.inventory.model;

import com.conurets.inventory.util.validation.annotation.InventoryNotNull;
import lombok.*;

import java.util.Date;

/**
 * Created by Iraj on 03/20/19.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasicInformation  {

    private Long id;

    @InventoryNotNull(message = "Entry Date cannot be null")
    private Date entryDate;

    @InventoryNotNull(message = "Location Id cannot be null")
    private Integer locationId;

    @InventoryNotNull(message = "User Name cannot be null")
    private Integer userId;

    @InventoryNotNull(message = "Company Id cannot be null")
    private Integer companyId;

    @InventoryNotNull(message = "Item Id cannot be null")
    private Integer itemId;

    @InventoryNotNull(message = "Serial No cannot be null")
    private String serialNo;

    @InventoryNotNull(message = "Quantity cannot be null")
    private Integer qty;
    private String warranty;

    @InventoryNotNull(message = "Manufacturer cannot be null")
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
    private String itemCondition;
    private String itemUseable;
    private Integer supplierId;
    private Integer supplier_Rep_Id;
    private String supplierRepresentative;
    private String supplierRepresentativeMobile;
    private String supplierRepresentativeEmail;

}
