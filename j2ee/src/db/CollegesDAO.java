package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import utils.CollegesUtil;

public class CollegesDAO{
	
		public static JSONArray clgJSON;
		public static JSONArray examJSON;
		public static JSONArray collegeJSON;

	public boolean validate(CollegesUtil collegesUtil) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("passed: "+collegesUtil.getuid());
		String universityid=collegesUtil.getuid(); 
		if(collegesUtil.getuid() != null && collegesUtil.getuid().length()!=0)
		{
			//System.out.println("passed:"+collegesUtil.getuid());
			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ncp?allowPublicKeyRetrieval=true&useSSL=false", "root", "pass");

					//Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection
							.prepareStatement("insert into universitybookmark values(?,?)")) {
				preparedStatement.setString(1, collegesUtil.getUsername());
				preparedStatement.setString(2, universityid);

				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// process sql exception
				printSQLException(e);
			}

		}

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/ncp?useSSL=false", "root", "password");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from university")) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			clgJSON = new JSONArray();
			
			while (rs.next()) {
				status=true;
                int numColumns = rsmd.getColumnCount();
                System.out.println(numColumns);
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = rsmd.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                clgJSON.add(obj);
            }
			System.out.println("COLLEGE JSON RESPONSE");
			System.out.println(clgJSON.toString());
			

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/ncp?useSSL=false", "root", "password");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from universitybookmark join university on universitybookmark.universityID=university.universityID and universitybookmark.email= ?")) {
			preparedStatement.setString(1, collegesUtil.getUsername());

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
				.getConnection("jdbc:mysql://localhost:3306/ncp?useSSL=false", "root", "password");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from exambookmark join exam on exambookmark.examID=exam.examID and exambookmark.email= ?")) {
			preparedStatement.setString(1, collegesUtil.getUsername());

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
