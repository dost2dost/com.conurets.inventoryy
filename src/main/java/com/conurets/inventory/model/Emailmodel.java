package com.conurets.inventory.model;

import lombok.*;

/**
 * Created by Dost M. Soomro on 4/25/2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emailmodel {

    private String  emailTo;
    private String  emailFrom;
    private String  emailSubject;
    private String  emailContent;



}
