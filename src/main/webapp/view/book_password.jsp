<div class="form_center">
	<div class="form_container login">
	<p>Complete version of the book requires Author's Permission. Please fill in the valid password or <a class="blue" href="/contact_me">contact author</a> for password.</p>
		<div class="status ${status}">${statusMessage}</div>
		<form id="adminForm" action="/book_password" method="post">
			<div class="username_password">
				<div class="password_input">
					<input type="password" name="password" id="emailInput" placeholder="password" type="text" class="text" maxlength="40">
				</div>
				<div class="clearfix"></div>
			</div>

			<div class="admin_login">
				<a id="adminLogin" class="button" ontouchstart="" href=""><span>Login</span></a>
			</div>
		</form>
	</div>
</div>