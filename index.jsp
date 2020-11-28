<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 11/22/20
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String error = session.getAttribute("error") != null ? (String) session.getAttribute("error") : ""; %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Login</title>
    <script>
      history.pushState(null, null, document.URL);
      window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
      });
    </script>
  </head>
  <body style="background-color: cornsilk">
  <nav class="navbar navbar-light bg-light">
    <a class="navbar-brand">
      <img src="DollarSign.png" width="30" height="30" class="d-inline-block align-top" alt="">
      Bank
    </a>
  </nav>
  <form action="Login" method="post" style="text-align: center">
    <div class="input-group flex-nowrap">
      <div class="input-group-prepend">
        <span class="input-group-text" id="username">@</span>
      </div>
      <input type="text" class="form-control col-xs-2" name="username" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
    </div>
    <div class="input-group flex-nowrap">
      <div class="input-group-prepend">
        <span class="input-group-text" id="password-label">@</span>
      </div>
      <input type="password" class="form-control col-xs-2" name="password" placeholder="Password" aria-label="Password" aria-describedby="password-label">
    </div>
    <div class="form-group mx-sm-3">
      <%= error %>
    </div>
    <button type="submit" class="btn btn-success mx-sm-3">Sign In</button>
  </form>
  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="Cards.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Accounts</h5>
          <p>Check accounts through the re-imagined website with the ability to send and receive money
            easily..</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="Teller.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Banking</h5>
          <p>Whether you want to bank at a location or on the go, the banking system makes mobile banking easy.</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="Family.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Family</h5>
          <p>With banking made easier, keep focus on your loved ones.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-app.js"></script>
  <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-firestore.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
          integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
          integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
          integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>
