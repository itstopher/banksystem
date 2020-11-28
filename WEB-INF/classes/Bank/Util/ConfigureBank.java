package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Bank Database)
 * Final Release November 30th, 2020
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfigureBank {
    /**
     * Initializes the account holders for the banking session.
     *
     * @return the list of customers.
     * @throws FileNotFoundException
     */
    public static CustomerList initBank(InputStream file) {
        int i, j, k, acctHoldersCount, acctCount, transCount, contactCount;
        Scanner info;

        // Read in the file and grab attributes.
        info = new Scanner(file);
        acctHoldersCount = info.nextInt();
        List<Customer> customers = new ArrayList<>();

        // For each account holder, grab the respective attributes from the file and fill in as necessary.
        for (i = 0; i < acctHoldersCount; i++) {
            String fName = info.next();
            String lName = info.next();
            String name = fName + " " + lName;
            acctCount = info.nextInt();
            List<Account> accounts = new ArrayList<>();
            ContactList contactList;
            AccountList accountList;

            // For each account, read and fill in transaction information.
            for (j = 0; j < acctCount; j++) {
                String account = info.next();
                double balance = info.nextDouble();
                Common.AccountType type = Common.toAccountType(info.next());
                transCount = info.nextInt();
                List<Transaction> transactions = new ArrayList<>();

                // For each transaction, create the transaction and fill it in.
                for (k = 0; k < transCount; k++) {
                    double amount = info.nextDouble();
                    Common.TransactionType transType = Common.toTransactionType(info.next());
                    String merchant = info.nextLine();

                    transactions.add(new Transaction(merchant, amount, transType));
                }

                TransactionList transactionList = new TransactionList(transactions);
                accounts.add(new Account(account, balance, type, transactionList));
            }

            contactCount = info.nextInt();
            List<Contact> contacts = new ArrayList<>();

            // For each contact, fill in the information of the contacts.
            for (k = 0; k < contactCount; k++) {
                contacts.add(new Contact(info.next() + " " + info.next(),
                        new Account(info.next(), info.nextDouble(),
                                Common.toAccountType(info.next()), null)));
            }

            // Create the contactList, accountList, and add it to the list of customers.
            contactList = new ContactList(contacts);
            accountList = new AccountList(accounts);
            customers.add(new Customer(name, accountList, contactList, info.next(), info.next()));
        }

        // Return the customers as a customer list.
        return new CustomerList(customers);
    }
}
