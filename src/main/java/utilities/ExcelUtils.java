package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    // Method to read an Excel sheet and return data as a map of maps
    public static Map<String, Map<String, Object>> readExcelSheet(String sheetName) {
        // Create a map to store the data
        Map<String, Map<String, Object>> dataMap = new HashMap<>();
        // Provide the path to your Excel file
        String filePath = System.getProperty("user.dir") + "/src/test/resources/TestDataSheet.xlsx";
        try (FileInputStream inputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            // Get the specified sheet from the workbook
            XSSFSheet sheet = workbook.getSheet(sheetName);
            // Check if the sheet exists
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' does not exist.");
            }

            // Iterate through each row in the sheet
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                // Get the current row
                XSSFRow row = sheet.getRow(i);
                if (row != null) {
                    // Get the value in the first column (row header)
                    String rowHeader = row.getCell(0).getStringCellValue();
                    // Create a map to store the data for the current row
                    Map<String, Object> rowData = new HashMap<>();
                    // Iterate through each cell in the row
                    for (int j = 1; j < row.getLastCellNum(); j++) {
                        // Get the current cell
                        XSSFCell cell = row.getCell(j);
                        // Get the value in the first row (column header)
                        String columnHeader = sheet.getRow(0).getCell(j).getStringCellValue();
                        // Get the cell value using the helper method
                        Object cellValue = getCellValue(cell);
                        // Put the cell value in the inner map
                        rowData.put(columnHeader, cellValue);
                    }
                    // Put the inner map in the outer map using the row header as the key
                    dataMap.put(rowHeader, rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the map containing all the data
        return dataMap;
    }

    // Helper method to get the value of a cell
    private static Object getCellValue(XSSFCell cell) {
        // Check if the cell is null
        if (cell == null) {
            return null;
        }
        // Get the type of the cell
        CellType cellType = cell.getCellType();
        // Determine the type of the cell and return the appropriate value
        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                    return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case ERROR:
                return cell.getErrorCellValue();
            default:
                return null;
        }
    }

    // Main method for testing
    public static Map<String, Map<String, Object>> getMap(String sheetName) {
        // Read the Excel sheet and store the data in a map
       return readExcelSheet(sheetName);
    }
}
