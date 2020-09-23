package com.hdm.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hdm.bean.ProfileTO;
import com.hdm.delegate.SecurityUserDelegate;
import com.hdm.exception.ConnectionException;
import com.hdm.exception.LoginException;
import com.hdm.util.UtilConstants;

/**
 * LoginAction servlet Class for to Login in his account. This class Helps to
 * hold some user related data in session.
 * 
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		HttpSession session = request.getSession();
		ProfileTO pro = new ProfileTO();
		Vector<ProfileTO> vpro = new Vector<ProfileTO>();
		String username = request.getParameter(UtilConstants._USERNAME);
		pro.setUserName(username);
		String password = request.getParameter(UtilConstants._PASSWORD);
		pro.setPassword(password);
		try {
			vpro = new SecurityUserDelegate().loginCheck(pro);
			Iterator it = vpro.listIterator();
			while (it.hasNext()) {
				pro = (ProfileTO) it.next();
				System.out.println("in LoginAction Role is.........."
						+ pro.getLogintype());
			}
			if (pro.getLogintype().equalsIgnoreCase(UtilConstants._ADMIN)) {
				request.setAttribute("status", "Welcome " + pro.getLoginid());
				target = UtilConstants._ADMIN_HOME;
				session.setAttribute(UtilConstants._LOGINID, pro.getLoginid());
				session.setAttribute(UtilConstants._USERID, pro.getUserid());
				session.setAttribute(UtilConstants._ROLE, pro.getLogintype());
			} else if (pro.getLogintype().equalsIgnoreCase(
					UtilConstants._DOCTOR)) {
				session.setAttribute(UtilConstants._LOGINID, pro.getLoginid());
				session.setAttribute(UtilConstants._USERID, pro.getUserid());
				session.setAttribute(UtilConstants._ROLE, pro.getLogintype());
				System.out.println("LoginAction :" + pro.getLogintype());
				target = UtilConstants._ADMIN_HOME;
			} else if (pro.getLogintype().equalsIgnoreCase(
					UtilConstants._FINANCER)) {
				session.setAttribute(UtilConstants._LOGINID, pro.getLoginid());
				session.setAttribute(UtilConstants._USERID, pro.getUserid());
				session.setAttribute(UtilConstants._ROLE, pro.getLogintype());
				target = UtilConstants._ADMIN_HOME;
				System.out.println("LoginAction :" + pro.getLogintype());
				System.out.println("logind :" + pro.getLoginid());
				System.out.println("userid :" + pro.getUserid());
			} else {
				request.setAttribute("status", UtilConstants._INVALID_USER);
				target = UtilConstants._LOGIN_FAILED_PAGE;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._LOGIN_FAILED_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
