package com.conurets.inventory.model;

import com.conurets.inventory.util.validation.annotation.InventoryNotNull;
import java.util.Date;

/**
 * Created by Iraj on 03/20/19.
 */

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
    private Integer serialNo;

    @InventoryNotNull(message = "Quantity cannot be null")
    private Integer qty;

    @InventoryNotNull(message = "Manufacturer cannot be null")
    private String manufacturer;

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
