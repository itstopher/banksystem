/**
 * Christopher Polynice
 * Banking System 2.0 - Account History Implementation
 * Final Release November 30th, 2020
 */

import Bank.Util.BankSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountHistory extends HttpServlet {
    /* The bank session instance shared amongst the web application. Here, it gets set to the
     * session captured from login. */
    protected static BankSession bank = Login.bank;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;

        if (bank.getSession() == null) {
            rd = request.getRequestDispatcher("/index.jsp");
        } else {
            rd = request.getRequestDispatcher("/accounthistory.jsp");
        }
        rd.forward(request, response);
    }
}
