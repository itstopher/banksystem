/**
 * Christopher Polynice
 * Banking System 2.0 - Check Accounts Implementation
 * Final Release November 30th, 2020
 */

import Bank.Util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Accounts extends HttpServlet {
    /* The bank session instance shared amongst the web application. Here, it gets set to the
    * session captured from login. */
    protected static BankSession bank = Login.bank;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Grab the current customer and the web session.
        if (bank.getSession() == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession();

            // Search for the customer's account information for both the savings and checking
            // accounts.
            AccountList accounts = bank.checkAccounts();
            Account checking = accounts.getAccount(Common.AccountType.CHECKING);
            Account savings = accounts.getAccount(Common.AccountType.SAVINGS);
            String chkAccount = checking.getAccount();
            String last4Chk = chkAccount.substring(chkAccount.length() - 4);
            String savAccount = savings.getAccount();
            String last4Sav = savAccount.substring(savAccount.length() - 4);
            String chkBalance = String.format("%.2f", checking.getBalance());
            String savBalance = String.format("%.2f", savings.getBalance());

            // Populate the jsp attributes.
            session.setAttribute("chkAccount", last4Chk);
            session.setAttribute("chkBalance", chkBalance);
            session.setAttribute("savAccount", last4Sav);
            session.setAttribute("savBalance", savBalance);

            // Forward the request to the page.
            RequestDispatcher rd = request.getRequestDispatcher("/checkaccounts.jsp");
            rd.forward(request, response);
        }
    }
}
