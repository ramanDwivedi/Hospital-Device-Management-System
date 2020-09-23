package com.hdm.servicei;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import com.hdm.bean.ProfileTO;
import com.hdm.exception.ConnectionException;


public interface UserServiceI {	
	public boolean insertNewUser(ProfileTO profileTO) throws FileNotFoundException,ConnectionException;

	public String checkUser(String userName) throws ConnectionException,
			SQLException;
	public Vector<ProfileTO> viewUser(String user,String path) throws FileNotFoundException,ConnectionException, SQLException, IOException;
	public boolean updateUser(ProfileTO profileTO) throws FileNotFoundException,ConnectionException;
}
