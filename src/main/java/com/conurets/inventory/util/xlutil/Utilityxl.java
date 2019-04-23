package com.conurets.inventory.util.xlutil;

import com.conurets.inventory.model.BasicInfoxl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Dost M. Soomro on 4/5/2019.
 */
public class Utilityxl {

    public  List<BasicInfoxl> test(String filepath){


         DataFormatter dataFormatter = new DataFormatter();
        List<BasicInfoxl> lstBase=new ArrayList<>();
        BasicInfoxl basicInformation=null;
         Workbook workbook = null;
        int numRows=0;
        int numCols=0;

        try {
            workbook = WorkbookFactory.create(new File(filepath));
            Sheet sheet = workbook.getSheetAt(0);
             numRows = sheet.getLastRowNum()+1;
             numCols = sheet.getRow(0).getLastCellNum();
            String[][] excelData = new String[numRows][numCols];
            String value="";
            final boolean b=false;
            //System.out.println("Populating Array");
            for (int i=3; i<numRows; i++) {
                Row row = sheet.getRow(i);

                //System.out.println("bool: "+bool);

                for (int j=0; j<=numCols; j++) {
                    Cell cell = row.getCell(j);

                    // String cellValue = dataFormatter.formatCellValue(cell);
                    String cellValue="";
                    if(cell==null){

                    }else{
                         cellValue = chkCelType(cell);
                    }



                    //value = obj.cellToString(cellValue);
                    if(cellValue.isEmpty() ||cellValue.equals("")){

                    }else{
                        value = cellValue;
                        excelData[i][j] = value;
                    }





                }
            }

            /*
            Location	Venue	Product Category 	Item Id	Item Description	Serial Number	Manufacturer	"Date Item Entered
"	Item Entered By	User Company Name	Qty	Warranty	Warranty Expiration

             */
            for (int i=3; i<numRows; i++) {

                basicInformation=new BasicInfoxl();
                for (int j = 0; j <= numCols; j++) {


                    switch (j) {
                        case 0:
                            basicInformation.setLocation(excelData[i][j]);
                            break;
                        case 1:
                            basicInformation.setVenue(excelData[i][j]);
                            break;
                        case 2:
                            basicInformation.setProduct_category(excelData[i][j]);
                            break;
                        case 3:
                            basicInformation.setItem_Id(excelData[i][j]);
                            break;
                        case 4:
                            basicInformation.setItem_Description(excelData[i][j]);
                            break;
                        case 5:
                            basicInformation.setSerial_Number(excelData[i][j]);
                            break;
                        case 6:
                            basicInformation.setManufacturer(excelData[i][j]);
                            break;
                        case 7:
                            basicInformation.setDate_Item_Entered(excelData[i][j]);
                            break;
                        case 8:
                            basicInformation.setItem_Entered_By_User(excelData[i][j]);
                            break;
                        case 9:
                            basicInformation.setCompany_Name(excelData[i][j]);
                            break;
                        case 10:
                            basicInformation.setQty(excelData[i][j]);
                            break;
                        case 11:
                            basicInformation.setWarranty(excelData[i][j]);
                            break;
                        case 12:
                            basicInformation.setWarranty_Expiration(excelData[i][j]);
                            break;

                            //case 13:
//                            basicInformation.setWarranty_Expiration(excelData[i][j]);
//                            break;
                            case 14:
                            basicInformation.setStorageLocation(excelData[i][j]);
                            break;
                            case 15:
                            basicInformation.setStoredOnShelf(excelData[i][j]);
                            break;
                            case 16:
                            basicInformation.setShelfBayNo(excelData[i][j]);
                            break;
                            case 17:
                            basicInformation.setStoredInCabinet(excelData[i][j]);
                            break;
                            case 18:
                            basicInformation.setCabinetShelfNo(excelData[i][j]);
                            break;
//                            case 19:
//                            basicInformation.setCabinetShelfNo(excelData[i][j]);
//                            break;
                            case 20:
                            basicInformation.setSpecialHandlingRequired(excelData[i][j]);
                            break;
                            case 21:
                            basicInformation.setSpecialHandlingNotes(excelData[i][j]);
                            break;
                            case 22:
                            basicInformation.setApproxWeight(excelData[i][j]);
                            break;
//                            case 23:
//                            basicInformation.setApproxWeight(excelData[i][j]);
//                            break;

                            case 24:
                            basicInformation.setCalibrationRequired(excelData[i][j]);
                            break;
                            case 25:
                            basicInformation.setDateCalibrated(excelData[i][j]);
                            break;
                            case 26:
                            basicInformation.setValidityOfCalibration(excelData[i][j]);
                            break;
                            case 27:
                            basicInformation.setCalibrationDueDate(excelData[i][j]);
                            break;
//                            case 28:
//                            basicInformation.setCalibrationDueDate(excelData[i][j]);
//                            break;
                            case 29:
                            basicInformation.setUsed(excelData[i][j]);
                            break;
                            case 30:
                            basicInformation.setReconditioned(excelData[i][j]);
                            break;
                            case 31:
                            basicInformation.setUseable(excelData[i][j]);
                            break;
//                            case 32:
//                            basicInformation.setUseable(excelData[i][j]);
//                            break;
                            case 33:
                            basicInformation.setSupplier(excelData[i][j]);
                            break;
                            case 34:
                            basicInformation.setSupplierRepresentative(excelData[i][j]);
                            break;
                            case 35:
                            basicInformation.setSupplierRepresentativeMobile(excelData[i][j]);
                            break;
                            case 36:
                            basicInformation.setSupplierRepresentativeEmail(excelData[i][j]);
                            break;
//                            case 37:
//                            basicInformation.setSupplierRepresentativeEmail(excelData[i][j]);
//                            break;
                            case 38:
                            basicInformation.setDate(excelData[i][j]);
                            break;
                            case 39:
                            basicInformation.setTracking(excelData[i][j]);
                            break;
                            case 40:
                            basicInformation.setDateofRMA(excelData[i][j]);
                            break;
                            case 41:
                            basicInformation.setNotes(excelData[i][j]);
                            break;
//                            case 42:
//                            basicInformation.(excelData[i][j]);
//                            break;
                            case 43:
                            basicInformation.setComments(excelData[i][j]);
                            break;
//                            case 44:
//                            basicInformation.(excelData[i][j]);
//                            break; */

                    }




                }
                lstBase.add(basicInformation);

            }






        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return lstBase;
    }
    public static  <T> List<T> twoDArrayToList(T[][] twoDArray) {
        List<T> list = new ArrayList<T>();
        for (T[] array : twoDArray) {
            list.addAll(Arrays.asList(array));
        }
        return list;
    }


    private static void printCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }

        System.out.print("\t");
    }

    public static String chkCelType(Cell cell){
        String str="";

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                str = cell.toString().trim();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    //you should change this to your application date format
                    SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    str = objSimpleDateFormat.format(cell.getDateCellValue());
                } else {
                    int num = (int) cell.getNumericCellValue();
                    str = String.valueOf(num);
                }
                break;
            case Cell.CELL_TYPE_BLANK:
                str = "";
                break;
            case Cell.CELL_TYPE_ERROR:
                str = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                str = String.valueOf(cell.getBooleanCellValue());
                break;
        }
        return str;

    }


}
