<!Doctype html>
<html>
<head lang="en">
    <meta http-equiv="Cache-control" content="public">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0, maxuser-scalable=no">
    
    <meta name="description" content="${description}">
    
    <meta property="og:title" content="${title}"/>
    <meta property="og:description" content="${description}"/>
    <meta property="og:image" content="http://www.redalert.org.uk/images/book_thumbnail.png"/>
    <meta property="og:url" content="http://www.redalert.org.uk"/>

    <meta property="twitter:title" content="${title}"/>
    <meta property="twitter:description" content="${description}"/>
    <meta property="twitter:image" content="http://www.redalert.org.uk/images/book_thumbnail.png"/>
    <meta property="twitter:url" content="http://www.redalert.org.uk"/>

    <link rel="stylesheet" type="text/css" href="/style/style.css">
    <link rel="icon" type="image/png" href="/images/book_favicon.png" />    

    <script src="/js/jquery.js"></script>        
    <script src="/js/main.js"></script>    
    
    <title>${title}</title>


    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

      ga('create', 'UA-44977573-2', 'redalert.org.uk');
      ga('send', 'pageview');

    </script>

    
</head>
<body>
<div id="container" data-role="page">    

    <div class="mobile_menu" data-role="content">
        <div class="mobile_menu_button"></div>
    </div>

    <div class="upper_body">
        <a href="/"><div class="main_heading"></div></a>
        <div itemscope itemtype="http://schema.org/Book" itemref="review" class="main_heading_desc"><span itemprop="name">Money Laundering Cases and Materials</span></br> by <a itemprop="author" class="author" href="/biography">John Cusack</a>
        
        <meta itemprop="bookEdition" content="2014 Edition - Issue 1">        
        <meta itemprop="description" content="Money Laundering Cases and Materials for professionals">
        <meta itemprop="numberOfPages" content="430">
        <meta itemprop="inLanguage" content="en-US">
        <meta itemprop="about" content="Money Laundering Cases and Materials for professionals">
        <meta itemprop="headline" content="This book is dedicated to the hard work of all those involved in money laundering prevention and in particular to one of its brightest sons, and so to the memory of MATTHEW COOPER">
        <link itemprop="thumbnailUrl" href="http://www.redalert.org.uk/images/book_thumbnail.png">

        <span itemprop="aggregateRating" itemscope itemref="rating" itemtype="http://schema.org/AggregateRating">
            <meta itemprop="ratingValue" content="4.9">            
        </span>
        
        </div>


        <div class="line"></div>
        <div class="line"></div>
    </div>

    <div class="body_container">
        <div class="left_nav">
            <span class="close">X</span>
            <ul class="nav_list">
                <li><a href="/">Read The Book</a></li>
                <li><a href="/biography">About the author</a></li>
                <li><a href="/matthew_cooper">Dedication to Matthew cooper</a></li>
                <li><a href="/book_reviews">Book Reviews</a></li>
                <li><a href="/buy_or_download">Buy/Download Red Alert</a></li>
                <li><a href="/contact_me">Contact me</a></li>
                <li><a href="/comments">Reader's Comments</a></li>
                <li><a href="/blog">Blog</a></li>                
            </ul>
        </div>
        
        <div class="right_hand_side">
            <jsp:include page="${pageName}" />                        
        </div>
    
    </div>

</div>

    <div class="mobile_left_nav">
            <span class="close">X</span>
            <ul>
                <li><a href="/">Read The Book</a></li>
                <li><a href="/biography">About the author</a></li>
                <li><a href="/matthew_cooper">Dedication to Matthew cooper</a></li>
                <li><a href="/book_reviews">Book Reviews</a></li>
                <li><a href="/buy_or_download">Buy/Download Red Alert</a></li>
                <li><a href="/contact_me">Contact me</a></li>
                <li><a href="/comments">Reader's Comments</a></li>
                <li><a href="/blog">Blog</a></li>                
            </ul>
        </div>
    </div>


</body>
</html>