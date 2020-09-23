package com.hdm.servicei.impl;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.hdm.bean.DeviceTO;
import com.hdm.daoi.DoctorDaoI;
import com.hdm.daoi.impl.DoctorDaoImpl;
import com.hdm.exception.ConnectionException;
import com.hdm.servicei.DoctorServiceI;

public class DoctorServiceImpl implements DoctorServiceI {

	boolean flag = false;
	Vector<DeviceTO> vdevice = null;
	DeviceTO deviceTO =new DeviceTO();
	DoctorDaoI sdaoi = new DoctorDaoImpl();

	public boolean addCompanyDetails(DeviceTO deviceTO)
			throws FileNotFoundException, ConnectionException {
		return sdaoi.addCompanyDetails(deviceTO);
	}

	public Vector<DeviceTO> deviceCompanyNames() throws ConnectionException {
		vdevice = sdaoi.deviceCompanyNames();
		return vdevice;
	}

	public Vector<DeviceTO> viewDevices(String path) throws ConnectionException {
		vdevice = sdaoi.viewDevices(path);
		return vdevice;
	}

	public boolean addNewDevice(DeviceTO deviceTO) throws FileNotFoundException,
			ConnectionException {
		return sdaoi.addNewDevice(deviceTO);
	}

	public boolean requestDoctorDevice(DeviceTO deviceTO)
			throws ConnectionException {
		return sdaoi.requestDoctorDevice(deviceTO);
	}

	public Vector<DeviceTO> viewDevicesRequest() throws ConnectionException {
		return sdaoi.viewDevicesRequest();
	}

	public boolean updateDoctorDeviceRequest(int requestid)
			throws ConnectionException {
		return sdaoi.updateDoctorDeviceRequest(requestid);
	}

	public Vector<DeviceTO> inventaryDevicesRequest(DeviceTO deviceTO)
			throws ConnectionException {
		return sdaoi.inventaryDevicesRequest(deviceTO);
	}

	public boolean devicePurchageDetails(DeviceTO deviceTO)
			throws ConnectionException {
		return sdaoi.devicePurchageDetails(deviceTO);
	}

	public Vector<DeviceTO> viewPurchageDevices() throws ConnectionException {
		return sdaoi.viewPurchageDevices();
	}

	public Vector<DeviceTO> viewDevicesCompanies() throws ConnectionException {
		return sdaoi.viewDevicesCompanies();
	}

	public boolean deleteItem(int i) throws ConnectionException {
		return sdaoi.deleteItem(i);
	}

	public boolean addDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException {
		return sdaoi.addDoctorPatientRatio(deviceTO);
	}

	public Vector<DeviceTO> viewDevicePatientRatio() throws ConnectionException {
		return sdaoi.viewDevicePatientRatio();

	}

	public boolean updateDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException {
		return sdaoi.updateDoctorPatientRatio(deviceTO);
	}

	public DeviceTO updateviewDoctorDevice(int devicedetailsid)
			throws ConnectionException {
		deviceTO= sdaoi.updateviewDoctorDevice(devicedetailsid);
		return deviceTO;
	}
	public Vector<DeviceTO> viewAllDevices() throws ConnectionException {
		return sdaoi.viewAllDevices();

	}
	public Vector<DeviceTO> viewDoctorApprovedDevices() throws ConnectionException {
		return sdaoi.viewDoctorApprovedDevices();

	}
	public boolean deleteIDeviceRequest(int i) throws ConnectionException {
		return sdaoi.deleteIDeviceRequest(i);

	}
}		
