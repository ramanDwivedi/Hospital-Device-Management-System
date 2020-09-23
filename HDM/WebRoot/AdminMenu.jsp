<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>stu nicholls dot com | menu - Professional dropdown #3</title>
		<meta name="Author" content="Stu Nicholls" />
		<link rel="stylesheet" type="text/css" href="menu/pro_dropdown_3.css" />
		<script src="menu/stuHover.js" type="text/javascript"></script>
	</head>
	<body bgcolor='skyblue'>
		<ul id="nav">

			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Registration</span> </a>
				<ul class="sub">
					<li>
						<a href="./RegistrationForm.jsp">NewRegistration</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Company</span> </a>
				<ul class="sub">
					<li>
						<a href="./AddDeviceCompany.jsp">AddDeviceCompany</a>
					</li>
					<li>
						<a href="./ViewDeviceCompany">ViewDeviceCompany</a>
					</li>
				</ul>
			</li>

			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Devices</span> </a>
				<ul class="sub">
					<li>
						<a href="./ViewDevices">ViewDevice</a>
					</li>
					<li>
						<a href="#nogo22" id="services"><span class="down">DeviceRequest</span>
						</a>
						<ul>
							<li>
								<a href="./ViewDevicesRequestAction">viewDeviceRequest</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="./ViewDevicePurchages">ViewPurchageDevices</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">DevicesRatio</span> </a>
				<ul class="sub">
					<li>
						<a href="./ViewDevicePatientRatio">ViewDevicePatientRatio</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">DoctorDevice</span> </a>
				<ul class="sub">
					<li>
						<a href="./ViewDoctorApproveDevices">DoctorApproveDevices</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Inventary</span> </a>
				<ul class="sub">
					<li>
						<a href="./ViewAllDevices">ViewAllDevices</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">Profile</span> </a>
				<ul class="sub">
					<li>
						<a
							href="./ViewProfileAction?userid=<%=session.getAttribute("userid")%>">ViewProfile</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="#nogo22" id="services" class="top_link"><span
					class="down">security</span> </a>
				<ul class="sub">
					<li>
						<a
							href="./Changepassword.jsp?userid=<%=session.getAttribute("userid")%>">changepassword</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="./LogoutAction" class="top_link"><span>Logout</span> </a>
			</li>
		</ul>
	</body>
</html>
