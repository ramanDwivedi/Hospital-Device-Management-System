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
 * ViewAllDevicesAction servlet Class for to View All device details. This class
 * Helps to view All devices details.
 * 
 */
public class ViewAllDevicesAction extends HttpServlet {

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
			vdevice = new DoctorDelegate().viewAllDevices();
			if (vdevice != null) {
				request.setAttribute("inventary", vdevice);
				path = UtilConstants._VIEW_INVENTARY_DEVICES;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_INVENTARY_DEVICES_FAIL);
				path = UtilConstants._VIEW_INVENTARY_DEVICES;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._VIEW_INVENTARY_DEVICES;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
