package edu.sjsu.project.validator;

import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;

public abstract class CreditCardValidator {
	
	protected CreditCardValidator nextValidator;
	
	public abstract CardType validate(InputRecord inputRecord);
	
	public abstract void setNextValidator(CreditCardValidator creditCardValidator);
	
}
