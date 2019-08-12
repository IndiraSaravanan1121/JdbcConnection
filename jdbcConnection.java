package JdbcConnection;

import java.sql.*;

/**
 * purpose:jdbc connection from eclipse to mssql server.
 */
public class jdbcConnection {
	public static void main(String[] args) throws Exception {
		
		// To register or load jdbc driver.
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		/**
		 * URL to establish the connection. ServerName:ATMECSINDT-083\\SQLEXPRESS.
		 * Database Name:Student Integratedsecurity:true which means it takes windows
		 * account credential.
		 */
		String connectionUrl = "jdbc:sqlserver://ATMECSINDT-083\\SQLEXPRESS;database=Student;integratedSecurity=true;";

		Connection con = DriverManager.getConnection(connectionUrl);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from Student");

		while (rs.next()) {
			int id = rs.getInt("Student_ID");
			String name = rs.getString("Student_Name");
			String dept = rs.getString("Student_Dept");

			System.out.println(id + " " + name + " " + dept);
		}
		rs.close();

	}

}
