package logic.controller;

public class Transaction {

    private String amount;
    private String iban;
    private String ks;
    private String vs;
    private String swift;

    private String accountFrom;
    private static final String currency = "EUR";
    private String date;
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

    public Transaction(String amount, String iban, String ks, String vs, String swift) {
        this.amount = amount;
        this.iban = iban;
        this.ks = ks;
        this.vs = vs;
        this.swift = swift;
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

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public void setDate(String date) {
        this.date = date;
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
