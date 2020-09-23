<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				DEVICES LIST
			</h3>
		</center>
		<center>
			<table border='0'>
				<tr bgcolor='white'>
					<td align='center'>
						<b>Device Id</b>
					</td>
					<td align='center' width='200'>
						<b>Device Names</b>
					</td>
					<td align='center' width='100'>
						<b>Device Quantity</b>
					</td>

				</tr>
				<c:forEach var="device" items="${inventary}">
					<tr>
						<td>
							<b>${device.inventaryid }</b>
						</td>
						<td align='center'>
							<b> ${device.devicename } 
						</td>
						<td align='center'>
							<b> ${device.devicequantity } 
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
