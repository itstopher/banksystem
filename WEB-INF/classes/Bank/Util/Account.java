package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Account)
 * Final Release November 30th, 2020
 */

public class Account {
    /* The account number. */
    private String account;

    /* The balance of the account. */
    private double balance;

    /* Account type. */
    private Common.AccountType type;

    /* The list of transactions associated with the account. */
    private TransactionList transactions;

    /**
     * Constructor
     *
     * @param account the account number
     * @param balance the balance
     * @param type account type
     * @param transactions the list of transactions
     */
    public Account(String account, double balance, Common.AccountType type, TransactionList transactions) {
        this.account = account;
        this.balance = balance;
        this.type = type;
        this.transactions = transactions;
    }

    /**
     * Updates the balance.
     *
     * @param balance the balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the balance.
     *
     * @return the balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the account number to the account.
     *
     * @param account the account number
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Returns the account number.
     *
     * @return the account number.
     */
    public String getAccount() {
        return account;
    }

    /**
     * Returns the account type.
     *
     * @return the account type.
     */
    public Common.AccountType getType() {
        return type;
    }

    /**
     * Returns the list of transactions.
     *
     * @return the list of transactions.
     */
    public TransactionList getTransactions() {
        return transactions;
    }
}
