package edu.sjsu.project.factory;

import edu.sjsu.project.parser.CsvParser;
import edu.sjsu.project.parser.FileParser;
import edu.sjsu.project.writer.CsvGenerator;
import edu.sjsu.project.writer.FileGenerator;

public class CsvFactory implements FileFactory {
	
	public FileParser getFileParser() {
		return new CsvParser();
	}

	public FileGenerator getFileGenerator() {
		return new CsvGenerator();
	}

}
