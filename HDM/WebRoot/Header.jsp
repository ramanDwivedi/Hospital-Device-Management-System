<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'Header.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

	<body bgcolor='skyblue'>
		<img src="./images/Head.jpg" align='top' height='220' width='968'>
		<c:choose>
			<c:when test="${sessionScope.role eq 'Admin'}">
				<jsp:include page="AdminMenu.jsp" />
			</c:when>


			<c:when test="${sessionScope.role eq 'Doctor'}">
				<jsp:include page="DoctorMenu.jsp" />
			</c:when>

			<c:when test="${sessionScope.role eq 'Financer'}">
				<jsp:include page="FinancerMenu.jsp" />
			</c:when>

			<c:otherwise>
				<jsp:include page="HomeMenu.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>


		<br />
		<br />

		<center>
			<font color="red"><b> <c:if
						test="${requestScope.status!='null'}">

						<c:out value="${requestScope.status}"></c:out>
					</c:if> </b> </font>

		</center>
	</body>
</html>
