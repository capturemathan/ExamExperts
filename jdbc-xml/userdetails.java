import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class userdetails{
  public static void main(String args[]) {
    createPrettyXMLUsingDOM();
  }
  private static void createPrettyXMLUsingDOM()
  {
      try
      {
          Class.forName("com.mysql.cj.jdbc.Driver");  
          Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ncp","root","password");  
          Statement s=c.createStatement();  
          ResultSet rs=s.executeQuery("select * from login");
          DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
          Document doc = docBuilder.newDocument();
          Element rootElement = doc.createElement("users");
          doc.appendChild(rootElement);
          
          while(rs.next()){                
              Element student = doc.createElement("user");
              Element email = doc.createElement("email");
              email.setTextContent(rs.getString("email"));
              student.appendChild(email);
              Element name = doc.createElement("name");
              name.setTextContent(rs.getString("nam"));
              student.appendChild(name);
              Element password = doc.createElement("password");
              password.setTextContent(rs.getString("pwd"));
              student.appendChild(password);
              rootElement.appendChild(student);
          }
          
          // Write the content into XML file
          DOMSource source = new DOMSource(doc);
          StreamResult result = new StreamResult(new File("userdetails.xml"));
          TransformerFactory transformerFactory = TransformerFactory.newInstance();
          Transformer transformer = transformerFactory.newTransformer();
          // Beautify the format of the resulted XML
          transformer.setOutputProperty(OutputKeys.INDENT, "yes");
          transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
          transformer.transform(source, result);
      }
      catch(Exception ex)
      {
          ex.printStackTrace();
      }
  }
}
