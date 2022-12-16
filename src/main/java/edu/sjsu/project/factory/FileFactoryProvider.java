package edu.sjsu.project.factory;

import edu.sjsu.project.enums.FileType;

public class FileFactoryProvider {
	
	public static FileFactory getFileFactory(String fileName) {
		fileName = fileName.toLowerCase();
		if(fileName.endsWith(FileType.json.toString())) {
			return new JsonFactory();
		} else if(fileName.endsWith(FileType.xml.toString())) {
			return new XmlFactory();
		} else if(fileName.endsWith(FileType.csv.toString())) {
			return new CsvFactory();
		}
		return null;
	}
}
