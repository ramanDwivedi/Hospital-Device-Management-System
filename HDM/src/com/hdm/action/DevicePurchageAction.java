package com.hdm.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hdm.bean.DeviceTO;
import com.hdm.delegate.DoctorDelegate;
import com.hdm.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * DevicePurchageAction servlet Class for to Devices Purchaging details. This
 * class Helps to view Device Purchage details.
 * 
 */
public class DevicePurchageAction extends HttpServlet {
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
		DeviceTO deviceTO = new DeviceTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(deviceTO, map);
			flag = new DoctorDelegate().devicePurchageDetails(deviceTO);
			if (flag) {
				request.setAttribute("status",
						UtilConstants._ADD_DEVICE_PURCHAGE);
				path = UtilConstants._STATUS;
			} else {
				request.setAttribute("status",
						UtilConstants._ADD_DEVICE_PURCHAGE_FAIL);
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
