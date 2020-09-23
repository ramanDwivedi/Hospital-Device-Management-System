package com.hdm.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.hdm.bean.ProfileTO;
import com.hdm.delegate.SecurityUserDelegate;
import com.hdm.util.UtilConstants;

/**
 * RecoverPasswordAction servlet Class for to RecoverPassword. This class Helps
 * to get their password by using their security question and answer.
 * 
 */
public class RecoverPasswordAction extends HttpServlet {
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
		String path = "";
		boolean flag = true;
		HttpSession session = request.getSession();
		ProfileTO pro = new ProfileTO();

		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(pro, map);
			flag = new SecurityUserDelegate().passwordRecovery(pro);
			if (flag) {
				String loginid = pro.getUserName();
				request.setAttribute("status",
						UtilConstants._RECOVER_PASSWORD_SUCCESS);
				path = UtilConstants._NEW_PASSWORD;
				session.setAttribute("loginid", loginid);
				System.out.println(path);
			} else {
				request.setAttribute("status",
						UtilConstants._RECOVER_PASSWORD_FAILED);
				path = UtilConstants._RECOVER_PASSWORD;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._RECOVER_PASSWORD;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
