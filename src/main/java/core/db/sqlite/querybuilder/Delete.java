package core.db.sqlite.querybuilder;

public class Delete {
	
	private String tableName;
	private String condition;
	
	public Delete(String tableName, String condition) {
		this.tableName = tableName;
		this.condition = " WHERE " + condition;
	}
	
	public String toSQL() {
		return ("DELETE FROM " + (this.tableName + (this.condition + ";")));
	}
}
