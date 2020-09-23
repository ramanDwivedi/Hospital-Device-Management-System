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
 * AddPatientDeviceRatioAction servlet Class for to Add Patient to Device Ratio
 * details. This class Helps to add patient to device ratio details.
 * 
 */
public class AddDevicePatientRatioAction extends HttpServlet {

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
				path = UtilConstants._PATIENT_DEVICE_RATIO;
			} else {
				request.setAttribute("status", UtilConstants._VIEW_DEVICE_FAIL);
				path = UtilConstants._PATIENT_DEVICE_RATIO;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._PATIENT_DEVICE_RATIO;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
