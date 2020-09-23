package com.hdm.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hdm.delegate.DoctorDelegate;
import com.hdm.util.UtilConstants;

/**
 * DeleteDeviceRequestAction servlet Class for to Delete Device Request. This
 * class Helps to Delete device Request details by using deviceid.
 * 
 */
public class DeleteDeviceRequestAction extends HttpServlet {

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
		String ch[] = request.getParameterValues("ch");
		try {
			for (int i = 0; i < ch.length; i++) {
				System.out.println(ch[i]);
				flag = new DoctorDelegate().deleteIDeviceRequest(Integer
						.parseInt(ch[i]));
			}
			if (flag) {
				request.setAttribute("status",
						UtilConstants._VIEW_DEVICE_REQUEST_SUCCESS);
				path = UtilConstants._STATUS;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_COMPANY_DELETE_FAIL);
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
