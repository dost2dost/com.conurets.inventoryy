package com.conurets.inventory.util;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.Item;
import com.conurets.inventory.entity.SupplierInformation;
import com.conurets.inventory.model.BasicInformation;
import com.conurets.inventory.model.BasicInfoxl;
import com.conurets.inventory.model.FormDatain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.nio.ch.SelectorImpl;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dost M. Soomro on 4/9/2019.
 */

@Component
public class FormData {

    static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("dd/MMM/yyyy");

    @Autowired
    private DAOFactory daoFactory;

    public BasicInformation  basicinfo4mXLData(BasicInfoxl formDatain) throws ParseException {

        BasicInformation basicInformation=new BasicInformation();
        Item item=daoFactory.getItemDAO().findById(Long.parseLong(formDatain.getItem_Id()));
        //SupplierInformation supplierInformation=daoFactory.getSupplierInformationDao().findById(1);

       // basicInformation.setSupplierInformation(supplierInformation);

        SupplierInformation supplierInformation=daoFactory.getSupplierInformationDao().findByKeyValue("representative",formDatain.getSupplierRepresentative());

        if(supplierInformation==null) {
             supplierInformation = new SupplierInformation();
            supplierInformation.setActive(true);
            supplierInformation.setEmail(formDatain.getSupplierRepresentativeEmail());
            supplierInformation.setMobile(formDatain.getSupplierRepresentativeMobile());
            supplierInformation.setSupplier(formDatain.getSupplier());
            supplierInformation.setRepresentative(formDatain.getSupplierRepresentative());
            daoFactory.getSupplierInformationDao().save(supplierInformation);
        }else{
            basicInformation.setSupplierInformation(supplierInformation);
        }



        if(item==null){
            item=new Item();
            item.setItemCode(String.valueOf(Math.random()));
            item.setManufacturer(formDatain.getManufacturer());
            item.setCreatedBy((long) 1);
            item.setActive(true);
            item.setItemDescription(formDatain.getItem_Description());
            item.setCalibrationRequired(false);
            item.setCreatedDate(Timestamp.valueOf(formDatain.getDate_Item_Entered()));
            daoFactory.getItemDAO().save(item);
            basicInformation.setItem(item);


        }else {
            basicInformation.setItem(item);
        }
        basicInformation.setSerialNo(String.valueOf(formDatain.getSerial_Number()));
        basicInformation.setItem(item);
        basicInformation.setCompanyId(1);
        basicInformation.setLocationId(1);
        basicInformation.setUserId(1);
        //basicInformation.setItem(Integer.valueOf(formDatain.getItem_Id()));
        basicInformation.setQty(Integer.valueOf(formDatain.getQty()));
        basicInformation.setStorageLocation(formDatain.getVenue());

//        if(formDatain.getDate_Item_Entered().equals("")  || formDatain.getDate_Item_Entered()==null){
//
//            basicInformation.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-15"));
//        }else {
//            basicInformation.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-04-15"));
//        }
//        basicInformation.setWarranty(formDatain.getWarranty());
//        basicInformation.setProduct_category(formDatain.getProduct_category());
//        basicInformation.setWarranty_Expiration(simpleDateFormat2.parse(formDatain.getWarranty_Expiration()));




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
       // basicInformation.setSupplierId(1);
        basicInformation.setSupplier_Rep_Id(2);
//        basicInformation.setSupplierRepresentative(formDatain.getSupplierRepresentative());
//        basicInformation.setSupplierRepresentativeMobile(formDatain.getSupplierRepresentativeMobile());
//        basicInformation.setSupplierRepresentativeEmail(formDatain.getSupplierRepresentativeEmail());





        return basicInformation;

    }
    public BasicInformation  basicinfo4mFormData(FormDatain formDatain) throws ParseException {

        Item item=new Item();
        item.setItemDescription(formDatain.getItemDescription());
        item.setActive(true);
        item.setCalibrationRequired(false);
        item.setManufacturer(formDatain.getManufacturer());
        item.setCreatedBy(Long.valueOf(1));
        item.setItemCode(formDatain.getItemCode());
        //item.setCreatedDate((Timestamp) new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-10"));

        daoFactory.getItemDAO().save(item);

        BasicInformation basicInformation=new BasicInformation();
        basicInformation.setId(formDatain.getId());
        basicInformation.setSerialNo(String.valueOf(formDatain.getSerialNo()));
        basicInformation.setItem(item);
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
        //basicInformation.setSupplierId(formDatain.getSupplierId());
        basicInformation.setSupplier_Rep_Id(formDatain.getSupplier_Rep_Id());
        basicInformation.setSupplierRepresentative(formDatain.getSupplierRepresentative());
        basicInformation.setSupplierRepresentativeMobile(formDatain.getSupplierRepresentativeMobile());
        basicInformation.setSupplierRepresentativeEmail(formDatain.getSupplierRepresentativeEmail());





        return basicInformation;

    }
}
