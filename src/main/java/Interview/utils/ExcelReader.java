package Interview.utils;

import groovy.util.logging.Log4j2;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;

@Log4j2
public class ExcelReader {

    public HashMap<String, BigInteger> readExcel(){
        try {
            FileInputStream fis = new FileInputStream(new File(getClass().getClassLoader().getResource("numbers.xlsx").getFile()));
//creating workbook instance that refers to .xls file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
//creating a Sheet object to retrieve the object
            XSSFSheet sheet = wb.getSheetAt(0);

            HashMap<String, BigInteger> retMap = new HashMap<>();
            for (Row row : sheet)     //iteration over row using for each loop
            {
                if(row.getCell(0).getStringCellValue() == null || row.getCell(0).getStringCellValue().trim().equals("") ){
                    break;
                }
                String val = row.getCell(0).getStringCellValue();
                BigInteger bInt = new BigInteger(row.getCell(1).getStringCellValue());
                retMap.put(val,bInt);
            }
            return retMap;
        }
        catch (FileNotFoundException e){

        }
        catch (IOException e){

        }
        return null;
    }
}

