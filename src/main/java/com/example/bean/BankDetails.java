package com.example.bean;

public class BankDetails {

	Integer codeId;
	String bankName;
	
	/**
	 * @return the codeId
	 */
	public Integer getCodeId() {
		return codeId;
	}
	/**
	 * @param codeId the codeId to set
	 */
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return "BankDetails [codeId=" + codeId + ", bankName=" + bankName + "]";
	}
}
