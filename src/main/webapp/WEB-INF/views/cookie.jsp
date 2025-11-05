<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키</title>
</head>
<body>
    <%
//        String counter = "1";
        int counter = 1;
        String visited = "";
        for (Cookie c : request.getCookies()) {
            String name = c.getName();
            if (name.equals("visited")) {
                visited = c.getValue();
            }
            if (name.equals("counter")) {
//                counter = c.getValue();
                counter = Integer.parseInt(c.getValue());
            }
        }
    %>
    <p>
        <%= counter %>번째 방문
    </p>
    <p>
        <%= visited %>
    </p>
</body>
</html>
