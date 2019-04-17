package com.conurets.inventory.controller;

import com.conurets.inventory.model.BasicInfoxl;
import com.conurets.inventory.model.FormDatain;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.util.xlutil.Utilityxl;
import com.conurets.inventory.vo.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.ALL;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Dost M. Soomro on 4/2/2019.
 */
@RestController
public class ReportController extends BaseController{

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "E://dtemp//";

    @PostMapping(value ="/uploadf")
    public ResponseEntity<?> report(@RequestParam("file") MultipartFile file){

        List<BasicInfoxl> lst=new ArrayList<>();
        try {

            String fileName=file.getOriginalFilename();
            String fileur=UPLOADED_FOLDER+fileName;

            // Get the file and save it somewhere//@RequestParam("file") MultipartFile file
            //Save file
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            //Read file

            Utilityxl obj=new Utilityxl();
             lst=obj.test(fileur);


        } catch (IOException e) {
            e.printStackTrace();
        }


        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS,lst);

        return ResponseEntity.ok(baseResponse);

    }
}
