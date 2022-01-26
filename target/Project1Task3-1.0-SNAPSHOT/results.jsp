<%--
  Author: Martin Arango (marangol)
  This file is a part of the view component of the MVC
  It is the page that shows the results being the count of each answer type
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%= request.getAttribute("doctype") %>
<html>
<head>
    <title>Project1Task3</title>
</head>
<body>
<h1>Distributed Systems Class Clicker</h1>
<%--
  It checks if all the counts sent by the controller equal 0.
  If true the page shows the message that there are no results.
--%>
<% if ( request.getAttribute("countA").toString().equals("0") &&
        request.getAttribute("countB").toString().equals("0") &&
        request.getAttribute("countC").toString().equals("0") &&
        request.getAttribute("countD").toString().equals("0")) { %>
<p>There are currently no results</p>
<% } else { %>
<%--
  If there is at least one answer, it shows the answer counts sent by the controller
--%>
<p>The results from the survey are as follows<br><br>
    A: ${countA}<br>
    B: ${countB}<br>
    C: ${countC}<br>
    D: ${countD}
</p> <% } %>
</body>
</html>
