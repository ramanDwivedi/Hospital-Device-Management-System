<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int count = 0;
%>
<%
	if (session.getAttribute("role") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("./LoginForm.jsp");
		rd.forward(request, response);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<h3>
				DOCTOR APPROVED DEVICES LIST
			</h3>
		</center>
		<center>
			<table border='1'>
				<tr bgcolor='white'>
					<td align='center'>
						<b>Sno</b>
					</td>
					<td align='center' width='200'>
						<b>Provider Name</b>
					</td>
					<td align='center' width='100'>
						<b>Doctor Name</b>
					</td>
					<td align='center' width='100'>
						<b>Device Name</b>
					</td>
					<td align='center' width='100'>
						<b>DeviceQuantity</b>
					</td>
					<td align='center' width='100'>
						<b>ReceviedDate</b>
					</td>
				</tr>
				<c:forEach var="device" items="${doctor_devices}">
					<tr>
						<td>
							<b><%=++count%></b>
						</td>
						<td align='center'>
							<b> ${device.financername } 
						</td>
						<td align='center'>
							<b> ${device.doctorname } 
						</td>
						<td align='center'>
							<b> ${device.devicename}</b>
						</td>
						<td align='center'>
							<b> ${device.devicequantity}</b>
						</td>
						<td align='center'>
							<b> ${device.devicereceivedate}</b>
						</td>
					</tr>
				</c:forEach>
				<tr>
				</tr>
				<tr>

				</tr>
			</table>

		</center>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
