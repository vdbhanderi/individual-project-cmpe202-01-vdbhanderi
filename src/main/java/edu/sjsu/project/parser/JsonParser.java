package edu.sjsu.project.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser implements FileParser {

	public List<InputRecord> parseFile(String inputPath) {
		List<InputRecord> recordList = new ArrayList<InputRecord>();
		try {
			ObjectMapper om = new ObjectMapper();
			
			JsonNode node = om.readTree(new File(inputPath));
			JsonNode node1 = node.get("cards");
			Iterator<JsonNode> iterator = node1.elements();
			while(iterator.hasNext()) {
				JsonNode jsonRecord = iterator.next();
				String cardNumber = jsonRecord.get("cardNumber") != null ?jsonRecord.get("cardNumber").asText().trim() : "";
				String expirationDate = jsonRecord.get("expirationDate").asText().trim();
				String nameOfCardholder = jsonRecord.get("cardHolderName").asText().trim();
				InputRecord inputRecord = new InputRecord(cardNumber, expirationDate, nameOfCardholder);
				FileParser.parseRecord(inputRecord);
				recordList.add(inputRecord);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found at specified path");
		} catch (IOException e) {
			System.out.println("Error occurred while parsing");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return recordList;
	}
}
