package com.example.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

@Entity
public class CustomerDetails {

  private @Id @GeneratedValue Integer customerId;
  private String customerName;
  private String password;
  
  public CustomerDetails() {
  }
  
  public CustomerDetails(Integer customerId, String customerName, String password) {
	this.customerId = customerId;
	this.customerName = customerName;
	this.password = password;
  }
  /**
   * @return the customerId
   */
  public Integer getCustomerId() {
	  return customerId;
  }
  /**
   * @param customerId the customerId to set
   */
  public void setCustomerId(Integer customerId) {
	  this.customerId = customerId;
  }
  /**
   * @return the customerName
   */
  public String getCustomerName() {
	  return customerName;
  }
  /**
   * @param customerName the customerName to set
   */
  public void setCustomerName(String customerName) {
	  this.customerName = customerName;
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
	  return "CustomerDetails [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
			  + "]";
  }
}
