package club.hcmiuiot.sandbox.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	private static Connection connect;
	private static Statement statement;
	private static ResultSet resultset;
	
	public static void connectDB() throws Exception{
		try {
			///Driver
			Class.forName("com.mysql.jdbc.Driver");
			///Setup connection
			connect = (Connection) DriverManager
					.getConnection("jdbc://db.hcmiuiot.club/ititiu16137?"
					+"user=ititiu16137&password=Trung@1998");
			
			statement = connect.createStatement();
		}catch (Exception e) {
			throw e;
		}finally {}
	  }
		private static void writeResultSet(ResultSet resultSet) throws SQLException {
	        // ResultSet is initially before the first data set
	        while (resultSet.next()) {
	            // It is possible to get the columns via name
	            // also possible to get the columns via the column number
	            // which starts at 1
	            // e.g. resultSet.getSTring(2);
	            String tenMember = resultSet.getString("TenMember");
	            String tenProject = resultSet.getString("TenProject");

	            System.out.println("TenMember: " + tenMember + "| TenProject: " + tenProject);
	        }
	    }
		
		public static void print2Table() throws Exception {
			resultset.first();
			for (int i=0; i<resultset.getRow(); i++) {
				//resultSet.absolute(i);

				for(int k=0; k<2; k++) {
					jTable.setValueAt(resultset.getString(k+1), i, k);
				}
				resultset.next();
			}
		}
		
		 public static void close() {
		        try {
		            if (resultset != null) {
		                resultset.close();
		            }

		            if (statement != null) {
		                statement.close();
		            }

		            if (connect != null) {
		                connect.close();
		            }
		        } catch (Exception e) {

		        }
	}
}
