<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 13/10/2023
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String birthtime = request.getParameter("birthtime");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String toeic = request.getParameter("toeic");
        String message = request.getParameter("message");
        String favorite_ide = request.getParameter("favorite_ide");
    %>
    <h3> <%=name%> </h3>
    <h3> <%=email%> </h3>
    <h3> <%=birthday%> </h3>
    <h3> <%=birthtime%> </h3>
    <h3> <%=gender%> </h3>
    <h3> <%=country%> </h3>
    <h3> <%=toeic%> </h3>
    <h3> <%=message%> </h3>
    <h3> <%=favorite_ide%> </h3>
</body>
</html>
