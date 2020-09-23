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
 * ViewDevicePatientRatioAction Servlet Class for to View Patient to Device
 * ratio details. This class Helps to Device Purchages Details.
 * 
 */
public class ViewDevicePatientRatioAction extends HttpServlet {
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
			vdevice = new DoctorDelegate().viewDevicePatientRatio();
			if (vdevice != null) {
				request.setAttribute("deviceTO", vdevice);
				path = UtilConstants._VIEW_DOCTOR_DEVICE;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_DOCTOR_DEVICE_FAIL);
				path = UtilConstants._VIEW_DOCTOR_DEVICE;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._VIEW_DOCTOR_DEVICE;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
