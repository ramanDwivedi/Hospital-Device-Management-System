package com.hdm.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.hdm.bean.ProfileTO;
import com.hdm.delegate.SecurityUserDelegate;
import com.hdm.util.UtilConstants;

/**
 * NewPasswordAction servlet Class for to change Password. This class Helps to
 * get change password by using old password.
 * 
 */
public class NewPasswordAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2941564269120432640L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		boolean flag = false;
		String path = "";

		ProfileTO pro = new ProfileTO();

		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(pro, map);
			flag = new SecurityUserDelegate().forgetPass(pro);
			if (flag) {
				request.setAttribute("status", UtilConstants._PASSWORD_SUCCESS);
				path = UtilConstants._USER_PASSWORD_CHANGE;
			} else {
				request.setAttribute("status", UtilConstants._PASSWORD_FAILED);
				path = UtilConstants._STATUS;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._STATUS;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
