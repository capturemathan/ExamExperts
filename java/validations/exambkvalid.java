import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class exambkvalid{
  public static void main(String[] args) {
    String exambkXSD = "C:\\Users\\Hp\\Desktop\\My Projects\\ExamExperts\\xml\\xsd\\exambookmarks.xsd";
    String exambkXML = "C:\\Users\\Hp\\Desktop\\My Projects\\ExamExperts\\xml\\exambookmarks.xml";
    boolean isValid;
    
    isValid = validateXMLSchema(exambkXSD,exambkXML);
        if(isValid) {
          System.out.println("Exam Bookmarks - Valid");
        } else {
          System.out.println("Exam Bookmarks - Invalid");
        }
        
  }
  public static boolean validateXMLSchema(String XSD, String XML){
    try {
           SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
           Schema schema = factory.newSchema(new File(XSD));
           Validator validator = schema.newValidator();
           validator.validate(new StreamSource(new File(XML)));
        } catch (IOException err) {
           System.out.println("Exception: "+err.getMessage());
           return false;
        } catch(SAXException err) {
           System.out.println("SAX Exception: "+err.getMessage());
           return false;
        }
    return true;
  }
}