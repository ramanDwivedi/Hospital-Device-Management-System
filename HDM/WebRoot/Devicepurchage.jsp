<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hdm.bean.DeviceTO"%>
<%@ page import="java.util.*"%>
<%@ page errorPage="UserExceptionHandler.jsp"%>
<%
	String path;
	String usertype;
	String s;
	Vector c;
	Iterator it;
	DeviceTO d;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head id="ctl00_header">
	<head>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript"></script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js"></script>
		<script language="JavaScript1.1" src="scripts/pass.js"></script>
		<script type="text/javascript" src="scripts/image.js"> </script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/adi.js"> </script>
		<script type="text/javascript" src="scripts/form_validation.js"> </script>
		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
		<script>

//var x_win = window.self; 

function goOn() {
var port=document.company.port.value;
var host=document.company.host.value;
var userName=document.company.userName.value;
window.location.href='http://'+host+':'+port+'/HospitalDeviceManagement/CheckUserAction?userName='+userName+"&path=./RegistrationForm.jsp";
} 
</script>
		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>
		<%
			if (session.getAttribute("userid") == null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("./LoginForm.jsp");
				rd.forward(request, response);
			}
		%>
	
<html>
	<head>
		<script language="JavaScript"
			src="<%=request.getContextPath()
					+ "/scripts/gen_validatorv31.js"%>"
			type="text/javascript"></script>
	</head>
	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<center>
			<b><h4>
					Purchage Devices Form
				</h4> </b>
		</center>
		<form method='get'
			action="<%=request.getContextPath() + "/DevicePurchageAction"%>"
			name="company">

			<table align="center" bgcolor="skyblue">
				<%
					if (request.getAttribute("device1") != null) {
								d = (DeviceTO) request.getAttribute("device1");
								System.out.println(d.getDeviceid());
								System.out.println(d.getDevicename());
								System.out.println(d.getDevicequantity());
				%>
				<tr>
					<td align='right'>
						<b>DeviceName :</b>
					</td>
					<td>
						<input type='hidden' name='deviceid' value='<%=d.getDeviceid()%>'
							readonly />
							<input type='hidden' name='doctorid' value='<%=d.getDoctorid()%>'
							readonly />
							<input type='hidden' name='userid' value='<%=d.getUserid()%>'
							readonly />
							<input type='hidden' name='deviceqrequestid' value='<%=d.getDeviceqrequestid()%>'
							readonly />
						<input type='text' name='devicename'
							value='<%=d.getDevicename()%>' readonly />
					</td>
				<tr>
					<td align='right'>
						<b>DeviceQuantity :</b>
					</td>
					<td>
						<input type="text" name="devicequantity"
							value="<%=d.getDevicequantity()%>" size="20" readonly />
					</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td align='right'>
						<b> CompanyName : </b>
					</td>
					<td>
						<%
							c = (Vector) request.getAttribute("devicereq");
											it = c.listIterator();
						%>
						<select name="companyid" id="select">
							<option value="">
								--SELECT--
							</option>
							<%
								while (it.hasNext()) {
														DeviceTO device = (DeviceTO) it.next();
							%>
							<option value="<%=device.getCompanyid()%>" selected="true">
								<font size="3" face="Verdana"><%=device.getCompanyname()%>
								</font>
							</option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td width="120" align='right'>
						<b>DevicePrice :</b>
					</td>
					<td width="273">
						<input type="text" name="deviceprice" value="" size="20" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>TotalPrice :</b>
					</td>
					<td>
						<input type="text" name="totalprice" value="" size="20" />
					</td>
				</tr>
				<tr>
					<td align='right'>
						<b>PurchageDate :</b>
					</td>
					<td>
						<input type="text" name="purchagedate" value="" size="20"
							readonly="readonly" />
						<a
							href="javascript:show_calendar('document.company.purchagedate', document.company.purchagedate.value);">
							<img src="images/cal.gif" alt="a" width="18" height="18"
								border="0" /> </a>
					</td>
				</tr>
				<tr>
					<td align='right'>
						<input type='submit' value='Add' />
					</td>
					<td>
						<input type='reset' value='Clear' />
					</td>
				</tr>
			</table>
		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("company");

 frmvalidator.addValidation("companyid","dontselect=0");
    frmvalidator.addValidation("deviceprice","req");
 frmvalidator.addValidation("deviceprice","numeric");
     frmvalidator.addValidation("totalprice","req");
  frmvalidator.addValidation("totalprice","numeric");
 frmvalidator.addValidation("purchagedate","req","Please enter your purchagedate");  
     
 </script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
