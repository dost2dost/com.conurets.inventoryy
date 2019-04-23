package com.conurets.inventory.model;

import lombok.*;

/**
 * Created by Dost M. Soomro on 4/23/2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplierIformation {

    private Long supplierInformationId;
    private String supplier;
    private String representative;
    private String mobile;
    private String email;
    private Boolean active;
}
