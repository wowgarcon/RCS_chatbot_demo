package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeolocationPushMessage {
	/*
	 * [Optional] Its the name given to location that is being shared.
	 */
	private String label;
	/*
	 * [Optional] Timestamp when location info was shared.
	 */
	private String timestamp;
	/*
	 * [Optional] Timestamp till the location info is valid.
	 */
	private String expiry;
	/*
	 * [Optional] Current time zone info expressed as the number of minutes away from UTC.
	 */
	private Integer timeOffset;
	/*
	 * This is the coordinates in WGS 84 (latitude, longitude) decimal notion as described in [RFC5491], providing the latitude and longitude as 'double'-encoded decimal numbers (as specified in [GML3.1.1]) representing the degrees, separated by a space starting with the latitude. (e.g.,"26.1181289 -80.1283921").
	 */
	private String  pos;
	/*
	 * [Optional] The radius of the circle will be represented in meters, which will be indicated by setting the unit of measure attribute of the radius element to the value of EPSG9001 as described in [RFC5491].
	 */
	private Integer radius;
}
