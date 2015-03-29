package core.utilities.converter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.json.JSONArray;

public class ResultSet2JSON {

	private ResultSet rs;
	private JSONArray jsonArray;
	
	public ResultSet2JSON(ResultSet rs) {
		this.rs = rs;
		this.jsonArray = new JSONArray();
		this.convert();
	}
	
	private void convert() {
		
		try {
			while(this.rs.next()) {
				int nbRows = this.rs.getMetaData().getColumnCount();
				JSONObject jsonObj = new JSONObject();
				for(int i = 0; i < nbRows; i++) {
					jsonObj.put(this.rs.getMetaData().getColumnLabel(i+1).toLowerCase(), this.rs.getObject(i + 1));
				}
				jsonArray.put(jsonObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public JSONArray getJSON() {
		return this.jsonArray;
	}
}
