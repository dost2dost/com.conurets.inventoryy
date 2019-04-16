package com.conurets.inventory.util;

import com.conurets.inventory.model.BasicInformation;
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
    public static BasicInformation  basicinfo4mFormData(FormDatain formDatain) throws ParseException {

        BasicInformation basicInformation=new BasicInformation();
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
