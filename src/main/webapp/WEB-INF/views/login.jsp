<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
    <h3>Parameter</h3>
    <p>
        <%= request.getParameter("msg") %>
    </p>
    <h3>Attribute</h3>
    <p>
        <%= request.getAttribute("msg") %><br>
        <%= request.getAttribute("key") %>
    </p>
    <%-- GET --%>
    <%-- 현재 링크에 GET 요청 --%>
    <form action="" method="get">
        <input name="msg" placeholder="아무거나 입력해보세요">
        <button>제출</button>
    </form>
    <%-- POST --%>
    <%-- 현재 링크에 POST 요청 --%>
    <%-- 주소창에 데이터 속성들이 노출되지 X --%>
    <%-- REST API POST (application/json) vs Form POST (application/x-www-form-urlencoded) --%>
    <%-- json: json body를 가지면서 + searchParam (주소창 데이터를 가질 수 있음) --%>
    <%-- form: parameter만 가질 수 있음 (url 노출 되느냐 vs body로 들어가느냐) --%>
    <form action="" method="post">
        <input name="msg" placeholder="아무거나 입력해보세요">
        <button>제출</button>
    </form>
</body>
</html>
