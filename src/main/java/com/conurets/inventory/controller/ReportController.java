package com.conurets.inventory.controller;

import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.BasicInformation;
import com.conurets.inventory.model.BasicInfoxl;
import com.conurets.inventory.util.FormData;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.util.xlutil.Utilityxl;
import com.conurets.inventory.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dost M. Soomro on 4/2/2019.
 */
@RestController
public class ReportController extends BaseController{

    @Autowired
    private FormData formData;

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "E://dtemp//";


    @PostMapping(value = "/saveBulk")
    public ResponseEntity<?> saveBulkimport(@RequestBody List<BasicInfoxl> basicInfoxls) throws InventoryException {


        List<BasicInfoxl> lstB=new ArrayList<>();
        lstB=basicInfoxls;
        List<BasicInformation> lstBasicinfo=new ArrayList<>();

        lstB.forEach(s->{

            BasicInfoxl basicInfoxl=new BasicInfoxl();
            if(s==null){

            }else {
                basicInfoxl=s;
            }


            BasicInformation basicInformation= new BasicInformation();
            try {
                basicInformation = formData.basicinfo4mXLData(basicInfoxl);

                if(basicInformation==null){

                }else{
                    lstBasicinfo.add(basicInformation);
                }


            } catch (ParseException e) {
                e.printStackTrace();
            }
        });


        basicInfoService.save(lstBasicinfo);




        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS,"success");

        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping(value ="/uploadf")
    public ResponseEntity<?> report(@RequestParam("file") MultipartFile file){

        List<BasicInfoxl> lst=new ArrayList<>();
        List<BasicInfoxl> lstCopy=new ArrayList<>();
        List<BasicInfoxl> lstFinal=new ArrayList<>();
        List<BasicInformation> lstBasicinfo=new ArrayList<>();
        try {

            String fileName=file.getOriginalFilename();
            String fileur= InventoryUtil.PROJECT_FILES + fileName;
            //String fileur=UPLOADED_FOLDER+ fileName;

            // Get the file and save it somewhere//@RequestParam("file") MultipartFile file
            //Save file
            byte[] bytes = file.getBytes();
            Path path = Paths.get(InventoryUtil.PROJECT_FILES + file.getOriginalFilename());
            //Path path = Paths.get(UPLOADED_FOLDER+ file.getOriginalFilename());
            Files.write(path, bytes);

            //Read file

            Utilityxl obj=new Utilityxl();
             lst=obj.test(fileur);
             lstCopy.addAll(lst);

             //lst.get(2).setQty("some");

             lst.forEach(s->{
                 int parseValue=InventoryUtil.stringToInteger(s.getQty());
                // int  parseValue=InventoryUtil.stringToInteger(s.getQty());
                 //InventoryUtil.convertFromStringToDate(s.getDate_Item_Entered());

                 if(parseValue==0){
                     lstFinal.add(s);
                     lstCopy.remove(s);
                 }

             });

//             if(!lstCopy.isEmpty()){
//                 lstCopy.forEach(s->{
//
//                     BasicInfoxl basicInfoxl=new BasicInfoxl();
//                     if(s==null){
//
//                     }else {
//                         basicInfoxl=s;
//                     }
//
//
//                     BasicInformation basicInformation= new BasicInformation();
//                     try {
//                         basicInformation = formData.basicinfo4mXLData(basicInfoxl);
//
//                         if(basicInformation==null){
//
//                         }else{
//                             lstBasicinfo.add(basicInformation);
//                         }
//
//
//                     } catch (ParseException e) {
//                         e.printStackTrace();
//                     }
//                 });

                // basicInfoService.save(lstBasicinfo);
            // }



        } catch (IOException e) {
            e.printStackTrace();
        }


        BaseResponse<Object> baseResponse = InventoryUtil.setBaseResponse(InventoryConstants.STATUS_CODE_SUCCESS,
                InventoryConstants.STATUS_MSG_SUCCESS,lst);

        return ResponseEntity.ok(baseResponse);

    }



}
