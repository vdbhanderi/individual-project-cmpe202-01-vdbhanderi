package edu.sjsu.project.parser;

import java.util.List;

public interface FileParser {
	List<InputRecord> parseFile(String inputPath);
	static void parseRecord(InputRecord inputRecord) throws Exception{
		
	}
}
