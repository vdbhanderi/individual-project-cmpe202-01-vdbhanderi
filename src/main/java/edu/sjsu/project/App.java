package edu.sjsu.project;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.project.card.CreditCard;
import edu.sjsu.project.enums.CardType;
import edu.sjsu.project.factory.CreditCardFactory;
import edu.sjsu.project.factory.FileFactory;
import edu.sjsu.project.factory.FileFactoryProvider;
import edu.sjsu.project.parser.InputRecord;
import edu.sjsu.project.validator.CreditCardValidator;
import edu.sjsu.project.validator.ValidatorChain;

public class App 
{
    public static void main( String[] args )
    {
    	String inputPath;
    	String outputPath;
    	if(args.length == 2) {
    		inputPath = args[0];
    		outputPath = args[1];
    	} else {
    		System.out.println("Incorrect input arguments");
    		return;
    	}

    	FileFactory fileFactory = FileFactoryProvider.getFileFactory(inputPath);
    	if(fileFactory == null) {
    		System.out.println("Invalid file format");
    		return;
    	}
    	
    	List<InputRecord> inputRecords = fileFactory.getFileParser().parseFile(inputPath);
    	
    	CreditCardValidator validator = new ValidatorChain().getFirstValidator();
    	
    	List<CreditCard> creditCards = new ArrayList<CreditCard>();
    	for(InputRecord inputRecord : inputRecords) {
    		CardType cardType = validator.validate(inputRecord);
    		CreditCard creditCard = CreditCardFactory.buildCreditCard(inputRecord, cardType);
    		creditCards.add(creditCard);
    	}
    	
    	fileFactory.getFileGenerator().generateFile(creditCards, outputPath);
    }
}
