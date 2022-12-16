package edu.sjsu.project.validator;

public class ValidatorChain {
	
	private CreditCardValidator firstValidator;
	
	public ValidatorChain() {
		firstValidator = new BaseValidator();
		CreditCardValidator secondValidator = new MasterValidator();
		CreditCardValidator thirdValidator = new VisaValidator();
		CreditCardValidator fourthValidator = new AmExValidator();
		CreditCardValidator fifthValidator = new DiscoverValidator();
		
		firstValidator.setNextValidator(secondValidator);
		secondValidator.setNextValidator(thirdValidator);
		thirdValidator.setNextValidator(fourthValidator);
		fourthValidator.setNextValidator(fifthValidator);
	}
	
	public CreditCardValidator getFirstValidator() {
		return firstValidator;
	}
}
