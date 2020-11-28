/**
 * Christopher Polynice
 * Banking System 2.0 - Send Money Implementation
 * Final Release November 30th, 2020
 */

import Bank.Util.BankSession;
import Bank.Util.Common;
import Bank.Util.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SendMoney extends HttpServlet {

    /* The bank session instance shared amongst the web application. Here, it gets set to the
     * session captured from login. */
    protected static BankSession bank = Login.bank;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (bank.getSession() == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            // Grab the current web session.
            HttpSession session = request.getSession();

            // Retrieve the web application attributes.
            String acctChoiceSend = request.getParameter("accountsSend");
            String acctChoiceReceive = request.getParameter("accountsRec");
            String recipient = request.getParameter("recipient");
            String amountStr = request.getParameter("amount");

            if (acctChoiceSend == null || acctChoiceReceive == null ||
                    recipient == null || amountStr == null) {
                String msg = "<div class=\"alert alert-warning\" role=\"alert\">\n" +
                        "  Please make sure all fields are filled.\n" +
                        "</div>";
                session.setAttribute("errorMsgs", msg);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/sendmoney.jsp");
                rd.forward(request, response);
            } else {
                // Clear out the error message(s).
                session.setAttribute("errorMsgs", null);
                double amount = Double.parseDouble(request.getParameter("amount"));

                // Format the arguments as necessary for the bank to send money.
                Customer receiver = bank.getAccountHolders().getCustomer(recipient);
                Common.AccountType sendType = Common.toAccountType(acctChoiceSend);
                Common.AccountType receiveType = Common.toAccountType(acctChoiceReceive);
                String error = bank.sendMoney(sendType, receiver, receiveType, amount);

                // If sending money created an error message, output to the web application.
                if (error != null) {
                    session.setAttribute("errorMsgs", error);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/sendmoney.jsp");
                    rd.forward(request, response);
                } else {
                    // Proceed as normal.
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
                    rd.forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;

        if (bank.getSession() == null) {
            rd = getServletContext().getRequestDispatcher("/index.jsp");
        } else {
            rd = getServletContext().getRequestDispatcher("/sendmoney.jsp");
        }

        rd.forward(req, resp);
    }
}
