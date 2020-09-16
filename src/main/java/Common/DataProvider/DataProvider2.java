package Common.DataProvider;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProvider2 {


    @DataProvider(name = "TESTDATA1")
    public static Object[][] getExcelData3() throws IOException {

        ReadExcel read = new ReadExcel();
        String[][] data3 = read.getCellData("/Users/mohammed/Desktop/iMohammed/EmpCountDep_V1.0/TestDataFiles/TestData.xlsx","TestData(valid)");
        for(int i = 0; i < data3.length; i++){
            for(int j = 0; j < data3[i].length; j++){
            }
        }
        return data3;

    }
    
    @DataProvider(name = "TESTDATA2")
    public static Object[][] getExcelData2() throws IOException {

        ReadExcel read = new ReadExcel();
        String[][] data2 = read.getCellData("/Users/mohammed/Desktop/iMohammed/EmpCountDep_V1.0/TestDataFiles/TestData.xlsx","TestData(Invalid)");
        for(int i = 0; i < data2.length; i++){
            for(int j = 0; j < data2[i].length; j++){
            }
        }
        return data2;

    }

    }

