package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Account List)
 * Final Release November 30th, 2020
 */

import java.util.List;

public class AccountList {
    /* The list of accounts. */
    private List<Account> accounts;

    /**
     * Constructor
     *
     * @param accounts the list of accounts.
     */
    public AccountList(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Gets the account specified from the list of accounts.
     *
     * @param type the type of account to retrieve
     * @return the account.
     */
    public Account getAccount(Common.AccountType type) {
        for (Account account : accounts) {
            if (type.equals(account.getType())) {
                return account;
            }
        }

        return null;
    }

    /**
     * Updates the given account in the list of accounts.
     *
     * @param account the account to update.
     */
    public void setAccount(Account account) {
        int index = accounts.indexOf(account);
        accounts.set(index, account);
    }
}
