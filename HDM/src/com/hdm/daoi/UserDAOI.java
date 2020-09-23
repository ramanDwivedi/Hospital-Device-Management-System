package com.hdm.daoi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import com.hdm.bean.ProfileTO;
import com.hdm.exception.ConnectionException;

public interface UserDAOI {

	public boolean insertNewUser(ProfileTO pf) throws FileNotFoundException,ConnectionException;
	public boolean updateUser(ProfileTO pf) throws FileNotFoundException,ConnectionException; 
	public String checkUser(String userid) throws ConnectionException, SQLException;
	public Vector<ProfileTO> viewUser(String user, String path)
			throws ConnectionException, SQLException, FileNotFoundException,
			IOException;
}
