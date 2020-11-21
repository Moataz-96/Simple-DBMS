package DBMS;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.XMLConstants;
//import javax.xml.bind.Validator;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent; import javax.xml.transform.Source;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
class StAXParserXml {

	public void WriteStAXParser() throws Exception{
		FileWriter file = new FileWriter("C:/Users/select1/Desktop/Project II/CreateStaxFile.xml");
		XMLOutputFactory factory = XMLOutputFactory.newInstance();	
		XMLStreamWriter streamWriter = factory.createXMLStreamWriter(file);
		
		streamWriter.writeStartDocument();
		
		streamWriter.writeStartElement("Database");
		
		streamWriter.writeStartElement("First Name");
		streamWriter.writeCharacters("Mickey");
		streamWriter.writeEndElement();
		
		streamWriter.writeStartElement("Last Name");
		streamWriter.writeCharacters("Mouse");
		streamWriter.writeEndElement();
		
		streamWriter.writeStartElement("Adress");
		streamWriter.writeCharacters("123 Fantasy Way");
		streamWriter.writeEndElement();
		
		streamWriter.writeStartElement("City");
		streamWriter.writeCharacters("Anaheim");
		streamWriter.writeEndElement();
		
		streamWriter.writeStartElement("Age");
		streamWriter.writeCharacters("73");
		streamWriter.writeEndElement();
		
		streamWriter.writeEndElement();
		streamWriter.writeEndDocument();
		
		streamWriter.flush();
		streamWriter.close();
		
		String xmlFile = file.toString();
		
		System.out.println(xmlFile);
		
		
		
	}
	
	
	
	public void ReaderStAXParser() throws Exception , ParserConfigurationException{
		FileReader file = new FileReader("D:/Java Programs/XMLExamples/Invoice/Invoice.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		//XMLStreamReader reader = factory.createXMLStreamReader(file);
		XMLEventReader eventReader = factory.createXMLEventReader(file);
	
		
	
			
			
		
		while(eventReader.hasNext()){
			XMLEvent event = eventReader.nextEvent();
			
		if ((event.getEventType() == XMLStreamConstants.START_DOCUMENT))
				System.out.print("Document has been Started : ENJOY!\n\n\n ");
				
		
		if ((event.getEventType() == XMLStreamConstants.START_ELEMENT)){
				if(event.asStartElement().getName().getLocalPart().equals("Database") )
				System.out.print(event.asStartElement().getName().getLocalPart()+ ":");
				System.out.print("  " + event.asStartElement().getName().getLocalPart()+ ":");
				
		}
		if ((event.getEventType() == XMLStreamConstants.CHARACTERS))
			System.out.print(event.asCharacters().getData() + "\n");

		
		if ((event.getEventType() == XMLStreamConstants.END_ELEMENT)){
			if(event.asEndElement().getName().getLocalPart().equals("Database") )
			System.out.print(event.asEndElement().getName().getLocalPart()+ ":");
			
		}
		if ((event.getEventType() == XMLStreamConstants.END_DOCUMENT)){
			
			System.out.print("\n\nDocument has been Finshed : Thank You !\n\n\n ");
			
	}	
		
		}
		
		 
		
	}
}


/*MY XML FILE{
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<RootElement> 

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





}

*/
//REFERENCE TUTORIAL

/*
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParserXml{
	public void ReaderStAXParser() {
      boolean bFirstName = false;
      boolean bLastName = false;
      boolean bNickName = false;
      boolean bMarks = false;
      try {
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(
            new FileReader("C:/Users/select1/Desktop/Project II/CreatedFile.xml"));

            while(eventReader.hasNext()){
               XMLEvent event = eventReader.nextEvent();
               switch(event.getEventType()){
                  case XMLStreamConstants.START_ELEMENT:
                     StartElement startElement = event.asStartElement();
                     String qName = startElement.getName().getLocalPart();
                     if (qName.equalsIgnoreCase("student")) {
                        System.out.println("Start Element : student");
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        String rollNo = attributes.next().getValue();
                        System.out.println("Roll No : " + rollNo);
                     } else if (qName.equalsIgnoreCase("firstname")) {
                        bFirstName = true;
                     } else if (qName.equalsIgnoreCase("lastname")) {
                        bLastName = true;
                     } else if (qName.equalsIgnoreCase("nickname")) {
                        bNickName = true;
                     }
                     else if (qName.equalsIgnoreCase("marks")) {
                        bMarks = true;
                     }				        
                     break;
                  case XMLStreamConstants.CHARACTERS:
                     Characters characters = event.asCharacters();
                     if(bFirstName){
                        System.out.println("First Name: " 
                        + characters.getData());
                        bFirstName = false;
                     }
                     if(bLastName){
                        System.out.println("Last Name: " 
                        + characters.getData());
                        bLastName = false;
                     }
                     if(bNickName){
                        System.out.println("Nick Name: " 
                        + characters.getData());
                        bNickName = false;
                     }
                     if(bMarks){
                        System.out.println("Marks: " 
                        + characters.getData());
                        bMarks = false;
                     }
                     break;
                  case  XMLStreamConstants.END_ELEMENT:
                     EndElement endElement = event.asEndElement();
                     if(endElement.getName().getLocalPart().equalsIgnoreCase("student")){
                        System.out.println("End Element : student");
                        System.out.println();
                     }
                     break;
               }		    
            }
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (XMLStreamException e) {
            e.printStackTrace();
      }
   }
}
*/