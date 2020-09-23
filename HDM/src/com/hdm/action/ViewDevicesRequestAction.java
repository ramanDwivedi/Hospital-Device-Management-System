package com.hdm.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hdm.bean.DeviceTO;
import com.hdm.delegate.DoctorDelegate;
import com.hdm.exception.ConnectionException;
import com.hdm.util.UtilConstants;

/**
 * ViewDevicesRequestAction Servlet Class for to view Devices Requests for
 * Doctors. This class Helps to view Doctors device request Details.
 * 
 */
public class ViewDevicesRequestAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229229798006038995L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path;
		RequestDispatcher rd = null;
		Vector<DeviceTO> vdevice = null;
		try {
			vdevice = new DoctorDelegate().viewDevicesRequest();
			if (vdevice != null) {
				request.setAttribute("devicereq", vdevice);
				path = UtilConstants._VIEW_DEVICE_REQUEST;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_DEVICE_REQ_FAIL);
				path = UtilConstants._VIEW_DEVICE_REQUEST;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._VIEW_DEVICE_REQUEST;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
