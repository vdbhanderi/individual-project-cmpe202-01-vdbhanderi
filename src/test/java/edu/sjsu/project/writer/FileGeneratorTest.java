package edu.sjsu.project.writer;
import org.junit.Test;
import org.w3c.dom.Element;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.sjsu.project.adapter.CreditCardAdapter;
import edu.sjsu.project.card.CreditCard;
import edu.sjsu.project.card.Master;
import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.writer.CsvGenerator;
import edu.sjsu.project.writer.JsonGenerator;
import edu.sjsu.project.writer.OutputRecord;
import edu.sjsu.project.writer.XmlGenerator;
import junit.framework.TestCase;

public class FileGeneratorTest extends TestCase{	
	
	@Test
	public void testGenerateRecord() {
		CreditCard creditCard = new Master();
		creditCard.setCardNumber("5410000000000000");
		creditCard.setCardType(CardType.MASTER);
		creditCard.setExpirationDate("3/20/2030");
		creditCard.setNameOfCardholder("Alice");
		OutputRecord outputRecord = new CreditCardAdapter(creditCard);
		
		String csvRecord = new CsvGenerator().generateRecord(outputRecord);
		assertEquals("5410000000000000,MASTER", csvRecord);
		
		Element xmlRecord = new XmlGenerator().generateRecord(outputRecord);
		assertEquals(outputRecord.getCardNumber(), xmlRecord.getElementsByTagName("CARD_NUMBER").item(0).getTextContent());
		assertEquals(outputRecord.getTypeOfCard(), xmlRecord.getElementsByTagName("CARD_TYPE").item(0).getTextContent());
		
		
		ObjectNode jsonRecord = new JsonGenerator().generateRecord(outputRecord);
		assertEquals(Long.parseLong(outputRecord.getCardNumber()), jsonRecord.get("cardNumber").asLong());
		assertEquals(outputRecord.getTypeOfCard(), jsonRecord.get("TypeOfCard").asText());
	}
}
