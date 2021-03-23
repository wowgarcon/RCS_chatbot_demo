package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceSpecifics {
	/*
	 * [Optional] Device model description.
	 */
	private String deviceModel;
	/*
	 * [Optional] Device platform version.
	 */
	private String platformVersion;
	/*
	 * [Optional] Short code for client vendor
	 */
	private String clientVendor;
	/*
	 * [Optional] Client version information
	 */
	private String clientVersion;
	/*
	 * [Optional] Remaining battery use of device in minutes.
	 */
	private Integer batteryRemainingMinutes;
}
