<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'Services.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>


		<center>

			<table>
				<tr>
					<td colspan="4" rowspan="14" valign="top" bgcolor="#E8E8E8">
						<img src="images/home-page_34a.jpg" width="224" height="250">
					</td>
					<td colspan="4" rowspan="13" valign="top" bgcolor="#E8E8E8">
				<tr>
					<td height="212" valign="top">
						<p align="justify" class="style9">
							<br>
							<span class="style27">Hospital Devices</span> establish in 1988
							with an object to manufacture economical & practically useful
							anesthesia machines by using Indigenous technology with maximum
							patient safety to full fill needs of Hospitals, Nursing Homes &
							clinics as per International Standards.
							<br>
							<br>

							HOASPITAL DEVICES has ISI Certification for its Anesthesia
							Machines

						</p>
					</td>
				</tr>

				<tr>
					<td colspan="26" bgcolor="#E8E8E8" class="style28">
						&nbsp;&nbsp;
						<span class="style5">&copy; 2012 Hospital Devices 
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							Designed &amp; Developed by <a>NIT Technologies</a>
					</td>
				</tr>
			</table>
		</center>

		<br>
	</body>