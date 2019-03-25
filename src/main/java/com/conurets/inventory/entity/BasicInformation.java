package com.conurets.inventory.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author MSA
 */

@Entity
@Table(name = "basic_information")
public class BasicInformation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long basicInformationId;

    @Column(name = "entry_date")
    private Date entryDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location locationId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company companyId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item itemId;

    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "stored_on_shelf")
    private Boolean storedOnShelf;

    @Column(name = "shelf_bay_number")
    private Integer shelfBayNumber;

    @Column(name = "stored_in_cabinet")
    private Boolean storedInCabinet;

    @Column(name = "cabinet_shelf_no")
    private Integer cabinetShelfNo;

    @Column(name = "calibrated_date")
    private Date calibratedDate;

    @Column(name = "validity_of_calibration")
    private Date validityOfCalibration;

    @Column(name = "calibration_due_date")
    private Date calibrationDueDate;

    @Column(name = "item_condition")
    private String itemCondition;

    public Long getBasicInformationId() {
        return basicInformationId;
    }

    public void setBasicInformationId(Long basicInformationId) {
        this.basicInformationId = basicInformationId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Boolean getStoredOnShelf() {
        return storedOnShelf;
    }

    public void setStoredOnShelf(Boolean storedOnShelf) {
        this.storedOnShelf = storedOnShelf;
    }

    public Integer getShelfBayNumber() {
        return shelfBayNumber;
    }

    public void setShelfBayNumber(Integer shelfBayNumber) {
        this.shelfBayNumber = shelfBayNumber;
    }

    public Boolean getStoredInCabinet() {
        return storedInCabinet;
    }

    public void setStoredInCabinet(Boolean storedInCabinet) {
        this.storedInCabinet = storedInCabinet;
    }

    public Integer getCabinetShelfNo() {
        return cabinetShelfNo;
    }

    public void setCabinetShelfNo(Integer cabinetShelfNo) {
        this.cabinetShelfNo = cabinetShelfNo;
    }

    public Date getCalibratedDate() {
        return calibratedDate;
    }

    public void setCalibratedDate(Date calibratedDate) {
        this.calibratedDate = calibratedDate;
    }

    public Date getValidityOfCalibration() {
        return validityOfCalibration;
    }

    public void setValidityOfCalibration(Date validityOfCalibration) {
        this.validityOfCalibration = validityOfCalibration;
    }

    public Date getCalibrationDueDate() {
        return calibrationDueDate;
    }

    public void setCalibrationDueDate(Date calibrationDueDate) {
        this.calibrationDueDate = calibrationDueDate;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
    }

}