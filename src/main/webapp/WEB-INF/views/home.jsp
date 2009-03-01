<%-- 
    Document   : home
    Created on : Feb 28, 2009, 1:54:15 PM
    Author     : jared
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@page contentType="text/html" pageEncoding="MacRoman"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>Dashboard - Jared Blitzstein</title>
    </head>
    <body>
        <h2>Hey</h2>

        <ol>
            <c:forEach var="message" items="${messages}">
                <li>
                    <span class="username">${message.user.username}:</span><span class="message"> ${message.content}</span>
                    <span class="time">
                        ${message.insertedAt}
                    </span>

                    </li>
            </c:forEach>
        </ol>

    </body>
</html>
