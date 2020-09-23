
<%@ page import="com.hdm.bean.DeviceTO;"%>
<%@ page errorPage="UserExceptionHandler.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<script language="JavaScript"
		src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
		type="text/javascript"></script>
</head>
<body>
	&nbsp;
	<jsp:include page="Header.jsp"></jsp:include>
<body>
	<center>
		<h3>
			Device Reports
		</h3>
		<form method='post' action='DeleteDeviceRequestAction'>
			<table>
				<c:if test="${not empty devicereq}">
					<tr bgcolor='white'>
						<td></td>
						<td align='center'>
							<b>DOCTOR NAME</b>
						</td>
						<td align='center'>
							<b>DEVICE NAME</b>
						</td>
						<td align='center'>
							<b>QUANTITY</b>
						</td>
						<td align='center'>
							<b>REQUEST DATE</b>
						</td>
						<td align='center'>
							<b>STATUS</b>
						</td>
					</tr>

					<c:forEach var="devcie" items="${devicereq}">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.role eq 'Doctor'}">
									<td>
										<input name="ch" type="checkbox" id="checkbox2"
											onClick="check1()" value="${devcie.deviceqrequestid }" />
									</td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>

							<td align='center'>
								<b> ${devcie.doctorname}</b>
							</td>
							<td align='center'>
								<b> ${devcie.devicename}</b>
							</td>
							<td align='center'>
								<b> ${devcie.devicequantity}</b>
							</td>
							<td align='center'>
								<b> ${devcie.requestdate}</b>
							</td>

							<c:choose>
								<c:when test="${devcie.status eq 'Approved'}">
									<td>
										<b> ${devcie.status}</b>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${sessionScope.role eq 'Admin'}">
											<td align='center'>
												<b> <a
													href="./UpdateDoctorDeviceReq?reqid=${devcie.deviceqrequestid }"><b>
															${devcie.status}(Click Here)</b> </a>
											</td>
										</c:when>
										<c:when test="${sessionScope.role eq 'Financer'}">
											<td align='center'>
												<b> <a
													href="./InventaryDeviceRequest?devicename=${devcie.devicename }&deviceid=${devcie.deviceid }&devicequantity=${devcie.devicequantity}&doctorid=${devcie.doctorid}&userid=${sessionScope.userid}&deviceqrequestid=${devcie.deviceqrequestid }"><b>
															${devcie.status}(Click Here)</b> </a>
											</td>
										</c:when>
										<c:otherwise>
											<td align='center'>
												<b> ${devcie.status}</b>
											</td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

						</tr>
					</c:forEach>
					<tr>
						<c:choose>
							<c:when test="${sessionScope.role eq 'Doctor'}">
								<td>
								<td align='center' colspan='8'>
									<input type="submit" value="Delete" />
								</td>
							</c:when>
						</c:choose>
					</tr>
			</table>
			</c:if>
		</form>
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

