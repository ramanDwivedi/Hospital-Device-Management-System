package com.hdm.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
 * RegisterAction servlet Class for to insert new user details. This class Helps
 * to insert user personal,address details.
 * 
 */
public class RegisterAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean flag = false;
		String path = "";
		ProfileTO pf = new ProfileTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(pf, map);

		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			flag = new UserDelegate().insertNewUser(pf);
			if (flag) {
				path = UtilConstants._STATUS;
				request.setAttribute("status",
						UtilConstants._REGISTERED_SUCCESS);
			} else {
				path = UtilConstants._STATUS;
				request.setAttribute("status", UtilConstants._REGISTERED_FAIL);
			}
		} catch (Exception e) {
			path = UtilConstants._STATUS;
			request.setAttribute("status", e.getMessage());
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
