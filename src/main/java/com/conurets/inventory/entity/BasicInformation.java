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
    private Item item;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private SupplierInformation supplierInformation;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "warranty")
    private String warranty;

    @Column(name = "stored_on_shelf")
    private String storedOnShelf;

    @Column(name = "shelf_bay_number")
    private Integer shelfBayNumber;

    @Column(name = "stored_in_cabinet")
    private String storedInCabinet;

    @Column(name = "cabinet_shelf_no")
    private Integer cabinetShelfNo;

    @Column(name = "calibrated_date")
    private Date calibratedDate;

    @Column(name = "caliberation_required")
    private String caliberation_Required;
    @Column(name = "product_category")
    private String product_category;
    @Column(name = "warranty_Expiration")
    private Date warranty_Expiration;


    public SupplierInformation getSupplierInformation() {
        return supplierInformation;
    }

    public void setSupplierInformation(SupplierInformation supplierInformation) {
        this.supplierInformation = supplierInformation;
    }

    public String getCaliberation_Required() {
        return caliberation_Required;
    }

    public void setCaliberation_Required(String caliberation_Required) {
        this.caliberation_Required = caliberation_Required;
    }

    @Column(name = "validity_of_calibration")
    private Date validityOfCalibration;

    @Column(name = "calibration_due_date")
    private Date calibrationDueDate;

    @Column(name = "item_condition")
    private String itemCondition;

    @Column(name = "storage_location")
    private String itemStorageLocation;

    @Column(name = "Special_Handling_Notes")
    private String specialHandlingNotes;

    @Column(name = "Approx_Weight")
    private Integer approxWeight;

    @Column(name = "Special_Handling_Required")
    private String specialHandlingRequired;



    @Column(name = "Supplier_Rep_ID")
    private Integer supplier_Rep_Id;



    public Integer getSupplier_Rep_Id() {
        return supplier_Rep_Id;
    }

    public void setSupplier_Rep_Id(Integer supplier_Rep_Id) {
        this.supplier_Rep_Id = supplier_Rep_Id;
    }

    public String getSpecialHandlingRequired() {
        return specialHandlingRequired;
    }

    public void setSpecialHandlingRequired(String specialHandlingRequired) {
        this.specialHandlingRequired = specialHandlingRequired;
    }

    public String getSpecialHandlingNotes() {
        return specialHandlingNotes;
    }

    public void setSpecialHandlingNotes(String specialHandlingNotes) {
        this.specialHandlingNotes = specialHandlingNotes;
    }

    public Integer getApproxWeight() {
        return approxWeight;
    }

    public void setApproxWeight(Integer approxWeight) {
        this.approxWeight = approxWeight;
    }

    public String getItemStorageLocation() {
        return itemStorageLocation;
    }

    public void setItemStorageLocation(String itemStorageLocation) {
        this.itemStorageLocation = itemStorageLocation;
    }

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }



    public Integer getShelfBayNumber() {
        return shelfBayNumber;
    }

    public void setShelfBayNumber(Integer shelfBayNumber) {
        this.shelfBayNumber = shelfBayNumber;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getStoredOnShelf() {
        return storedOnShelf;
    }

    public void setStoredOnShelf(String storedOnShelf) {
        this.storedOnShelf = storedOnShelf;
    }

    public String getStoredInCabinet() {
        return storedInCabinet;
    }

    public void setStoredInCabinet(String storedInCabinet) {
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



    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public Date getWarranty_Expiration() {
        return warranty_Expiration;
    }

    public void setWarranty_Expiration(Date warranty_Expiration) {
        this.warranty_Expiration = warranty_Expiration;
    }
}