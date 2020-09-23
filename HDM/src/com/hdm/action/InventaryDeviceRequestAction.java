package com.hdm.action;

import java.io.IOException;
import java.util.ListIterator;
import java.util.Map;
import java.util.Vector;

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
 * InventaryDeviceRequestAction servlet Class for to Device Intentary Details
 * This class Helps to view InventaryDevice Details.
 * 
 */
public class InventaryDeviceRequestAction extends HttpServlet {
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
		DeviceTO dev;
		Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
		Vector<DeviceTO> vdevice1 = new Vector<DeviceTO>();
		Map map = request.getParameterMap();
		int userid = Integer.parseInt(request.getParameter("userid"));
		int deviceqrequestid = Integer.parseInt(request
				.getParameter("deviceqrequestid"));
		System.out.println(userid);
		System.out.println(deviceqrequestid);
		try {
			BeanUtils.populate(deviceTO, map);
			vdevice = new DoctorDelegate().inventaryDevicesRequest(deviceTO);
			if (vdevice != null) {
				System.out.println(vdevice.size());
				int i = vdevice.size();
				dev = vdevice.get(i - 1);
				System.out.println(dev.getDeviceid());
				System.out.println(dev.getDevicename());
				System.out.println(dev.getDevicequantity());
				System.out.println(dev.getUserid());
				System.out.println("request :" + dev.getDeviceqrequestid());
				DeviceTO device1 = new DeviceTO();
				device1.setDeviceid(dev.getDeviceid());
				device1.setDevicename(dev.getDevicename());
				device1.setDevicequantity(dev.getDevicequantity());
				device1.setUserid(dev.getUserid());
				device1.setDoctorid(dev.getDoctorid());
				device1.setDeviceqrequestid(dev.getDeviceqrequestid());
				vdevice.remove(i - 1);
				System.out.println(vdevice.size());
				ListIterator iter = vdevice.listIterator();
				while (iter.hasNext()) {
					// System.out.println((DeviceTO)iter.next());
					deviceTO = (DeviceTO) iter.next();
					System.out.println("loop");
					vdevice1.add(deviceTO);
				}
				request.setAttribute("device1", device1);
				request.setAttribute("devicereq", vdevice1);
				path = UtilConstants._DEVICE_PURCHAGE;
			} else {
				request.setAttribute("status",
						UtilConstants._DEVICE_PURCHAGE_FAIL);
				path = UtilConstants._DEVICE_PURCHAGE;
			}
		} catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._DEVICE_PURCHAGE;
		}
		rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
