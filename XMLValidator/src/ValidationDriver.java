import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class ValidationDriver {
	
	public static void main(String[] args) {
		boolean flag = true;
		try {
			validate("res/channel.xml", "res/channel.xsd");
		} catch (SAXException | IOException e) {
			flag = false;
			e.printStackTrace();
		}
		
		System.out.println("Xml file is valid: " + flag);
	}
	
	/**
	 * validate method
	 * 
	 * picking up a new schema with newSchema method, passing validationFile obj, calling newValidator on 
	 * that schema, calling validate method on the validator, passing in the xml file to be validated as StreamSource
	 * 
	 * */
	public static void validate(String xmlFile, String validationFile) throws SAXException, IOException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schemaFactory.newSchema(new File(validationFile)).newValidator().validate(new StreamSource(new File(xmlFile)));
	}
}
