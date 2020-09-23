<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'AboutUs.jsp' starting page</title>

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
		<!-- ImageReady Slices (home page.jpg) -->
		<div align="center">


			<table>
				<tr>
					<td align='center' colspan="3" bgcolor="#663366">
						<p class="style30">
							&nbsp;&nbsp;Contact Details:
						</p>
					</td>

				</tr>
				<tr>

					<td width="38%" align="left" valign="top">
						<div align="center">
							<img src="images/contectus.jpg" width="202" height="289">
						</div>
					</td>
					<td width="61%" colspan="2" style="padding: 5px">
						<p class="style16">
							<br>
							<span class="style17"><b>HOSPITAL DEVICES</b> <br> <br>
								<span class="style29"><span class="style19">Ramesh
										Gupta</span> </span> </span><span class="style19">(M.D)</span>
							<br>

							<br>
							<span class="style29">A/33-34, DSIDC Engineering Complex,
								<br> Mangol Puri Industrial Area, <br> Phase-1,
								Delhi-110083 (INDIA)<br> <br> Telefax : 91-11-27921737<br>
								Mobile : +91 9312240317, 9810664652 <br> <br> E-mail :
								hospitaldevicesindia@gmail.com<br> 
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								abbu.nabi@yahoomail.com<br> <br> <br> </span>
						</p>
					</td>
				</tr>

			</table>
			<span class="style5"><span class="style6">&copy; 2011
					Hospital Devices
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Designed
					&amp; Developed by <a
					">NIT
						Technologies</a> <img src="images/home-page_47.jpg" width="2"
						height="6" alt=""> &nbsp;&nbsp; <span class="style5"><span
						class="style6"></span>


						
	</body>

</html>
