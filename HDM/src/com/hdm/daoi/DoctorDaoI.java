package com.hdm.daoi;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.hdm.bean.DeviceTO;
import com.hdm.exception.ConnectionException;

public interface DoctorDaoI {
	public boolean addCompanyDetails(DeviceTO deviceTO)
			throws FileNotFoundException, ConnectionException;

	public Vector<DeviceTO> deviceCompanyNames() throws ConnectionException;

	public boolean addNewDevice(DeviceTO deviceTO)
			throws FileNotFoundException, ConnectionException;

	public Vector<DeviceTO> viewDevices(String path) throws ConnectionException;

	public boolean requestDoctorDevice(DeviceTO deviceTO)
			throws ConnectionException;

	public Vector<DeviceTO> viewDevicesRequest() throws ConnectionException;

	public boolean updateDoctorDeviceRequest(int requestid)
			throws ConnectionException;

	public Vector<DeviceTO> inventaryDevicesRequest(DeviceTO deviceTO)
			throws ConnectionException;

	public boolean devicePurchageDetails(DeviceTO deviceTO)
			throws ConnectionException;

	public Vector<DeviceTO> viewPurchageDevices() throws ConnectionException;

	public Vector<DeviceTO> viewDevicesCompanies() throws ConnectionException;

	public boolean deleteItem(int i) throws ConnectionException;

	public boolean addDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException;

	public Vector<DeviceTO> viewDevicePatientRatio() throws ConnectionException;

	public boolean updateDoctorPatientRatio(DeviceTO deviceTO)
			throws ConnectionException;

	public DeviceTO updateviewDoctorDevice(int devicedetailsid)
			throws ConnectionException;

	public Vector<DeviceTO> viewAllDevices() throws ConnectionException;

	public Vector<DeviceTO> viewDoctorApprovedDevices()
			throws ConnectionException;

	public boolean deleteIDeviceRequest(int i) throws ConnectionException;
}
