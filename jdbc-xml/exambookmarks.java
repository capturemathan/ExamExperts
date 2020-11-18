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

public class exambookmarks{
  public static void main(String args[]) {
    createPrettyXMLUsingDOM();
  }
  private static void createPrettyXMLUsingDOM()
  {
      try
      {
          Class.forName("com.mysql.cj.jdbc.Driver");  
          Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ncp","root","pass");  
          Statement s=c.createStatement();  
          ResultSet rs=s.executeQuery("Select * from exambookmark,exam where exambookmark.examID=exam.examID");
          DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
          Document doc = docBuilder.newDocument();
          Element rootElement = doc.createElement("Bookmarks");
          doc.appendChild(rootElement);
          
          while(rs.next()){                
              Element childElement = doc.createElement("Bookmark");
              Element email = doc.createElement("Email");
              email.setTextContent(rs.getString("email"));
              childElement.appendChild(email);
              Element examID = doc.createElement("ExamID");
              examID.setTextContent(rs.getString("examID"));
              childElement.appendChild(examID);
              Element examName = doc.createElement("ExamName");
              examName.setTextContent(rs.getString("exam"));
              childElement.appendChild(examName);
              Element examDesc = doc.createElement("Description");
              examDesc.setTextContent(rs.getString("examDescription"));
              childElement.appendChild(examDesc);
              Element totalMarks = doc.createElement("Totalmarks");
              totalMarks.setTextContent(rs.getString("totalMarks"));
              childElement.appendChild(totalMarks);
              
              
              rootElement.appendChild(childElement);
          }
          
          // Write the content into XML file
          DOMSource source = new DOMSource(doc);
          StreamResult result = new StreamResult(new File("exambookmarks.xml"));
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
