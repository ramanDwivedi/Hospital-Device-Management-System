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
<html>
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
			<table border='1'>
				<tr bgcolor='white'>
					<td align='center'>
						Sno
					</td>
					<td align='center' width='200'>
						<b>Device Names</b>
					</td>
					<td align='center' width='100'>
						<b>Device Description</b>
					</td>
					<td align='center' width='100'>
						<b>Device CompanyName</b>
					</td>
					<td align='center' width='100'>
						<b>DeviceImage</b>
					</td>
				</tr>
				<c:forEach var="device" items="${deviceTO}">
					<tr>
						<td><%=++count%></td>
						<td align='center'>
							<b> ${device.devicename } 
						</td>
						<td align='center'>
							<b> ${device.devicedesc } 
						</td>
						<td align='center'>
							<b> ${device.companyname}</b>
						</td>
						<td align='center'>
							<image src="${device.devicephoto}" height=100 width=100>
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
