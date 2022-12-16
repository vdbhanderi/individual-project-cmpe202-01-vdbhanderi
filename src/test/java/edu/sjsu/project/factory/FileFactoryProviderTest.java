package edu.sjsu.project.factory;

import org.junit.Test;

import junit.framework.TestCase;

public class FileFactoryProviderTest extends TestCase{
	
	@Test
	public void testGetFileFactory() {
		String jsonFilePath = "f1.json";
		String xmlFilePath = "f2.xml";
		String csvFilePath = "f3.csv";
		String txtFilePath = "f4.txt";
		assertTrue(FileFactoryProvider.getFileFactory(jsonFilePath) instanceof JsonFactory);
		assertTrue(FileFactoryProvider.getFileFactory(xmlFilePath) instanceof XmlFactory);
		assertTrue(FileFactoryProvider.getFileFactory(csvFilePath) instanceof CsvFactory);
		assertNull(FileFactoryProvider.getFileFactory(txtFilePath));
	}
}
