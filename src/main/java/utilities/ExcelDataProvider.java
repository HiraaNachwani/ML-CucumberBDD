package utilities;
import constants.ExcelSheetConstants;

import java.util.HashMap;
import java.util.Map;
public class ExcelDataProvider {

    protected static Map<String, Map<String, Map<String, Object>>> excelDataMap;

    public static void loadExcelData() {
        // Load Excel data from all sheets and store it in the map
        excelDataMap = new HashMap<>();
        excelDataMap.put(ExcelSheetConstants.COMMON_PAGE, ExcelUtils.getMap(ExcelSheetConstants.COMMON_PAGE));
        excelDataMap.put(ExcelSheetConstants.DEALS_PAGE, ExcelUtils.getMap(ExcelSheetConstants.DEALS_PAGE));
        excelDataMap.put(ExcelSheetConstants.CHECKOUT_PAGE, ExcelUtils.getMap(ExcelSheetConstants.CHECKOUT_PAGE));
        // Add more sheets if needed
    }

    public static Map<String, Map<String, Map<String, Object>>> getExcelDataMap() {
        loadExcelData();
        return excelDataMap;
    }
}
