package DBMS;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


// SAXParser for reading only 
/*
 * lazmm ykon gwa elfile element wa7d(root) w gwah b2a kaza element b kaza child elemen
 * y3ne msln lw 3ayz a2ra 2 company hena msh hynf3 lazm a7othom kolohm gwa wa7d element kper msln esmo ay 7aga
 * example xml file 
 * 
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
<RootElement> // lazm ykon kolohm m7toten gwa 7aga w7da bs w tsmeha ay 7aga msln hena rootelement aw lw 3ndk company w7da 7otha mkan el root element

    <Company>
			<firstname>Mu3taz</firstname>
			<lastname>Mansour</lastname>
			<nickname>Pixo</nickname>
			<salary>5000000</salary>
   </Company>
   
    <Company>
			<firstname>Mu3taz</firstname>
			<lastname>Mansour</lastname>
			<nickname>Pixo</nickname>
			<salary>5000000</salary>
    </Company>
</RootElement>
 * 
 */
public class SaxParserClass {
	
	public void SAXParserDemo(){
		
		try{
		File file = new File("D:/Java Programs/XMLExamples/Invoice/Invoice.xml");
	
		SAXParserFactory spFactory = SAXParserFactory.newInstance();
		SAXParser saxParse = spFactory.newSAXParser();

		
		DefaultHandler DefaultHand = new DefaultHandler(){
			
			 private boolean firstname = false;
			 private boolean lastname = false;
			 private boolean nickname = false;
			 private boolean salary = false;
			
			 //startElement btsht3'l awl my2ra el 7rf dh ( < ) w tefdl sh3'ala l7d mt2apl el 7rf dh ( > )
			 @Override 
			 public void startElement(String uri,String localName,String qName,Attributes attr) throws SAXException{
				 
				 qName = qName.toLowerCase();
				 if(qName.equalsIgnoreCase("company"))
					 System.out.println("First Employee");
				 switch(qName){
					 case "firstname":
						 firstname = true;
						 	break;
					 case "lastname":
						 lastname = true;
						 	break;
					 case "nickname":
						 nickname = true;
						 	break;	 	
					 case "salary":
						 salary = true;
						 	break;
				 }
			 }
			 //start document btsht3'l awl ma el xml file ybd2 
			 @Override
			 public void startDocument() throws SAXException{
				 System.out.println("Document Has been Started !! ");
			 }
			//end document btsht3'l abl ma el xml file y5ls
			 @Override
			 public void endDocument() throws SAXException{
				 System.out.println("Document Has been Finshed !!");
			 }
			 
			 //endElement btsht3'l awl ma ma tshof el 7rf dh ( </ ) w bt5ls awl mtshof el 7rf dh ( > )
			 @Override
			 public void endElement(String uri , String localName, String qName ) throws SAXException{
				 
				 qName = qName.toLowerCase();
				 if(qName.equalsIgnoreCase("company"))
					 
					 System.out.println("Company ended");
				 }
				 
		
			 /*
			
			@Override
			public void characters(char ch[] , int start , int length) throws SAXException{
				
				if(firstname){
					System.out.println("first Name is : " + new String(ch,start,length));
					firstname = false;
				}
				else if(lastname){
					System.out.println("last Name is : " + new String(ch,start,length));
					lastname = false;
				}
				else if(nickname){
					System.out.println("Nick Name is : " + new String(ch,start,length));
					nickname = false;
				}
				else if(salary){
					System.out.println("Salary Name is : " + new String(ch,start,length));
					salary = false;
				}
			}
			 */
			 
			 //characters btfdl sh3'ala fe ay w2t 3'er el fato dol y3ne  lw mfesh odmha < aw > aw / aw ay 7aga
			 @Override
				public void characters(char ch[] , int start , int length) throws SAXException{

						System.out.println(new String(ch,start,length));
					
				}
		};
		
		saxParse.parse(file, DefaultHand);
		}
		catch(Exception se){
			se.printStackTrace();
		}
	}
	

}
