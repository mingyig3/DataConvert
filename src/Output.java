import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Output {
    public static void Run(ArrayList data, String OutputFilePath) throws IOException {
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet("simca筛选数据");
        int rowNumber = data.size();
        for (int row = 0; row < rowNumber; row++) {
            HSSFRow rows = sheet.createRow(row);
            ArrayList rowArray = (ArrayList) data.get(row);
            int columnNumber = rowArray.size();
            for (int col = 0; col < columnNumber; col++) {
                // 向工作表中添加数据
                try {
                    rows.createCell(col).setCellValue((double) rowArray.get(col));
                } catch (Exception e) {
                    rows.createCell(col).setCellValue((String) rowArray.get(col));
                }
            }
        }
        File xlsFile = new File(OutputFilePath);
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
    }
}
