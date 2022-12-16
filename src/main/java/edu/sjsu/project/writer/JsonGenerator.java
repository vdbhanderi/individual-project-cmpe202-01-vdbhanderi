package edu.sjsu.project.writer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.sjsu.project.adapter.CreditCardAdapter;
import edu.sjsu.project.card.CreditCard;

public class JsonGenerator implements FileGenerator {
	
	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	public void generateFile(List<CreditCard> creditCards, String outputPath) {
		
		try {
			File outputFile = new File(outputPath);
			List<ObjectNode> jsonRecords = new ArrayList<ObjectNode>();
			for(CreditCard creditCard : creditCards) {
				ObjectNode jsonRecord = generateRecord(new CreditCardAdapter(creditCard));
				jsonRecords.add(jsonRecord);
			}
			mapper.writeValue(outputFile, jsonRecords);
			System.out.println("Output file generated successfully!");
		} catch (Exception e) {
			System.out.println("Error occurred while writing file");
		}
	}

	@Override
	public ObjectNode generateRecord(OutputRecord outputRecord) {
		ObjectNode jsonRecord = mapper.createObjectNode();
		Constants c = new Constants();
//		jsonRecord.put("cardNumber", new BigInteger(outputRecord.getCardNumber()));
		jsonRecord.put("cardNumber", outputRecord.getCardNumber());
		jsonRecord.put("cardType", c.getTypeOrError(outputRecord.getTypeOfCard()));
		return jsonRecord;
	}

}
