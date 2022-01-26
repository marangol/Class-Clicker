<%--
  Author: Martin Arango (marangol)
  This file is a part of the view component of the MVC
  It is the default page of the site
  It gives the user the posibility to submit an answer and see the last answer submitted
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
  Shows the las answer submitted sent in the response by the controller
--%>
<p>Your "${answer}" has been registered</p>
<%--
  This html form submits the selected answer as an HTTP post request to the servlet (the controller)
--%>
<form action="postAnswer" method="post" id="answer_form">
    <legend>Submit your answer to the current question</legend>
    <input type="radio" id="A" name="answer" value="A">
    <label for="A">A</label><br>
    <input type="radio" id="B" name="answer" value="B">
    <label for="B">B</label><br>
    <input type="radio" id="C" name="answer" value="C">
    <label for="C">C</label><br>
    <input type="radio" id="D" name="answer" value="D">
    <label for="D">D</label><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
