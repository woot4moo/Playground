<!-- This page should not be used I am just trying to prove something.  Awful code below -->

<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.example.model.jpa.Text"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>JPA Guest Book Web Application Tutorial</title>
</head>

<body>
<form method="POST" action="guest">
    Name: <input type="text" name="name" />
    <input type="submit" value="Add" />
</form>

<hr><ol> <%
    @SuppressWarnings("unchecked")
    List<Text> guests = (List<Text>)request.getAttribute("guests");
    if (guests != null) {
        for (Text guest : guests) { %>
    <li> <%= guest %> </li> <%
            }
        } %>
</ol><hr>

<iframe src="http://www.objectdb.com/pw.html?jee-eclipse"
        frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
</body>
</html>