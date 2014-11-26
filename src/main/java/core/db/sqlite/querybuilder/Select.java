package core.db.sqlite.querybuilder;

import java.util.ArrayList;
import java.util.Iterator;

public class Select extends BuildSQLInstruction {

	private String tableName;
	private String condition;
	private ArrayList<String> columnName;
	
	public Select(String tableName) {
		this.tableName = tableName;
		this.condition = "";
		this.columnName = new ArrayList<String>();
	}
	
	public Select(String tableName, boolean selectAll) {
		this(tableName);
		
		if(selectAll) {
			this.columnName.add("*");
		}
	}
	
	public void addColumnName(String colName) {
		this.columnName.add(colName);
	}
	
	public void setCondition(String condition) {
		this.condition = " WHERE " + condition;
	}
	
	@Override
	public String toSQL() {
		StringBuilder sql = new StringBuilder();
		Iterator<String> it = this.columnName.iterator();
		
		sql.append("SELECT ");
		
		while(it.hasNext()) {
			sql.append(it.next());
			if(it.hasNext()) {
				sql.append(",");
			}
		}
		
		sql.append(" FROM ");
		sql.append(this.tableName);
		sql.append(this.condition);
		sql.append(";");
		
		return sql.toString();
	}
	
}
