package com.hdm.delegate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import com.hdm.bean.ProfileTO;
import com.hdm.exception.ConnectionException;
import com.hdm.servicei.UserServiceI;
import com.hdm.servicei.impl.UserServiceImpl;

public class UserDelegate {

	UserServiceI usi = new UserServiceImpl();

	public boolean insertNewUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException {
		return usi.insertNewUser(pf);

	}

	public boolean updateUser(ProfileTO pf) throws FileNotFoundException,
			ConnectionException {
       return usi.updateUser(pf);
	}

	public String checkUser(String userName) throws ConnectionException, SQLException {
		return usi.checkUser(userName);

	}

	public Vector<ProfileTO> viewUser(String path, String user)
			throws ConnectionException, SQLException, IOException {
		return usi.viewUser(path, user);
	}

}
