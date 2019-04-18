package com.conurets.inventory.util;

import com.conurets.inventory.model.BasicInformation;
import com.conurets.inventory.model.BasicInfoxl;
import com.conurets.inventory.model.FormDatain;
import sun.nio.ch.SelectorImpl;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dost M. Soomro on 4/9/2019.
 */
public class FormData {

    static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy/MM/dd");
    public static BasicInformation  basicinfo4mXLData(BasicInfoxl formDatain) throws ParseException {

        BasicInformation basicInformation=new BasicInformation();


        basicInformation.setSerialNo(String.valueOf(formDatain.getSerial_Number()));
        basicInformation.setItemId(Integer.parseInt(formDatain.getItem_Id()));
        basicInformation.setCompanyId(1);
        basicInformation.setLocationId(1);
        basicInformation.setUserId(1);
        basicInformation.setItemId(Integer.valueOf(formDatain.getItem_Id()));
        basicInformation.setQty(Integer.valueOf(formDatain.getQty()));
        basicInformation.setStorageLocation(formDatain.getVenue());
        if(formDatain.getDate_Item_Entered().equals("")  || formDatain.getDate_Item_Entered()==null){

        }else {
            basicInformation.setEntryDate(simpleDateFormat2.parse(formDatain.getDate_Item_Entered()));
        }
        basicInformation.setWarranty(formDatain.getWarranty());
        basicInformation.setProduct_category(formDatain.getProduct_category());
        basicInformation.setWarranty_Expiration(simpleDateFormat2.parse(formDatain.getWarranty_Expiration()));




//        basicInformation.setLocationId((int) formDatain.getLocationId());
//        basicInformation.setQty(Integer.valueOf(formDatain.getQty()));
//        basicInformation.setWarranty(formDatain.getWarranty());
        basicInformation.setManufacturer("M");
//
//        basicInformation.setEntryDate(simpleDateFormat.parse(formDatain.getEntryDate()));
//        basicInformation.setUserId(Integer.parseInt(String.valueOf(formDatain.getUserId())));
//        //Storage
        //basicInformation.setStorageLocation(formDatain.getStorageLocation());
        basicInformation.setStorageOnShelf("No");
        basicInformation.setShelfByNo("10");
        basicInformation.setStoredInCabnet("No");
        basicInformation.setCabnetShelfNo("00001");
//        //SpecialHandling
        basicInformation.setSpcialHandlinReq("No");
        basicInformation.setSpecialHandlingNotes("specinot 4m exel");
        basicInformation.setApproxWeight("10");
//        //Caliberation
        basicInformation.setCalibrationRequired("No");
//        String date=simpleDateFormat.format("2019-10-10");
//        basicInformation.setCalibratedDate(String.valueOf(date));
//        basicInformation.setCalibrationValidity(String.valueOf(date));
//        basicInformation.setCalibrationDueDate(String.valueOf(date));
//        //item
//        basicInformation.setItemNew(formDatain.getItemNew());
//        basicInformation.setItemUsed(formDatain.getItemUsed());
//        basicInformation.setItemReconditioned(formDatain.getItemReconditioned());
//        basicInformation.setItemUseable(formDatain.getItemUseable());
        basicInformation.setItemCondition("Used");
//        //Supplier
        basicInformation.setSupplierId(1);
        basicInformation.setSupplier_Rep_Id(2);
//        basicInformation.setSupplierRepresentative(formDatain.getSupplierRepresentative());
//        basicInformation.setSupplierRepresentativeMobile(formDatain.getSupplierRepresentativeMobile());
//        basicInformation.setSupplierRepresentativeEmail(formDatain.getSupplierRepresentativeEmail());





        return basicInformation;

    }
    public static BasicInformation  basicinfo4mFormData(FormDatain formDatain) throws ParseException {

        BasicInformation basicInformation=new BasicInformation();
        basicInformation.setId(formDatain.getId());
        basicInformation.setSerialNo(String.valueOf(formDatain.getSerialNo()));
        basicInformation.setItemId((int) formDatain.getItemId());
        basicInformation.setCompanyId((int) Math.toIntExact(formDatain.getCompanyId()));
        basicInformation.setLocationId((int) formDatain.getLocationId());
        basicInformation.setQty(Integer.valueOf(formDatain.getQty()));
        basicInformation.setWarranty(formDatain.getWarranty());
        basicInformation.setManufacturer(formDatain.getManufacturer());

        basicInformation.setEntryDate(simpleDateFormat.parse(formDatain.getEntryDate()));
        basicInformation.setUserId(Integer.parseInt(String.valueOf(formDatain.getUserId())));
        //Storage
        basicInformation.setStorageLocation(formDatain.getStorageLocation());
        basicInformation.setStorageOnShelf(formDatain.getStorageOnShelf());
        basicInformation.setShelfByNo(String.valueOf(formDatain.getShelfByNo()));
        basicInformation.setStoredInCabnet(formDatain.getStoredInCabnet());
        basicInformation.setCabnetShelfNo(String.valueOf(formDatain.getCabnetShelfNo()));
        //SpecialHandling
        basicInformation.setSpcialHandlinReq(formDatain.getSpcialHandlinReq());
        basicInformation.setSpecialHandlingNotes(formDatain.getSpecialHandlingNotes());
        basicInformation.setApproxWeight(formDatain.getApproxWeight());
        //Caliberation
        basicInformation.setCalibrationRequired(formDatain.getCalibrationRequired());
        basicInformation.setCalibratedDate(formDatain.getCalibratedDate());
        basicInformation.setCalibrationValidity(formDatain.getCalibrationValidity());
        basicInformation.setCalibrationDueDate(formDatain.getCalibrationDueDate());
        //item
        basicInformation.setItemNew(formDatain.getItemNew());
        basicInformation.setItemUsed(formDatain.getItemUsed());
        basicInformation.setItemReconditioned(formDatain.getItemReconditioned());
        basicInformation.setItemUseable(formDatain.getItemUseable());
        basicInformation.setItemCondition(formDatain.getItemCondition());
        //Supplier
        basicInformation.setSupplierId(formDatain.getSupplierId());
        basicInformation.setSupplier_Rep_Id(formDatain.getSupplier_Rep_Id());
        basicInformation.setSupplierRepresentative(formDatain.getSupplierRepresentative());
        basicInformation.setSupplierRepresentativeMobile(formDatain.getSupplierRepresentativeMobile());
        basicInformation.setSupplierRepresentativeEmail(formDatain.getSupplierRepresentativeEmail());





        return basicInformation;

    }
}
