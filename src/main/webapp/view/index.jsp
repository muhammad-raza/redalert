<%@ page pageEncoding="ISO-8859-1" %>
<!Doctype html>
<html>
<head lang="en">
    <meta http-equiv="Cache-control" content="public">
    
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600|Arvo:700,400" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/style/style.css">
    <link rel="stylesheet" type="text/css" href="/style/mobile_style.css">
    <link rel="icon" type="image/png" href="/images/book_favicon.png" />

    <script src="/js/jquery.js"></script>
    <script src="/js/turn.js"></script>
    <script src="/js/turn_responsive.js"></script>
    <script src="/js/main.js"></script>
    
    <title>Red Alert</title>
</head>
<body>
<div id="container">

    <div class="login_container">
        <form>
            <input type="text" name="email" value="" placeholder="Email address" maxlength="30"/>
            <input type="password" name="password" placeholder="password" value=""/>
            <input class="button" type="submit" value="Login"/>
            <span>&nbsp;or&nbsp;</span>
            <span href="#" class="button register">Register</span>
        </form>
    </div>

    <div class="mobile_menu">
        <div class="mobile_menu_button"></div>
    </div>

    <div class="upper_body">
        <a href="/"><div class="main_heading">RED ALERT</div></a>
        <div class="main_heading_desc">Money Laundering Cases and Materials </br> by John Cusack</div>
        <div class="signIn hidden"><a class="anim" href="/secure/signin">Sign In / Register</a></div>
    </div>

    <div class="body_container">
        <div class="left_nav">
            <ul>
                <li><a href="/">Buy The Book</a></li>
                <li><a href="/biography">About the author</a></li>
                <li><a href="/matthew_cooper">Dedication to Matthew cooper</a></li>
                <!-- <li><a href="/table_of_contents">Table of contents</a>
                    <ul class="table_of_contents">
                        <li><a href="/table_of_contents#introduction">Introduction</a></li>
                        <li class="part"><a href="/table_of_contents#money_laundering_crimes">Part 1:</a></li>
                        <li><a href="/table_of_contents#money_laundering_crimes">Money Laundering Crimes</a></li>
                        <li><a href="/table_of_contents#money_laundering_risks">Money Laundering Risks</a></li>
                        <li><a href="/table_of_contents#money_laundering_laws">Money Laundering Laws & Regulations</a></li>
                        <li><a href="/table_of_contents#money_laundering_prevention">Money Laundering Prevention Programmes</a></li>
                        <li class="part"><a href="/table_of_contents#criminals_and_terrorists">Part 2:</a></li>
                        <li><a href="/table_of_contents#criminals_and_terrorists">Criminals & Terrorists</a></li>
                        <li><a href="/table_of_contents#terrorist_attacks">Terrorist Attacks</a></li>
                        <li><a href="/table_of_contents#criminal_cases">Criminals Cases</a></li>
                        <li><a href="/table_of_contents#enforcement_cases">Enforcement Cases</a></li>
                    </ul>
                </li>        -->          
                <li><a href="/request_test">Request Test</a></li>
                <li><a href="/book_reviews">Book Reviews</a></li>
            </ul>
        </div>
        
        <div class="right_hand_side">
            <jsp:include page="${pageName}" />            
        </div>
    
</div>

</div>
    <!-- <footer> -->

    <!-- </footer> -->
</body>
</html>