package com.hdm.delegate;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.hdm.bean.DeviceTO;
import com.hdm.exception.ConnectionException;
import com.hdm.servicei.DoctorServiceI;
import com.hdm.servicei.impl.DoctorServiceImpl;

public class DoctorDelegate {
	DoctorServiceI usi = new DoctorServiceImpl();
	Vector<DeviceTO> vdevice = new Vector<DeviceTO>();
	DeviceTO deviceTO = null;

	public boolean addCompanyDetails(DeviceTO deviceTO)
			throws FileNotFoundException, ConnectionException {
		return usi.addCompanyDetails(deviceTO);
	}

	public Vector<DeviceTO> deviceCompanyNames() throws ConnectionException {
		vdevice = usi.deviceCompanyNames();
		return vdevice;
	}

	public Vector<DeviceTO> viewDevices(String path) throws ConnectionException {
		vdevice = usi.viewDevices(path);
		return vdevice;
	}

	public boolean addNewDevice(DeviceTO deviceTO)
			throws FileNotFoundException, ConnectionException {
		return usi.addNewDevice(deviceTO);
	}

	public boolean requestDoctorDevice(DeviceTO deviceTO)
			throws ConnectionException {
		return usi.requestDoctorDevice(deviceTO);
	}

	public Vector<DeviceTO> viewDevicesRequest() throws ConnectionException {
		vdevice = usi.viewDevicesRequest();
		return vdevice;
	}

	public boolean updateDoctorDeviceRequest(int requestid)
			throws ConnectionException {
		return usi.updateDoctorDeviceRequest(requestid);
	}

	public Vector<DeviceTO> inventaryDevicesRequest(DeviceTO deviceTO)
			throws ConnectionException {
		vdevice = usi.inventaryDevicesRequest(deviceTO);
		return vdevice;
	}

	public boolean devicePurchageDetails(DeviceTO deviceTO)
			throws ConnectionException {
		return usi.devicePurchageDetails(deviceTO);
	}

	public Vector<DeviceTO> viewPurchageDevices() throws ConnectionException {
		vdevice = usi.viewPurchageDevices();
		return vdevice;
	}

	public Vector<DeviceTO> viewDevicesCompanies() throws ConnectionException {
		vdevice = usi.viewDevicesCompanies();
		return vdevice;
	}

	public boolean deleteItem(int i) throws ConnectionException {
		return usi.deleteItem(i);
	}

	public boolean deleteIDeviceRequest(int i) throws ConnectionException {
		return usi.deleteIDeviceRequest(i);
	}

	public boolean addDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException {
		return usi.addDoctorPatientRatio(deviceTO);
	}

	public Vector<DeviceTO> viewDevicePatientRatio() throws ConnectionException {
		vdevice = usi.viewDevicePatientRatio();
		return vdevice;
	}

	public boolean updateDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException {
		return usi.updateDoctorPatientRatio(deviceTO);
	}

	public DeviceTO updateviewDoctorDevice(int devicedetailsid)
			throws ConnectionException {
		deviceTO = usi.updateviewDoctorDevice(devicedetailsid);
		return deviceTO;
	}

	public Vector<DeviceTO> viewAllDevices() throws ConnectionException {
		vdevice = usi.viewAllDevices();
		return vdevice;
	}

	public Vector<DeviceTO> viewDoctorApprovedDevices()
			throws ConnectionException {
		vdevice = usi.viewDoctorApprovedDevices();
		return vdevice;
	}
}
