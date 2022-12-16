package edu.sjsu.project.card;

import edu.sjsu.project.enums.CardType;

public class CreditCard {
	protected String cardNumber;
	protected String expirationDate;
	protected String nameOfCardholder;
	protected CardType cardType = CardType.UNKNOWN;
	
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
	public CardType getCardType() {
		return cardType;
	}
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", nameOfCardholder="
				+ nameOfCardholder + ", cardType=" + cardType + "]";
	}
	
}
