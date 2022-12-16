package edu.sjsu.project.writer;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.sjsu.project.adapter.CreditCardAdapter;
import edu.sjsu.project.card.CreditCard;


public class XmlGenerator implements FileGenerator {

	Document document;

	public void generateFile(List<CreditCard> creditCards, String outputPath) {
		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder xmlBuilder = documentFactory.newDocumentBuilder();

			document = xmlBuilder.newDocument();

			Element root = document.createElement("CARDS");
			document.appendChild(root);

			for (CreditCard creditCard : creditCards) {
				OutputRecord outputRecord = new CreditCardAdapter(creditCard);
				Element row = generateRecord(outputRecord);
				root.appendChild(row);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(outputPath));

			transformer.transform(domSource, streamResult);
			System.out.println("Output file generated successfully!");
		} catch (Exception e) {
			System.out.println("Error occurred while writing file");
		}
	}

	@Override
	public Element generateRecord(OutputRecord outputRecord) {
		if (document == null) {
			try {
				document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			} catch (ParserConfigurationException e) {
				System.out.println("Error while generating xml record");
			}
		}
		Element row = document.createElement("CARD");
		Element cardNumber = document.createElement("CARD_NUMBER");
		cardNumber.appendChild(document.createTextNode(outputRecord.getCardNumber()));
		row.appendChild(cardNumber);

		Element typeOfCard = document.createElement("CARD_TYPE");
		Constants c = new Constants();
		typeOfCard.appendChild(document.createTextNode(c.getTypeOrError(outputRecord.getTypeOfCard()) + ""));
		row.appendChild(typeOfCard);
			
		return row;
	}

}
