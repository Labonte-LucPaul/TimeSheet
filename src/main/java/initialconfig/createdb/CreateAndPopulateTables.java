package initialconfig.createdb;

import java.sql.SQLException;
import java.util.ArrayList;

import core.db.sqlite.ConnectSQLite3;
import core.db.sqlite.FilePath;
import core.utilities.files.FileManager;

public class CreateAndPopulateTables {

	private ArrayList<String> SQLs;
	private ConnectSQLite3 conn;
	
	private CreateTableUsers users;
	
	
	public CreateAndPopulateTables() {
		this.SQLs = new ArrayList<String>();
		this.users = new CreateTableUsers();
	}
	
	public void execute() {
		generateSQL();
		createFile();
		writeToDB();
	}
	
	private void generateSQL() {
		addToList(users.create());
	}
	
	private void addToList(String sql) {
		this.SQLs.add(sql);
	}
	
	private void createFile() {
		FileManager fm = new FileManager(FilePath.DATABASE_SOURCE.toString());
		fm.writeFile("");
	}
	
	private void writeToDB() {
		try {
			this.conn = new ConnectSQLite3(FilePath.DATABASE_SOURCE.toString());
			conn.connect();
			conn.executeUpdate(users.getSQL());
			conn.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.closeConnection();
		}
	}
}
