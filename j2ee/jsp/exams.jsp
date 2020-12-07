  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
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

    
        <nav class="navbar is-transparent is-fixed-top" role="navigation" aria-label="main navigation" id="navbar">
            <div class="navbar-menu is-active">
                <div class="navbar-start">
                    <!-- navbar items -->
                    <div class="navbar-item" id="navtext"></div>
                </div>
                <div class="navbar-end">
                    <div class="navbar-item">
                        <a href="" id="logout">Logout</a>
                    </div>
                </div>
            </div>
          </nav>
        <section class="section" id="section">
        <div class="mainhead has-text-centered"><div class="box">Exams</div></div>
          <div id="exam">
           
          <% String exams = (String) request.getAttribute("exams");
          JSONParser jsonParser = new JSONParser();
          	JSONArray jsonArray = (JSONArray)jsonParser.parse(exams); 
          	System.out.println(jsonArray.size());
          	for(int i = 0; i < jsonArray.size(); ++i) {
          		JSONObject jsonObject = (JSONObject) jsonArray.get(i); %>
          	<div class="columns is-vcentered" id="exam-list">
          		<div class="column side-align">
          			<div class="box">
          			<form action="<%=request.getContextPath()%>/exams" method="post">
              		
              		<div class="field">
              		<div class="control">  
              		   <input name ="eid" type="hidden"  value="<% out.print(jsonObject.get("examID")); %>">
              		  <div class="buttons is-right clg-btns">
              		  <input type="submit" class="button is-success is-rounded" value="Save to Bookmarks">
              			</div>
              		</div>
            		</div>
            		</form>
          				<div class="exam-name">
          				<% out.println(jsonObject.get("exam")); %>
          				</div>
          				<p class="exam-desc">
          				<% out.println(jsonObject.get("examDescription")); %>
          				</p>
          				<div class="exam-details">
          					<span class="tag is-medium is-warning desc-tags">TotalMarks</span>
          					<span class="exam-cutoff"><% out.println(jsonObject.get("totalMarks")); %></span>
          				</div>
          			</div>
          		</div>
          	</div>
          	<% } %>
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