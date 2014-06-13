<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<h2>Admin Dashboard</h2>

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