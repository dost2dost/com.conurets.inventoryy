package com.conurets.inventory.entity;

import javax.persistence.*;

/**
 * @author MSA
 */

@Entity
@Table(name = "item_supplier")
public class ItemSupplier extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long itemSupplierId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "supplier_id")
    private Integer supplierId;

    public Long getItemSupplierId() {
        return itemSupplierId;
    }

    public void setItemSupplierId(Long itemSupplierId) {
        this.itemSupplierId = itemSupplierId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
}