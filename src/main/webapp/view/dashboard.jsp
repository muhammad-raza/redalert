<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<h2>Reader's Comments</h2>

<c:forEach items="${comments}" var="comment">
    
    <div class="comment">
    	<div class="comment_header">
    		<div class="comment_image">
    			<img class="comment_image_src" src="/images/person.png">
    		</div>
    		<div class="comment_name">${comment.name}</div>
    		<div class="comment_time">${comment.time}</div>
    		<div class="clearfix"></div>
    	</div>
    	<p class="comment_message">
    		${comment.comment}
    	</p>
    	<div class="buttonHolder">
			
		<span data-commentid="${comment.id}" class="simpleButtonGreen <c:if test="${comment.approved=='1'}">displayNone</c:if>">Allow</span>

		<span data-commentid="${comment.id}" class="simpleButtonRed <c:if test="${comment.approved=='0'}">displayNone</c:if>">DisAllow</span>

	    	<span data-commentid="${comment.id}" class="simpleButtonDelete">Delete</span>
	    </div>	
    </div>    

</c:forEach>

<div class="line"></div>

<h2>Blog Posts</h2>

<c:forEach items="${blog}" var="blog">
    <div class="blogTopicsContainer">
        <p>
            <a href="/blog/${blog.id}">${blog.topic}</a><br>
            <small>As for ${blog.date}</small>
            <div></div>
            <span data-blogid="${blog.id}" class="simpleBlogDelete">Delete</span>
        </p>
    </div>             
    <div class="line"></div> 
</c:forEach>




<div class="blog_container">
    <p class="status"></p>
    <form id="blogForm" action="/ajax/addBlog" method="post"> 
        
        <div class="topic_input">
            <input name="topic" id="topicInput" placeholder="Topic *" type="text" class="text">
        </div>
        
        <div class="description_input">
            <textarea name="description" id="descriptionInput" class="description" placeholder="Description *">${emailContent.getMessage()}</textarea>
            
        </div>      

        <div class="date">
            <span>As at </span>
            <select name="month" id="monthInput">
                <option value="">Month</option>
                <option value="January">January</option>
                <option value="February">February</option>
                <option value="March">March</option>
                <option value="April">April</option>
                <option value="May">May</option>
                <option value="June">June</option>
                <option value="July">July</option>
                <option value="August">August</option>
                <option value="September">September</option>
                <option value="October">October</option>
                <option value="November">November</option>
                <option value="December">December</option>                
            </select>

            <select name="year" id="yearInput">
                <option value="">Year</option>
                <c:forEach items="${years}" var="year">
                    <option value="${year}">${year}</option>
                </c:forEach>                
            </select>
        </div>  

        <div class="post_button">
            <a id="postBlogButton" class="button" ontouchstart="" href=""><span>Post Blog</span></a>
        </div>

    </form>

    <p><div>You can use the following in description:</div></p>

    <p>&lt;p&gt;&nbsp;This is Example Paragraph&nbsp;&lt;/p&gt;</p>
    <p>&lt;a href="www.google.com"&gt;<a href="www.google.com">&nbsp;This is Example Link&nbsp;</a>&lt;/a&gt;</p>
    <p><div>&lt;div&gt;&nbsp;This is Example Bold Text&nbsp;&lt;/div&gt;</div></p>
    <p>For new line use &lt;br&gt;</p>
</div>