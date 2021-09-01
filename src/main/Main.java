package main;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello JDBC");
		
		Connection conn=null;
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");  // a utiliser avant JDBC 4
			
			// Driver se charge impliciment via l'instruction dans le fichier java.sql.Driver
			// jdbc url : "jdbc:mysql://localhost:3306/isikabd2021","root",""
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/isikabd2021","root","");
			Statement stmt = conn.createStatement(); //Objet permettant d'accepter des requettes SQL
			
			
		
			
			// Une insertion
			//int result = stmt.executeUpdate("insert into etudiant(nom,email) values('ali', 'mohamed.ali@gmail.com')");
			int result = stmt.executeUpdate("delete from etudiant");
			System.out.println(result); // 2
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conn);

	}

}
