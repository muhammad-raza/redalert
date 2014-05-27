<%@ page pageEncoding="ISO-8859-1" %>
<!Doctype html>
<html>
<head lang="en">
    <meta http-equiv="Cache-control" content="public">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0, maxuser-scalable=no">
    
    <meta name="description" content="This Book is intended to serve as a comprehensive source of information for money laundering professionals.">
    
    <meta property="og:title" content="Red Alert | Money Laundering Cases & Materials"/>
    <meta property="og:description" content="This Book is intended to serve as a comprehensive source of information for money laundering professionals."/>
    <meta property="og:image" content="http://www.redalert.org.uk/images/book_thumbnail.png"/>
    <meta property="og:url" content="http://www.redalert.org.uk"/>

    <meta property="twitter:title" content="Red Alert | Money Laundering Cases & Materials"/>
    <meta property="twitter:description" content="This Book is intended to serve as a comprehensive source of information for money laundering professionals."/>
    <meta property="twitter:image" content="http://www.redalert.org.uk/images/book_thumbnail.png"/>
    <meta property="twitter:url" content="http://www.redalert.org.uk"/>

    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600|Arvo:700,400" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/style/style.css">
    <link rel="stylesheet" type="text/css" href="/style/mobile_style.css">
    <link rel="icon" type="image/png" href="/images/book_favicon.png" />    


    <script src="/js/pdf.js"></script>
    <script>
        PDFJS.workerSrc = '/js/pdf.worker.js';
    </script>
    <script src="/js/jquery.js"></script>        
    <script src="/js/main.js"></script>    
    
    <title>${title}</title>
</head>
<body>
<div id="container" data-role="page">    

    <div class="mobile_menu" data-role="content">
        <div class="mobile_menu_button"></div>
    </div>

    <div class="upper_body">
        <a href="/"><div class="main_heading"></div></a>
        <div itemscope itemtype="http://schema.org/Book" itemref="edition description rating review" class="main_heading_desc"><span itemprop="name">Money Laundering Cases and Materials</span></br> by <a itemprop="author" class="author" href="/biography">John Cusack</a>

        <span itemprop="aggregateRating" itemscope itemtype="http://schema.org/AggregateRating">
            <meta itemprop="ratingValue" content="4.9">
            <meta itemprop="reviewCount" content="22">
        </span>
        
        </div>


        <div class="line"></div>
        <div class="line"></div>
    </div>

    <div class="body_container">
        <div class="left_nav">
            <span class="close">X</span>
            <ul>
                <li><a href="/">Read The Book</a></li>
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
                <!-- <li><a href="/request_test">Request Test</a></li> -->
                <li><a href="/book_reviews">Book Reviews</a></li>
                <li><a href="/buy_or_download">Buy/Download Red Alert</a></li>
                <li><a href="/contact_me">Contact me</a></li>
            </ul>
        </div>
        
        <div class="right_hand_side">
            <jsp:include page="${pageName}" />            
        </div>
    
    </div>

</div>


    <div class="left_nav mobile_left_nav">
            <span class="close">X</span>
            <ul>
                <li><a href="/">Read The Book</a></li>
                <li><a href="/biography">About the author</a></li>
                <li><a href="/matthew_cooper">Dedication to Matthew cooper</a></li>
                <li><a href="/book_reviews">Book Reviews</a></li>
                <li><a href="/buy_or_download">Buy/Download Red Alert</a></li>
                <li><a href="/contact_me">Contact me</a></li>
            </ul>
        </div>
    </div>


</body>
</html>