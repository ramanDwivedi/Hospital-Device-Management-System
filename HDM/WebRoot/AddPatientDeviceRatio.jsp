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
		<script language="JavaScript1.1" src="scripts/pass.js"></script>
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
					Devices Request Form
				</h4> </b>
		</center>
		<form method='post' action="./AddPatientDeviceRatio" name="ratio">
			<table border='1' align="center" bgcolor="skyblue">
				<tr>
					<td align='right'>
						<b>DoctorName :</b>
					</td>
					<input type='hidden' name='doctorid' value='${sessionScope.userid}' />
					<td>
						<input type='text' name='doctorname'
							value=<c:out value="${sessionScope.loginid}" /> readonly />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>device Name :</b>
					</td>
					<td>
						<select name="deviceid" id="select">
							<option value="">
								--SELECT--
							</option>
							<c:if test="${not empty device}">
								<c:forEach var="dvice" items="${device}">
									<option value="${dvice.deviceid}">
										${dvice.devicename}
									</option>
								</c:forEach>
							</c:if>
						</select>
				<tr>
					<td align='right'>
						<b>Quantity :</b>
					</td>
					<td>
						<input type='text' name="devicequantity" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td align='right'>
						<b>DevicePatient Ratio :</b>
					</td>
					<td>
						<input type='text' name="ratio" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td align='right'>
						<b>Device WorkStatus :</b>
					</td>
					<td>
						<textarea type='text' name="deviceworkstatus" height=50 wedth=10 />
				
					
					</td>
					<td>haiiiiiiiiiiiiiiiii</td>
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
  var frmvalidator  = new Validator(""ratio"");
   frmvalidator.addValidation("deviceid","dontselect=0");
	  frmvalidator.addValidation("devicequantity","numeric");
  </script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
