package in.astro.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectApp {
	public static final String EXCEL_FILE = "select * from data.Student";

	public static void main(String[] args) {
		String url = "jdbc:Excel:///C:\\Users\\pande\\Documents\\excel data";
		try(Connection connection = DriverManager.getConnection(url)){
			try(PreparedStatement preparedStatement = connection.prepareStatement(EXCEL_FILE)){
					try(ResultSet resultSet = preparedStatement.executeQuery()){
						while(resultSet.next())
							System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
					}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
