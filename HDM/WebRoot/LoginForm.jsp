
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript"></script>
		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>

		<script type="text/javascript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>


	</head>

	<body onload="javascript:disableBackButton()">
		<jsp:include page="Header.jsp"></jsp:include>
		<form action="<%=request.getContextPath() + "/LoginAction"%>"
			method=post name="login">
			<table bgcolor="skyblue" border="0" align="center" bgcolor="white">
				<tr>
					<td height="120" align="center"></td>
					<td>
						<center>
							<table border="0" align="center">
								<tr>
									<td align='center' colspan='2'>
										<h3>
											Login here
										</h3>
									</td>
								</tr>

								<tr>
									<td align='right'>
										<span class="Title">UserID :</span>
									</td>
									<td>
										<font face="Baskerville Old Face"><input type="text"
												name="username"> </font>
									</td>
								</tr>
								<tr>
									<td align='right'>
										<span class="Title">Password :</span>
									</td>
									<td>
										<input type="password" name="password">
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div align="center" class="style11">
											<input type="submit" name="Submit" value="Sign In">
											&nbsp;
											<input name="Input2" type="reset" value="Clear">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;
									</td>
									<td>
										<div align="center">
											<a href="./Recoverpassword.jsp"><font color="#000000">Forgot
													Password....?</font> </a>
										</div>
									</td>
									<td>
										&nbsp;
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;
									</td>
									<td>
										&nbsp;
									</td>
								</tr>


							</table>
				<tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");

  frmvalidator.addValidation("username","req","Login Name is required");
    frmvalidator.addValidation("password","req","Password is required");
   
  </script>
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>