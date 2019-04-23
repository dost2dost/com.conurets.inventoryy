package com.conurets.inventory.vo;

import lombok.*;

import java.io.Serializable;

/**
 * @author MSA
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SupplierinfoVO implements Serializable {


    private Long supplierInformationId;
    private String supplier;
    private String representative;
    private String mobile;
    private String email;
    private Boolean active;

}