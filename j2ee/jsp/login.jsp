<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--
 Copyright (c) 2020 | Exam Experts
-->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Exam Experts</title>
    <link rel="stylesheet" href="./css/bulma.min.css">
    <link rel="stylesheet" href="./css/main.css">
    <link href="https://fonts.googleapis.com/css2?family=Lato&family=Pacifico&family=Poppins&family=Quicksand&display=swap" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar is-transparent is-fixed-top" role="navigation" aria-label="main navigation" id="navbar">
      <div class="navbar-menu is-active">
          <div class="navbar-start">
              <!-- navbar items -->
              <div class="navbar-item" id="navtext"></div>
          </div>
      </div>
    </nav>

    <section class="section" id="section">
      <div class="columns">
        <div class="column is-6">
          <img src="./assets/placeholders/examexperts.png" class="logo">
        </div>
        <div class="column" id="login-form">
          <% if(request.getAttribute("error")=="true"){ %>
        	  <article class="message"><div class="message-header">Please provide the correct credentials</div></article>
          <% } %>
          <div class="welcometext has-text-centered">
            Welcome Back
          </div>
          <form action="<%=request.getContextPath()%>/login" id="myform" method="post">
            <div class="field">
              <label class="label">Email</label>
              <div class="control">
                <input class="input" type="email" id="email" name="email" placeholder="capturesmk@gmail.com">
              </div>
            </div>
            
            <div class="field">
              <label class="label">Password</label>
              <div class="control">
                <input class="input" type="password" id="pass" name="pass" placeholder="secret">
              </div>
            </div>

            <div class="field">
              <div class="control">  
                <input id="login-btn" type="submit" class="button is-success is-rounded" value="Login">
              </div>
            </div>
          </form>

          <div class="buttons is-centered">
            <a class="button is-info is-rounded" id="register-btn" href="<%=request.getContextPath()%>/register">New User? Register Here</a>
          </div>

        </div>
      </div>
    </section>

  <!--Scripts ARENA-->
  <script src="https://unpkg.com/typewriter-effect@latest/dist/core.js"></script>
  <script src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script>
        var app = document.getElementById('navtext');
        var typewriter = new Typewriter(app, {
            loop: true
        });
        typewriter.typeString('Exam Experts')
            .start();

    </script>
  <!--Scripts ARENA Ends-->
  </body>
</html>