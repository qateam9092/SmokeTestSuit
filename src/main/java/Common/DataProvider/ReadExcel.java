package Common.DataProvider;

import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public  String[][] getCellData(String path, String sheetName) throws InvalidFormatException, IOException {
        try {
            FileInputStream stream = new FileInputStream(path);
            XSSFWorkbook workbook = (XSSFWorkbook) XSSFWorkbookFactory.create(stream);
            XSSFSheet s = workbook.getSheet(sheetName);
            int rowcount = s.getLastRowNum();
            int cellcount = s.getRow(1).getLastCellNum();
            String data[][] = new String[rowcount][cellcount];
            for (int i = 1; i <= rowcount; i++) {
                XSSFRow r = s.getRow(i);
                for (int j = 0; j < cellcount; j++) {
                    XSSFCell Cell = r.getCell(j);
                    int w = i - 1;
                    data[w][j] = Cell.toString();
                }
            }
            return data;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
