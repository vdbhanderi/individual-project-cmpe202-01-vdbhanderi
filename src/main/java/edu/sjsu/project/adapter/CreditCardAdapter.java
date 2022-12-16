package edu.sjsu.project.adapter;

import edu.sjsu.project.card.CreditCard;
import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.writer.OutputRecord;

public class CreditCardAdapter extends OutputRecord {
	
	private CreditCard creditCard;
	
	public CreditCardAdapter(CreditCard creditCard) {
		this.creditCard = creditCard;
		this.cardNumber = this.creditCard.getCardNumber();
		CardType cardType = this.creditCard.getCardType();
		if(CardType.INVALID.equals(cardType)) {
			this.error = "Invalid card number";
		} else {
			this.typeOfCard = creditCard.getCardType().toString();
		}
	}
}
