package core.db.sqlite;

import java.sql.*;

public class ConnectSQLite3 {
	
	private String dbURI = "";
	private Connection conn = null;
	private Statement stmt = null;
	private boolean isTransaction = false;
	
	public ConnectSQLite3(String dbURI) {
		this.dbURI = dbURI;
	}
	
	public void connect() {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + this.dbURI);
			stmt = conn.createStatement();

		} catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			closeConnection();
		}
	}

	/**
	 * For getting data: SELECT
	 * @param sqlStatement
	 * @return The number of rows affected by the query
	 * @throws Exception
	 */
	public ResultSet executeQuery(String sqlStatement) throws Exception {
		try {

			return this.stmt.executeQuery(sqlStatement);

		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection();
			throw new SQLException(this.getClass().getPackage().getName() + " executeQuery\n" + e.getMessage());
		}		
	}
	
	/**
	 * Query on: INSERT, UPDATE, DELETE
	 * @param sqlStatement
	 * @return 
	 * @throws SQLException
	 */
	public int executeUpdate(String sqlStatement) throws SQLException {
		
		try {
			if(isTransaction) {
				sqlStatement = "BEGIN TRANSACTION;" + sqlStatement + "END TRANSACTION;";
			}
			return this.stmt.executeUpdate(sqlStatement);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(this.getClass().getPackage().getName() + " executeQuery\n" + e.getMessage());
		}
	}
	
	public void setTranscaction() {
		this.isTransaction = true;
	}
	
	public void closeConnection() {
		try {
			if(!stmt.isClosed())
				stmt.close();
			if(!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
