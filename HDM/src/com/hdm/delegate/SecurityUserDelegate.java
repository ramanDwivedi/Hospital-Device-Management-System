package com.hdm.delegate;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;

import com.hdm.bean.ProfileTO;
import com.hdm.exception.ConnectionException;
import com.hdm.exception.LoginException;
import com.hdm.servicei.SecurityServiceI;
import com.hdm.servicei.UserServiceI;
import com.hdm.servicei.impl.SecurityServiceImpl;

public class SecurityUserDelegate {
	SecurityServiceI ssi = new SecurityServiceImpl();
	Vector<ProfileTO> vpro = null;
	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws LoginException,
			ConnectionException {
		vpro = ssi.loginCheck(pro);
		return vpro;
	}
	public boolean changePass(ProfileTO pro) throws ConnectionException {
		return ssi.changePass(pro);
	}
	public boolean passwordRecovery(ProfileTO pro) throws ConnectionException {
		return ssi.passwordRecovery(pro);
	}
	public boolean forgetPass(ProfileTO pro) throws ConnectionException {
		return ssi.forgetPass(pro);
	}
}
