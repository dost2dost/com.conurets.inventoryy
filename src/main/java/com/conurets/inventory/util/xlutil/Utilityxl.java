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

        try {
            workbook = WorkbookFactory.create(new File(filepath));
            Sheet sheet = workbook.getSheetAt(0);
            int numRows = sheet.getLastRowNum()+1;
            int numCols = sheet.getRow(0).getLastCellNum();
            String[][] excelData = new String[numRows][numCols];
            String value="";
            final boolean b=false;
            //System.out.println("Populating Array");
            for (int i=3; i<numRows; i++) {
                Row row = sheet.getRow(i);

                boolean bb=chkboolStatus(row);
                System.out.println("chk   : "+bb);





                //System.out.println("bool: "+bool);

                for (int j=0; j<=12; j++) {
                    Cell cell = row.getCell(j);

                    // String cellValue = dataFormatter.formatCellValue(cell);
                    String cellValue = chkCelType(cell);


                    //value = obj.cellToString(cellValue);
                    value = cellValue;


                    excelData[i][j] = value;

                }
            }

            /*
            Location	Venue	Product Category 	Item Id	Item Description	Serial Number	Manufacturer	"Date Item Entered
"	Item Entered By	User Company Name	Qty	Warranty	Warranty Expiration

             */
            for (int i=3; i<numRows; i++) {

                basicInformation=new BasicInfoxl();
                for (int j = 0; j <= 12; j++) {


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

    public boolean chkboolStatus(Row row){

        //System.out.println("row num :    "+row.getRowNum());
        boolean bool = false;
        //System.out.println("row num :    "+row.getRowNum()+"bool before   "+bool);
        for(Cell cell:row){



            if(cell.getColumnIndex()==0  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==1  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==2  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==3  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {

                 bool=true;
                break;
            }if(cell.getColumnIndex()==4  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==5  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==6  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==7  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {

                 bool=true;
                break;
            }if(cell.getColumnIndex()==8  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==9  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==10  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==11  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                 bool=true;
                break;
            }if(cell.getColumnIndex()==12  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    System.out.println("The cell contains a date value: " + cell.getDateCellValue()+"ronum"+cell.getRowIndex());
                }
                 bool=true;
                break;
            }
            //after 12
            if(cell.getColumnIndex()==13  && !cell.getCellTypeEnum().equals(CellType.STRING) && !cell.getCellTypeEnum().equals(CellType.BLANK)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==14  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==15  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==16  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==17  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==18 && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==19 && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==20  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==21 && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==22  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==23  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==24  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==25  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                bool=true;
                break;
            }
            //after 24
            if(cell.getColumnIndex()==26  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==27  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==28  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==29 && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==30  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==31 && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==32  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==33 && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==33  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==34  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==35  && !cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                bool=true;
                break;
            }if(cell.getColumnIndex()==36  && !cell.getCellTypeEnum().equals(CellType.STRING)) {
                bool=true;
                break;
            }

        }
        return bool;
    }
}
