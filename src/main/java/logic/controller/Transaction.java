package logic.controller;

public class Transaction {

    private String amount;
    private String iban;
    private String ks;
    private String vs;
    private String swift;

    private static final String accountFrom = "2600927896";
    private static final String currency = "EUR";
    private static final String date = "2016-06-13";
    private static final String paymentType = "431008";

    public Transaction(String[] data) {
        this.amount = data[0];
        this.iban = data[1];
        this.ks = data[2];
        this.vs = data[3];
        this.swift = data[4];
    }

    public Transaction() {
    }

    public String getAmount() {
        return amount;
    }

    public String getIban() {
        return iban;
    }

    public String getKs() {
        return ks;
    }

    public String getVs() {
        return vs;
    }

    public String getSwift() {
        return swift;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount='" + amount + '\'' +
                ", iban='" + iban + '\'' +
                ", ks='" + ks + '\'' +
                ", vs='" + vs + '\'' +
                ", swift='" + swift + '\'' +
                '}';
    }

    public String xmlString() {

        String result = "<accountFrom>" + accountFrom + "</accountFrom>\n" +
                "<currency>" + currency + "</currency>\n" +
                "<amount>" + amount.replace(",", ".") + "</amount>\n" +
                "<accountTo>" + iban + "</accountTo>\n" +
                "<ks>" + ks + "</ks>\n" +
                "<vs>" + vs + "</vs>\n" +
                "<date>" + date + "</date>\n" +
                "<comment>" + "</comment>\n" +
                "<benefName>" + "</benefName>\n" +
                "<paymentType>" + paymentType + "</paymentType>";

        return result;
    }
}
