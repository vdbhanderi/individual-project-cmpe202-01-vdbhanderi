package edu.sjsu.project.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements FileParser {
	
	public String DELIMITER = ","; 
	
	public List<InputRecord> parseFile(String inputPath) {
		String line = "";
		List<InputRecord> recordList = new ArrayList<InputRecord>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(inputPath)));
			String header = br.readLine();
			if(header != null && header.trim().startsWith("cardNumber")) {
				while ((line = br.readLine()) != null) { 
					String[] tuple = line.split(DELIMITER);
					InputRecord record = new InputRecord(tuple[0].trim(), tuple[1].trim(), tuple[2].trim());
					FileParser.parseRecord(record);
					recordList.add(record);
				}
			} else {
				System.out.println("Error occurred while parsing");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found at specified path");
		} catch (IOException e) {
			System.out.println("Error occurred while parsing");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if(br!=null)
				try {
					br.close();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
		}
		return recordList;
	}
}
