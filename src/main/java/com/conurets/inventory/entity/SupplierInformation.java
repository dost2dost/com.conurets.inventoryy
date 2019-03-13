package com.conurets.inventory.entity;

import javax.persistence.*;

/**
 * @author MSA
 */

@Entity
@Table(name = "supplier_information")
public class SupplierInformation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long supplierInformationId;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "representative")
    private String representative;

    @Column(name = "repre_mobile")
    private String mobile;

    @Column(name = "repre_email")
    private String email;

    @Column(name = "is_active")
    private Boolean active;

    public Long getSupplierInformationId() {
        return supplierInformationId;
    }

    public void setSupplierInformationId(Long supplierInformationId) {
        this.supplierInformationId = supplierInformationId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}