<h2>Login as Admin</h2>
<div class="form_center">
	<div class="form_container login">	
		<div class="status ${status}">${statusMessage}</div>
		<form id="adminForm" action="/internal/admin_login" method="post">	
			<div class="username_password">
				<div class="usermame_input">
					<input type="text" name="username" placeholder="Username" type="text" class="text" maxlength="25">
				</div>
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