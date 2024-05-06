package util;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import com.spire.xls.CellRange;
import com.spire.xls.CellStyle;
import com.spire.xls.HorizontalAlignType;
import com.spire.xls.LineStyleType;
import com.spire.xls.VerticalAlignType;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class CopyExcelData {
    
    public void copyExcel(String pathForReport, String WorkBookName , String SheetName, String LobName) throws Exception {
        
        File pathForReportfile = new File(pathForReport);
         Workbook srcWorkbook = new Workbook();
            srcWorkbook.loadFromFile(WorkBookName);
            
            //Get the specific worksheet to copy
            Worksheet originalSheet = srcWorkbook.getWorksheets().get(SheetName);

            //Create another Workbook object to load the destination document
            Workbook destWorkbook = new Workbook();
            destWorkbook.loadFromFile(pathForReportfile+"\\"+LobName.concat("_")+ConfigReader.getInstance().getValue("ExcelReport")+".xlsx");
            
            Worksheet newSheet = destWorkbook.getWorksheets().addCopy(originalSheet);
            newSheet.setName(SheetName);
            
            destWorkbook.copyTheme(srcWorkbook);
            //Save to another file
            destWorkbook.saveToFile(pathForReportfile+"\\"+LobName.concat("_")+ConfigReader.getInstance().getValue("ExcelReport")+".xlsx");
    }

    
        public void AssertExecutionReport(String pathForReport, ArrayList allReportValue,String ScanerioType, String lobName) throws Exception {
            
              ArrayList FinalValue= new ArrayList<>();
              FinalValue  =  allReportValue;
              
              Workbook workbook = new Workbook();
              workbook.loadFromFile(pathForReport+"\\"+lobName.concat("_")+ConfigReader.getInstance().getValue("ExcelReport")+".xlsx");
                
              Worksheet sheet = workbook.createEmptySheet("Execution Summary Report");

                CellStyle style = workbook.getStyles().addStyle("style");
                style.getFont().setColor(Color.black);
                style.getFont().setSize(15);
                style.getFont().isBold(true);
                style.setColor(Color.cyan);
                style.setHorizontalAlignment(HorizontalAlignType.Center);
                style.setVerticalAlignment(VerticalAlignType.Center);

                CellStyle style1 = workbook.getStyles().addStyle("style1");
                style1.getFont().setColor(Color.black);
                style1.getFont().setSize(12);
                style1.getFont().isBold(true);
                style1.setColor(Color.white);
                style1.setHorizontalAlignment(HorizontalAlignType.Center);
                style1.setVerticalAlignment(VerticalAlignType.Center);

                CellStyle style2 = workbook.getStyles().addStyle("style2");
                style2.getFont().setSize(10f);
                style2.getFont().setColor(Color.BLACK);
                style2.setHorizontalAlignment(HorizontalAlignType.Center);
                style2.setVerticalAlignment(VerticalAlignType.Center);

                ArrayList<Object> headerValue = new ArrayList<>();
                headerValue.add("Sr no");
                headerValue.add("Total Scenarios");                
                headerValue.add("Passed Scenarios");
                headerValue.add("Failed Scenarios");
                headerValue.add("Total Verification Point");
                headerValue.add("Passed Verification Point");
                headerValue.add("Failed Verification Point");
                headerValue.add("Run Time Verification Point");
                headerValue.add("Not Executed Verification Point");
                headerValue.add("Total Execution Time");
                
                sheet.getRange().get("A1:J1").merge();
                sheet.get(sheet.getCellRange(1,1).getRangeAddress()).setValue("Automation Execution Report For "+ScanerioType);
                sheet.get(sheet.getCellRange(1,1).getRangeAddress()).setCellStyleName(style.getName());
                // sheet.get("A1").setColumnWidth(20);
                sheet.get(sheet.getCellRange(1, 1).getRangeAddress()).setRowHeight(30);
                sheet.getRange().get(sheet.getCellRange(1, headerValue.size()).getRangeAddress())
                        .borderAround(LineStyleType.Thin, Color.black);

                for (int i = 0; i < headerValue.size(); i++) {
                    CellRange TotalScenarios = sheet.getCellRange(2, i + 1);

                    switch (headerValue.get(i).toString().trim()) {
                    case "Passed Scenarios":
                        style1.setColor(Color.green);
                        break;
                    case "Failed Scenarios":
                        style1.setColor(Color.red);
                        break;
                    case "Passed Verification Point":
                        style1.setColor(Color.GREEN);
                        break;
                    case "Failed Verification Point":
                        style1.setColor(Color.orange);
                        break;
                    default:
                        style1.setColor(Color.white);
                        break;
                    }

                    TotalScenarios.setValue(headerValue.get(i).toString());
                    TotalScenarios.setCellStyleName(style1.getName());
                    TotalScenarios.setColumnWidth(23);
                    sheet.getRange().get(TotalScenarios.getRangeAddress()).borderAround(LineStyleType.Thin, Color.black);
                }

                for (int i = 3; i < 4; i++) {
                    for (int j = 1; j <= FinalValue.size(); j++) {
                        CellRange cell = sheet.getCellRange(i, j);
                        cell.setValue(FinalValue.get(j - 1).toString());
                        cell.setCellStyleName(style2.getName());
                        sheet.getRange().get(cell.getRangeAddress()).borderAround(LineStyleType.Thin, Color.black);
                    }
                }
           
                //Save the resultant file
                workbook.saveToFile(pathForReport+"\\"+lobName.concat("_")+ConfigReader.getInstance().getValue("ExcelReport")+".xlsx");
                System.out.println("Done Done Done");
        }

}
