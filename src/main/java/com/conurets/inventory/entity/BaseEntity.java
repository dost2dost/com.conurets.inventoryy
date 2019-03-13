package com.conurets.inventory.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author MSA
 */

@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = true)
    @Column(name = "created_date", updatable = false)
    private Timestamp createdDate;

    @Basic(optional = true)
    @Column(name = "created_by_id", updatable = false)
    private Long createdBy;

    @Basic(optional = true)
    @Column(name = "modified_date", insertable = false)
    private Timestamp lastUpdate;

    @Basic(optional = true)
    @Column(name = "modified_by_id", insertable = false)
    private Long lastUpdateBy;

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}