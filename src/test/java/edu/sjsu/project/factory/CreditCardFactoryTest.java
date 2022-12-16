package edu.sjsu.project.factory;

import org.junit.Test;

import edu.sjsu.project.card.CreditCard;
import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.parser.InputRecord;
import junit.framework.TestCase;

public class CreditCardFactoryTest extends TestCase{
	
	@Test
	public void testBuildCreditCard() {
		InputRecord inputRecord = new InputRecord("4120000000000", "4/20/2030", "Bob");
		CreditCard creditCard = CreditCardFactory.buildCreditCard(inputRecord, CardType.VISA);
		assertEquals(creditCard.getCardType(), CardType.VISA);
	}
}
