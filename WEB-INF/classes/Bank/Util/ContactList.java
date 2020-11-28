package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Contact List)
 * Final Release November 30th, 2020
 */

import java.util.List;

public class ContactList {
    /* The list of contacts. */
    private List<Contact> contacts;

    /**
     * Constructor
     *
     * @param contacts the list of contacts.
     */
    public ContactList(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
