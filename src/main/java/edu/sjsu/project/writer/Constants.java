package edu.sjsu.project.writer;

public class Constants {
     public static final String NONNUMERIC = "Invalid: non numeric characters";
     public static final String GREATERTHAN19 ="Invalid: more than 19 digits";
     public static final String NULLENTRY = "Invalid: empty/null card number";
     public static final String UNKNOWN = "Invalid: Not a possible card number";
     public static final String DISCOVER = "Discover";
     public static final String MASTER = "Master Card";
     public static final String VISA = "Visa";
     public static final String AMEX = "AmericanExpress";
     
     public String getTypeOrError(String cardType) {
    	 String output = null;
    	 if(cardType == "VISA") {
    		 return VISA;
    	 }
    	 else if(cardType == "NULLENTRY") {
    		 return NULLENTRY;
    	 }
    	 else if(cardType == "UNKNOWN") {
    		 return UNKNOWN;
    	 }
    	 else if(cardType == "DISCOVER") {
    		 return DISCOVER;
    	 }
    	 else if(cardType == "MASTER") {
    		 return MASTER;
    	 }
    	 else if(cardType == "AMEX") {
    		 return AMEX;
    	 }
    	 else if(cardType == "GREATERTHAN19") {
    		 return GREATERTHAN19;
    	 }
    	 else if(cardType == "NONNUMERIC") {
    		 return NONNUMERIC;
    	 }
    	 return output;
     }
}
