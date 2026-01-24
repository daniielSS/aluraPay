package br.com.daniel.alurapay.models;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Transaction implements Comparable<Transaction> {

    private String purchaseDate;
    private String purchaseDescription;
    private double purchaseValue;

    @Override
    public String toString() {
        return  purchaseDate + " | " +
                purchaseDescription + " | " +
                "R$ " + purchaseValue;
    }

    public Transaction saveTransaction(String description, double value, CreditCard creditCard) {
        Transaction transaction = new Transaction();

        if (!description.isEmpty() || value != 0) {
            if (value <= creditCard.getCreditLimit()) {
                Calendar calendar = Calendar.getInstance();
                Date data = calendar.getTime();
                DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DATE_FIELD);

                transaction.purchaseDate = dateFormat.format(data);
                transaction.purchaseDescription = description;
                transaction.purchaseValue = value;

                creditCard.deductCreditLimit(transaction.purchaseValue);
                System.out.println("Transação Aprovada com sucesso!");
            } else {
                System.err.println("Limite Insuficiente para essa compra!");
            }
        }
        return transaction;
    }

    @Override
    public int compareTo(Transaction transaction) {

        if (purchaseValue < transaction.purchaseValue) {
            return 1;
        } else if (purchaseValue > transaction.purchaseValue) {
            return -1;
        }
        return 0;
    }
}