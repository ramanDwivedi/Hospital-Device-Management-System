package com.hdm.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hdm.delegate.UserDelegate;
import com.hdm.util.UtilConstants;

/**
 * CheckUserAction servlet Class for to CheckUserAction. This class Helps to
 * check whether user available or not.
 * 
 */
public class CheckUserAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String target = request.getParameter("path");
		System.out.println(target);
		try {
			// String a="Available";
			String user = new UserDelegate().checkUser(username);
			System.out.println(user);

			if (user == null) {
				request.setAttribute("status", UtilConstants._USER_AVAILABLE);
				// request.setAttribute("status", a);
				// System.out.println(a);
			} else
				request
						.setAttribute("status",
								UtilConstants._USER_NO_AVAILABLE);
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
