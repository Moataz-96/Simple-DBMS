package DBMS;

import java.util.Scanner;


public class MainClass {


	@Deprecated
    public void showDeprecatedMessage(){
        System.out.println("This method is marked as deprecated");
    }

	
	 @SuppressWarnings("deprecation")
	public static void main(String[] args) {
		 
		 JDBConnection x=new JDBConnection();
		 x.CreateTable();
        DOMParser p = new DOMParser();
		  p.CreateXMLByDomParser();
	    p.ReadXMLByDomParser();
		
		  SaxParserClass SParser = new SaxParserClass();
		  SParser.SAXParserDemo();
		
		
		StAXParserXml StParser = new StAXParserXml();
		try {
			//StParser.WriteStAXParser();
			StParser.ReaderStAXParser();
			Validation v = new Validation();
			v.validate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not Validate");
		//	e.printStackTrace();
		}
	}
	
	 
	

}
