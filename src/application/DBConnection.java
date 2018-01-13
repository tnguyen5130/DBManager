package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection{
	
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
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,e);
		}
		return null;
	}
}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		TableColumn id = new TableColumn("StudentID");
//		id.setMinWidth(80);
//		id.setCellValueFactory(new PropertyValueFactory<Profile, String>("Profile"));
//		
//		TableColumn name = new TableColumn("Name");
//		name.setMinWidth(100);
//		name.setCellValueFactory(new PropertyValueFactory<Profile, String>("Name"));
//		
//		TableColumn proj = new TableColumn("Project");
//		proj.setMinWidth(100);
//		proj.setCellValueFactory(new PropertyValueFactory<Profile, String>("Project"));
//
//		table.getColumns().addAll(id,name,proj);
//		
//		while (true) {
//
//			try {
//				statement = connect.createStatement();
//				resultset = statement.executeQuery("SELECT * FROM ititiu16137.Profile;");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			try {
//	        	data.clear();
//				while (resultset.next()) {
//					 //Iterate Row
//
//					data.add(new Profile(resultset.getString(1), resultset.getString(2), resultset.getString(3)));
//				}
//				table.setItems(data);
//				//table.getColumns().setAll(idCol, nameCol);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
////		  try {
////				connect.close();
////			} catch (SQLException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//	}
 

