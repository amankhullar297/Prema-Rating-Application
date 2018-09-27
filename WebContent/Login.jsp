 <%@include file="swAssets/include/header.jsp"%>

<!-- Google Maps Sections -->
<section id="google_map" class="">
	<div class="container-fullwidth">
		<!-- <div style="width:100%;height:60px;" class="ourmaps"></div> -->
	</div>
</section>

<!-- Contact form -->
<section id="message_area">
	<div class="container">
		<!-- <div class="row">
			<div class="col-md-6 col-sm-6">
				<div class="message_top_text text-center">
					<h2><b>Login</b></h2>
					
				</div>
			</div>
			<div class="col-md-6 col-sm-6">
				<div class="message_top_text text-center">
					<h2><b>Sign up</b></h2>
					
				</div>
			</div>
		</div> -->

		<div class="row">
			<div class="messsage_contant" align="center">
			<h2><b>Login</b></h2>

					<form:form modelAttribute="loginModel" action="loginNow" method="post">
						<h7>${result}</h7><br>
						<form:input type="email" path="email" placeholder="Email" required="true"/><br><br>
						<form:input type="password" path="pwd" placeholder="Password" required="true"/><br><br>
						<input type="submit" value="login">
					</form:form>					
			<!-- End of messsage contant-->
		</div><br><br><br><br><br>
	</div>
</section>


<%@include file="swAssets/include/download.jsp"%>
<%@include file="swAssets/include/footer.jsp"%>