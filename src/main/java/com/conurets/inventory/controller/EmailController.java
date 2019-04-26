package com.conurets.inventory.controller;

import com.conurets.inventory.model.Emailmodel;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.util.emails.EmailSender;
import com.conurets.inventory.vo.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Dost M. Soomro on 4/25/2019.
 */
@RestController
public class EmailController {

    @RequestMapping(value = "/sendEmails")
    public ResponseEntity<?> sendEmail(@RequestBody Emailmodel emailmodel){
        EmailSender emailSender=new EmailSender();
        String status= emailSender.sendemail(emailmodel.getEmailTo(),"2019/10/10");

        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS,status);

        return ResponseEntity.ok(baseResponse);


    }
}
