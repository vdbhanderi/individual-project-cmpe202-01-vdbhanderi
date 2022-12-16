package edu.sjsu.project.factory;

import edu.sjsu.project.parser.FileParser;
import edu.sjsu.project.parser.XmlParser;
import edu.sjsu.project.writer.FileGenerator;
import edu.sjsu.project.writer.XmlGenerator;

public class XmlFactory implements FileFactory {

	public FileParser getFileParser() {
		return new XmlParser();
	}

	public FileGenerator getFileGenerator() {
		return new XmlGenerator();
	}

}
