package br.com.daniel.alurapay;

import br.com.daniel.alurapay.models.CreditCard;
import br.com.daniel.alurapay.models.Transaction;

import java.lang.invoke.CallSite;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        CreditCard creditCard = new CreditCard("5127 8108 7729 7191", "Daniel", "Silva", "30-03-2027", "692", 8000.0);
        List<Transaction> listTransactions = new ArrayList<>();
        List<Transaction> listTransactionsOrdenadas = new ArrayList<>();
        Scanner scanner;
        boolean isActive = true;

        System.out.print("Defina seu limite de crédito (Max: " + creditCard.getCreditLimit() + "): ");
        scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        if (value < creditCard.getCreditLimit()) {
            creditCard.setCreditLimit(value);

            while (isActive) {
                System.out.print("Digite a descrição do produto: ");
                scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                System.out.print("Digite o valor da compra: ");
                scanner = new Scanner(System.in);
                double purchaseValue = scanner.nextDouble();

                Transaction actualTransaction = transaction.saveTransaction(input, purchaseValue, creditCard);
                listTransactions.add(actualTransaction);

                if (purchaseValue >= creditCard.getCreditLimit()) {
                    isActive = false;
                    break;
                }
                System.out.println("-- Digite uma das opções --");
                System.out.println(" ");
                System.out.println("[1] - Continuar");
                System.out.println("[0] - Sair");
                System.out.println(" ");

                scanner = new Scanner(System.in);
                input = scanner.nextLine();

                switch (input) {
                    case "0":
                        isActive = false;
                        scanner.close();
                        break;
                    case "1":
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            }
        } else {
            System.err.println("O seu limite de crédito aprovado atual é de R$ " + creditCard.getCreditLimit());
        }

        System.out.println(" ");
        System.out.println("****************************************************************************************");
        System.out.println("*                                                                                      *");
        System.out.println("* Transações:                                                                          *");
        System.out.println("*                                                                                      *");

        for (Transaction transactionItem : listTransactions) {
            listTransactionsOrdenadas.add(transactionItem);
            Collections.sort(listTransactionsOrdenadas);
        }

        System.out.println(listTransactionsOrdenadas);

        System.out.println("*                                                                                      *");
        System.out.println("* Limite Atual: " + "R$ " + creditCard.getCreditLimit());
        System.out.println("*                                                                                      *");
        System.out.println("****************************************************************************************");
    }
}