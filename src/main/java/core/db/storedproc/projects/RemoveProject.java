package core.db.storedproc.projects;

import java.sql.SQLException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import core.db.sqlite.ConnectSQLite3;
import core.db.sqlite.FilePath;
import core.db.sqlite.querybuilder.Delete;
import core.db.tables.Tables;

public class RemoveProject {

	private Delete delete;
	
	public RemoveProject(JSONObject json) {
		try {
			this.delete = new Delete(Tables.PROJECTS.toString(), "projectname = '" + json.getString("projectname")+ "'");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void executeQuery() {
		ConnectSQLite3 conn = new ConnectSQLite3(FilePath.DATABASE_SOURCE.toString());
		conn.connect();
		
		try {
			conn.executeUpdate(this.delete.toSQL());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
	}
}
