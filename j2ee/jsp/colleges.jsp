<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<!--
 Copyright (c) 2020 | Exam Experts
-->
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Exam Experts</title>
        <link rel="stylesheet" href="./css/bulma.min.css">
        <link rel="stylesheet" href="./css/main.css">
        <link href="https://fonts.googleapis.com/css2?family=Lato&family=Pacifico&family=Poppins&family=Quicksand&display=swap" rel="stylesheet">
    </head>

    <body onload="fetchXML()">
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
           
           <div id="clgpage">
           	<% JSONParser jsonParser = new JSONParser();
          	String college = (String) request.getAttribute("college");
          	JSONArray jsonArray = (JSONArray) jsonParser.parse(college); 
          	for(int i = 0; i < jsonArray.size(); ++i) {
          		JSONObject jsonObject = (JSONObject) jsonArray.get(i); %>
          	<div class="columns is-vcentered" id="college-list">
          		<div class="column is-2">
          			<img alt="college-pic" src="<% out.println("./assets/logos/"+jsonObject.get("UniversityID")+".png"); %>">
          		</div>
          		<div class="column side-align">
          			<div class="box">
          			<form action="<%=request.getContextPath()%>/colleges" method="post">
              		
              		<div class="field">
              		<div class="control">  
              		   <input name ="uid" type="hidden"  value="<% out.print(jsonObject.get("UniversityID")); %>">
              		  <div class="buttons is-right clg-btns">
              		  <input type="submit" class="button is-success is-rounded" value="Save to Bookmarks">
              			</div>
              		</div>
            		</div>
              		
          			</form>
          			<div class="clg-name">
          			<% out.println(jsonObject.get("UniversityName")); %>
          			</div>
          			<p class="clg-desc">
          			<% out.println(jsonObject.get("Description")); %>
          			</p>
          			<div class="clg-details">
          				<div class="space-tags">
          					<span class="tag is-medium is-warning desc-tags">Examination</span>
          					<span class="clg-exam"><% out.println(jsonObject.get("ExamID")); %></span>
          				</div>
          				<div>
          					<span class="tag is-medium is-warning desc-tags">Cut-Off Score</span>
          					<span class="clg-cutoff"><% out.println(jsonObject.get("Cutoff")); %></span>
          				</div>
          			</div>
          			<div class="buttons is-right clg-btns">
          				<a class="button is-dark is-rounded clg-location" target="_blank" href="<% out.println(jsonObject.get("Location")); %>">Locate in Maps</a>
          				<a class="button is-link clg-url" target="_blank" href="<% out.println(jsonObject.get("URL")); %>">View More</a>
          			</div>
          			</div>
          		</div>
          	</div>
          	<%} %>
           </div>
          		 
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
      
      // LOADING XML RESPONSE
      
    </script>
    <!--Scripts ARENA Ends-->
    </body>
</html>