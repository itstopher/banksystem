/**
 * Christopher Polynice
 * Banking System 2.0 - Home Implementation
 * Final Release November 30th, 2020
 */

import Bank.Util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Home extends HttpServlet {
    /* The bank session instance shared amongst the web application. Here, it gets set to the
     * session captured from login. */
    protected static BankSession bank = Login.bank;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (bank.getSession() == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            // Grab the quick look information for both checking and savings accounts.
            AccountList accounts = bank.checkAccounts();
            Account checking = accounts.getAccount(Common.AccountType.CHECKING);
            Account savings = accounts.getAccount(Common.AccountType.SAVINGS);
            String chkAccount = checking.getAccount();
            String last4Chk = chkAccount.substring(chkAccount.length() - 4);
            String savAccount = savings.getAccount();
            String last4Sav = savAccount.substring(savAccount.length() - 4);
            String chkBalance = String.format("%.2f", checking.getBalance());
            String savBalance = String.format("%.2f", savings.getBalance());

            // Check which option was selected for ordering the transactions then grab the transactions
            // utilizing the order type.
            String order = request.getParameter("order");
            Common.Order orderType = Common.toOrder(order);
            TransactionList chkTrans = bank.accountHistory(Common.AccountType.CHECKING, orderType);
            TransactionList savTrans = bank.accountHistory(Common.AccountType.SAVINGS, orderType);

            // Create the HTML code for outputting the transactions.
            StringBuilder output = new StringBuilder("<div class=\"card\">" + "<div class=\"card-body\">\n" +
                    "            <h5 class=\"card-title\">Checking Account x" + last4Chk + "</h5>");
            output.append("<p class=\"card-text\">Available Balance: $").append(chkBalance).append("</p>");

            buildTransactionOutput(chkTrans, output);
            output.append("</div>\n" +
                    "    </div>\n" +
                    "    <div class=\"card\">\n" +
                    "        <div class=\"card-body\">").append("            <h5 class=\"card-title\">Savings Account x")
                    .append(last4Sav).append("</h5>")
                    .append("<p class=\"card-text\">Available Balance: $").append(savBalance).append("</p>");
            buildTransactionOutput(savTrans, output);
            output.append("</div>\n" +
                    "    </div>\n" +
                    "    <div class=\"card\">\n" +
                    "        <div class=\"card-body\">");

            // Update the attribute in the jsp and forward the request.
            request.getSession().setAttribute("accountInfo", output.toString());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/accounthistory.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;

        if (bank.getSession() == null) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
        } else {
            rd = getServletContext().getRequestDispatcher("/home.jsp");
        }

        rd.forward(req, resp);
    }

    /**
     * Helper method that builds each transaction cell with the respective information.
     *
     * @param trans the list of transactions
     * @param output the string that holds the generated HTML code
     */
    private void buildTransactionOutput(TransactionList trans, StringBuilder output) {
        // For each transaction, grab the required information and append it in the
        // locations the HTML code will accept.
        for (Transaction t : trans.getTransactions()) {
            String type = t.getType().equals(Common.TransactionType.DEPOSIT) ? "+" : "-";
            output.append("<a href=\"#\" class=\"list-group-item list-group-item-action\">\n" + "" + " " +
                    "               <div class=\"d-flex w-100 justify-content-between\">\n" + " " + " " +
                    "                  <h5 class=\"mb-1\">")
                    .append(t.getMerchant())
                    .append("</h5>\n")
                    .append("  ")
                    .append("<small>")
                    .append(type).append("$").append(t.getAmount())
                    .append("</small>\n")
                    .append(" ")
                    .append("</div>\n")
                    .append("   ")
                    .append("<p class=\"mb-1\">")
                    .append(t.getId())
                    .append("</p>\n")
                    .append("  ")
                    .append("<small>")
                    .append(t.getDate())
                    .append("</small>\n")
                    .append("            </a>");
        }
    }
}
