import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

public class Import {
    private ArrayList data = new ArrayList();
    public void Run(String pathname) throws IOException, InvalidFormatException {
        File xlsFile = new File(pathname);
        // 获得工作簿
        Workbook workbook = WorkbookFactory.create(xlsFile);
        // 获得工作表个数
        int sheetCount = workbook.getNumberOfSheets();
        // 遍历工作表
        for (int i = 0; i < sheetCount; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            // 获得行数
            int rows = sheet.getLastRowNum() + 1;
            // 获得列数，先获得一行，在得到改行列数
            Row tmp = sheet.getRow(0);
            if (tmp == null)
            {
                continue;
            }
            int cols = tmp.getPhysicalNumberOfCells();
            // 读取数据
            for (int row = 0; row < rows; row++) {
                ArrayList ArrayRow = new ArrayList();
                Row r = sheet.getRow(row);
                for (int col = 0; col < cols; col++) {
                    if (r.getCell(col).getCellTypeEnum().equals(CellType.NUMERIC)) {
                        ArrayRow.add(r.getCell(col).getNumericCellValue());
                    } else if (r.getCell(col).getCellTypeEnum().equals(CellType.STRING)) {
                        ArrayRow.add(r.getCell(col).getStringCellValue());
                    }
                }
                data.add(ArrayRow);
            }
        }
    }
    public ArrayList getData() {
        return data;
    }
}