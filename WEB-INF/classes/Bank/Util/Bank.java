package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Bank Interface)
 * Final Release November 30th, 2020
 */

public interface Bank {
    /**
     * Authenticates the user into the system.
     *
     * @param username the customer's username
     * @param password the customer's password
     * @return a value indicating if the login was successful.
     */
    boolean login(String username, String password);

    /**
     * Logs the current user out of the system.
     *
     * @return the value indicating if logging out was successful.
     */
    boolean logout();

    /**
     * Checks the accounts associated with the current user.
     *
     * @return the list of accounts.
     */
    AccountList checkAccounts();

    /**
     * Processes the sending of money from one user to another user.
     *
     * @param fromType the account type sending from
     * @param toCustomer the customer receiving the money
     * @param toType the receiving customer account type
     * @param amount the amount to send
     * @return a message indicating if sending the money was successful.
     */
    String sendMoney(Common.AccountType fromType, Customer toCustomer, Common.AccountType toType, double amount);

    /**
     * Shows the accounts for the type and order.
     *
     * @param type the account type
     * @param order the order to organize the accounts by
     * @return the list of transactions.
     */
    TransactionList accountHistory(Common.AccountType type, Common.Order order);
}
