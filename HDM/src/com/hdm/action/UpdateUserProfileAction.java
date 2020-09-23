package com.hdm.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hdm.bean.ProfileTO;
import com.hdm.delegate.UserDelegate;
import com.hdm.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * UpdateUserProfileAction servlet Class for to update user profile. This class
 * Helps to UpdateUserProfile.
 * 
 */
public class UpdateUserProfileAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			flag = new UserDelegate().updateUser(pro);
			if (flag) {
				path = UtilConstants._STATUS;
				request.setAttribute("status", UtilConstants._UPDATE_SUCCESS);
			} else {
				path = UtilConstants._STATUS;
				request.setAttribute("status", UtilConstants._UPDATE_FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			path = UtilConstants._STATUS;
			request.setAttribute("status", e.getMessage());
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
