import Bank.Util.BankSession;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {
    /* The bank session instance shared amongst the web application. Here, it gets set to the
     * session captured from login. */
    protected static BankSession bank = Login.bank;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bank.logout();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
