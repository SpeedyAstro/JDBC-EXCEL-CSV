package in.astro.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertApp {
	public static final String CSV_FILE = "insert into data.csv values (?,?,?)";

	public static void main(String[] args) {
		String url = "jdbc:Text:///C:\\Users\\pande\\Documents\\excel data";
		try(Connection connection = DriverManager.getConnection(url)){
			try(PreparedStatement preparedStatement = connection.prepareStatement(CSV_FILE)){
					preparedStatement.setInt(1, 10);
					preparedStatement.setString(2, "rabbit");
					preparedStatement.setString(3, "forest");
					int count = preparedStatement.executeUpdate();
					if (count==0) {
						System.out.println("Query failed !!");
					}else {
						System.out.println("Query inserted successfully");
					}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
