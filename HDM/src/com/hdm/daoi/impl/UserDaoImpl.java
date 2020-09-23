package com.hdm.daoi.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import com.hdm.bean.ProfileTO;
import com.hdm.dao.AbstractDataAccessObject;
import com.hdm.dao.SqlConstants;
import com.hdm.daoi.UserDAOI;
import com.hdm.exception.ConnectionException;
import com.hdm.util.DateWrapper;
import com.hdm.util.LoggerManager;

public class UserDaoImpl implements UserDAOI {
	Connection con;
	PreparedStatement pstmt, pstmt1, cstmt, cstmt1;
	Statement stmt;
	ResultSet rs, rs1;

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
			if (cstmt1 != null)
				pstmt.close();
			if (cstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	/**
	 * checkUser
	 * 
	 * @see com.hdm.daoi.UserDAOI#checkUser(java.lang.String) The checkUser
	 *      method of the UserDaoImpl Class. <br>
	 * 
	 *      This method is called when to check whether the user available or
	 *      not
	 * @param passing
	 *            userName as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return string with user name
	 * @throws ConnectionException
	 */
	public String checkUser(String userName) throws ConnectionException,
			SQLException {
		String user = null;
		System.out.println("username" + userName);
		try {
			con = AbstractDataAccessObject.getConnection();
			con.setAutoCommit(true);
			CallableStatement cstmt = con
					.prepareCall("{ call loginidavailablity(?,?) }");
			cstmt.setString(1, userName);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.execute();
			user = cstmt.getString(2);
		} finally {
			closeConnection();
		}

		return user;
	}

	/**
	 * viewUser
	 * 
	 * @see com.hdm.daoi.UserDAOI#viewUser(java.lang.String, java.lang.String)
	 *      This method is called when to check whether the user available or
	 *      not
	 * @param passing
	 *            userid as one parameter
	 * @param passing
	 *            path for image as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return vector bean with user Profile
	 */
	public Vector<ProfileTO> viewUser(String userid, String realpath)
			throws ConnectionException, SQLException, IOException {
		Vector<ProfileTO> v = new Vector<ProfileTO>();
		ProfileTO pro = null;
		v.clear();
		try {
			con = AbstractDataAccessObject.getConnection();
			pstmt = con.prepareStatement(SqlConstants._VIEW_USER_PROFILE);
			pstmt.setString(1, userid);
			System.out.println(userid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new ProfileTO();
				pro.setUserid(rs.getInt(1));
				pro.setFirstName(rs.getString(2));
				pro.setLastName(rs.getString(3));
				pro.setBirthdate(DateWrapper.parseDate(rs.getDate(4)));
				pro.setEmail(rs.getString(5));
				Blob b = rs.getBlob(6);
				byte b1[] = b.getBytes(1, (int) b.length());
				String path = realpath + "/" + rs.getInt(1) + ".jpg";
				System.out.println("path  :" + path);
				OutputStream fout = new FileOutputStream(path);
				fout.write(b1);
				pro.setPhoto(path);
				pro.setGender(rs.getString(7));
				pro.setAddressid(rs.getInt(8));
				pro.setAddressType(rs.getString(9));
				pro.setHouseNo(rs.getString(10));
				pro.setStreet(rs.getString(11));
				pro.setCity(rs.getString(12));
				pro.setDistrict(rs.getString(13));
				pro.setState(rs.getString(14));
				pro.setCountry(rs.getString(15));
				pro.setPin(rs.getString(16));
				pro.setPhoneType(rs.getString(17));
				pro.setPhoneNo(rs.getString(18));
				v.add(pro);
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
		return v;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.hdm.daoi.UserDAOI#insertNewUser(com.hdm.bean.ProfileTO)
	 * @param passing
	 *            Profile bean with contains userdetails as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value with true or false depends upon operations
	 */
	public boolean insertNewUser(ProfileTO pro) throws FileNotFoundException,
			ConnectionException {
		boolean flag = false;
		String firstname = pro.getFirstName();
		System.out.println("firstname  :" + firstname);
		String lastname = pro.getLastName();
		System.out.println("lastname- " + lastname);
		String birthdate = DateWrapper.parseDate(pro.getBirthdate());
		System.out.println("birthdate-" + birthdate);
		String squest = pro.getSquest();
		// System.out.println("squest-"+squest);
		if (squest == null) {
			squest = pro.getOwnquest();
			System.out.println("squest" + squest);
		}
		String sqansw = pro.getSecrete();
		System.out.println("sqansw :" + sqansw);
		String email = pro.getEmail();
		System.out.println("email-" + email);
		String gender = pro.getGender();
		System.out.println("gender-" + gender);
		String addresstype = pro.getAddressType();
		System.out.println("addresstype-" + addresstype);
		String houseno = pro.getHouseNo();
		System.out.println("houseno:" + houseno);
		String street = pro.getStreet();
		System.out.println("street-" + street);
		String city = pro.getCity();
		System.out.println("city-" + city);
		String district = pro.getDistrict();
		System.out.println("district-" + district);
		String state = pro.getState();
		System.out.println("state-" + state);
		String country = pro.getCountry();
		System.out.println("country" + country);
		String pin = pro.getPin();

		System.out.println("pin" + pin);
		String phonetype = pro.getPhoneType();
		System.out.println("phonetype-" + phonetype);
		String phoneno = pro.getPhoneNo();
		System.out.println("phoneno-" + phoneno);
		String logintype = pro.getLogintype();
		System.out.println("logintype-" + logintype);
		String username = pro.getUserName();
		System.out.println("username-" + username);
		String password = pro.getPassword();
		System.out.println("password-" + password);
		String photo = pro.getPhoto();

		try {
			con = AbstractDataAccessObject.getConnection();
			System.out.println("photo=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			CallableStatement cstmt = con
					.prepareCall("{ call insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cstmt.setBinaryStream(1, fis, (int) f.length());
			cstmt.setString(2, firstname);
			cstmt.setString(3, lastname);
			cstmt.setString(4, birthdate);
			cstmt.setString(5, squest);
			cstmt.setString(6, sqansw);
			cstmt.setString(7, email);
			cstmt.setString(8, gender);
			cstmt.setString(9, username);
			cstmt.setString(10, password);
			cstmt.setString(11, logintype);
			cstmt.setString(12, addresstype);
			cstmt.setString(13, houseno);
			cstmt.setString(14, street);
			cstmt.setString(15, city);
			cstmt.setString(16, district);
			cstmt.setString(17, state);
			cstmt.setString(18, country);
			cstmt.setString(19, pin);
			cstmt.setString(20, phoneno);
			cstmt.setString(21, phonetype);

			int i = cstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;

			}
			con.close();
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
	 * updateUser
	 * 
	 * @see com.hdm.daoi.UserDAOI#updateUser(com.hdm.bean.ProfileTO)
	 * @param passing
	 *            Profile bean with contains userdetails as one parameter
	 * @throws ConnectionException
	 *             if an error occurred
	 * @return boolean value with true or false depends upon operations
	 */
	public boolean updateUser(ProfileTO profileTO)
			throws FileNotFoundException, ConnectionException {
		boolean flag = false;
		int userid = profileTO.getUserid();
		String firstname = profileTO.getFirstName();
		String lastname = profileTO.getLastName();
		String birthdate = DateWrapper.parseDate(profileTO.getBirthdate());
		String photo = profileTO.getPhoto1();
		System.out.println("hsi" + photo);
		if (photo.equals("")) {
			photo = profileTO.getPhoto();
		}
		String email = profileTO.getEmail();
		String gender = profileTO.getGender();
		String addresstype = profileTO.getAddressType();
		String houseno = profileTO.getHouseNo();
		String street = profileTO.getStreet();
		String city = profileTO.getCity();
		String district = profileTO.getDistrict();
		String state = profileTO.getState();
		String country = profileTO.getCountry();
		String pin = profileTO.getPin();
		String phoneno = profileTO.getPhoneNo();

		try {
			con = AbstractDataAccessObject.getConnection();
			System.out.println("photo=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			/*
			 * CallableStatement cstmt = con .prepareCall("{call
			 * updateprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			 */
			System.out.println("userid " + userid);
			cstmt = con.prepareStatement(SqlConstants._UPDATE_USERDETAILS);
			cstmt.setInt(7, userid);
			cstmt.setBinaryStream(4, fis, (int) f.length());
			cstmt.setString(1, firstname);
			System.out.println("firstname :" + firstname);
			cstmt.setString(2, lastname);
			System.out.println("lastname :" + lastname);
			cstmt.setString(3, birthdate);
			System.out.println("birthdate :" + birthdate);
			cstmt.setString(5, email);
			System.out.println("email :" + email);
			cstmt.setString(6, gender);
			cstmt1 = con.prepareStatement(SqlConstants._UPDATE_ADDRESSES);
			System.out.println("gender :" + gender);

			System.out.println("addresstype :" + addresstype);
			cstmt1.setString(1, houseno);
			System.out.println("houseno :" + houseno);
			cstmt1.setString(2, street);
			System.out.println("street :" + street);
			cstmt1.setString(3, city);
			System.out.println("city :" + city);
			cstmt1.setString(4, district);
			System.out.println("district :" + district);
			cstmt1.setString(5, state);
			System.out.println("state :" + state);
			cstmt1.setString(6, country);
			System.out.println("country :" + country);
			cstmt1.setString(7, pin);
			System.out.println("pin :" + pin);
			cstmt1.setString(8, phoneno);
			System.out.println("phoneno :" + phoneno);
			cstmt1.setInt(9, userid);
			System.out.println("HI");
			int i = cstmt.executeUpdate();
			int j = cstmt1.executeUpdate();
			System.out.println(i);
			System.out.println(j);
			System.out.println("Haiiiii");
			if (i == 1 && j == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
			}
			con.close();
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
}
