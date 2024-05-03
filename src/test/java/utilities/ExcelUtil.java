package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelUtil {

    public List<Map<String, String>> getData(String excelPathName, String sheetName) throws EncryptedDocumentException, IOException {
        Sheet sheet=getsheetByName(excelPathName, sheetName);
        return readSheet(sheet);
    }

    private Sheet getsheetByName(String excelPathName, String sheetName) throws EncryptedDocumentException, IOException {
        Sheet sheet=getWorkBook(excelPathName).getSheet(sheetName);
        return sheet;
    }

    private Workbook getWorkBook(String excelPathName) throws EncryptedDocumentException, IOException {
        return WorkbookFactory.create(new File(excelPathName));

    }

    private List<Map<String, String>> readSheet(Sheet sheet) {


        List<Map<String,String>> dataSet=new ArrayList<Map<String,String>>();

        int totalRows=sheet.getLastRowNum();
        for (int currentRow=1; currentRow<=totalRows; currentRow++) {
            Row row=sheet.getRow(currentRow);
            Map<String,String> rowValues = getRowCellValues(sheet, row);
            dataSet.add(rowValues);
        }
        return dataSet;
    }

    private int getHeaderRowNumber(Sheet sheet) {

        int firstRowNum=sheet.getFirstRowNum();
        return firstRowNum;

    }

    private Map<String,String> getRowCellValues(Sheet sheet, Row row){

        int headerRowIndex=getHeaderRowNumber(sheet);
        int totalColumns = sheet.getRow(headerRowIndex).getLastCellNum();
        Map<String,String> rowMap=new HashMap<String,String>();
        for(int currentColumn=0;currentColumn<totalColumns;currentColumn++) {
            if(row == null) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
                rowMap.put(columnHeaderName, "");

            }
            else {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
                Cell cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if(cell.getCellType() == CellType.STRING) {
                    rowMap.put(columnHeaderName, cell.getStringCellValue());
                }
                else if(cell.getCellType() == CellType.NUMERIC){
                    rowMap.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
                else if(cell.getCellType() == CellType.BLANK  ) {
                    rowMap.put(columnHeaderName, "");
                }
                else if(cell.getCellType() == CellType.BOOLEAN ) {
                    rowMap.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
                else if(cell.getCellType() == CellType.ERROR ) {
                    rowMap.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return rowMap;

    }

}
