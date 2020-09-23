<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (session.getAttribute("userid") == null) {
		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js">
</script>
		<script type="text/javascript" src="scripts/image.js"> </script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/adi.js"> </script>
		<script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
		<script>
		<script language="JavaScript"
			src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript"></script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<b><h4>
					Add New Devices
				</h4> </b>
		</center>
		<form method='post'
			action="<%=request.getContextPath() + "/AddNewDeviceAction"%>"
			name="Device">
			<table border='1' align="center" bgcolor="skyblue">

				<tr>
					<td align='right'>
						<b>DeviceName :</b>
					</td>
					<td>
						<input type='text' name='devicename' value=''>
					</td>
					<td rowspan='3'>
						<img alt="See Photo Here" id="previewField" src="images/flag.gif"
							height="150" width="120" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>Device Description :</b>
					</td>
					<td>
						<input type='text' name="devicedesc" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td align='right'>
						<b>Company Name :</b>
					</td>
					<td>
						<select name="companyid" id="select">
							<option value="">
								--SELECT--
							</option>
							<c:if test="${not empty company}">
								<c:forEach var="cmp" items="${company}">
									<option value="${cmp.companyid}">
										${cmp.companyname}
									</option>
								</c:forEach>
							</c:if>
						</select>
				<tr>
					<td align='right'>
						<b>Device Image :</b>
					</td>
					<td>
						<input type='file' name="deviceimage" class="textfield"
							onChange="preview(this)" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td align='right'>
						<input type=submit value=Add>
					</td>
					<td>
						<input type=reset value=Clear>
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("Device");
 
frmvalidator.addValidation("devicename","req","Please enter your Company Name");
frmvalidator.addValidation("animaldesc","req","Please enter your Device Description");
   frmvalidator.addValidation("companyid","dontselect=0");
    frmvalidator.addValidation("Deviceimage","req","Device Image is not selected");

  </script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
