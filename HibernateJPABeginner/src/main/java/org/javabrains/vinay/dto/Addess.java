/**
 * 
 */
package org.javabrains.vinay.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author VINAY
 *
 */
@Embeddable
public class Addess {
	
	@Column ( name = "STREET_NAME")
	private String street;
	
	@Column ( name = "CITY_NAME")
	private String city;
	
	@Column ( name = "STATE_NAME")
	private String state;
	
	@Column ( name = "PINCODE_NAME")
	private String pincode;

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
