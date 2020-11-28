package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Customer)
 * Final Release November 30th, 2020
 */

import java.util.List;

public class CustomerList {
    /* The list of customers. */
    private static List<Customer> customers;

    /**
     * Constructor
     *
     * @param customers the list of customers
     */
    public CustomerList(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * Retrieve the customer by the name (used for contacts).
     *
     * @param name the name of the customer
     * @return the corresponding customer.
     */
    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (name.equals(customer.getName())) {
                return customer;
            }
        }

        return null;
    }

    /**
     * Retrieves the customer by the username and password (used to authenticate user).
     *
     * @param username the username of the customer
     * @param password the password of the customer
     * @return the customer instance, or null if not found.
     */
    public static Customer getCustomer(String username, String password) {
        for (Customer customer : customers) {
            String testUser = customer.getUsername();
            String testPass = customer.getPassword();

            if (testUser.equals(username) && testPass.equals(password)) {
                return customer;
            }
        }

        return null;
    }
}
