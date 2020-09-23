<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.hdm.bean.ProfileTO"%>
<%@ page errorPage="UserExceptionHandler.jsp"%>
<%
	String path;
	String usertype;
	String s;
	Vector c;
	Iterator it;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
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
		</head>
		<body>

			<jsp:include page="Header.jsp"></jsp:include>
			<br />
			<form method='post' action="./UpdateUserProfileAction"
				name="register" onsubmit="return validate()">
				<!--<table border="1"><tr><td></td></tr></table>-->
				<input type="hidden" name="port" value="<%=request.getLocalPort()%>" />
				<input type="hidden" name="host"
					value="<%=request.getServerName()%>" />
				<br />

				<table border='0' align="center">
					<th colspan="6" bgcolor="#999933">
						Personal Details
					</th>
					<%
						c = (Vector) request.getAttribute("userinfo");
						it = c.listIterator();
						if (it.hasNext()) {
							ProfileTO pro = (ProfileTO) it.next();
							path = request.getRealPath("/images");
							s = path + "\\" + pro.getPhoto();
							System.out.println(s);
					%>
					<tr></tr>
					<tr></tr>
					<tr>
						<td align='right'>
							First Name :
						</td>
						<td>
							<input type="text" name="firstName"
								value="<%=pro.getFirstName()%>" readonly />
						</td>
						<td align='right'>
							Browse Photo :
						</td>
						<td>
							<input type="file" name="photo1" class="textfield"
								onChange="preview(this)" />
							<input type="hidden" name="photo" value='<%=pro.getPhoto()%>'>
							<input type="hidden" name="userid"
								value='<%=request.getParameter("userid")%>'>
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td border="0" align="left" rowspan="5" colspan='2'>
							<img alt="See Photo Here" id="previewField"
								src="<%=pro.getPhoto()%>" height="150" width="120" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Last Name :
						</td>
						<td>
							<input type="text" name="lastName" value="<%=pro.getLastName()%>"
								size="20" />
						</td>
						<td align='right'>

						</td>
						<td>

						</td>
					</tr>
					<tr>
						<td align='right'>
							Birth Date :
						</td>
						<td width='256'>
							<input type="text" name="birthdate"
								value="<%=pro.getBirthdate()%>" size="20" ="" />
							<a
								href="javascript:show_calendar('document.register.birthdate', document.register.birthdate.value);">
								<img src="images/cal.gif" alt="a" width="18" height="18"
									border="0" /> </a>
						</td>
						<td align='right'>
						</td>
						<td>

						</td>
					</tr>
					<tr>
						<td align='right'>
							Email :
						</td>
						<td>
							<input type="text" name="email" value="<%=pro.getEmail()%>"
								size="20" />
						</td>
						<td>
							<input type="hidden" name="email" value="<%=pro.getAddressid()%>" />
						</td>
						<td></td>
					</tr>
					<tr>

						<td align='right'>
							Gender :
					</tr>
					<td align='left'>
						<select name="gender">
							<option value="<%=pro.getGender()%>" selected="true">
								<font size="3" face="Verdana"><%=pro.getGender()%></font>
							</option>
							<option value="Male">
								<font size="3" face="Verdana">Male</font>
							</option>
							<option value="Female">
								<font size="3" face="Verdana">Female</font>
							</option>
						</select>
					</td>
					<td></td>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr></tr>
					<tr></tr>
					<th colspan="6" bgcolor="#999933">
						<center> Contact Details </center>
					</th>
					<tr></tr>
					<tr></tr>
					<tr>
						<td align='right'>
							Address Type :
						</td>
						<td width="276">
							<select name="addressType" onChange="cleartext()">
								<option value="<%=pro.getAddressType()%>">
									<font size="3" face="Verdana"><%=pro.getAddressType()%></font>
								</option>
								<option value="home">
									<font size="3" face="Verdana">Home</font>
								</option>
								<option value="office">
									<font size="3" face="Verdana">Office</font>
								</option>
								<option value="personal">
									<font size="3" face="Verdana">Personal</font>
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align='right'>
							House No :
						</td>
						<td>
							<input type="text" name="houseNo" value="<%=pro.getHouseNo()%>"
								size="20" />
						</td>

						<td width="120" align='right'>
							District :
						</td>
						<td width="273">
							<input type="text" name="district" value="<%=pro.getDistrict()%>"
								size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Street :
						</td>
						<td>
							<input type="text" name="street" value="<%=pro.getStreet()%>"
								size="20" />
						</td>
						<td align='right'>
							State :
						</td>
						<td>
							<input type="text" name="state" value="<%=pro.getState()%>"
								size="20" />
						</td>
					</tr>
					<tr>
						<td width="120" align='right'>
							City :
						</td>
						<td width="273">
							<input type="text" name="city" value="<%=pro.getCity()%>"
								size="20" />
						</td>

						<td align='right'>
							Country :
						</td>
						<td>
							<input type="text" name="country" value="<%=pro.getCountry()%>"
								size="20" />
						</td>
					</tr>
					<tr>
						<td align='right'>
							Phone No :
						</td>
						<td>
							<input type="text" name="phoneNo" value="<%=pro.getPhoneNo()%>"
								size="20" />
						</td>
						<td align='right'>
							Pin :
						</td>
						<td>
							<input type="text" name="pin" value="<%=pro.getPin()%>" size="20" />
						</td>
					</tr>
					<th colspan="5">
						&nbsp;
					</th>
					<tr></tr>
					<tr></tr>
					<%
						}
					%>
					<tr>
						<td></td>
						<td align="right">
							<font size="3" face="Verdana"> <input type="submit"
								name="update" value="update" />&nbsp; </font>
						</td>
						<td align="left">
						</td>
						<td></td>
					</tr>
				</table>
				<br />
				<br />
				<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("register");

frmvalidator.addValidation("firstName", "req", "Please enter your First Name");
frmvalidator.addValidation("firstName", "maxlen=20",
		"Max length for FirstName is 20");
frmvalidator.addValidation("firstName", "alpha",
		" First Name Alphabetic chars only");

frmvalidator.addValidation("lastName", "req", "Please enter your Last Name");
frmvalidator.addValidation("lastName", "maxlen=20", "Max length is 20");
frmvalidator.addValidation("lastName", "alpha",
		" Last Name Alphabetic chars only");

frmvalidator.addValidation("birthdate", "req", "Please enter your birthdate");

frmvalidator.addValidation("photo", "req", "Please Load Your Photo");

frmvalidator.addValidation("email", "maxlen=50");
frmvalidator.addValidation("email", "req");
frmvalidator.addValidation("email", "email");

frmvalidator.addValidation("houseNo", "req", "Please enter your House Number");

frmvalidator.addValidation("street", "req", "Please enter your Street Number");
frmvalidator.addValidation("phoneType", "dontselect=0");
frmvalidator.addValidation("phoneNo", "req");

frmvalidator.addValidation("phoneNo", "maxlen=50");
frmvalidator.addValidation("phoneNo", "numeric");
frmvalidator.addValidation("phoneNo", "Phone");
frmvalidator.addValidation("city", "req", "Please enter your city Name");
frmvalidator.addValidation("state", "req", "Please enter your State Name");
frmvalidator.addValidation("country", "req", "Please enter your Country Name");
frmvalidator.addValidation("pin", "req", "Please enter your pin Number");
frmvalidator.addValidation("userName", "req", "Please enter your Username");
frmvalidator.addValidation("password", "req", "Please enter your Password");
frmvalidator.addValidation("conformpassword", "req",
		"Please enter your Confirm Password");
frmvalidator.addValidation("secrete", "req", "Please enter your Answer");
frmvalidator.addValidation("squest", "dontselect=0");
frmvalidator.addValidation("fax", "req", "Please enter Fax Number");
</script>
				<jsp:include page="Footer.jsp"></jsp:include>
		</body>
</html>