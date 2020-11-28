package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Contact)
 * Final Release November 30th, 2020
 */

public class Contact {
    /* The name of the contact. */
    private String name;

    /* The account associated with the contact. */
    private Account account;

    /**
     * Constructor
     *
     * @param name the name of the contact
     * @param account the account
     */
    public Contact(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    /**
     * Return the name of the contact.
     *
     * @return the name of the contact.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the account for the contact.
     *
     * @return the account.
     */
    public Account getAccount() {
        return account;
    }
}
