package Bank.Util;

import java.util.Date;

/**
 * Christopher Polynice
 * Banking System 2.0 - System Interface (Common)
 * Final Release November 30th, 2020
 */

public class Common {
    /* The enums represented for an order. */
    public enum Order {
        AMOUNT, DATE
    }

    /* The enums represented for an account type. */
    public enum AccountType {
        CHECKING, SAVINGS
    }

    /* The enums represented for a transaction type. */
    public enum TransactionType {
        DEPOSIT, WITHDRAW
    }

    /**
     * Converts the string representation of the order to the enum.
     *
     * @param order the order type
     * @return the enum order type.
     */
    public static Order toOrder(String order) {
        return Order.valueOf(order);
    }

    /**
     * Converts the string representation of the account type to the enum.
     *
     * @param accountType the account type
     * @return the enum account type.
     */
    public static AccountType toAccountType(String accountType) {
        return AccountType.valueOf(accountType);
    }

    /**
     * Converts the string representation of the transaction type to the enum.
     *
     * @param transactionType the transaction type.
     * @return the enum transaction type.
     */
    public static TransactionType toTransactionType(String transactionType) {
        return TransactionType.valueOf(transactionType);
    }

    /**
     * Retrieves the current time.
     *
     * @return the current time.
     */
    public static Date convertCurrentTime() {
        return new Date(System.currentTimeMillis());
    }
}
