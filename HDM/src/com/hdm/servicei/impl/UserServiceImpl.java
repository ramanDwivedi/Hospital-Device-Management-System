package com.hdm.servicei.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import com.hdm.bean.ProfileTO;
import com.hdm.daoi.UserDAOI;
import com.hdm.daoi.impl.UserDaoImpl;
import com.hdm.exception.ConnectionException;
import com.hdm.servicei.UserServiceI;

public class UserServiceImpl implements UserServiceI {

	UserDAOI rdao = new UserDaoImpl();
	boolean flag = false;
	Vector<ProfileTO> vpro = new Vector<ProfileTO>();

	public boolean changePass(ProfileTO pf) throws ConnectionException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeQuestion(ProfileTO pf) throws ConnectionException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertNewUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException {
		flag = rdao.insertNewUser(pf);
		return flag;
	}

	public boolean updateUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException {
		flag = rdao.updateUser(pf);
		return flag;
	}

	public boolean logout(String loginid) throws ConnectionException {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector<ProfileTO> viewUser(String path, String user)
			throws ConnectionException, SQLException, IOException {
		vpro = rdao.viewUser(path, user);
		return vpro;
	}

	public String checkUser(String userName) throws ConnectionException, SQLException {
		userName = rdao.checkUser(userName);
		return userName;
	}

}
