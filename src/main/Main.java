package main;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// System.out.println("Hello JDBC");

		Connection conn = null;

		try {
			// Class.forName("com.mysql.jdbc.Driver"); // a utiliser avant JDBC 4

			// Driver se charge impliciment via l'instruction dans le fichier
			// java.sql.Driver
			// jdbc url : "jdbc:mysql://localhost:3306/isikabd2021","root",""
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/isikabd2021", "root", "");
			Statement stmt = conn.createStatement(); // Objet permettant d'accepter des requettes SQL
			/*
			Scanner sc = new Scanner(System.in);

			System.out.println("Donner un nom");
			String nom = sc.nextLine();

			System.out.println("Donner son email");
			String email = sc.nextLine();
			 */
			// int result = stmt.executeUpdate("insert into etudiant(nom,email)
			// values('"+nom+"', '"+email+"')");

			// 1-Une insertion
			// int result = stmt.executeUpdate("insert into etudiant(nom,email)
			// values('ali', 'mohamed.ali@gmail.com')");

			// 2-la suppression
			// int result = stmt.executeUpdate("delete from etudiant");

			// 3-la mise à jour
			// int result = stmt.executeUpdate("update etudiant set email='amine@gmail.com'
			// where id=3");
			// System.out.println("Insertion avec succès"); // 2

			// 4-Affichage

			
			/*
			ResultSet rs = stmt.executeQuery("select id, nom, email from etudiant");
			while (rs.next()) {
				int id = rs.getInt("id"); //rs.getInt(1);
				String name= rs.getString("nom");   //rs.getString(2);
				String mail= rs.getString("email");  // troisième colonne de type String  rs.getString(3)
				
				System.out.println("ID : "+id+ " Nom : "+name +" Email : "+mail);
			}
			*/
			
			//String sql ="select id, nom, email from etudiant";
			
			String sql = "insert into etudiant(nom,email) values('ab', 'ab@gmail.com')";
			boolean isResultSet = stmt.execute(sql);
			
			if (isResultSet==true) {
				ResultSet rs = stmt.getResultSet();  //getResultSet();
			   System.out.println("ran a Select query");
			   } 
			else {
				 int result = stmt.getUpdateCount();  //getUpdateCount();
			     System.out.println("ran an update on the database");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(conn);

	}

}
