package com.hdm.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.hdm.bean.DeviceTO;
import com.hdm.dao.AbstractDataAccessObject;

import com.hdm.util.DateWrapper;
import com.hdm.util.LoggerManager;
import com.hdm.dao.SqlConstants;
import com.hdm.daoi.DoctorDaoI;
import com.hdm.exception.ConnectionException;

public class DoctorDaoImpl implements DoctorDaoI {
	Connection con, con1, con2, con3;
	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3, pstmt4, pstmt5;
	Statement stmt;
	ResultSet rs;
	boolean flag = false;

	/**
	 * The closeConnection method of the AttendanceDaoImpl Class. <br>
	 * 
	 * This method is called when to take Employee InTime.
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 */
	public void closeConnection() throws ConnectionException {
		try {
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#addCompanyDetails(com.hdm.bean.DeviceTO)
	 * @param passing
	 *            Device bean with device details as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean addCompanyDetails(DeviceTO deviceTO)
			throws FileNotFoundException, ConnectionException {
		boolean flag = false;
		String companyname = deviceTO.getCompanyname();
		System.out.println(companyname);
		String street = deviceTO.getStreet();
		System.out.println(street);
		String city = deviceTO.getCity();
		System.out.println(city);
		String state = deviceTO.getState();
		System.out.println(state);
		String district = deviceTO.getDistrict();
		System.out.println(district);
		String country = deviceTO.getCountry();
		System.out.println(country);
		String email = deviceTO.getEmail();
		System.out.println(email);
		String contact = deviceTO.getPhoneNo();
		System.out.println(contact);
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_COMPANY);
			pstmt.setString(1, companyname);
			pstmt.setString(2, street);
			pstmt.setString(3, city);
			pstmt.setString(4, district);
			pstmt.setString(5, state);
			pstmt.setString(6, country);
			pstmt.setString(7, email);
			pstmt.setString(8, contact);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
				con.close();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#deviceCompanyNames()
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return vector bean with device company details depends upon operation
	 */
	public Vector<DeviceTO> deviceCompanyNames() throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DEVICE_COMPANY_NAMES);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setCompanyid(rs.getInt(1));
				deviceTO.setCompanyname(rs.getString(2));
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc) viewDevicesRequest
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#viewDevicesRequest()
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return vector bean with device details depends upon operation
	 */
	public Vector<DeviceTO> viewDevicesRequest() throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DEVICE);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setDeviceqrequestid(rs.getInt(1));
				deviceTO.setDoctorname(rs.getString(2));
				deviceTO.setRequestdate(DateWrapper.parseDate(rs.getDate(3)));
				deviceTO.setDevicequantity(rs.getInt(4));
				deviceTO.setStatus(rs.getString(5));
				deviceTO.setDevicename(rs.getString(6));
				deviceTO.setDeviceid(rs.getInt(7));
				deviceTO.setDoctorid(rs.getInt(8));
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc) viewDevices
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#viewDevices(java.lang.String)
	 * @param passing
	 *            realpath as one parameter for Devices images
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return vector bean with device details depends upon operation
	 */
	public Vector<DeviceTO> viewDevices(String realpath)
			throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DEVICES);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String path = "";
				deviceTO = new DeviceTO();
				deviceTO.setDeviceid(rs.getInt(1));
				deviceTO.setDevicename(rs.getString(2));
				deviceTO.setDevicedesc(rs.getString(3));
				deviceTO.setCompanyname(rs.getString(4));
				Blob b = rs.getBlob(5);
				byte b1[] = b.getBytes(1, (int) b.length());
				path = realpath + "/" + rs.getInt(1) + ".jpg";
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				deviceTO.setDevicephoto(path);
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc) addNewDevice This method is called when to add New Devices.
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#addNewDevice(com.hdm.bean.DeviceTO)
	 * 
	 * @param passing
	 *            Device bean with device details as one parameter for Devices
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return vector bean with device details depends upon operation
	 */
	public boolean addNewDevice(DeviceTO deviceTO)
			throws FileNotFoundException, ConnectionException {
		boolean flag = false;
		String devicename = deviceTO.getDevicename();
		String devicedesc = deviceTO.getDevicedesc();
		int companyid = deviceTO.getCompanyid();
		String deviceimage = deviceTO.getDeviceimage();
		File ff = new File(deviceimage);
		FileInputStream fisfile = new FileInputStream(ff);
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_DEVICE);
			pstmt.setString(1, devicename);
			pstmt.setString(2, devicedesc);
			pstmt.setInt(3, companyid);
			pstmt.setBinaryStream(4, fisfile, (int) ff.length());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
				con.close();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc)requestDoctorDevice This method helps to put device request
	 * from doctor.
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#requestDoctorDevice(com.hdm.bean.DeviceTO)
	 * @param passing
	 *            Device bean with device details as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean requestDoctorDevice(DeviceTO deviceTO)
			throws ConnectionException {
		boolean flag = false;
		int doctorid = deviceTO.getDoctorid();
		System.out.println(doctorid);
		int deviceid = deviceTO.getDeviceid();
		System.out.println(deviceid);
		int quentity = deviceTO.getDevicequantity();
		System.out.println(quentity);
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_DEVICES_REQUEST);
			pstmt.setInt(1, doctorid);
			pstmt.setInt(3, deviceid);
			pstmt.setInt(2, quentity);

			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
				con.close();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc)updateDoctorDeviceRequest This method helps to accept or
	 * reject device request from doctor.
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#updateDoctorDeviceRequest(int)
	 * @param passing
	 *            Device bean with device details as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean updateDoctorDeviceRequest(int requestid)
			throws ConnectionException {
		boolean flag = false;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._UPDATE_STATUS_ADMIN);
			pstmt.setInt(1, requestid);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
				con.close();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc) Inventery device details
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#inventaryDevicesRequest(com.hdm.bean.DeviceTO)
	 * 
	 * @param passing
	 *            Device bean with device details as one parameter for Devices
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return vector bean with Inventery device details depends upon operation
	 */
	public Vector<DeviceTO> inventaryDevicesRequest(DeviceTO deviceTO)
			throws ConnectionException {
		int userid = deviceTO.getUserid();
		int doctorid = deviceTO.getDoctorid();
		int devicerequestid = deviceTO.getDeviceqrequestid();
		System.out.println(userid);
		System.out.println("reqid " + devicerequestid);
		String devicename = deviceTO.getDevicename();
		int deviceid = deviceTO.getDeviceid();
		int devicequantity = deviceTO.getDevicequantity();
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO device1 = new DeviceTO();
		device1.setDevicename(devicename);
		device1.setDeviceid(deviceid);
		device1.setDevicequantity(devicequantity);
		device1.setUserid(userid);
		device1.setDoctorid(doctorid);
		device1.setDeviceqrequestid(devicerequestid);
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DEVICE_COMPANY_NAMES);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setCompanyid(rs.getInt(1));
				deviceTO.setCompanyname(rs.getString(2));
				vdevice.add(deviceTO);
			}
			vdevice.add(device1);
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc)devicePurchageDetails This method helps to add Devices
	 * Purchages Details.
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#devicePurchageDetails(com.hdm.bean.DeviceTO)
	 * @param passing
	 *            Device bean with device details as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean devicePurchageDetails(DeviceTO deviceTO)
			throws ConnectionException {
		boolean flag = false;
		int userid = deviceTO.getUserid();
		System.out.println(userid);
		int doctorid = deviceTO.getDoctorid();
		int devicerequestid = deviceTO.getDeviceqrequestid();
		System.out.println(devicerequestid);
		int deviceid = deviceTO.getDeviceid();
		System.out.println(deviceid);
		int devicereqid = deviceTO.getDeviceqrequestid();
		System.out.println(devicereqid);
		int devicequantity = deviceTO.getDevicequantity();
		System.out.println(devicequantity);
		int companyid = deviceTO.getCompanyid();
		System.out.println(companyid);
		float deviceprice = deviceTO.getDeviceprice();
		System.out.println(deviceprice);
		float totalprice = deviceTO.getTotalprice();
		System.out.println(totalprice);
		String purchagedate = deviceTO.getPurchagedate();
		System.out.println(purchagedate);

		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._PURCHAGE_DEVICE);
			pstmt.setInt(1, deviceid);
			pstmt.setInt(2, devicequantity);
			pstmt.setInt(3, companyid);
			pstmt.setFloat(4, deviceprice);
			pstmt.setFloat(5, totalprice);
			pstmt.setString(6, DateWrapper.parseDate(purchagedate));
			pstmt1 = con.prepareStatement(SqlConstants._INVENTARY_DEVICE);
			rs = pstmt1.executeQuery();
			int j = 0;
			if (!rs.next()) {
				System.out.println(rs);
				pstmt2 = con
						.prepareStatement(SqlConstants.INSERT_INVENTARY_DEVICE);
				pstmt2.setInt(1, deviceid);
				pstmt2.setInt(2, devicequantity);
				j = pstmt2.executeUpdate();
			} else {
				int id = rs.getInt(1);
				int did = rs.getInt(2);
				int quantity = rs.getInt(3);
				if (deviceid == did) {
					quantity = quantity + devicequantity;
					pstmt3 = con
							.prepareStatement(SqlConstants.UPDATE_INVENTARY_DEVICE);
					pstmt3.setInt(1, quantity);
					pstmt3.setInt(2, deviceid);
					j = pstmt3.executeUpdate();
				} else {
					pstmt2 = con
							.prepareStatement(SqlConstants.INSERT_INVENTARY_DEVICE);
					pstmt2.setInt(1, deviceid);
					pstmt2.setInt(2, devicequantity);
					j = pstmt2.executeUpdate();
				}
			}
			int i = pstmt.executeUpdate();
			pstmt4 = con.prepareStatement(SqlConstants.UPDATE_DEVICE_REQUEST);
			System.out.println(devicereqid);
			pstmt4.setInt(1, devicereqid);

			pstmt5 = con.prepareStatement(SqlConstants.INSERT_APPROVED_DEVICE);
			pstmt5.setInt(1, userid);
			System.out.println(userid);
			pstmt5.setInt(2, doctorid);
			System.out.println(doctorid);
			pstmt5.setInt(3, deviceid);
			System.out.println(deviceid);
			pstmt5.setInt(4, devicequantity);
			System.out.println(devicequantity);
			int l = pstmt5.executeUpdate();
			int k = pstmt4.executeUpdate();
			System.out.println(" i+" + i + " j=" + j + " k=" + k + " l=" + l);
			if (i == 1 && j > 0 && k == 1 && l == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
				con.close();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc)viewPurchageDevices viewPurchageDevices method helps to view
	 * Purchage device details
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#viewPurchageDevices()
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return vector bean with Purchage device details depends upon operation
	 */
	public Vector<DeviceTO> viewPurchageDevices() throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants.VIEW_PURCHAGE_DEVICES);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String path = "";
				deviceTO = new DeviceTO();
				deviceTO.setDevicepurchageid(rs.getInt(1));
				deviceTO.setDevicename(rs.getString(2));
				deviceTO.setDevicequantity(rs.getInt(3));
				deviceTO.setCompanyname(rs.getString(4));
				deviceTO.setDeviceprice(rs.getFloat(5));
				deviceTO.setTotalprice(rs.getFloat(6));
				deviceTO.setPurchagedate(DateWrapper.parseDate(rs.getDate(7)));
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc)viewDevicesCompanies viewDevicesCompanies method helps to
	 * display device display company details
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#viewDevicesCompanies()
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return vector bean with Devices Companies details depends upon operation
	 */
	public Vector<DeviceTO> viewDevicesCompanies() throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_COMPANY);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setCompanyid(rs.getInt(1));
				deviceTO.setCompanyname(rs.getString(2));
				deviceTO.setStreet(rs.getString(3));
				deviceTO.setCity(rs.getString(4));
				deviceTO.setDistrict(rs.getString(5));
				deviceTO.setState(rs.getString(6));
				deviceTO.setCountry(rs.getString(7));
				deviceTO.setEmail(rs.getString(8));
				deviceTO.setContact(rs.getString(9));
				deviceTO.setStatus(rs.getString(10));
				System.out.println("Hai");
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc)deleteItem This method helps to deleteItems
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#deleteItem(int)
	 * @param passing
	 *            itemid as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean deleteItem(int itemid) {
		boolean flag = false;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DELETE_COMPANY);
			pstmt.setInt(1, itemid);
			System.out.println("leaveid :" + itemid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println(se);
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return flag;
	}

	/**
	 * (non-Javadoc)deleteIDeviceRequest This method helps to delete Device
	 * Request
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#deleteIDeviceRequest(int)
	 * @param passing
	 *            itemid as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean deleteIDeviceRequest(int itemid) throws ConnectionException {
		boolean flag = false;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DELETE_DEVICE_REQUEST);
			pstmt.setInt(1, itemid);
			System.out.println("leaveid :" + itemid);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			} else
				flag = false;
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc)addDoctorPatientRatio This method helps to add Doctor
	 * Patient Ratio
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#addDoctorPatientRatio(com.hdm.bean.DeviceTO)
	 * @param passing
	 *            itemid as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean addDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException {
		boolean flag = false;

		int doctorid = deviceTO.getDoctorid();
		System.out.println(doctorid);
		int deviceid = deviceTO.getDeviceid();
		System.out.println(deviceid);
		int devicequantity = deviceTO.getDevicequantity();
		System.out.println(devicequantity);
		String ratio = deviceTO.getRatio();
		System.out.println(ratio);
		String status = deviceTO.getDeviceworkstatus();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._ADD_RATIO);
			pstmt.setInt(1, doctorid);
			pstmt.setInt(2, deviceid);
			pstmt.setInt(3, devicequantity);
			pstmt.setString(4, ratio);
			pstmt.setString(5, status);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
				con.close();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc)viewDevicePatientRatio viewDevicePatientRatio method helps
	 * to view Devices Patients Ratio details
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#viewDevicePatientRatio()
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return vector bean with view Device Patien Ratio details depends upon
	 *         operation
	 */
	public Vector<DeviceTO> viewDevicePatientRatio() throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_DOCTOR_DEVICE);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setDevicedetailsid(rs.getInt(1));
				System.out.println(rs.getInt(1));
				deviceTO.setDoctorname(rs.getString(2));
				System.out.println(rs.getString(2));
				deviceTO.setDevicename(rs.getString(3));
				System.out.println(rs.getString(3));
				deviceTO.setDevicequantity(rs.getInt(4));
				System.out.println(rs.getInt(4));
				deviceTO.setRatio(rs.getString(5));
				System.out.println(rs.getString(5));
				deviceTO.setDeviceworkstatus(rs.getString(6));
				System.out.println(rs.getString(6));
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc)updateviewDoctorDevice
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#updateviewDoctorDevice(int)
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return Device class reference with view Doctors Devices Ratio details
	 *         depends upon operation
	 */
	public DeviceTO updateviewDoctorDevice(int devicedetailsid)
			throws ConnectionException {
		DeviceTO deviceTO = null;
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con
					.prepareStatement(SqlConstants._UPDATE_VIEW_DOCTOR_DEVICE);
			pstmt.setInt(1, devicedetailsid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setDevicedetailsid(devicedetailsid);
				deviceTO.setDevicedetailsid(rs.getInt(1));
				System.out.println(rs.getInt(1));
				deviceTO.setDoctorname(rs.getString(2));
				System.out.println(rs.getString(2));
				deviceTO.setDevicename(rs.getString(3));
				System.out.println(rs.getString(3));
				deviceTO.setDevicequantity(rs.getInt(4));
				System.out.println(rs.getInt(4));
				deviceTO.setRatio(rs.getString(5));
				System.out.println(rs.getString(5));
				deviceTO.setDeviceworkstatus(rs.getString(6));
				System.out.println(rs.getString(6));
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return deviceTO;
	}

	/**
	 * (non-Javadoc)updateDoctorPatientRatio This method helps to update Doctor
	 * Patient Ratio
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#addDoctorPatientRatio(com.hdm.bean.DeviceTO)
	 * @param passing
	 *            itemid as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operation
	 */
	public boolean updateDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException {
		boolean flag = false;
		String ratio = deviceTO.getRatio();
		System.out.println("ratio :" + ratio);
		String deviceworkstatus = deviceTO.getDeviceworkstatus();
		System.out.println(deviceworkstatus);
		int devicedetailsid = deviceTO.getDevicedetailsid();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._UPDATE_DOCTOR_DEVICE);
			pstmt.setString(1, ratio);
			pstmt.setString(2, deviceworkstatus);
			pstmt.setInt(3, devicedetailsid);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;
				con.close();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return flag;
	}

	/**
	 * (non-Javadoc)viewAllDevices viewAllDevices method helps to view All
	 * Devices information.
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#viewAllDevices()
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return vector bean with view All Devices details depends upon operation
	 */
	public Vector<DeviceTO> viewAllDevices() throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._INVENTARY_DEVICES);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setInventaryid(rs.getInt(1));
				System.out.println(rs.getInt(1));
				deviceTO.setDevicename(rs.getString(2));
				deviceTO.setDevicequantity(rs.getInt(3));
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

	/**
	 * (non-Javadoc)viewDoctorApprovedDevices method helps to view Approved
	 * Doctor devices.
	 * 
	 * @see com.hdm.daoi.DoctorDaoI#viewDoctorApprovedDevices()
	 * @throws ConnectionException
	 *             if an error occurred
	 * 
	 * @return vector bean with view All Devices details depends upon operation
	 */
	public Vector<DeviceTO> viewDoctorApprovedDevices()
			throws ConnectionException {
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		DeviceTO deviceTO = null;
		vdevice.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._DOCTOR_APPROVED_DEVICES);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				deviceTO = new DeviceTO();
				deviceTO.setDeviceid(rs.getInt(1));
				System.out.println(rs.getInt(1));
				deviceTO.setFinancername(rs.getString(2));
				deviceTO.setDoctorname(rs.getString(3));
				deviceTO.setDevicename(rs.getString(4));
				deviceTO.setDevicequantity(rs.getInt(5));
				deviceTO.setDevicereceivedate(DateWrapper.parseDate(rs
						.getDate(6)));
				vdevice.add(deviceTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} catch (Exception e) {
			throw new ConnectionException(
					"server busy please try latter.......");
		} finally {
			closeConnection();
		}
		return vdevice;
	}

}
