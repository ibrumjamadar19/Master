package com.example.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

@Entity
public class FevoriteBankDetails {
  	
  private @Id @GeneratedValue Integer id;
  private Integer customerId;
  @NotNull(message = "FevoriteBankName can not be null")
  private String FevoriteBankName;
  @NotNull(message = "FevoriteAccountNumber can not be null")
  @Size(max=20, message = "FevoriteAccountNumber size can not be more than 20")
  private String FevoriteAccountNumber;
  @NotNull(message = "FevoriteAccountName can not be null")
  private String FevoriteAccountName;
  
  public FevoriteBankDetails() {
  }
  
  public FevoriteBankDetails(Integer id, Integer customerId, String fevoriteBankName, String fevoriteAccountNumber,
		String fevoriteAccountName) {
	this.id = id;
	this.customerId = customerId;
	FevoriteBankName = fevoriteBankName;
	FevoriteAccountNumber = fevoriteAccountNumber;
	FevoriteAccountName = fevoriteAccountName;
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
   * @return the fevoriteBankName
   */
  public String getFevoriteBankName() {
	  return FevoriteBankName;
  }
  /**
   * @param fevoriteBankName the fevoriteBankName to set
   */
  public void setFevoriteBankName(String fevoriteBankName) {
	  FevoriteBankName = fevoriteBankName;
  }
  /**
   * @return the fevoriteAccountNumber
   */
  public String getFevoriteAccountNumber() {
	  return FevoriteAccountNumber;
  }
  /**
   * @param fevoriteAccountNumber the fevoriteAccountNumber to set
   */
  public void setFevoriteAccountNumber(String fevoriteAccountNumber) {
	  FevoriteAccountNumber = fevoriteAccountNumber;
  }
  /**
   * @return the fevoriteAccountName
   */
  public String getFevoriteAccountName() {
	  return FevoriteAccountName;
  }
  /**
   * @param fevoriteAccountName the fevoriteAccountName to set
   */
  public void setFevoriteAccountName(String fevoriteAccountName) {
	  FevoriteAccountName = fevoriteAccountName;
  }
  /**
   * @return the id
   */
  public Integer getId() {
	  return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
	  this.id = id;
  }

  @Override
  public String toString() {
	  return "FevoriteBankDetails [id=" + id + ", customerId=" + customerId + ", FevoriteBankName=" + FevoriteBankName
			  + ", FevoriteAccountNumber=" + FevoriteAccountNumber + ", FevoriteAccountName=" + FevoriteAccountName + "]";
  }
}
