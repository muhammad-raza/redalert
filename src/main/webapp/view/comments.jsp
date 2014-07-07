<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Leave Your Comment</h2>


<c:forEach items="${comments}" var="comment">
    <c:if test="${comment.approved==1}">
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
        </div>    
    </c:if> 

</c:forEach>

<div class="line"></div>


<p>This Book has been created to encourage discussion and comment. If you have questions comments or opinions please leave it here or <a class="blue" href="/contact_me">send me personal message.</a></p>

<p>Your email address will not be published. Required fields are marked *</p>

<div class="form_container">
    <p class="status ${status}"><strong>${statusMessage}</strong></p>
    <form id="commentForm" action="/ajax/comment" method="post"> 
        <div class="comment">
            <div class="name_input">
                <input name="name" id="nameInput" placeholder="Name *" type="text" class="text" maxlength="25">
            </div>
            <div class="email_input">
                <input name="email" id="emailInput" placeholder="Email *" type="text" class="text" maxlength="40">
            </div>
            
            <div class="clearfix"></div>
        </div>
        
        <div class="message_input">
            <textarea name="message" id="messageInput" class="message" placeholder="Message *" maxlength="250">${emailContent.getMessage()}</textarea>
            <p class="max_words">Max: 250 words</p>
        </div>      
        <div class="post_button">
            <a id="sendCommentButton" class="button" ontouchstart="" href=""><span>Post Comment</span></a>
        </div>  
    </form>

</div>
