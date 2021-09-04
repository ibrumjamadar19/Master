package com.example.bean;

import javax.validation.constraints.NotNull;

public class Customer {
	
	@NotNull(message = "customerId can not be null")
	public Integer customerId;
	@NotNull(message = "password can not be null")
	public String password;
	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", password=" + password + "]";
	}
}
