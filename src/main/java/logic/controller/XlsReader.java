package logic.controller;

import org.apache.commons.math3.util.Precision;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    private XSSFWorkbook myWorkbook;

    private String date;
    private String accountFrom;

    public XlsReader(String path) throws IOException, InvalidFormatException {
        this.path = path;
        header = new ArrayList<>();

        xlsFile = new File(path);
        file = new FileInputStream(xlsFile);
        myWorkbook = new XSSFWorkbook(file);

    }


    public void fillTransactions(ArrayList<Transaction> transactions, String date, String accountFrom) {

        this.date = date;
        this.accountFrom = accountFrom;

        XSSFSheet mySheet = myWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();

        int i = 0;

        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            ArrayList<String> rowList = new ArrayList<>();

            while(cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                if(i == 0) {
                    header.add(cell.getStringCellValue());
                } else {
                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            rowList.add(cell.getStringCellValue().toString());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            Double value = cell.getNumericCellValue();
                            rowList.add(value.toString());
                            break;
                        default:
                            rowList.add("cannot-read");
                            break;
                    }
                }
            }
            if(i != 0) {
                transactions.add(rowListToTransaction(rowList));
            }
            i++;
        }
    }


    private Transaction rowListToTransaction(ArrayList<String> rowList) {
        int amountIndex = header.indexOf("eura");
        int ibanIndex = header.indexOf("IBAN");
        int ksIndex = header.indexOf("Konst.sym.");
        int vsIndex = header.indexOf("Var.sym.");
        int swiftIndex = header.indexOf("SWIFT");

        Double amount = Double.parseDouble(rowList.get(amountIndex));
        amount = Precision.round(amount, 2);

        Transaction transaction = new Transaction(
                amount.toString(),
                rowList.get(ibanIndex),
                rowList.get(ksIndex),
                rowList.get(vsIndex),
                rowList.get(swiftIndex)
        );
        transaction.setDate(date);
        transaction.setAccountFrom(accountFrom);

        return transaction;
    }

}
