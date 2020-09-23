package com.hdm.daoi;

import java.util.Vector;
import com.hdm.bean.ProfileTO;
import com.hdm.exception.ConnectionException;

public interface SecurityDaoI {
	public Vector<ProfileTO> loginCheck(ProfileTO pro) throws ConnectionException;
	public boolean changePass(ProfileTO pro) throws ConnectionException;
	public boolean passwordRecovery(ProfileTO pro) throws ConnectionException;
	public boolean forgetPass(ProfileTO pro) throws ConnectionException;
}
