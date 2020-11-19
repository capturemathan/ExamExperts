<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
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
                <div class="navbar-end">
                    <div class="navbar-item">
                        <a href="" id="logout">Logout</a>
                    </div>
                </div>
            </div>
          </nav>
          <section class="section">
          <div class="mainhead has-text-centered"><div class="box">Bookmarked Colleges</div></div>
          <div id="clgbk">
          	<% JSONParser jsonParser = new JSONParser();
          	String collegeBookmarks = (String) request.getAttribute("collegeBookmarks");
          	JSONArray jsonArray = (JSONArray) jsonParser.parse(collegeBookmarks); 
          	for(int i = 0; i < jsonArray.size(); ++i) {
          		JSONObject jsonObject = (JSONObject) jsonArray.get(i); %>
          	<div class="columns is-vcentered" id="college-list">
          		<div class="column is-2">
          			<img alt="college-pic" src="<% out.println("./assets/logos/"+jsonObject.get("universityID")+".png"); %>">
          		</div>
          		<div class="column side-align">
          			<div class="box">
          			<div class="clg-name">
          			<% out.println(jsonObject.get("university")); %>
          			</div>
          			<p class="clg-desc">
          			<% out.println(jsonObject.get("univDescription")); %>
          			</p>
          			<div class="clg-details">
          				<div class="space-tags">
          					<span class="tag is-medium is-warning desc-tags">Examination</span>
          					<span class="clg-exam"><% out.println(jsonObject.get("examID")); %></span>
          				</div>
          				<div>
          					<span class="tag is-medium is-warning desc-tags">Cut-Off Score</span>
          					<span class="clg-cutoff"><% out.println(jsonObject.get("expectedCutoff")); %></span>
          				</div>
          			</div>
          			<div class="buttons is-right clg-btns">
          				<a class="button is-dark is-rounded clg-location" target="_blank" href="<% out.println(jsonObject.get("location")); %>">Locate in Maps</a>
          				<a class="button is-link clg-url" target="_blank" href="<% out.println(jsonObject.get("siteURL")); %>">View More</a>
          			</div>
          			</div>
          		</div>
          	</div>
          	<%} %>
          </div>
          <div class="mainhead has-text-centered"><div class="box">Bookmarked Exams</div></div>
          <div id="exambk">
          <% String examBookmarks = (String) request.getAttribute("examBookmarks");
          	JSONArray jsonArray2 = (JSONArray) jsonParser.parse(examBookmarks); 
          	for(int i = 0; i < jsonArray2.size(); ++i) {
          		JSONObject jsonObject2 = (JSONObject) jsonArray2.get(i); %>
          	<div class="columns is-vcentered" id="exam-list">
          		<div class="column side-align">
          			<div class="box">
          				<div class="exam-name">
          				<% out.println(jsonObject2.get("exam")); %>
          				</div>
          				<p class="exam-desc">
          				<% out.println(jsonObject2.get("examDescription")); %>
          				</p>
          				<div class="exam-details">
          					<span class="tag is-medium is-warning desc-tags">Total Marks</span>
          					<span class="exam-cutoff"><% out.println(jsonObject2.get("totalMarks")); %></span>
          				</div>
          			</div>
          		</div>
          	</div>
          	<% } %>
          </div>
          </section>
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
    </body>
</html>