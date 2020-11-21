package DBMS;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.lang.NullPointerException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class Validation {
	
	public void validate() throws FileNotFoundException{
	try {
		
		  SAXParserFactory factory = SAXParserFactory.newInstance();
		  factory.setNamespaceAware( true);
		  factory.setValidating( true);
		  SAXParser Parse = factory.newSAXParser();

		  XMLReader reader = Parse.getXMLReader();
		  reader.setEntityResolver(new DTDEntityResolver( "D:/Java Programs/XMLExamples/Invoice/Invoice.dtd"));
		  
		  reader.parse( new InputSource( "D:/Java Programs/XMLExamples/Invoice/Invoice.xml"));
	
		} catch ( ParserConfigurationException e) {
		
		 e.printStackTrace();
		} catch ( SAXException e) {
			
			 e.printStackTrace();
		} catch ( IOException e) {
			 
			 e.printStackTrace();	
		}
	
	}}
@SuppressWarnings("unchecked")
class DTDEntityResolver implements EntityResolver {
	  private String newSystemId = null;
	  boolean firstPass = true;

	  public DTDEntityResolver( String systemId) {
	    this.newSystemId = systemId;
	  }

	  public InputSource resolveEntity( String publicId, String systemId) throws SAXException, IOException {
	    InputSource result = null;
	    
	    if ( firstPass) {
	    result = new InputSource( newSystemId);
	    	
	    } else {
	      result = new InputSource( systemId);
	    }
	    
	    firstPass = false;
	 //   String n = result.toString();
	    return result;
	  }
	}	
