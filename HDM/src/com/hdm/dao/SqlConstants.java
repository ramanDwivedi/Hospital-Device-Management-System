package com.hdm.dao;

public class SqlConstants {

	public static final String _CHECK_USER = "select useridref,loginid,logintype,u.status from logindetails,userdetails u  where loginid=? and password=? and u.status='Active'";
	public static final String _CHANGE_PASSWORD = "update logindetails set password=? where loginid=? and password=?";
	public static final String _EMPLOYEEID = "select nvl(max(employeeid),1000)+1 from employee_Details";
	public static final String _DELETE_EMPLOYEE = "update employee set leftdate=sysdate where employeeidref=?";
	public static final String _UPDATE_EMPLOYEE = "update employee set job=?,hiredate=?,departmentno=?,salary=? where employeeidref=?";
	public static final String _VIEW_USER_PROFILE = "select u.userid,u.firstname,u.lastname,u.dob,u.emailid,u.photograph,u.gender, a.addressid,a.addresstype,a.houseno,a.STREET,a.city,a.DISTRICT,a.STATE,a.COUNTRY,a.PINCODE,a.phonetype,a.phoneno from userdetails u,addresses a where  u.userid=a.useridref  and u.userid=?";
	public static final String _RECOVER_PASSWORD = "select password from logindetails l,userdetails u where l.loginid=? and u.forgotpwquestion=? and u.forgotpwanswer=?";
	public static final String _NEW_PASSWORD = "update logindetails set password=? where loginid=?";

	// company
	public static final String _ADD_COMPANY = "insert into company values((select nvl(max(companyid),100)+1 from company),?,?,?,?,?,?,?,?,'Request at Admin')";
	public static final String _VIEW_COMPANY = "select * from company ";
	public static final String _DELETE_COMPANY = "delete company where companyid=?";
	public static final String _DELETE_DEVICE_REQUEST = "delete device_request where requestid=?";
	// DeviceTO
	public static final String _DEVICE_COMPANY_NAMES = "select companyid,companyname from company";
	public static final String _ADD_DEVICE = "insert into devices values((select nvl(max(deviceid),100)+1 from devices),?,?,?,?)";
	public static final String _DEVICES = "select Deviceid,devicename,devicedescription,(select companyname from company where companyid=devices.companyname),deviceimage from devices";
	public static final String _ADD_DEVICES_REQUEST = "insert into device_request values((select nvl(max(requestid),100)+1 from device_request),?,sysdate,?,'pending',?)";
	public static final String _DEVICE = "select a.requestid,(select loginid from logindetails l where l.useridref=a.useridref),a.requestdate,a.quantity,a.status,(select devicename from devices d where d.deviceid=a.deviceidref ),a.deviceidref,a.useridref from device_request a";
	public static final String _UPDATE_STATUS_ADMIN = "update device_request set status='Request at Inventary' where requestid=?";
	public static final String _PURCHAGE_DEVICE = "insert into device_purchage values((select nvl(max(purchageid),100)+1 from device_purchage),?,?,?,?,?,?)";
	public static final String DEVICE_UPDATE = "update device_request set where status='Accepted' where requestid=?";
	public static final String VIEW_DEVICES_REQUEST = "select Deviceid,devicename,devicedescription,(select companyname from company where companyid=devices.companyname),deviceimage from devices";
	public static final String VIEW_PURCHAGE_DEVICES = "select purchageid,(select devicename from devices where deviceid=device_purchage.deviceidref),devicequantiry,(select companyname from company where companyid=device_purchage.companyidref),deviceprice,totalprice,purchagedate from device_purchage ";
	public static final String _ADD_RATIO = "insert into doctor_device values(?,?,?,?,?,(select nvl(max(devicedetailsid),100)+1 from doctor_device))";
	public static final String _VIEW_DOCTOR_DEVICE = "select devicedetailsid,(select loginid from logindetails where useridref=doctor_device.useridref),(select devicename from devices where deviceid=doctor_device.deviceidref),devicequeantity,patientratio,deviceworkingstatus from doctor_Device";
	public static final String _UPDATE_VIEW_DOCTOR_DEVICE = "select devicedetailsid,(select loginid from logindetails where useridref=doctor_device.useridref),(select devicename from devices where deviceid=doctor_device.deviceidref),devicequeantity,patientratio,deviceworkingstatus from doctor_Device where devicedetailsid=?";
	public static final String _UPDATE_DOCTOR_DEVICE = "update doctor_Device set patientratio=? ,deviceworkingstatus=? where devicedetailsid=?";
	public static final String _INVENTARY_DEVICE = "select * from inventary";
	public static final String INSERT_INVENTARY_DEVICE = "insert into inventary values((select nvl(max(id),100)+1 from inventary),?,?)";
	public static final String UPDATE_INVENTARY_DEVICE = "update inventary set quantity=? where deviceidref=?";
	public static final String _INVENTARY_DEVICES = "select id,(select devicename from devices where deviceid=inventary.deviceidref),quantity from inventary";
	public static final String UPDATE_DEVICE_REQUEST = "update device_request set status='Approved' where requestid=?";
	public static final String INSERT_APPROVED_DEVICE = "insert into device_delivary values((select nvl(max(id),100)+1 from device_delivary),?,?,?,sysdate,?)";
	public static final String _DOCTOR_APPROVED_DEVICES = "select id,(select firstname from userdetails where userid=device_delivary.providerid),(select firstname from userdetails where userid=device_delivary.receiverid),(select devicename from devices where deviceid=device_delivary.receiveddeviceid),devicequantity,devicereceivedate from device_delivary";
	// department
	public static final String _ADD_DEPARTMENT = "insert into department values((select nvl(max(departmentno),100)+1 from department),?, ?)";
	public static final String _VIEW_USER = "select * from employee_details ed ,employee_address ea,employee e "
			+ "where employeeid=? and ed.employeeid=ea.EMPLOYEEIDREF "
			+ "and ed.employeeid=e.employeeidref and ed.status='Active'";
	public static final String _DEPARTMENT = "select * from department where departmentno=?";
	public static final String _VIEW_DEPARTMENT = "select * from department";
	public static final String _SELECT_SALARY = "select salary from employee where employeeidref=?";
	public static final String _VIEW_DEPT_EMPLOYEES = "select e.employeeidref,e.employeename,e.job,e.hiredate,"
			+ "e.departmentno,e.salary from Employee e,employee_details ed "
			+ "where ed.status='Active' and e.departmentno=?  and ed.employeeid=e.employeeidref and e.leftdate is null";
	public static final String _VIEW_DATEWISE_EMPLOYEES = "select e.employeeidref,e.employeename,e.job,e.hiredate,"
			+ "e.departmentno,e.salary from Employee e,employee_details ed "
			+ "where ed.status='Active' and e.hiredate<=?  and ed.employeeid=e.employeeidref and e.leftdate is null";
	public static final String _VIEW_EMPIDWIES_EMPLOYEES = "select e.employeeidref,e.employeename,e.job,e.hiredate,"
			+ "e.departmentno,e.salary from Employee e,employee_details ed "
			+ "where ed.status='Active' and e.employeeidref=?  and ed.employeeid=e.employeeidref and e.leftdate is null";
	public static final String _DELETE_DEPARTMENT = "delete department where departmentno=?";
	public static final String _EMP_SAL = "select salary from employee where employeeidref=?";
	public static final String _UPDATE_VIEW_EMPLOYEE = "select e.employeeidref,e.employeename,e.job,e.hiredate,(select departname from department where departmentno=e.departmentno),e.salary,(select location from department where departmentno=e.departmentno ),(select departmentno from department where departmentno=e.departmentno) from employee e where employeeidref=? and leftdate is null";
	public static final String _VIEW_EMP_SALARY = "select e.employeeidref,(select employeename from employee where employeeidref=e.employeeidref),e.salarydate,e.salaryamount,e.salarystatus from employee_salaries e where departmentidref=? and to_char(salarydate,'mon')=to_char(to_date(?,'dd/mm/yyyy'),'mon')";

	// Attendance
	public static final String _RECORD_TIME = "insert into EMPLOYEE_DAILY_ATTENDeNCE(employeeidref,logindate,intime,outtime)  values((select employeeidref from employee where employeeidref=? and leftdate is NULL),to_date(sysdate,'dd/mm/yy'),sysdate,NULL)";
	public static final String _OUT_RECORD_TIME = "update EMPLOYEE_DAILY_ATTENDeNCE set outtime=sysdate where employeeidref=? and logindate=TO_date(sysdate,'dd/mm/yy')";
	public static final String _VIEW_DEPT_MONTHLY_ATTENDANCE = "";
	public static final String _VIEW_EMP_ATTENDANCE = "select ea.logindate,to_char(ea.intime,'HH24:MM'),to_char(ea.outtime,'HH24:MM') from employee_daily_attendence ea where ea.employeeidref=? and to_char(ea.logindate,'MON')=to_char(sysdate,'MON')";
	public static final String _VIEW_EMPLOYEE_ATTENDANCE = "select e.employeeidref,e.employeename,e.job,e.hiredate,(select d.departname from department d where d.departmentno=e.departmentno) from employee e  where e.employeeidref=?";
	public static final String _MONTH_DAYS = "SELECT to_char((TRUNC(to_date(?,'dd/mm/yyyy'), 'mon') +rownum-1),'dd'),to_char(TRUNC(to_date(?,'dd/mm/yyyy'), 'MON') +rownum-1,'dy') FROM DUAL CONNECT BY LEVEL <= (select last_day(to_date(?,'dd/mm/yyyy'))-(add_months(last_day(to_date(?,'dd/mm/yyyy')),-1)) from dual)";
	public static final String _DEPT_ATTENDANCE = "select * from employee_daily_attendence where employeeidref=? and to_char(logindate,'mm')=?";

	// holidays
	public static final String _ADD_HOLIDAY = "insert into Holiday values((select nvl(max(holidayid),100)+1 from holiday),?,?,?)";
	public static final String _VIEW_HOLIDAYS = "select * from holiday";
	public static final String _VIEW__UPDATE_HOLIDAYS = "select * from holiday where holidayid=?";
	public static final String _UPDATE_HOLIDAYS = "update holiday set holidaydesc=?,dates=to_date(?,'dd/mm/yyyy'),day=? where holidayid=?";
	public static final String _DELETE_HOLIDAY = "delete Holiday where holidayid=?";
	public static final String _VIEW_MONTH_HOLIDAYS = "select * from holiday where to_char(to_date(dates,'dd/mm/yyyy'),'mon')=to_char(to_date(?,'dd/mm/yyyy'),'mon')";

	// Leaves
	public static final String _APPLY_LEAVES = "insert into Employee_leaves values((select nvl(max(leaveid),100)+1 from employee_leaves),?,?,?,?,?,?,'pending')";
	public static final String _VIEW_LEAVES = "select * from Employee_leaves";
	public static final String _ACCEPT_LEAVES = "update employee_leaves set status=? where employeeidref=?";
	public static final String _VIEW_EMP_LEAVES = "select * from Employee_leaves where employeeidref=?";

	// mails
	public static final String _MAIL_CONTACTS = "select employeeid,loginid from employee_details";
	public static final String _SEND_MAIL = "insert into employee_inbox_mails values((select nvl(max(messageid),100)+1 from employee_inbox_mails),?,?,?,?,sysdate)";
	public static final String _SEND_MAIL1 = "insert into employee_outbox_mails values((select nvl(max(messageid),100)+1 from employee_outbox_mails),?,?,?,?,sysdate)";
	public static final String _VIEW_OUT_MAILS = "select * from employee_outbox_mails where frommailid=?";
	public static final String _VIEW_OUT_MAIL = "select * from employee_outbox_mails where messageid=?";
	public static final String _VIEW_IN_MAILS = "select * from employee_inbox_mails where tomailid=?";
	public static final String _VIEW_IN_MAIL = "select * from employee_inbox_mails where messageid=?";
	public static final String _VIEW_MAILID = "select loginid from employee_details where employeeid=?";
	public static final String _DELETE_MAIL = "delete employee_outbox_mails where messageid=?";
	public static final String _DELETE_MAIL1 = "delete employee_inbox_mails where messageid=?";
	public static final String _UPDATE_USERDETAILS = "update userdetails set firstname=?,lastname=?,dob=?,photograph=?,emailid=?,gender=? where userid=?";
	public static final String _UPDATE_ADDRESSES = "update addresses set houseno=?, street=?, city=?,district=?, state=?,country=?, pincode=?,phoneno=? where useridref=?";

	/*
	 * public static final String _CHANGE_QUESTION="update userdetails set
	 * forgotpwquestion=?,forgotpwanswer=? where (select loginid from
	 * logindetails l,userdetails u where loginid='a' and l.useridref=u.userid
	 * )=?"; public static final String _RECOVER_PASSWORD="select password from
	 * logindetails l,userdetails u where l.loginid=? and u.forgotpwquestion=?
	 * and u.forgotpwanswer=?";
	 * 
	 * 
	 * public static final String _VIEW_USER_PROFILE="select
	 * u.userid,u.firstname,u.lastname,u.dob,u.emailid,u.faxno,u.photograph,p.phonetype,p.phoneno,a.addresstype,a.houseno,a.STREET,a.city,a.DISTRICT,a.STATE,a.COUNTRY,a.PINCODE
	 * from userdetails u,phones p,addresses a, logindetails l where
	 * u.userid=p.useridref and u.userid=a.useridref and p.useridref=a.useridref
	 * and l.loginid=? and u.userid=l.useridref and p.useridref=l.useridref and
	 * a.useridref=l.useridref"; public static final String
	 * _UPDATE_USER_STATUS="update userdetails set status='Active' where
	 * userid=?"; public static final String _ADD_ANIMAL_TYPE="insert into
	 * Animal_type values((select nvl(max(animaltypeid),100)+1 from
	 * Animal_type),?,?)"; public static final String _VIEW_ANIMAL_TYPE="select
	 * AnimalTypeId,Typename,typedescription from animal_type"; public static
	 * final String _ADD_ANIMAL_NAME="insert into Animal_Name values((select
	 * nvl(max(animalid),100)+1 from Animal_NAME),?,?,?,?)"; public static final
	 * String _VIEW_ANIMAL_NAME="select
	 * AnimalId,animalname,animaldescription,animalimg from animal_Name"; public
	 * static final String _GET_ANIMAL_NAMES="select
	 * a.animaltypeid,a.typename,b.AnimalId,b.animalname " + "from animal_name
	 * b,animal_type a where animaltypeidref=? and
	 * a.animaltypeid=b.animaltypeidref"; public static final String
	 * _ADD_ANIMAL_FILE="insert into Animal_blog values(?,?,?,?,?,(select
	 * nvl(max(blogid),100)+1 from animal_blog))"; public static final String
	 * _VIEW_ANIMAL_FILE="select animalid,animalname,animaldescription,animalimg
	 * from animal_name"; public static final String _VIEW_ANIMAL_PHOTO="select *
	 * from animal_Name where animaltypeidref=?"; public static final String
	 * _VIEW_ANIMAL_ALLPHOTO="select * from animal_blog where animalidref=?";
	 * public static final String _ADD_NEWSLETTER="insert into NEWS_LETTER
	 * values((select nvl(max(newsid),100)+1 from news_letter),?,?,?,sysdate)";
	 * public static final String _VIEW_NEWS_LETTER="select
	 * newsId,newsheadlines,newsdescription,newsphotos,newsdate from
	 * news_letter"; public static final String _DELETE_USER="update userdetails
	 * set status='DeActive' where userid=?"; public static final String
	 * _DELETE_NEWS_LETTER="delete news_letter where newsid=?"; public static
	 * final String _VIEW_DELETE_ALLPHOTOS="select * from animal_blog where
	 * animalidref=? and animaltypeidref=?"; public static final String
	 * _UPDATE_EVENT_STATUS="update event set eventstatus='Active' where
	 * eventid=?"; public static final String _DELETE_EVETNS="delete EVENT where
	 * eventid=?"; public static final String _POST_QUERY="insert into queries
	 * (queryid,querytype,useridref,query,qstatus) values((select
	 * nvl(max(queryid),100)+1 from queries),?,?,?,'pending')";
	 * 
	 * 
	 * 
	 * 
	 * //career public static final String _VIEW_CAREERS="select * from career";
	 * public static final String _VIEW_COURSES="select * from degree"; public
	 * static final String _VIEW_EVENT="select
	 * e.eventid,e.eventname,e.eventtype,e.eventdescription,e.eventdate,e.eventstatus,ea.street,ea.city,ea.district,ea.state,ea.country,ea.pincode,ea.contactno" + "
	 * from event e, event_addresses ea where e.eventid=ea.eventidref"; public
	 * static final String _ADD_COURSE="insert into degree values((select
	 * nvl(max(degreeid),100)+1 from degree),?,?,?,?,?,?)"; public static final
	 * String _DELETE_COURSE="delete degree where degreeid=?"; public static
	 * final String _DELETE_CAREER="delete career where careerid=?"; public
	 * static final String _VIEW_QUERIES="select * from queries where
	 * querytype=?"; public static final String _POST_ANSWER="update queries set
	 * queryanswer=?,qstatus='solved' where queryid=?"; public static final
	 * String _VIEW_QUERIE_USER="select * from queries where useridref=?";
	 * public static final String _DELETE_QUERY="delete queries where
	 * queryid=?";
	 */
}