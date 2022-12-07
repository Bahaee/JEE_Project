package dao.user;

import java.sql.SQLException;
import java.util.List;

import bean.User;

public interface IUserDAO {

	public void addUser(User user) throws SQLException;
	public User fetchUserById(int id);
	public List<User> fetchAllUsers();
	public boolean deleteUser(int id) throws SQLException;
	public User updateUser(User user) throws SQLException;
}
