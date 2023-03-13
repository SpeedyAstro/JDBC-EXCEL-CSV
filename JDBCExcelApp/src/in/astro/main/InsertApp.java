package in.astro.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertApp {
	public static final String EXCEL_FILE = "insert into data.Student values (?,?,?)";

	public static void main(String[] args) {
		String url = "jdbc:Excel:///C:\\Users\\pande\\Documents\\excel data";
		try(Connection connection = DriverManager.getConnection(url)){
			try(PreparedStatement preparedStatement = connection.prepareStatement(EXCEL_FILE)){
					preparedStatement.setInt(1, 10);
					preparedStatement.setString(2, "kamlesh");
					preparedStatement.setString(3, "DLH");
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
