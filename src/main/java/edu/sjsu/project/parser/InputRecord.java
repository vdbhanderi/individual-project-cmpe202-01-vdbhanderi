package edu.sjsu.project.parser;

public class InputRecord {
	private String cardNumber;
	private String expirationDate;
	private String nameOfCardholder;
	
	public InputRecord() {}
	
	public InputRecord(String cardNumber, String expirationDate, String nameOfCardholder) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.nameOfCardholder = nameOfCardholder;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getNameOfCardholder() {
		return nameOfCardholder;
	}
	public void setNameOfCardholder(String nameOfCardHolder) {
		this.nameOfCardholder = nameOfCardHolder;
	}
}
