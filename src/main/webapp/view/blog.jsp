<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>My Blog</h2>

<p>This Blog is a personal commentary on issues that are related to money laundering prevention and financial crime. The opinions contained in this Blog are my own and in no way necessarily represent the views of anyone else, including those of my employer. Occasionally, additional contributors may add their own attributed  commentaries.</p>

<div>${firstBlog.topic}</div>
<p>
${firstBlog.description}
</p>
<p>As at ${firstBlog.date}</p>

<h2>More Related Topics</h2>
<c:forEach items="${allBlog}" var="blog">
    <div class="blogTopicsContainer">
	    <p>
	    	<a href="/blog/${blog.id}">${blog.topic}</a><br>
	    	<small>As at ${blog.date}</small>
	    </p>
	</div>				
</c:forEach>
