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
 * ViewDevicesAction Servlet Class for to view Devices.
 * This class Helps to view devices  Details.
 * 
 */
public class ViewDevicesAction extends HttpServlet {

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
		String path1 = request.getRealPath("./images");
		RequestDispatcher rd = null;
		Vector<DeviceTO> vdevice = null;
		try {
			vdevice = new DoctorDelegate().viewDevices(path1);
			if (vdevice != null) {
				request.setAttribute("deviceTO", vdevice);
				path = UtilConstants._ADD_DEVICE_REQUEST;
			} else {
				request.setAttribute("status", UtilConstants._VIEW_DEVICE_FAIL);
				path = UtilConstants._ADD_DEVICE_REQUEST;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._ADD_DEVICE_REQUEST;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
