package initialconfig.createdb;

import initialconfig.createdb.create.CreateTableUsers;
import initialconfig.createdb.populate.PopulateTableUsers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import core.db.sqlite.ConnectSQLite3;
import core.db.sqlite.FilePath;
import core.db.tables.TabUsers;
import core.utilities.files.FileManager;

public class CreateAndPopulateTables {

	private Map<String, String[]> args;
	
	private ArrayList<String> SQLs;
	private ConnectSQLite3 conn;
	
	private CreateTableUsers users;
	
	private PopulateTableUsers populateUsers;
	
	public CreateAndPopulateTables(Map<String, String[]> args) {
		this.args = args;
		this.SQLs = new ArrayList<String>();
		this.users = new CreateTableUsers();
		
		populateUsers = new PopulateTableUsers();
	}
	
	public void execute() {
		populate();
		generateSQL();
		createFile();
		writeToDB();
	}

	private void populate() {
		populateUsers.populateFields(args.get("firstName")[0], args.get("lastName")[0], args.get("login")[0], args.get("email")[0]);
		populateUsers.addValue(TabUsers.PASSWD.toString(), args.get("passwd")[0]);
	}
	
	private void generateSQL() {
		addToList(users.create());
		addToList(populateUsers.getSQL());
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
			this.conn.setTranscaction();
			conn.connect();
			conn.executeUpdate(getSQL());
			conn.closeConnection();
		} catch (SQLException e) {
			System.out.println(getSQL());
			e.printStackTrace();
			conn.closeConnection();
		}
	}
	
	private String getSQL() {
		StringBuilder sql = new StringBuilder();
		for(String s : this.SQLs) {
			sql.append(s);
		}
		return sql.toString();
	}
}
