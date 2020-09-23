

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head id="ctl00_header">
		<head>

			<script language="JavaScript" src="scripts/gen_validatorv31.js"
				type="text/javascript">
</script>
			<script language="JavaScript" type="text/javascript"
				src="scripts/ts_picker.js">
</script>
			<script language="JavaScript1.1" src="scripts/pass.js">
</script>
			<script type="text/javascript" src="scripts/image.js">
</script>
			<script type="text/javascript" src="scripts/general.js">
</script>
			<script type="text/javascript" src="scripts/adi.js">
</script>
			<script type="text/javascript" src="scripts/form_validation.js">
</script>

			<script language="JavaScript" src="images/javascripts.js">
</script>
			<script language="JavaScript" src="images/pop-closeup.js">
</script>
			<script>

//var x_win = window.self; 

function goOn() {
	var port = document.register.port.value;
	var host = document.register.host.value;
	var userName = document.register.userName.value;
	window.location.href = 'http://' + host + ':' + port
			+ '/HospitalDeviceManagement/CheckUserAction?userName=' + userName
			+ "&path=./RegistrationForm.jsp";
}
</script>
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

			<%
				if (session.getAttribute("userid") == null) {

					RequestDispatcher rd = request
							.getRequestDispatcher("./LoginForm.jsp");
					rd.forward(request, response);
			%>
			<%
				}
			%>

			<html>
				<head>

					<script language="JavaScript"
						src="<%=request.getContextPath()
							+ "/scripts/gen_validatorv31.js"%>"
						type="text/javascript">
					</script>



				</head>

				<body>

					<jsp:include page="Header.jsp"></jsp:include>


					<center>
						<b><h4>
								Add New Devices
							</h4> </b>
					</center>
					<form method='post'
						action="<%=request.getContextPath() + "/AddDeviceCompanyAction"%>"
						name="company">
						<table align="center" bgcolor="skyblue">
							<tr>
								<td align='right'>
									<b>CompanyName :</b>
								</td>
								<td>
									<input type='text' name='companyname' value='' />
								</td>
								<tr>
									<td align='right'>
										<b>Street :</b>
									</td>
									<td>
										<input type="text" name="street" value="" size="20" />
									</td>
								</tr>
								<tr>
									<td align='right'>
										<b> City : </b>
									</td>
									<td>
										<input type="text" name="city" value="" size="20" />
									</td>
								</tr>

								<tr>
									<td width="120" align='right'>
										<b>District :</b>
									</td>
									<td width="273">
										<input type="text" name="district" value="" size="20" />
									</td>
								</tr>
								<tr>
									<td align='right'>
										<b>State :</b>
									</td>
									<td>
										<input type="text" name="state" value="" size="20" />
									</td>
								</tr>
								<tr>
									<td align='right'>
										<b>Country :</b>
									</td>
									<td>
										<input type="text" name="country" value="" size="20" />
									</td>
								</tr>
								<tr>
									<td align='right'>
										<b>Email :</b>
									</td>
									<td>
										<input type="text" name="email" value="" size="20" />
									</td>
								</tr>
								<tr>
									<td align='right'>
										<b>Phone No :</b>
									</td>
									<td>
										<input type="text" name="phoneNo" value="" size="20"
											onBlur="ValidateForm()" />
									</td>
								</tr>
								<tr>
									<td align='right'>
										<input type='submit' value='Add' />
									</td>
									<td>
										<input type='reset' value='Clear' />
									</td>
								</tr>
						</table>
					</form>
					<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("company");
frmvalidator.addValidation("companyname", "req",
		"Please enter your Company Name");

frmvalidator.addValidation("street", "req", "Please enter your Street Name");
frmvalidator.addValidation("phoneNo", "req");
frmvalidator.addValidation("phoneNo", "maxlen=50");
frmvalidator.addValidation("phoneNo", "numeric");
frmvalidator.addValidation("phoneNo", "Phone");

frmvalidator.addValidation("email", "maxlen=50");
frmvalidator.addValidation("email", "req");
frmvalidator.addValidation("email", "email");

frmvalidator.addValidation("city", "req", "Please enter your city Name");
frmvalidator.addValidation("state", "req", "Please enter your State Name");
frmvalidator.addValidation("country", "req", "Please enter your Country Name");
</script>
					<br />
					<jsp:include page="Footer.jsp"></jsp:include>
				</body>
			</html>