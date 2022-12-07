/*package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/jee_db?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	//GetConnection Method allows us to apply a jdbc connection with the DataBase
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}*/
