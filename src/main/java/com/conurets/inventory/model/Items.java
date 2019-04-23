package com.conurets.inventory.model;

import lombok.*;

/**
 * Created by Dost M. Soomro on 4/22/2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Items {

    private Long itemId;
    private String itemCode;
    private String itemDescription;
    private String manufacturer;
    private Boolean calibrationRequired;
    private Boolean active;
}
