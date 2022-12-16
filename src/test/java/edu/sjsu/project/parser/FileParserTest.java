package edu.sjsu.project.parser;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class FileParserTest extends TestCase{
	
	@Test
	public void testParseFile() throws URISyntaxException {
		String csvPath = Paths.get(this.getClass().getResource("/resources/f1.csv").toURI()).toString();
		String xmlPath = Paths.get(this.getClass().getResource("/resources/f3.xml").toURI()).toString();
		String jsonPath = Paths.get(this.getClass().getResource("/resources/f2.json").toURI()).toString();
		
		List<InputRecord> csvRecords = new CsvParser().parseFile(csvPath);
		List<InputRecord> xmlRecords = new XmlParser().parseFile(xmlPath);
		List<InputRecord> jsonRecords = new JsonParser().parseFile(jsonPath);
		
		assertEquals(csvRecords.size(), 4);
		assertEquals(xmlRecords.size(), 4);
		assertEquals(jsonRecords.size(), 6);
	}
}
