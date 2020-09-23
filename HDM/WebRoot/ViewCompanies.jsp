<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.hdm.bean.DeviceTO;"%>
<%@ page errorPage="UserExceptionHandler.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path;
	String usertype;
	String s;
	Vector c;
%>

<head>
	<script language="JavaScript"
		src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
		type="text/javascript"></script>
</head>
<body>
	&nbsp;
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<center>
		<h1>
			LIST OF COMPANIES
		</h1>
	</center>

	<form name='deleteuser' action='./DeleteItemAction'>
		<center>
			<table border='1'>
				<table border='1'>
					<tr bgcolor='white'>

						<td>
						</td>
						<td align='center'>
							<b>Company Name </b>
						</td>
						<td align='center'>
							<b>Contact </b>
						</td>
						<td align='center'>
							<b>Address </b>
						</td>
					</tr>
					<c:forEach var="company" items="${company}">
						<tr>
							<c:choose>
								<c:when test="${(sessionScope.role  eq 'Admin')}">
									<td>
										<input name="ch" type="checkbox" id="checkbox2"
											onClick="check1()" value="${company.companyid}" />
									</td>
								</c:when>
								<c:otherwise>
									<td></td>
								</c:otherwise>
							</c:choose>
							<td>
								<b>${company.companyname }</b>
							</td>
							<td>
								<b>mail :</b>${company.email }
								<br>
								<b>Ph :</b>${company.contact }
							</td>
							<td>
								${company.street },
								<br>
								${company.city },${company.district }
								<b>(District)</b>
								<br>
								${company.state },${company.country }
								<br>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<c:choose>
							<c:when test="${sessionScope.role eq 'Admin'}">
								<td>
								<td align='center' colspan='8'>
									<input type="submit" value="Delete" />
								</td>
							</c:when>
						</c:choose>
					</tr>

				</table>
</table></center>
				<jsp:include page="/Footer.jsp"></jsp:include>
</body>
