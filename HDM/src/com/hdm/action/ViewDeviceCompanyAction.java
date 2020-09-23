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
 * ViewDeviceCompanyAction Servlet Class for to View devices Companies ratio
 * details. This class Helps to view Company names.
 * 
 */
public class ViewDeviceCompanyAction extends HttpServlet {

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
			vdevice = new DoctorDelegate().viewDevicesCompanies();
			if (vdevice != null) {
				request.setAttribute("company", vdevice);
				path = UtilConstants._VIEW_COMPANY;
				System.out.println("Hai");
			} else {
				request
						.setAttribute("status",
								UtilConstants._VIEW_COMPANY_FAIL);
				path = UtilConstants._VIEW_COMPANY;
			}
		} catch (ConnectionException ce) {
			request.setAttribute("status", ce.getMessage());
			path = UtilConstants._VIEW_COMPANY;
		}
		rd = request.getRequestDispatcher(path);
		rd.include(request, response);
	}
}
