package edu.sjsu.project.writer;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

import edu.sjsu.project.adapter.CreditCardAdapter;
import edu.sjsu.project.card.CreditCard;

public class CsvGenerator implements FileGenerator {
	
	public static String[] HEADERS = {"cardNumber", "cardType"};
	public static String DELIMITER = ",";
    
	public void generateFile(List<CreditCard> creditCards, String outputPath) {
		File outputFile = new File(outputPath);
		try (PrintWriter fileWriter = new PrintWriter(outputFile)){
			String header = String.join(DELIMITER, HEADERS[0], HEADERS[1]);
			fileWriter.println(header);
			for(CreditCard creditCard : creditCards) {
				String outputRecord = generateRecord(new CreditCardAdapter(creditCard));
				fileWriter.println(outputRecord);
			}
			System.out.println("Output file generated successfully!");
		} catch (IOException e) {
			System.out.println("Error occurred while writing file");
		}
	}

	@Override
	public String generateRecord(OutputRecord outputRecord) {
		Constants c = new Constants();
		return String.join(DELIMITER, outputRecord.getCardNumber(), c.getTypeOrError(outputRecord.getTypeOfCard()));
	}

}
