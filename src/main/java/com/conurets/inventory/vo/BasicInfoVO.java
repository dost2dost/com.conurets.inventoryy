package com.conurets.inventory.vo;

import com.conurets.inventory.entity.SupplierInformation;
import lombok.*;

import java.util.Date;

/**
 * Created by Iraj on 03/25/19. Update by Dost M
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasicInfoVO {

    private Date entryDate;
    private Long locationId;
    private String locationName;

    private Long userId;
    private String userName;

    private Long companyId;
    private String companyName;

    private Long itemId;
    private String itemName;

    private String serialNumber;
    private Integer qty;
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
//    private String itemNew;
//    private String itemUsed;
    //private String itemReconditioned;
    private String itemCondition;
    //private String itemUseable;
    private String  supplierName;
    private String supplierRepresentative;
    private String supplierRepresentativeMobile;
    private String supplierRepresentativeEmail;

    private Date warranty_Expiration;




}
