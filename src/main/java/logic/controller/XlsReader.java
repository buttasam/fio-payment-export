package logic.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsReader {

    private String path;
    private List<String> header;

    private File xlsFile;
    private FileInputStream file;
    private Workbook myWorkbook;

    public XlsReader(String path) throws IOException, InvalidFormatException {
        this.path = path;
        header = new ArrayList<>();

        xlsFile = new File(path);
        file = new FileInputStream(xlsFile);
        myWorkbook = WorkbookFactory.create(file);

    }



    public void fillTransactions() {

        Sheet mySheet = myWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();

        int i = 0;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            ArrayList<String> rowList = new ArrayList<>();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                if(i == 0) {
                    header.add(cell.getStringCellValue());
                } else {
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            rowList.add(cell.getStringCellValue().toString());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            Double value = cell.getNumericCellValue();
                            rowList.add(value.toString());
                            break;
                        default :

                    }
                }


            }
            System.out.println(rowList);
            i++;
        }

        System.out.println(header + " " + header.indexOf("eura"));
    }



}
