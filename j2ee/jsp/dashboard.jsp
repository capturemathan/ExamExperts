<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <div class="mainhead has-text-centered">
          My Dashboard
      </div>
        <div class="columns">
            <div class="column is-4 is-offset-2">
                <a href="<%=request.getContextPath()%>/bookmarks">
                <div class="box">
                    <div class="columns">
                        <div class="column is-6">
                            <figure class="image is-128x128">
                                <img src="./assets/placeholders/bookmark.png">
                              </figure>
                        </div>
                        <div class="column has-text-centered col-head">
                            My Bookmarks
                            <div class="col-text">
                                Find your Saved Bookmarks here
                            </div>
                        </div>
                        
                    </div>
                </div>
                </a>
            </div>
            <div class="column is-4">
                <a href="<%=request.getContextPath()%>/colleges">
                <div class="box">
                    <div class="columns">
                        <div class="column is-6">
                            <figure class="image is-128x128">
                                <img src="./assets/placeholders/college.png">
                              </figure>
                        </div>
                        <div class="column has-text-centered col-head">
                            Colleges
                            <div class="col-text">
                                Search exams to enter your desired college
                            </div>
                        </div> 
                    </div>
                </div>
                </a>
            </div>
        </div>
        <div class="columns">
            <div class="column is-4 is-offset-1">
                <a href="<%=request.getContextPath()%>/exams">
                <div class="box">
                    <div class="columns">
                        <div class="column is-6">
                            <figure class="image is-128x128">
                                <img src="./assets/placeholders/exam.png">
                              </figure>
                        </div>
                        <div class="column has-text-centered col-head">
                            Exams
                            <div class="col-text">
                                Search your desired exams in one go.
                            </div>
                        </div>
                        
                    </div>
                </div>
                </a>
            </div>
            <div class="column is-4 is-offset-2">
                <div class="box">
                    <div class="columns">
                        <div class="column is-6">
                            <figure class="image is-128x128">
                                <img src="./assets/placeholders/prediction.png">
                              </figure>
                        </div>
                        <div class="column has-text-centered col-head">
                            Rank Predictor
                            <div class="col-text">
                                Predict your results with our data
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--Scripts ARENA-->
        <script src="https://unpkg.com/typewriter-effect@latest/dist/core.js"></script>
        <script>
            // TYPEWRITER JS
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