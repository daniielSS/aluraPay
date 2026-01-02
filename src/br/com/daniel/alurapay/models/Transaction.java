package br.com.daniel.alurapay.models;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Transaction {

    private String purchaseDate;
    private String purchaseDescription;
    private double purchaseValue;
    
    @Override
    public String toString() {
        return  purchaseDate + " | " +
                purchaseDescription + " | " +
                "R$ " + purchaseValue;
    }

    public List<Transaction> saveTransaction(String description, double value, List<Transaction> listTransactions, Transaction transaction) {
        if (listTransactions != null && transaction != null) {
            if (!description.isEmpty() || value != 0) {
                transaction = new Transaction();
                Calendar calendar = Calendar.getInstance();
                Date data = calendar.getTime();
                DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DATE_FIELD);

                transaction.purchaseDate = dateFormat.format(data);
                transaction.purchaseDescription = description;
                transaction.purchaseValue = value;

                listTransactions.add(transaction);
                System.out.println("Transação Aprovada com sucesso!");
            }
        }
        return listTransactions;
    }
}