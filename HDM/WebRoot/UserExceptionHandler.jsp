<%@ page isErrorPage="true" import="java.io.*"%>

<head>
	<title>Exceptional Even Occurred!</title>
	<style>
body,p {
	font-family: Tahoma;
	font-size: 10pt;
	padding-left: 30;
}

pre {
	font-size: 8pt;
}
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br />
	<center>
		<table border='1'>
			<tr bgcolor='#12345'>
			<tr>
				<td align='center' colspan='6'>
					<font color="red"><b>ERROR........</b>
					<input type='hidden' value="<%=exception.toString()%>">
					</font>
				</td>
			</tr>
		</table>

		<%
			out.println("<!--");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			exception.printStackTrace(pw);
			//out.print(sw);
			sw.close();
			pw.close();
			out.println("-->");
		%>
	
</body>