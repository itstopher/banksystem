package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Bank Session)
 * Final Release November 30th, 2020
 */

import java.io.FileNotFoundException;
import java.io.InputStream;

public class BankSession implements Bank {
    /* The current session initiated by the customer logged in. */
    private Customer session;

    /* All account holders registered by the bank. */
    private final CustomerList accountHolders;

    /* Transaction type deposit. */
    private final String DEPOSIT = "DEPOSIT";

    /* Transaction type withdraw. */
    private final String WITHDRAW = "WITHDRAW";

    /* Merchant name for a deposit transaction. */
    private final String TRANSFER_IN = "Incoming Money Transfer";

    /* Merchant name for a withdraw transaction. */
    private final String TRANSFER_OUT = "Outgoing Money Transfer";

    /**
     * Constructor - initializes the given banking session.
     *
     * @throws FileNotFoundException
     */
    public BankSession(InputStream file) {
        this.accountHolders = ConfigureBank.initBank(file);
    }

    /**
     * Set the customer session to the bank. Used upon login().
     *
     * @param session the customer authenticated.
     */
    public void setSession(Customer session) {
        this.session = session;
    }

    /**
     * Get the current customer.
     *
     * @return session the current customer session.
     */
    public Customer getSession() {
        return session;
    }

    /**
     * Get all account holders of the bank.
     *
     * @return the current account holders registered with the bank.
     */
    public CustomerList getAccountHolders() {
        return accountHolders;
    }

    @Override
    public boolean login(String username, String password) {
        // Use the username and password to get the customer from the account holders.
        Customer session = CustomerList.getCustomer(username, password);

        // If the session is not null, the customer was found. Set the current session and
        // return success.
        if (session != null) {
            setSession(session);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean logout() {
        // Destroy the current session by setting the session to null.
        if (session != null) {
            setSession(null);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AccountList checkAccounts() {
        // Return the account list for the current customer.
        return session.getAccounts();
    }

    @Override
    public String sendMoney(Common.AccountType fromType, Customer toCustomer,
                                Common.AccountType toType, double amount) {
        // If the customer was not found, output the error message.
        if (toCustomer == null) {
            return "<div class=\"alert alert-warning\" role=\"alert\">\n" +
                    "  Could not find contact.\n" +
                    "</div>";
        }

        // Grab the accounts that will be sent from and received to.
        Account from = session.getAccounts().getAccount(fromType);
        Account to = toCustomer.getAccounts().getAccount(toType);

        // If the amount attempting to send is greater than the available balance, output error.
        if (amount > from.getBalance()) {
            return "<div class=\"alert alert-warning\" role=\"alert\">\n" +
                    "  You entered $" + String.format("%.2f", amount) + " and your available balance is $"
                    + String.format("%.2f", from.getBalance()) + ".\n" +
                    "</div>";
        }

        // Update accounts of both parties involved in the transaction.
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        // Create new transactions for both parties and add the transactions to the current transaction
        // lists.
        Transaction outTrans = new Transaction(TRANSFER_OUT, amount, Common.TransactionType.valueOf(WITHDRAW));
        Transaction inTrans = new Transaction(TRANSFER_IN, amount, Common.TransactionType.valueOf(DEPOSIT));
        from.getTransactions().addTransaction(outTrans);
        to.getTransactions().addTransaction(inTrans);

        // Update account information in the customers' list of accounts.
        session.getAccounts().setAccount(from);
        toCustomer.getAccounts().setAccount(to);

        // Null represents a successful sent message (no errors).
        return null;
    }

    @Override
    public TransactionList accountHistory(Common.AccountType type, Common.Order order) {
        // Grab the transaction list through the specified account type with the
        // requested order.
        Account userAccount = session.getAccounts().getAccount(type);
        TransactionList transactions = userAccount.getTransactions();
        transactions.changeOrder(order);
        return transactions;
    }
}
