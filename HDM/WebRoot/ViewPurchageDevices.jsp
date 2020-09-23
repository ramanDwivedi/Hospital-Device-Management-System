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
				PURCHASE DEVICES LIST
			</h3>
		</center>
		<
		<center>
			<table border='1'>
				<tr bgcolor='white'>
					<td align='center'>
						PurchageID
					</td>
					<td align='center' width='200'>
						<b>Device Names</b>
					</td>
					<td align='center' width='100'>
						<b>Device Queantity</b>
					</td>
					<td align='center' width='100'>
						<b>Device CompanyName</b>
					</td>
					<td align='center' width='100'>
						<b>Device Price</b>
					</td>
					<td align='center' width='100'>
						<b>Total Price</b>
					</td>
					<td align='center' width='100'>
						<b>Purchase Date</b>
					</td>
				</tr>
				<c:forEach var="device" items="${deviceTO}">
					<tr>
						<td>
							${device.devicepurchageid }
						</td>
						<td align='center'>
							<b> ${device.devicename } 
						</td>
						<td align='center'>
							<b> ${device.devicequantity } 
						</td>
						<td align='center'>
							<b> ${device.companyname}</b>
						</td>
						<td align='center'>
							<b> ${device.deviceprice}</b>
						</td>
						<td align='center'>
							<b> ${device.totalprice}</b>
						</td>
						<td align='center'>
							<b> ${device.purchagedate}</b>
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
