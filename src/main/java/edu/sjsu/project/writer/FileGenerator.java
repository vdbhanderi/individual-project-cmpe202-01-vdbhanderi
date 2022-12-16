package edu.sjsu.project.writer;

import java.util.List;

import edu.sjsu.project.card.CreditCard;

public interface FileGenerator {
	public void generateFile(List<CreditCard> creditCards, String outputPath);
	public Object generateRecord(OutputRecord outputRecord);
}
