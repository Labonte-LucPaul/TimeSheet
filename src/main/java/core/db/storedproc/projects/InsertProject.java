package core.db.storedproc.projects;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import core.db.sqlite.ConnectSQLite3;
import core.db.sqlite.FilePath;
import core.db.sqlite.querybuilder.InsertInto;
import core.db.tables.TabProjects;
import core.db.tables.Tables;

public class InsertProject {

	private InsertInto insert;
	
	public InsertProject(JSONObject json) {	
		insert = new InsertInto(Tables.PROJECTS.toString());
		insert(json);
	}
	
	private void insert(JSONObject jobj) {
		try {
			this.insert.addText(TabProjects.NAME.toString(), jobj.getString("projectname"));
			this.insert.addText(TabProjects.DESCRIPTION.toString(), jobj.getString("description"));
			this.insert.addReal(TabProjects.WEEKLEY_TIME.toString(), Double.parseDouble(jobj.getString("time")));		
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void executeQuery() {
		ConnectSQLite3 conn = new ConnectSQLite3(FilePath.DATABASE_SOURCE.toString());
		conn.connect();
		
		try {
			conn.executeUpdate(this.insert.toSQL());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.closeConnection();
		}
	}
}
