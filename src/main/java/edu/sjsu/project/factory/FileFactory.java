package edu.sjsu.project.factory;

import edu.sjsu.project.parser.FileParser;
import edu.sjsu.project.writer.FileGenerator;

public interface FileFactory {
	public FileParser getFileParser();
	public FileGenerator getFileGenerator();
}
