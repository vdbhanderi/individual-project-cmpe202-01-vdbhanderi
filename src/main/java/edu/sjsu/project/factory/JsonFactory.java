package edu.sjsu.project.factory;

import edu.sjsu.project.parser.FileParser;
import edu.sjsu.project.parser.JsonParser;
import edu.sjsu.project.writer.FileGenerator;
import edu.sjsu.project.writer.JsonGenerator;

public class JsonFactory implements FileFactory {

	public FileParser getFileParser() {
		return new JsonParser();
	}

	public FileGenerator getFileGenerator() {
		return new JsonGenerator();
	}

}
