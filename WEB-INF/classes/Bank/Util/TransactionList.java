package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Transaction List)
 * Final Release November 30th, 2020
 */

import java.util.Collections;
import java.util.List;

public class TransactionList {
    /* The list of transactions. */
    private List<Transaction> transactions;

    /**
     * Constructor
     *
     * @param transactions the list of transactions.
     */
    public TransactionList(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Add a new transaction to the transaction list.
     *
     * @param transaction the transaction to add.
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Changes the order of the entire transaction and sorts them for output.
     *
     * @param order the order to change.
     */
    public void changeOrder(Common.Order order) {
        for (Transaction t : transactions) {
            t.setOrder(order);
        }

        Collections.sort(transactions);
    }

    /**
     * Returns the list of transactions.
     *
     * @return the list of transactions.
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
