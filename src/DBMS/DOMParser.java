package DBMS;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;

public class DOMParser {
	
	 
	public void CreateXMLByDomParser(){
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document Doc = dBuilder.newDocument();
			//hena msh ha5od dBuilder.parse(file) 3shan ana lsa h3ml wa7d gdid kda kda
			// hdef child lel Docuemnt nfso el hwa rootElement el 3onsr el kper bt3hom awl tag kpir
			
			Element rootElement = Doc.createElement("Company");
			Doc.appendChild(rootElement);
			
			//hdef childs belnsba lel company fa h3ml childs rootelemt
			//add child element to upper element (el hwa company)
			//lw kan 3ndy element esmo esmo employee gwa el compnay lw 3ayz a3ml 7aga gwa employeehktb employee.appendChild(salary);
		
			Element firstname = Doc.createElement("firstname");
			firstname.appendChild(Doc.createTextNode("Mu3taz"));
			rootElement.appendChild(firstname);
			
			
			Element lastname = Doc.createElement("lastname");
			lastname.appendChild(Doc.createTextNode("Mansour"));
			rootElement.appendChild(lastname);
			
			Element nickname = Doc.createElement("nickname");
			nickname.appendChild(Doc.createTextNode("Pixo"));
			rootElement.appendChild(nickname);
			
			Element salary = Doc.createElement("salary");
			salary.appendChild(Doc.createTextNode("5000000"));
			rootElement.appendChild(salary);
			
			// now we create xml file as a Dom Parser
			
			 
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer tr = tFactory.newTransformer();
			DOMSource source = new DOMSource(Doc);
			File file = new File("C:/Users/select1/Desktop/Project II/CreatedFile.xml");
			StreamResult result = new StreamResult(file);
			tr.transform(source, result);
			System.out.println("File has been Created");
			
			
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();	
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	/*
	 packages to Import for CreateXMLByDomParsre same for ReadByDomParser but we add some packages here
	 	import javax.xml.transform.Transformer;
		import javax.xml.transform.TransformerException;
		import javax.xml.transform.TransformerFactory;
		import javax.xml.transform.dom.DOMSource;
		import javax.xml.transform.stream.StreamResult;

	 */
	}
	
	
	public void ReadXMLByDomParser(){
	
	
	 try {
		 File file = new File("C:/Users/select1/Desktop/Project II/CreatedFile.xml");
		
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();	//create Factory Dom Parser
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();					//create Builder of Dom Parser
		 Document Doc = dBuilder.parse(file);		//Create Docuemnt to connect with it
		// Element rootElement = Doc.getDocumentElement();				//get root Elements
		 Doc.getDocumentElement().normalize();
		 // for reading child elements of xml file we need nodelist (its like arrayslist but it read nodes of xml)
		 
		 NodeList nodes = Doc.getElementsByTagName("Company");  // hena el document feh node w7da
		 
		 System.out.println("----------------------");
            
		 for(int i = 0 ; i < nodes.getLength(); i ++){
			Node node = nodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) node;
				
				//System.out.println("Staff id : " + element.getAttribute("id"));
				System.out.println("First Name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Nick Name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("Salary : " + element.getElementsByTagName("salary").item(0).getTextContent());
				
			}
		
		 }
		 
		 
		 
		 
		/* Packages To Import For Dom Parser Reader
		 
		    import javax.xml.parsers.DocumentBuilderFactory;
			import javax.xml.parsers.DocumentBuilder;
			import javax.xml.parsers.ParserConfigurationException;
			
			import org.w3c.dom.Attr;
			import org.w3c.dom.Document;
			import org.w3c.dom.NodeList;
			import org.w3c.dom.Node;
			import org.w3c.dom.Element;
			import org.xml.sax.SAXException;
			
			import java.io.File;
			import java.io.FileInputStream; 
			import java.io.FileNotFoundException;
			import java.io.IOException;
		 
		 
		 */
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();	
		}}
}
