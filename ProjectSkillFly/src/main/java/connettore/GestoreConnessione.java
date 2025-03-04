package connettore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GestoreConnessione {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private final String URLDB = "jdbc:mysql://localhost:3306/skill_fly";
	private final String USERDBMS = "root";
	private final String PASSWORDDBMS = "root"; 

	private Connection conn; 

	public Connection apriConnessione() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URLDB,USERDBMS,PASSWORDDBMS);
		} catch (ClassNotFoundException e) {
			//
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}

	private static GestoreConnessione instance;

	public static GestoreConnessione getInstance() {
		if(instance == null) {
			instance = new GestoreConnessione();
		}
		return instance;
	}

	private GestoreConnessione() {

	}

}