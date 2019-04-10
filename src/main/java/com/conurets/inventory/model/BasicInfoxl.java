package com.conurets.inventory.model;

import lombok.*;

/**
 * Created by Dost M. Soomro on 4/5/2019.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasicInfoxl {
    private String location;
    private String venue;
    private String product_category;
    private String item_Id;
    private String item_Description;
    private String serial_Number;
    private String manufacturer;
    private String date_Item_Entered;
    private String item_Entered_By_User;
    private String company_Name;
    private String qty;
    private String warranty;
    private String warranty_Expiration;
}
