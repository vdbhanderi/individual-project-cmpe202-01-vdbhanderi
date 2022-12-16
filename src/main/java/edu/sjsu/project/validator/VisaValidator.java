package edu.sjsu.project.validator;

import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;

public class VisaValidator extends CreditCardValidator{
	
	@Override
	public void setNextValidator(CreditCardValidator creditCardValidator) {
		this.nextValidator = creditCardValidator;
	}
	
	@Override
	public CardType validate(InputRecord inputRecord) {
		CardType cardType = CardType.UNKNOWN;
		String cardNumber = inputRecord.getCardNumber();
		if(cardNumber.length() == 16 || cardNumber.length() == 13) {
			int firstDigit = Integer.parseInt(cardNumber.substring(0, 1));
			if(firstDigit == 4) {
				cardType = CardType.VISA;
			}
		} 
		
		if(cardType.equals(CardType.UNKNOWN) && nextValidator != null) {
			cardType = nextValidator.validate(inputRecord);
		}
		return cardType;
	}

}
