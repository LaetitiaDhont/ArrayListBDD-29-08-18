
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class BDDToArrayList {

	public static void main(String[] args) {

		// Chargement

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/users";
			String user = "root";
			String pwd = "Artichaut07";

			// Connexion

			Connection cn = (Connection) DriverManager.getConnection(url, user, pwd);

			// Statement

			Statement st = (Statement) cn.createStatement();

			// Execution

			String sql = "SELECT * FROM personne";

			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			// Instance de mon ArrayList Personne
			
			ArrayList<Personne> listePersonne = new ArrayList<Personne>();
			
			while(result.next()) {
				
				Personne p = new Personne();
				
				// On récupère les valeurs à partir de ResultSet
				
				p.setNom(result.getString("nom"));
				p.setPrenom(result.getString("prenom"));
				p.setAge(result.getInt("age"));
				p.setEmail(result.getString("email"));
				p.setTelephone(result.getString("telephone"));

				
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
