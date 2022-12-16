package edu.sjsu.project.validator;

import org.junit.Test;

import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;
import junit.framework.TestCase;

public class CreditCardValidatorTest extends TestCase{
	
	@Test
	public void testValidate() {
		InputRecord masterRecord = new InputRecord("5410000000000000", "3/20/2030", "Alice");
		InputRecord visaRecord = new InputRecord("4120000000000", "4/20/2030", "Bob");
		InputRecord amexRecord = new InputRecord("341000000000000", "5/20/2030", "Eve");
		InputRecord discoverRecord = new InputRecord("6011000000000000", "6/20/2030", "Richard");
		InputRecord unknownRecord = new InputRecord("6123000000000000", "6/20/2030", "Harry");
		InputRecord invalidRecord = new InputRecord("211100000000000000000", "6/20/2030", "Tom");
		CreditCardValidator firstValidator = new ValidatorChain().getFirstValidator();
		assertEquals(firstValidator.validate(masterRecord), CardType.MASTER);
		assertEquals(firstValidator.validate(visaRecord), CardType.VISA);
		assertEquals(firstValidator.validate(amexRecord), CardType.AMEX);
		assertEquals(firstValidator.validate(discoverRecord), CardType.DISCOVER);
		assertEquals(firstValidator.validate(unknownRecord), CardType.UNKNOWN);
		assertEquals(firstValidator.validate(invalidRecord), CardType.GREATERTHAN19);
	}
}
