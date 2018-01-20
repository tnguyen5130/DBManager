package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

	public Connection connectDB() {
		/// Driver
		try {
			String url = "jdbc:mysql://db.hcmiuiot.club/ititiu16137";
			String username = "ititiu16137";
			String password = "Trung@1998";

			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url, username, password);
			return connect;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
}
