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
				DOCTOR DEVICES LIST
			</h3>
		</center>
		
		<center>
			<table border='1'>
				<tr bgcolor='white'>
					<td align='center'>
						Sno
					</td>
					<td align='center' width='200'>
						<b>Doctor Name</b>
					</td>
					<td align='center' width='100'>
						<b>Device Name</b>
					</td>
					<td align='center' width='100'>
						<b>Device Quantity</b>
					</td>
					<td align='center' width='100'>
						<b>DevicePatirntRatio</b>
					</td>
					<td align='center' width='100'>
						<b>DeviceworkStatus</b>
					</td>
				</tr>
				<c:forEach var="device" items="${deviceTO}">
					<tr>
						<c:choose>
							<c:when test="${sessionScope.role eq 'Doctor'}">
								<td>
									<b><a
										href="./UpdateViewDoctorDevice?devicedetailsid=${device.devicedetailsid }">${device.devicedetailsid
											}</a> </b>
								</td>
							</c:when>
							<c:otherwise>
								<td>
									<b>${device.devicedetailsid }</b>
								</td>
							</c:otherwise>
						</c:choose>

						<td align='center'>
							<b> ${device.doctorname } 
						</td>
						<td align='center'>
							<b> ${device.devicename } 
						</td>
						<td align='center'>
							<b> ${device.devicequantity } 
						</td>
						<td align='center'>
							<b> ${device.ratio}</b>
						</td>
						<td align='center'>
							<b> ${device.deviceworkstatus}</b>
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
