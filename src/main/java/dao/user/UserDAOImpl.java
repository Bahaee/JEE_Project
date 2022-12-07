package dao.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;


//This DAO class provides CRUD database operations for the table users in the DB
public class UserDAOImpl implements IUserDAO{
	
	private String jdbcURL = "jdbc:mysql://localhost:3308/jee_db?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
//SQL Requests
	private static final String INSERT_USERS_SQL = "INSERT INTO users"
			+ "  (username, firstName, lastName, email, phone, age, gender, nationality, nationalityIdentity, functionality) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select idUser,username,firstName,lastName,email,phone,age,gender,nationality,nationalityIdentity,functionality from users where idUser =?;";
	private static final String SELECT_ALL_USERS = "select * from users;";
	private static final String DELETE_USERS_SQL = "delete from users where idUser = ?;";
	private static final String UPDATE_USERS_SQL = "update users set "
			+ "username = ?, firstName = ?, lastName = ?, email = ?, phone = ?, age = ?, gender = ?, nationality = ?, nationalityIdentity = ?, functionality = ? where idUser = ?;";

	public UserDAOImpl() {
	}
	
	//GetConnection Method allows us to apply a jdbc connection with the DataBase
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//Add Users
	public void addUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setDouble(5, user.getPhone());
			preparedStatement.setInt(6, user.getAge());
			preparedStatement.setString(7, user.getGender());
			preparedStatement.setString(8, user.getNationality());
			preparedStatement.setString(9, user.getNationalIdentity());
			preparedStatement.setString(10, user.getFunctionality());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	 //Fetch USER BY Id
	public User fetchUserById(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idUser = rs.getInt("idUser");
				String username = rs.getString("username");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				double phone = rs.getDouble("phone");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String nationality = rs.getString("nationality");
				String nationalityIdentity = rs.getString("nationalityIdentity");
				String functionality = rs.getString("functionality");
				user = new User(idUser, username, firstName, lastName, email, phone, age, gender, nationality, nationalityIdentity, functionality);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	//Fetch All Users
	public List<User> fetchAllUsers() {

		// using try-with-resources to avoid closing resources (boilerplate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idUser = rs.getInt("idUser");
				String username = rs.getString("username");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				double phone = rs.getDouble("phone");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String nationality = rs.getString("nationality");
				String nationalityIdentity = rs.getString("nationalityIdentity");
				String functionality = rs.getString("functionality");
				users.add(new User(idUser, username, firstName, lastName, email, phone, age, gender, nationality, nationalityIdentity, functionality));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//Update A user
	public User updateUser(User user) throws SQLException {
		//boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setDouble(5, user.getPhone());
			preparedStatement.setInt(6, user.getAge());
			preparedStatement.setString(7, user.getGender());
			preparedStatement.setString(8, user.getNationality());
			preparedStatement.setString(9, user.getNationalIdentity());
			preparedStatement.setString(10, user.getFunctionality());
			preparedStatement.setInt(11, user.getIdUser());
			//rowUpdated = preparedStatement.executeUpdate() > 0;
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		return user;
	}
	
	//Exception Function
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
