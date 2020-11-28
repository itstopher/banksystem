package Bank.Util;

public class Customer {
    /* The name of the customer. */
    private final String name;

    /* The list of accounts. */
    private final AccountList accounts;

    /* The list of contacts. */
    private final ContactList contacts;

    /* The username. */
    private final String username;

    /* The password. */
    private final String password;

    /**
     * Constructor
     *
     * @param name the name
     * @param accounts the account list
     * @param contacts the contact list
     * @param username the username
     * @param password the password
     */
    public Customer(String name, AccountList accounts, ContactList contacts,
                    String username, String password) {
        this.name = name;
        this.accounts = accounts;
        this.contacts = contacts;
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieve the name.
     *
     * @return the name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the list of accounts.
     *
     * @return the account list.
     */
    public AccountList getAccounts() {
        return accounts;
    }

    /**
     * Retrieve the username.
     *
     * @return the username of the customer.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieve the password.
     *
     * @return the password for the customer.
     */
    public String getPassword() {
        return password;
    }
}
