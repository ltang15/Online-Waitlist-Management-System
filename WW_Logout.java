import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.lang.*;
import org.apache.commons.lang.StringEscapeUtils; //for the string escaping


public class WW_Logout extends HttpServlet {
    
    private void doRequest(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        String selfUrl = res.encodeURL(req.getRequestURI());
        
        HttpSession session = req.getSession(true);

        String sessId = session.getId();
        
        printPageHeader(out);
        try {
            
            String session_bid = (String)session.getAttribute("session_bid");
            String name = (String)session.getAttribute("session_name");
            req.getSession().invalidate();
            if (!name.equals(null)){
                out.println("Good bye "+name);
            }
        }
            catch (Exception e) {
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
        
    }

    private void printPageHeader(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Walter Waitlist</title>");
        out.println("<h1><a href='/walter/servlet/WW_Signin'>Walter Waitlist</a></h1>");
        out.println("<a href='/walter/servlet/WW_WaitlistSearch'>Browse</a>");
        out.println("<a href='/walter/servlet/WW_Signin'>Sign in</a>");
        out.println("<link rel='stylesheet' href='//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css'>");
        out.println("<script src='//code.jquery.com/jquery-1.10.2.js'></script>");
        out.println("<script src='//code.jquery.com/ui/1.10.4/jquery-ui.js'></script>");
        out.println("</head><hr>");
        out.println("<body>");
    }
    // ========================================================================
    // These are the entry points for HttpServlets
    // ========================================================================
    
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    { doRequest(req,res);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    { doRequest(req,res);
    }
    
}

