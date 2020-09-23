package com.hdm.action;

import java.io.IOException;

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
 * UpdateViewDoctorDeviceAction servlet Class for to ViewDoctorDevices for
 * update. This class Helps to view UpdateDoctorDevices .
 * 
 */
public class UpdateViewDoctorDeviceAction extends HttpServlet {

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
		int devicedetailsid = Integer.parseInt(request
				.getParameter("devicedetailsid"));
		System.out.println(devicedetailsid);
		DeviceTO deviceTO = null;
		try {
			deviceTO = new DoctorDelegate()
					.updateviewDoctorDevice(devicedetailsid);
			if (deviceTO != null) {
				request.setAttribute("docdevice", deviceTO);
				path = UtilConstants._UPDATE_VIEW_DOCTOR_DEVICE;
			} else {
				request.setAttribute("status",
						UtilConstants._UPDATE_VIEW_DOCTOR_DEVICE_FAIL);
				path = UtilConstants._UPDATE_VIEW_DOCTOR_DEVICE;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._UPDATE_VIEW_DOCTOR_DEVICE;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
