package com.hdm.servicei.impl;

import java.util.Vector;

import com.hdm.bean.ProfileTO;
import com.hdm.daoi.SecurityDaoI;
import com.hdm.daoi.impl.SecurityDaoImpl;
import com.hdm.exception.ConnectionException;
import com.hdm.exception.LoginException;
import com.hdm.servicei.SecurityServiceI;

public class SecurityServiceImpl implements SecurityServiceI {

	String logintype = "";
	boolean flag = false;
	Vector<ProfileTO> vpro = null;
	SecurityDaoI sdaoi = new SecurityDaoImpl();

	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException {
		vpro = sdaoi.loginCheck(pro);
		return vpro;
	}
	public boolean changePass(ProfileTO pro) throws ConnectionException {
		flag = sdaoi.changePass(pro);
		if (flag == false) {
			throw new ConnectionException();
		}
		return flag;
	}
	public boolean passwordRecovery(ProfileTO pro) throws ConnectionException {
		return sdaoi.passwordRecovery(pro);
	}
	public boolean forgetPass(ProfileTO pro) throws ConnectionException {
		return sdaoi.forgetPass(pro);
	}
}
