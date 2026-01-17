package br.com.daniel.alurapay.models;

public class CreditCard {

    private String cardNumber;
    private String firstName;
    private String sunName;
    private String expirationDate;
    private String cvv;
    private double creditLimit;

    public CreditCard(String cardNumber, String firstName, String sunName, String expirationDate, String cvv, double creditLimit) {
        this.cardNumber = cardNumber;
        this.firstName = firstName;
        this.sunName = sunName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit + 0.01;
    }

    public void deductCreditLimit(double value) {
        this.creditLimit = creditLimit - value;
    }
}