package bd.edu.seu.ajlab1.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSingleton {
	private static ConnectionSingleton instance=new ConnectionSingleton();
	private static Connection connection;
	private ConnectionSingleton()  {
		connection=null;
		try {
			FileReader fileReader=new FileReader("db.properties");
			Properties properties=new Properties();
			properties.load(fileReader);
			final String USERNAME=properties.getProperty("username");
			final String PASSWORD=properties.getProperty("password");
			//final String DBNAME = properties.getProperty("dbname");
			//final String HOSTNAME = properties.getProperty("hostname");
			//final String URL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;\
			final String URL = properties.getProperty("url");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		
		return connection;
	}

}
