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
 * ViewDoctorApproveDevicesAction Servlet Class for to view Approved Devices for
 * Doctor. This class Helps to view Doctor Assigned Device Details.
 * 
 */
public class ViewDoctorApproveDevicesAction extends HttpServlet {

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
			vdevice = new DoctorDelegate().viewDoctorApprovedDevices();
			if (vdevice != null) {
				request.setAttribute("doctor_devices", vdevice);
				path = UtilConstants._VIEW_DOCTOR_APPROVED_DEVICES;
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_DOCTOR_APPROVED_DEVICES_FAIL);
				path = UtilConstants._VIEW_DOCTOR_APPROVED_DEVICES;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._VIEW_DOCTOR_APPROVED_DEVICES;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
