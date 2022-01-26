package edu.cmu.edu.marangol.project1task3;

/*
 * @author Martin Arango (marangol)
 *
 * This file is the servlet acting as the controller
 * There are three views - index.jsp, answered.jsp results.jsp
 * It decides between the three by determining if it is getting a post request or a get request
 * If there is no answer selected, then it uses the index.jsp view, as a
 * starting place. If there is an answer, then it uses the answered.jsp view
 * If there is a get request to the URL pattern getResults, it uses the results.jsp
 * The model is provided by ClickerModel.java.
 * Comments and code used from InterestingPicture
 * To run project remember to change the deployment application context to:
 * /Project1Task3-1.0-SNAPSHOT
 */

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// this web servlet annotation specifies the URL end pointss that the servlet will respond to
// used https://jakarta.ee/specifications/servlet/5.0/apidocs/jakarta/servlet/annotation/webservlet to understand
@WebServlet(name = "Clicker-Servlet", value = {"/postAnswer", "/getResults", "/index"})
public class ClickerServlet extends HttpServlet {
    ClickerModel cm = null; // The model for this app

    // Initiate this servlet by instantiating the model that it will use.
    public void init() {
        cm = new ClickerModel();
    }

    // Handles http post requests to the servlet. The post requests happen when students answer questions
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the answer if it exists
        String answer = request.getParameter("answer");
        // this code structure was taken from InterestingPicture
        String nextView;
        if (answer != null) {
            // add answer to the count in the model
            cm.addToCount(answer);
            // pass the answer back to the view
            request.setAttribute("answer", answer);
            // next view will show the selected answer
            nextView = "answered.jsp";
        } else {
            // no answer so choose the index "view"
            nextView = "index.jsp";
        }

        // Code taken from InterestingPicture. It sets the appropiate doctype for the html of the view
        // determine what type of device our user is
        String ua = request.getHeader("User-Agent");
        boolean mobile;
        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            mobile = true;
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }

        // Transfer control over the correct "view"
        RequestDispatcher view = request.getRequestDispatcher(nextView);
        view.forward(request, response);
    }

    // handles http get requests to the servlet. The get requests happen when the /getResults url is requested
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nextView ="index.jsp";

        //Checks if the request is for the /getResults URL pattern
        if(request.getServletPath().equals("/getResults")){
            // pass the answer counts back to the view
            request.setAttribute("countA", cm.getCountA());
            request.setAttribute("countB", cm.getCountB());
            request.setAttribute("countC", cm.getCountC());
            request.setAttribute("countD", cm.getCountD());
            // resets clicker
            cm.resetClicker();
            nextView = "results.jsp";
            }

        // Code taken from InterestingPicture. It sets the appropiate doctype for the html of the view
        // determine what type of device our user is
        String ua = request.getHeader("User-Agent");
        boolean mobile;
        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            mobile = true;
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }

        // Transfer control over to the results view
        RequestDispatcher view = request.getRequestDispatcher(nextView);
        view.forward(request, response);
    }
}