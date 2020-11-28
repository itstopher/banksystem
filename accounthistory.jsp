<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 11/26/20
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String accountInfo = session.getAttribute("accountInfo") != null ? (String) session.getAttribute("accountInfo") : "";
%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Account History</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body style="background-color: cornsilk">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="DollarSign.png" width="30" height="30" class="d-inline-block align-top" alt="">Bank</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#homePane" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" href="#" id="homePane">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" id="home" href="Home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="smoney" href="Accounts">Check Accounts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="viewTrans" href="SendMoney">Send Money</a>
            </li>
            <li class="nav-item disabled">
                <a class="nav-link" id="aHistory" href="accounthistory.jsp">Account History<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="logout" href="Logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="card-group">
    <%= accountInfo %>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
