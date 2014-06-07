<h2>Contact me</h2>

<p>This Book has been created to encourage discussion and comment. If you have questions comments or opinions please don't hesitate to contact me. I can be contacted at Jpcusack78@gmail.com.</p>

<div class="form_container">
	<div class="status ${status}">${statusMessage}</div>
<form id="emailForm" action="/email" method="post">	
	<div class="name_email">
		<div class="name_input">
			<input name="name" value="${emailContent.getName()}" id="nameInput" placeholder="Name" type="text" class="text" maxlength="25">
		</div>
		<div class="email_input">
			<input name="email" value="${emailContent.getEmail()}" id="emailInput" placeholder="Email" type="text" class="text" maxlength="40">
		</div>
		<div class="clearfix"></div>
	</div>
	
	<div class="message_input">
		<textarea name="message" id="messageInput" class="message" placeholder="Message" maxlength="150">${emailContent.getMessage()}</textarea>
		<div>Max: 150 words</div>
	</div>		
	<div class="send_email">
		<a id="sendEmailButton" class="button" ontouchstart="" href=""><span>Send Email</span></a>
	</div>	
</form>

</div>