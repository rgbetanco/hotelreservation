package com.nicahost.module.classified.bean;

import java.io.Serializable;

public class BankAccountBean implements Serializable {
	private String bankAccountHolder;
	private String bankName;
	private String bankAccount;

	public BankAccountBean() {		
	}
	
	
	/**
	 * @return
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * @return
	 */
	public String getBankAccountHolder() {
		return bankAccountHolder;
	}

	/**
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param string
	 */
	public void setBankAccount(String string) {
		bankAccount = string;
	}

	/**
	 * @param string
	 */
	public void setBankAccountHolder(String string) {
		bankAccountHolder = string;
	}

	/**
	 * @param string
	 */
	public void setBankName(String string) {
		bankName = string;
	}

}