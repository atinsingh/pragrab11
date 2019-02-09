package co.pragra.b10.framework.testdata;

import co.pragra.b10.framework.config.DriverConfig;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelReader {
    // Read the excel and prepare the dataProvider
    private String dataFileName = DriverConfig.getProperty("testDataFileName");
    private Path path = Paths.get(DriverConfig.getProperty("testDataFileLocation"));

    private static Workbook workbook;

    public ExcelReader(){
        try {
            FileInputStream inputStream = new FileInputStream(path+"/"+dataFileName);
            workbook = new XSSFWorkbook(inputStream);

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    @DataProvider
    public static Iterator<Object []> excelData(){
        if(workbook == null){
            new ExcelReader();
        }
        List<Object[]> data = new ArrayList<>();
        Sheet contactUsSheet = workbook.getSheet("ContactUs");
        Iterator<Row> rows = contactUsSheet.rowIterator();
        rows.next(); // Advance the iteroator to remove the header
        while(rows.hasNext()){
            Row row = rows.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            List<Object> cells = new ArrayList<>();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(cell.getCellTypeEnum()==CellType.NUMERIC){
                   cells.add(cell.getNumericCellValue());
                }
                if(cell.getCellTypeEnum()==CellType.STRING){
                    cells.add(cell.getStringCellValue());
                }
                if(cell.getCellTypeEnum()==CellType.BOOLEAN){
                    cells.add(cell.getBooleanCellValue());
                }

            }
            data.add(cells.toArray());

        }
        return data.iterator();
    }
}
