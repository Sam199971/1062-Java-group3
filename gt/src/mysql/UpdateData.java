package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/mydb?" + "user=root&password=0000&serverTimezone=UTC&useSSL=false");

			
			
			
			/*PreparedStatement stmt = conn.prepareStatement("UPDATE user_table SET  user_name= ? ,user_score= ? WHERE  user_id= ?;");
			stmt.setString(1, "root");
			stmt.setInt(2, 2);
			stmt.setInt(3, 1);
			stmt.executeUpdate();*/
			
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO user_table (user_id, user_name,user_score) VALUES (?,?,?);");
			stmt.setInt(1, 4);
			stmt.setString(2, "xx");
			stmt.setInt(3, 10);
			stmt.executeUpdate();

			ResultSet rs = stmt.executeQuery("select s.user_id, user_name, user_score"
					+ " from user_table s");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) );
			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
}