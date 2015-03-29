package core.db.storedproc.projects;

import java.sql.ResultSet;

import org.json.JSONArray;

import core.db.sqlite.ConnectSQLite3;
import core.db.sqlite.FilePath;
import core.db.sqlite.querybuilder.Select;
import core.db.tables.Tables;
import core.utilities.converter.ResultSet2JSON;

public class SelectProjects {

	private Select select;
	private String sql;
	private JSONArray json;
	
	public SelectProjects() {
		this.select = new Select(Tables.PROJECTS.toString());
		select.addColumnName("*");
		this.sql = select.toSQL();
		this.executeQuery();
	}
	
	private void executeQuery() {
		ConnectSQLite3 conn = new ConnectSQLite3(FilePath.DATABASE_SOURCE.toString());
		conn.connect();
		try {
			ResultSet rs = conn.executeQuery(this.sql);
			ResultSet2JSON rs2j = new ResultSet2JSON(rs);
			this.json = rs2j.getJSON();

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			conn.closeConnection();
		}
	}
	
	public JSONArray getJSON() {
		return this.json;
	}
}
