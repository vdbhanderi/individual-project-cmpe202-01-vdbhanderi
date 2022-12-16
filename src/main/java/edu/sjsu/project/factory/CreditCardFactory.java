package edu.sjsu.project.factory;

import edu.sjsu.project.card.AmEx;
import edu.sjsu.project.card.CreditCard;
import edu.sjsu.project.card.Discover;
import edu.sjsu.project.card.Generic;
import edu.sjsu.project.card.Master;
import edu.sjsu.project.card.Visa;
import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;

public class CreditCardFactory {
	
	private static CreditCard getCreditCard(CardType cardType) {
		if(CardType.AMEX.equals(cardType)) {
			return new AmEx();
		} else if(CardType.DISCOVER.equals(cardType)) {
			return new Discover();
		} else if(CardType.MASTER.equals(cardType)) {
			return new Master();
		} else if(CardType.VISA.equals(cardType)) {
			return new Visa();
		} else if(CardType.NONNUMERIC.equals(cardType)) {
			CreditCard invalidCard = new Generic();
			invalidCard.setCardType(CardType.NONNUMERIC);
			return invalidCard;
		} else if(CardType.NULLENTRY.equals(cardType)) {
			CreditCard invalidCard = new Generic();
			invalidCard.setCardType(CardType.NULLENTRY);
			return invalidCard;
		}
		else if(CardType.GREATERTHAN19.equals(cardType)) {
			CreditCard invalidCard = new Generic();
			invalidCard.setCardType(CardType.GREATERTHAN19);
			return invalidCard;
		}
		
		
		return new Generic();
	}
	
	public static CreditCard buildCreditCard(InputRecord inputRecord, CardType cardType) {
		CreditCard creditCard = getCreditCard(cardType);
		creditCard.setCardNumber(inputRecord.getCardNumber());
		creditCard.setExpirationDate(inputRecord.getExpirationDate());
		creditCard.setNameOfCardholder(inputRecord.getNameOfCardholder());
		return creditCard;
	}
}
