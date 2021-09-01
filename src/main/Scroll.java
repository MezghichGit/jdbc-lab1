package main;

import java.sql.*;

public class Scroll {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/isikabd2021", "root", "");

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select id from etudiant order by id");
			// rs.afterLast();
			System.out.println(rs.next()); // true
			// System.out.println(rs.previous()); // true
			System.out.println(rs.getInt("id")); //

			System.out.println(rs.relative(2));
			System.out.println(rs.getInt("id"));

			System.out.println(rs.relative(-1));
			System.out.println(rs.getInt("id"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/*if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();*/
			if (conn != null) {
				conn.close();
			}
		}

	}

}
