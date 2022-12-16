package edu.sjsu.project.validator;

import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;

public class AmExValidator extends CreditCardValidator{

	@Override
	public CardType validate(InputRecord inputRecord) {
		CardType cardType = CardType.UNKNOWN;
		String cardNumber = inputRecord.getCardNumber();
		if(cardNumber.length() == 15) {
			int firstDigit = Integer.parseInt(cardNumber.substring(0, 1));
			int secondDigit = Integer.parseInt(cardNumber.substring(1, 2));
			if(firstDigit == 3 && (secondDigit == 4 || secondDigit == 7)) {
				cardType = CardType.AMEX;
			}
		} else if(cardType.equals(CardType.UNKNOWN) && nextValidator != null) {
			cardType = nextValidator.validate(inputRecord);
		}
		return cardType;
	}
	
	@Override
	public void setNextValidator(CreditCardValidator creditCardValidator) {
		this.nextValidator = creditCardValidator;
	}

}
