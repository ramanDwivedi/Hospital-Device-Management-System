package com.hdm.action;

import java.io.IOException;
import java.io.PrintWriter;
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
 * ViewDeviceAction servlet Class for to View device details. This class Helps
 * to view devices details.
 * 
 */
public class ViewDeviceAction extends HttpServlet {

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
		String path = request.getRealPath("./images");
		String target;
		RequestDispatcher rd = null;
		Vector<DeviceTO> vdevice = null;

		try {
			vdevice = new DoctorDelegate().viewDevices(path);
			if (vdevice != null) {
				request.setAttribute("deviceTO", vdevice);
				target = UtilConstants._VIEW_DEVICE;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_ALL_DEVICE_FAIL);
				target = UtilConstants._VIEW_DEVICE;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			target = UtilConstants._VIEW_DEVICE;
		}
		rd = request.getRequestDispatcher(target);
		rd.include(request, response);
	}
}
