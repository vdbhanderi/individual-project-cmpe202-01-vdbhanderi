package edu.sjsu.project.validator;

import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;

public class DiscoverValidator extends CreditCardValidator{

	@Override
	public void setNextValidator(CreditCardValidator creditCardValidator) {
		this.nextValidator = creditCardValidator;
	}
	
	@Override
	public CardType validate(InputRecord inputRecord) {
		CardType cardType = CardType.UNKNOWN;
		String cardNumber = inputRecord.getCardNumber();
		if(cardNumber.length() == 16) {
			int firstFourDigits = Integer.parseInt(cardNumber.substring(0, 4));
			if(firstFourDigits == 6011) {
				cardType = CardType.DISCOVER;
			}
		} 
		
		if(cardType.equals(CardType.UNKNOWN) && nextValidator != null) {
			cardType = nextValidator.validate(inputRecord);
		}
		return cardType;
	}

}
