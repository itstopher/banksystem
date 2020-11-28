<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 11/23/20
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMsgs = session.getAttribute("errorMsgs") != null ? (String) session.getAttribute("errorMsgs") : "";
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Send Money</title>
</head>

<body style="background-color: cornsilk">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="DollarSign.png" width="30" height="30" class="d-inline-block align-top" alt="">Bank</a>
    <button class="navbar-toggler" type="button" data-toggle="dropdown" data-target="#homePane" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="homePane">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" id="home" href="Home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="smoney" href="Accounts">Check Accounts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="viewTrans" href="SendMoney">Send Money</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="aHistory" style="cursor: pointer" data-toggle="modal" data-target="#order">Account History</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="logout" href="Logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<form action="Home" method="post">
    <div class="modal fade" id="order" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Transaction Order</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Please specify how you would like to organize transactions.
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" name="order" value="AMOUNT">Amount</button>
                    <button type="submit" class="btn btn-secondary" name="order" value="DATE">Date</button>
                </div>
            </div>
        </div>
    </div>
</form>

<form action="SendMoney" method="post">
    <div class="form-group mx-sm-3">
        <label>Select sending account:</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="accountsSend" id="checkingSend" value="CHECKING">
            <label class="form-check-label">Checking</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="accountsSend" id="savingsSend" value="SAVINGS">
            <label class="form-check-label">Savings</label>
        </div>
    </div>
    <div class="form-group mx-sm-3">
        <label>Enter Recipient:</label>
        <input type="text" class="form-control col-xs-2" name="recipient">
        <small id="emailHelp" class="form-text text-muted">Format as First Name Last Name (i.e. John Doe) </small>
    </div>
    <div class="form-group mx-sm-3">
        <label>Select recipient account:</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="accountsRec" id="checkingRec" value="CHECKING">
            <label class="form-check-label">Checking</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="accountsRec" id="savingsRec" value="SAVINGS">
            <label class="form-check-label">Savings</label>
        </div>
    </div>
    <div class="form-group mx-sm-3">
        <label>Enter amount:</label>
        <input type="text" class="form-control col-xs-2" name="amount" placeholder="0.00">
    </div>
    <button type="button" class="btn btn-success mx-sm-3" data-toggle="modal" data-target="#staticBackdrop">
        Send
    </button>
    <div class="form-group mx-sm-3">
        <div class="form-group">
            <%= errorMsgs %>
        </div>
    </div>
    <div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Confirm Send</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you would like to send the money?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger mx-sm-3" data-dismiss="modal">No, Make Changes</button>
                    <button type="submit" class="btn btn-success mx-sm-3">Yes, Send Money</button>
                </div>
            </div>
        </div>
    </div>
</form>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
