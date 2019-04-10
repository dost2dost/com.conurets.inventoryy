package com.conurets.inventory.controller;

import com.conurets.inventory.model.FormDatain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dost M. Soomro on 4/8/2019.
 */
@Controller
public class FormController {

    @RequestMapping(value = "/submit/form")
    public String submitForm(){
        //@ModelAttribute  FormDatain formDatain
        return "ok";
    }
}
