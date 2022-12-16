package edu.sjsu.project.validator;

import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;
import org.apache.commons.lang3.StringUtils;

public class BaseValidator extends CreditCardValidator{
	
	@Override
	public void setNextValidator(CreditCardValidator creditCardValidator) {
		this.nextValidator = creditCardValidator;
	}

	@Override
	public CardType validate(InputRecord inputRecord) {
		CardType cardType = CardType.UNKNOWN;
		if(inputRecord.getCardNumber().length() > 19) {
			cardType = CardType.GREATERTHAN19;
		}
		else if(inputRecord.getCardNumber().length() == 0 || inputRecord.getCardNumber() == "" ||  inputRecord.getCardNumber().equals("null") ) {
			cardType = CardType.NULLENTRY;
		}
		else if(!StringUtils.isNumeric(inputRecord.getCardNumber())) {
			cardType = CardType.NONNUMERIC;
		}
		
		if(cardType.equals(CardType.UNKNOWN) && nextValidator != null) {
			cardType = nextValidator.validate(inputRecord);
		}
		return cardType;
	}
	
}
