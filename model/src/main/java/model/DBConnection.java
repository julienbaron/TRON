  package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1>The Class DBConnection allows to connect with Database .</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */

public class DBConnection {
	
	private static DBConnection	INSTANCE	= null;
	private Connection connection;
	
	 /**
     * Constructor.
     *         
     */
	private DBConnection() {
		this.open();
	}
	
	 /**
     * Gets the connection
     *@return DBConnection.INSTANCE
     *          
     */
	
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}
	
	 /**
     * Open the database.
     *@return true
     *          
     */
	
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	 /**
     * Gets the connection.
     *@return connection
     *          
     */
	
	public Connection getConnection() {
		return this.connection;
	}

}
