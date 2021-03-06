package com.conurets.inventory.converter;

import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.BasicInformation;
import com.conurets.inventory.entity.Item;
import com.conurets.inventory.exception.InventoryException;
import com.conurets.inventory.model.FormDatain;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.BasicInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.DateUtils;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

/**
 * Created by Iraj on 03/20/19.
 */
@Component
public class BasicInfoConverter {

    private static final Logger logger = LoggerFactory.getLogger(BasicInfoConverter.class);

    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private DAOFactory daoFactory;

    public BasicInformation fromControllerXl(com.conurets.inventory.model.BasicInformation model) throws InventoryException, ParseException {

        BasicInformation entity = new BasicInformation();

        entity=daoFactory.getBasicInfoDAO().findById(58);

        entity.setEntryDate(model.getEntryDate()) ;
        entity.setUserId(daoFactory.getUserDAO().findById(model.getUserId()));
        entity.setLocationId(daoFactory.getLocationDAO().findById(model.getLocationId()));
        entity.setCompanyId(daoFactory.getCompanyDAO().findById(model.getCompanyId()));
        //entity.setItem(daoFactory.getItemDAO().findById(model.getItemId()));
        entity.setSerialNumber(model.getSerialNo());
        entity.setQty(model.getQty());
        entity.setWarranty(model.getWarranty());
        entity.setStoredOnShelf(model.getStorageOnShelf());
        entity.setShelfBayNumber(Integer.valueOf(model.getShelfByNo()));
        entity.setStoredInCabinet(model.getStoredInCabnet());
        entity.setCabinetShelfNo(Integer.valueOf(model.getCabnetShelfNo()));
        //Caliberation
        entity.setCalibratedDate(simpleDateFormat.parse(model.getCalibratedDate()));
        entity.setCaliberation_Required(model.getCalibrationRequired());
        entity.setValidityOfCalibration(simpleDateFormat.parse(model.getCalibrationValidity()));
        entity.setCalibrationDueDate(simpleDateFormat.parse(model.getCalibrationDueDate()));
        entity.setItemStorageLocation(model.getStorageLocation());
        //item handling
        entity.setSpecialHandlingNotes(model.getSpecialHandlingNotes());
        entity.setApproxWeight(Integer.valueOf(model.getApproxWeight()));
        entity.setSpecialHandlingRequired(model.getSpcialHandlinReq());
        entity.setItemCondition(model.getItemCondition());
        //entity.set(model.getItemReconditioned());
        //Supplier info
        //entity.setSupplierId(model.getSupplierId());
        entity.setSupplier_Rep_Id(model.getSupplier_Rep_Id());


        entity.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setCreatedDate(InventoryUtil.currentDateTime());
        entity.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setLastUpdate(InventoryUtil.currentDateTime());

        return entity;
    }

    public BasicInformation fromControllerupdate(com.conurets.inventory.model.BasicInformation model) throws InventoryException, ParseException {

        BasicInformation entity = new BasicInformation();

        entity=daoFactory.getBasicInfoDAO().findById(model.getId());

        entity.setEntryDate(model.getEntryDate()) ;
        entity.setUserId(daoFactory.getUserDAO().findById(model.getUserId()));
        entity.setLocationId(daoFactory.getLocationDAO().findById(model.getLocationId()));
        entity.setCompanyId(daoFactory.getCompanyDAO().findById(model.getCompanyId()));
        //entity.setItem(daoFactory.getItemDAO().findById(model.getItemId()));
        entity.setSerialNumber(model.getSerialNo());
        entity.setQty(model.getQty());
        entity.setWarranty(model.getWarranty());
        entity.setStoredOnShelf(model.getStorageOnShelf());
        entity.setShelfBayNumber(Integer.valueOf(model.getShelfByNo()));
        entity.setStoredInCabinet(model.getStoredInCabnet());
        entity.setCabinetShelfNo(Integer.valueOf(model.getCabnetShelfNo()));
        //Caliberation
        entity.setCalibratedDate(simpleDateFormat.parse(model.getCalibratedDate()));
        entity.setCaliberation_Required(model.getCalibrationRequired());
        entity.setValidityOfCalibration(simpleDateFormat.parse(model.getCalibrationValidity()));
        entity.setCalibrationDueDate(simpleDateFormat.parse(model.getCalibrationDueDate()));
        entity.setItemStorageLocation(model.getStorageLocation());
        //item handling
        entity.setSpecialHandlingNotes(model.getSpecialHandlingNotes());
        entity.setApproxWeight(Integer.valueOf(model.getApproxWeight()));
        entity.setSpecialHandlingRequired(model.getSpcialHandlinReq());
        entity.setItemCondition(model.getItemCondition());
        //entity.set(model.getItemReconditioned());
        //Supplier info
        //entity.setSupplierId(model.getSupplierId());
        entity.setSupplier_Rep_Id(model.getSupplier_Rep_Id());


        entity.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setCreatedDate(InventoryUtil.currentDateTime());
        entity.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setLastUpdate(InventoryUtil.currentDateTime());

        return entity;
    }

    public BasicInformation fromController(com.conurets.inventory.model.BasicInformation model) throws InventoryException, ParseException {


//        Item item=new Item();
//        item.setItemDescription(model.getItemDescription());
//        item.setActive(true);
//        item.setCalibrationRequired(false);
//        item.setManufacturer(model.getManufacturer());
//        item.setCreatedBy(Long.valueOf(1));

        BasicInformation entity = new BasicInformation();


            //entity=daoFactory.getBasicInfoDAO().findById(58);

        entity.setEntryDate(model.getEntryDate()) ;
        entity.setUserId(daoFactory.getUserDAO().findById(model.getUserId()));
        entity.setLocationId(daoFactory.getLocationDAO().findById(model.getLocationId()));
        entity.setCompanyId(daoFactory.getCompanyDAO().findById(model.getCompanyId()));
       // entity.setItem(daoFactory.getItemDAO().findById(model.getItemId()));
       // entity.setItem(item);
        entity.setItem(model.getItem());
        entity.setSerialNumber(model.getSerialNo());
        entity.setQty(model.getQty());
        entity.setWarranty(model.getWarranty());
        entity.setStoredOnShelf(model.getStorageOnShelf());
        entity.setShelfBayNumber(Integer.valueOf(model.getShelfByNo()));
        entity.setStoredInCabinet(model.getStoredInCabnet());
        entity.setCabinetShelfNo(Integer.valueOf(model.getCabnetShelfNo()));
        //Caliberation
        if(model.getCalibratedDate()==null||model.getCalibratedDate().equals("")){

        }else {
            entity.setCalibratedDate(simpleDateFormat.parse(model.getCalibratedDate()));
        }
        entity.setCaliberation_Required(model.getCalibrationRequired());
        if(model.getCalibrationValidity()==null || model.getCalibrationValidity().equals("")){

        }else {
            entity.setValidityOfCalibration(simpleDateFormat.parse(model.getCalibrationValidity()));
        }
        if(model.getCalibrationDueDate()==null || model.getCalibrationDueDate().equals("")){

        }else {
            entity.setCalibrationDueDate(simpleDateFormat.parse(model.getCalibrationDueDate()));
        }
        entity.setItemStorageLocation(model.getStorageLocation());
        //item handling
        entity.setSpecialHandlingNotes(model.getSpecialHandlingNotes());
        entity.setApproxWeight(Integer.valueOf(model.getApproxWeight()));
        entity.setSpecialHandlingRequired(model.getSpcialHandlinReq());
        entity.setItemCondition(model.getItemCondition());
        //entity.set(model.getItemReconditioned());
        //Supplier info
       // entity.setSupplierId(model.getSupplierId());
        entity.setSupplier_Rep_Id(model.getSupplier_Rep_Id());


        entity.setCreatedBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setCreatedDate(InventoryUtil.currentDateTime());
        entity.setLastUpdateBy(InventoryConstants.DEFAULT_CREATED_BY);
        entity.setLastUpdate(InventoryUtil.currentDateTime());

//        Item item=new Item();
//        item.setManufacturer(model.getManufacturer());
//        item.setCalibrationRequired(false);
//        item.setActive(true);
//        item.setCreatedBy(Long.valueOf(1));
//        item.setItemDescription(model.getItemDescription());
//
//        entity.setItem(item);


        return entity;
    }

    public List<BasicInfoVO> toReportController(List<BasicInformation> entity) throws InventoryException {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        List<BasicInfoVO> basicInfoVOList = null;

        if(entity!=null){

            basicInfoVOList = new ArrayList<>();

            for(int i=0; i<entity.size();i++){

                BasicInfoVO basicVO = new BasicInfoVO();


                basicVO.setEntryDate(entity.get(i).getEntryDate());
                basicVO.setUserName(daoFactory.getUserDAO().findById(entity.get(i).getUserId().getUserId()).getUsername());
                basicVO.setUserId(entity.get(i).getUserId().getUserId());
                basicVO.setLocationName(daoFactory.getLocationDAO().findById(entity.get(i).getLocationId().getLoginUserId()).getLocation()) ;
                basicVO.setLocationId(entity.get(i).getLocationId().getLoginUserId());
                basicVO.setCompanyName(daoFactory.getCompanyDAO().findById(entity.get(i).getCompanyId().getCompanyId()).getCompany());
                basicVO.setCompanyId(entity.get(i).getCompanyId().getCompanyId());
                basicVO.setItemName(daoFactory.getItemDAO().findById(entity.get(i).getItem().getItemId()).getItemDescription()) ;
                basicVO.setItemId(daoFactory.getItemDAO().findById(entity.get(i).getItem().getItemId()).getItemId());

                basicVO.setSerialNumber(entity.get(i).getSerialNumber());
                basicVO.setQty(entity.get(i).getQty());
                basicVO.setApproxWeight(String.valueOf(entity.get(i).getApproxWeight()));
                basicVO.setCabnetShelfNo(String.valueOf(entity.get(i).getCabinetShelfNo()));
                basicVO.setCalibratedDate(String.valueOf(entity.get(i).getCalibratedDate()));
                basicVO.setCalibrationDueDate(String.valueOf(entity.get(i).getCalibrationDueDate()));
                basicVO.setCalibrationValidity(String.valueOf(entity.get(i).getValidityOfCalibration()));
                basicVO.setItemCondition(String.valueOf(entity.get(i).getItemCondition()));


                basicVO.setStorageLocation(String.valueOf(entity.get(i).getItemStorageLocation()));
                basicVO.setStorageOnShelf(String.valueOf(entity.get(i).getStoredOnShelf()));
                basicVO.setShelfByNo(String.valueOf(entity.get(i).getShelfBayNumber()));
                basicVO.setStoredInCabnet(String.valueOf(entity.get(i).getStoredInCabinet()));
                basicVO.setSpcialHandlinReq(String.valueOf(entity.get(i).getSpecialHandlingRequired()));
                basicVO.setSpecialHandlingNotes(String.valueOf(entity.get(i).getSpecialHandlingNotes()));
                basicVO.setCalibrationRequired(String.valueOf(entity.get(i).getCaliberation_Required()));

                //supplier information
                if(entity.get(i).getSupplierInformation()!=null){
                    basicVO.setSupplierName(String.valueOf(entity.get(i).getSupplierInformation().getSupplier()));
                    basicVO.setSupplierRepresentative(String.valueOf(entity.get(i).getSupplierInformation().getRepresentative()));
                    basicVO.setSupplierRepresentativeMobile(String.valueOf(entity.get(i).getSupplierInformation().getMobile()));
                    basicVO.setSupplierRepresentativeEmail(String.valueOf(entity.get(i).getSupplierInformation().getEmail()));
                    basicVO.setWarranty_Expiration(entity.get(i).getWarranty_Expiration());
                }


                basicInfoVOList.add(basicVO);
            }


        }

        return basicInfoVOList;
    }

    public FormDatain toEditForm(BasicInformation entity) {

        FormDatain basicVO = null;

        if (entity != null) {


             basicVO = new FormDatain();

             try{
                 String entryDate=simpleDateFormat.format(entity.getEntryDate());
                 String validityofCaliberation=simpleDateFormat.format(entity.getValidityOfCalibration());
                 String caliberationduedate=simpleDateFormat.format(entity.getCalibrationDueDate());
                 String caliberatedDate=simpleDateFormat.format(entity.getCalibratedDate());


                 basicVO.setEntryDate(entryDate);
                 basicVO.setCalibrationValidity(validityofCaliberation);
                 basicVO.setCalibratedDate(validityofCaliberation);
                 basicVO.setCalibrationDueDate(caliberationduedate);
                 basicVO.setCalibratedDate(caliberatedDate);
                 basicVO.setId(entity.getBasicInformationId());
                 basicVO.setItemDescription(entity.getItem().getItemDescription());
                 basicVO.setItemCode(entity.getItem().getItemCode());


             }catch (Exception ex){
                 ex.printStackTrace();
             }

            basicVO.setUserName(daoFactory.getUserDAO().findById(entity.getUserId().getUserId()).getUsername());
            //basicVO.setLocation(daoFactory.getLocationDAO().findById(entity.getLocationId().getLoginUserId()).getLocation());
            basicVO.setLocationId(1);
            basicVO.setCompany(daoFactory.getCompanyDAO().findById(entity.getCompanyId().getCompanyId()).getCompany());
            //basicVO.setItem_description(daoFactory.getItemDAO().findById(entity.getItem().getItemId()).getItemDescription());
            basicVO.setItemId(daoFactory.getItemDAO().findById(entity.getItem().getItemId()).getItemId());
            basicVO.setSerialNo(entity.getSerialNumber());
            basicVO.setQty(Integer.valueOf(String.valueOf(entity.getQty())));
            basicVO.setApproxWeight(String.valueOf(entity.getApproxWeight()));
            basicVO.setCabnetShelfNo(entity.getCabinetShelfNo());
            //basicVO.setCalibratedDate(String.valueOf(entity.getCalibratedDate()));
            //basicVO.setCalibrationRequired(entity.getCalibrationDueDate());
            //basicVO.setCalibrationValidity(String.valueOf(entity.getValidityOfCalibration()));

            //basicVO.setCalibrationDueDate(String.valueOf(entity.getCalibrationDueDate()));
            basicVO.setShelfByNo(entity.getShelfBayNumber());
            basicVO.setStorageOnShelf(entity.getStoredOnShelf());
            basicVO.setCabnetShelfNo(Integer.valueOf(entity.getCabinetShelfNo()));
            basicVO.setStorageLocation(entity.getItemStorageLocation());
            basicVO.setSpcialHandlinReq(entity.getSpecialHandlingRequired());
            basicVO.setSpecialHandlingNotes(entity.getSpecialHandlingNotes());
            basicVO.setStorageLocation(entity.getItemStorageLocation());
            basicVO.setWarranty(entity.getWarranty());
            basicVO.setStoredInCabnet(entity.getStoredInCabinet());
            basicVO.setSpecialHandlingNotes(entity.getSpecialHandlingNotes());
            basicVO.setSpcialHandlinReq(entity.getSpecialHandlingRequired());
            basicVO.setCalibrationRequired(entity.getCaliberation_Required());




        }
        return basicVO;
    }
}
