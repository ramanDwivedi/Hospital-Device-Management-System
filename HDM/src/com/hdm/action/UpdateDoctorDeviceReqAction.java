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
 * UpdateDoctorDeviceReqAction servlet Class for to Update Doctor Devices
 * Request. This class Helps to Update Doctor DeviceRequest change.
 * 
 */
public class UpdateDoctorDeviceReqAction extends HttpServlet {
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
		int reqid = Integer.parseInt(request.getParameter("reqid"));
		System.out.println(reqid);
		try {
			flag = new DoctorDelegate().updateDoctorDeviceRequest(reqid);
			if (flag) {
				request.setAttribute("status", UtilConstants._UPDATE_DEVICE);
				path = UtilConstants._STATUS;
			} else {
				request.setAttribute("status",
						UtilConstants._UPDATE_DEVICE_FAIL);
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
