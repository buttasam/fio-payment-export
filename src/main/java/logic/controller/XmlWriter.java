package logic.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class XmlWriter {


    public void writeTransactions(ArrayList<Transaction> transactions) {


        try(BufferedWriter bw = new BufferedWriter(new FileWriter("export.xml"))) {
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            bw.newLine();
            bw.write("<Import xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                    "xsi:noNamespaceSchemaLocation=\"http://www.fio.cz/schema/importIB.xsd\">");
            bw.newLine();
            bw.write("<Orders>");
            bw.newLine();

            for(Transaction transaction : transactions) {
                bw.write("<T2Transaction>");
                bw.newLine();
                bw.write(transaction.xmlString());
                bw.newLine();
                bw.write("</T2Transaction>");
                bw.newLine();
            }

            bw.write("</Orders>");
            bw.newLine();
            bw.write("</Import>");
            bw.newLine();
            bw.flush();
        } catch(Exception e) {
            System.err.println("Do souboru se nepovedlo zapsat.");
        }

    }

}
