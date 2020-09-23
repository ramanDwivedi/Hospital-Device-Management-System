package com.hdm.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hdm.bean.ProfileTO;
import com.hdm.delegate.UserDelegate;
import com.hdm.util.UtilConstants;

/**
 * ViewProfileAction Servlet Class for to view View User Profile This class
 * Helps to view user profile,personal details,address Details.
 * 
 */
public class ViewProfileAction extends HttpServlet {
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
		String path = "";
		HttpSession session = request.getSession();
		String userid = request.getParameter("userid");
		Vector<ProfileTO> opv = null;
		try {
			path = request.getRealPath("/images");
			opv = new UserDelegate().viewUser(userid, path);
			if (!opv.isEmpty()) {
				request
						.setAttribute("status",
								UtilConstants._USER_PROFILE_INFO);
				request.setAttribute("userinfo", opv);
				request.setAttribute("userid", userid);
				path = UtilConstants._VIEW_USER_PROFILE;

			} else {
				request.setAttribute("status", UtilConstants._NO_USER_PROFILE);
				request.setAttribute("userid", userid);
				path = UtilConstants._VIEW_USER_PROFILE;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._VIEW_USER_PROFILE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
