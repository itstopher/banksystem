package Bank.Util;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Transaction)
 * Final Release November 30th, 2020
 */

import java.util.Date;
import java.util.UUID;

public class Transaction implements Comparable<Transaction> {
    /* The amount of the transaction. */
    private final double amount;

    /* The random id associated with the transaction. */
    private final String id;

    /* Merchant name. */
    private final String merchant;

    /* The date the transaction occured. */
    private final Date date;

    /* The type of transaction. */
    private final Common.TransactionType type;

    /* Transaction order. */
    private Common.Order order;

    /**
     * Constructor
     *
     * @param merchant the merchant name
     * @param amount the amount
     * @param type the type (DEPOSIT, WITHDRAW)
     */
    public Transaction(String merchant, double amount, Common.TransactionType type) {
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
        this.merchant = merchant;
        this.date = Common.convertCurrentTime();
        this.type = type;
        this.order = Common.Order.DATE;
    }

    /**
     * Retrieves the date of the transaction.
     *
     * @return the date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the amount.
     *
     * @return the amount of the transaction.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the id of the transaction.
     *
     * @return the id of the transaction.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieve the merchant of the transaction.
     *
     * @return the merchant of the transaction.
     */
    public String getMerchant() {
        return merchant;
    }

    /**
     * Return the type of transaction.
     *
     * @return the transaction type.
     */
    public Common.TransactionType getType() {
        return type;
    }

    /**
     * Updates the order of the transaction.
     *
     * @param order the order of the transaction.
     */
    public void setOrder(Common.Order order) {
        this.order = order;
    }

    @Override
    public int compareTo(Transaction o) {
        // Implements Comparable so the transactions can be sorted from top to
        // bottom.
        return order.equals(Common.Order.AMOUNT)
                ? Double.compare(o.amount, amount)
                : Long.compare(o.date.getTime(), date.getTime());
    }
}
