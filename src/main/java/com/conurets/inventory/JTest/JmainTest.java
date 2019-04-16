package com.conurets.inventory.JTest;

import com.conurets.inventory.model.BasicInformation;
import com.conurets.inventory.model.BasicInfoxl;
import com.conurets.inventory.service.BasicInfoService;
import com.conurets.inventory.service.impl.BasicInfoServiceImpl;
import com.conurets.inventory.util.xlutil.Utilityxl;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Dost M. Soomro on 4/5/2019.
 */
public class JmainTest {
    static BasicInfoService basicInfoService = new BasicInfoServiceImpl();

    @Autowired
    static
    SimpleDateFormat simpleDateFormat;

    public static void main(String args[]){
        Utilityxl obj=new Utilityxl();
        List<BasicInfoxl> lst=obj.test();
        lst.forEach(s -> {
            BasicInformation basicInformation=new BasicInformation();

            //Date date=simpleDateFormat.parse(s.getDate_Item_Entered());
            Date date=new Date();
            basicInformation.setEntryDate(date);
            //basicInformation.se(s.getManufacturer());
            basicInformation.setQty(Integer.valueOf(s.getQty()));
            //basicInformation.setSerialNumber(s.getSerial_Number());
            //basicInformation.setItemId(Integer.valueOf(s.getItem_Id()));
            basicInfoService.save(basicInformation);

        });

        //basicInfoService.save();

    }
}
