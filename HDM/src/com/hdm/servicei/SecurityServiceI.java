package com.hdm.servicei;



import java.util.Vector;

import com.hdm.bean.ProfileTO;
import com.hdm.exception.ConnectionException;
import com.hdm.exception.LoginException;

public interface SecurityServiceI {
	
	 public Vector<ProfileTO>loginCheck(ProfileTO pro)throws LoginException,ConnectionException;
	public boolean changePass(ProfileTO pro)throws ConnectionException;
	
	 public boolean passwordRecovery(ProfileTO pro)throws ConnectionException;
	  	public boolean forgetPass(ProfileTO pro) throws ConnectionException;
	  	/*  public boolean changeQuestion(ProfileTO pro)throws ConnectionException;
		*/
}
