package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import utils.ExamsUtil;

public class ExamsDAO{
  
    public static JSONArray examJSON;
    public static JSONArray collegeJSON;
    public static JSONArray exJSON;

  public boolean validate(ExamsUtil examsUtil) throws ClassNotFoundException {
    boolean status = false;

    Class.forName("com.mysql.cj.jdbc.Driver");
	String exid=examsUtil.geteid(); 
	System.out.println("replaced"+exid);
    if(examsUtil.geteid() != null && examsUtil.geteid().length()!=0)
	{
		//System.out.println("passed:"+collegesUtil.getuid());
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/ncp", "root", "myaumspassword");

				//Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into exambookmarks values(?,?)")) {
			preparedStatement.setString(1, examsUtil.getUsername());
			preparedStatement.setString(2, exid);

			System.out.println(preparedStatement);
			//String s=preparedStatement.toString();
			preparedStatement.executeUpdate();
//			//ResultSetMetaData rsmd = rs.getMetaData();
//			
//			
//			if (rs.next()) {
//				status=true;
//            }
			
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}}
    
    try (Connection connection = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/ncp?useSSL=false", "root", "myaumspassword");

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection
            .prepareStatement("select * from Exam")) {

      System.out.println(preparedStatement);
      ResultSet rs = preparedStatement.executeQuery();
      ResultSetMetaData rsmd = rs.getMetaData();
      
      exJSON = new JSONArray();
      
      while (rs.next()) {
        status=true;
                int numColumns = rsmd.getColumnCount();
                System.out.println(numColumns);
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                exJSON.add(obj);
            }
      System.out.println("EXAM JSON RESPONSE");
      System.out.println(exJSON.toString());
      

    } catch (SQLException e) {
      // process sql exception
      printSQLException(e);
    }
    try (Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/ncp?useSSL=false", "root", "myaumspassword");

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from univbookmarks join University on univbookmarks.universityID=University.UniversityID and univbookmarks.emailID= ?")) {
		preparedStatement.setString(1, examsUtil.getUsername());

		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		collegeJSON = new JSONArray();
		
		while (rs.next()) {
			status=true;
            int numColumns = rsmd.getColumnCount();
            System.out.println(numColumns);
            JSONObject obj = new JSONObject();
            for (int i = 1; i <= numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
            }
            collegeJSON.add(obj);
        }
		System.out.println("COLLEGE BOOKMARKS JSON RESPONSE");
		System.out.println(collegeJSON.toString());
		

	} catch (SQLException e) {
		// process sql exception
		printSQLException(e);
	}
	
	try (Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/ncp?useSSL=false", "root", "myaumspassword");

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from exambookmarks join Exam on exambookmarks.examID=Exam.ExamID and exambookmarks.emailID= ?")) {
		preparedStatement.setString(1, examsUtil.getUsername());

		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		examJSON = new JSONArray();
		
		while (rs.next()) {
			status=true;
            int numColumns = rsmd.getColumnCount();
            System.out.println(numColumns);
            JSONObject obj = new JSONObject();
            for (int i = 1; i <= numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
                System.out.println(rs.getObject(column_name));
            }
            examJSON.add(obj);
        }
		System.out.println("EXAM BOOKMARKS JSON RESPONSE");
		System.out.println(examJSON.toString());
		

	} catch (SQLException e) {
		// process sql exception
		printSQLException(e);
	}
   
    return status;
  }

  private void printSQLException(SQLException ex) {
    for (Throwable e : ex) {
      if (e instanceof SQLException) {
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + ((SQLException) e).getSQLState());
        System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
        System.err.println("Message: " + e.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
          System.out.println("Cause: " + t);
          t = t.getCause();
        }
      }
    }
  }
}