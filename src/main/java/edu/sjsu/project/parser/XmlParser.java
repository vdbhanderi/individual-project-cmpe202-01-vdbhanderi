package edu.sjsu.project.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser implements FileParser {

	public List<InputRecord> parseFile(String inputPath) {
		List<InputRecord> recordList = new ArrayList<InputRecord>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(new File(inputPath));
		    doc.getDocumentElement().normalize();
		    NodeList nList = doc.getElementsByTagName("CARD");
		    for (int temp = 0; temp < nList.getLength(); temp++) {
		    	Node nNode = nList.item(temp);
		    	Element eElement = (Element) nNode;
				String cardNumber = eElement.getElementsByTagName("CARD_NUMBER").item(0).getTextContent().trim();
				String expirationDate = eElement.getElementsByTagName("EXPIRATION_DATE").item(0).getTextContent().trim();
				String nameOfCardholder = eElement.getElementsByTagName("CARD_HOLDER_NAME").item(0).getTextContent().trim();
				InputRecord inputRecord = new InputRecord(cardNumber, expirationDate, nameOfCardholder);
				FileParser.parseRecord(inputRecord);
				recordList.add(inputRecord);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found at specified path");
		} catch (IOException e) {
			System.out.println("Error occurred while parsing");
		} catch (ParserConfigurationException e) {
			System.out.println("Error occurred while parsing");
		} catch (SAXException e) {
			System.out.println("Error occurred while parsing");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return recordList;
	}

}
