/**
 * Christopher Polynice
 * Banking System 2.0 - Login Implementation
 * Final Release November 30th, 2020
 */

import Bank.Util.BankSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    /* The bank session instance shared amongst the web application. */
    protected static BankSession bank = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            // Initialize a new bank session before attempting to login.
            String filename = "/WEB-INF/initDatabase.txt";
            ServletContext context = getServletContext();
            InputStream is = context.getResourceAsStream(filename);
            bank = new BankSession(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve both the username and password from the input forms.
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Grab the HTML session.
        HttpSession session = request.getSession();

        // Attempt to login. If unsuccessful, output an error message and dispatch to the page.
        if (!bank.login(username, password)) {
            String errorMessage = "<div class=\"alert alert-warning\" role=\"alert\">\n" +
                    "  Incorrect credentials provided. Please enter in the correct username and password.\n" +
                    "</div>";
            session.setAttribute("error", errorMessage);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            // Clear out the error message and bring the user to the home page.
            session.setAttribute("error", null);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("error", null);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}
