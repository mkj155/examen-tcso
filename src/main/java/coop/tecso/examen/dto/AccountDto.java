package coop.tecso.examen.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = -1737700610469175651L;

	private String accountNumber;
	private String currency;
	private String saldo;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getSaldo() {
		return saldo;
	}
	
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
}
