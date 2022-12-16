package edu.sjsu.project.validator;

import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;

public class MasterValidator extends CreditCardValidator{
	
	@Override
	public void setNextValidator(CreditCardValidator creditCardValidator) {
		this.nextValidator = creditCardValidator;
	}
	
	@Override
	public CardType validate(InputRecord inputRecord) {
		CardType cardType = CardType.UNKNOWN;
		String cardNumber = inputRecord.getCardNumber();
		if(cardNumber.length() == 16) {
			int firstDigit = Integer.parseInt(cardNumber.substring(0, 1));
			int secondDigit = Integer.parseInt(cardNumber.substring(1, 2));
			if(firstDigit == 5 && secondDigit >= 1 && secondDigit <= 5) {
				cardType = CardType.MASTER;
			}
		}
		if(cardType.equals(CardType.UNKNOWN) && nextValidator != null) {
			cardType = nextValidator.validate(inputRecord);
		}
		return cardType;
	}

}
