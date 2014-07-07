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

<h2>Blog Post</h2>



<div class="blog_container">
    <form id="commentForm" action="/ajax/comment" method="post"> 
        
        <div class="topic_input">
            <input name="topic" id="topicInput" placeholder="Topic *" type="text" class="text" maxlength="25">
        </div>
        
        <div class="description_input">
            <textarea name="message" id="messageInput" class="description" placeholder="Description *">${emailContent.getMessage()}</textarea>
            
        </div>      
        <div class="post_button">
            <a id="sendCommentButton" class="button" ontouchstart="" href=""><span>Post Blog</span></a>
        </div>  
    </form>

</div>