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

public class univbookmarks{
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
          ResultSet rs=s.executeQuery("Select * from universitybookmark,university where universitybookmark.universityID=university.universityID");
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
              Element univID = doc.createElement("UniversityID");
              univID.setTextContent(rs.getString("universityID"));
              childElement.appendChild(univID);
              Element univName = doc.createElement("University");
              univName.setTextContent(rs.getString("university"));
              childElement.appendChild(univName);
              Element univDesc = doc.createElement("Description");
              univDesc.setTextContent(rs.getString("univDescription"));
              childElement.appendChild(univDesc);
              Element url = doc.createElement("URL");
              url.setTextContent(rs.getString("siteURL"));
              childElement.appendChild(url);
              Element location = doc.createElement("Location");
              location.setTextContent(rs.getString("location"));
              childElement.appendChild(location);
              Element cutoff = doc.createElement("Cutoff");
              cutoff.setTextContent(rs.getString("expectedCutoff"));
              childElement.appendChild(cutoff);
              Element examID = doc.createElement("ExamID");
              examID.setTextContent(rs.getString("examID"));
              childElement.appendChild(examID);
              Element courseID = doc.createElement("CourseID");
              courseID.setTextContent(rs.getString("courseID"));
              childElement.appendChild(courseID);
              Element countryID = doc.createElement("CountryID");
              countryID.setTextContent(rs.getString("countryID"));
              childElement.appendChild(countryID);
              rootElement.appendChild(childElement);
          }
          
          // Write the content into XML file
          DOMSource source = new DOMSource(doc);
          StreamResult result = new StreamResult(new File("univbookmarks.xml"));
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
