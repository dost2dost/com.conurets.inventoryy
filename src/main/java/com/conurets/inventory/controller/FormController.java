package com.conurets.inventory.controller;

import com.conurets.inventory.model.FormDatain;
import com.conurets.inventory.vo.BasicInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Dost M. Soomro on 4/8/2019.
 */
@Controller
public class FormController extends BaseController {

    @RequestMapping(value = "/submit/form")
    public String submitForm(){
        List<BasicInfoVO> basicInfoVOSList = basicInfoService.fetchBasicInfoReport("2019-10-10","2019-10-11");
        //@ModelAttribute  FormDatain formDatain
        return "ok";
    }
}
