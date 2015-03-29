package core.db.sqlite.querybuilder;

import java.util.ArrayList;
import java.util.Iterator;

import core.db.sqlite.field.Field;

public class Update {
	
	private String tableName;
	private String condition;
	private ArrayList<Field> columns;
	
	public Update(String tableName) {
		this.tableName = tableName;
		this.condition = "";
		this.columns = new ArrayList<Field>();
	}
	
	public void setCondition(String condition) {
		this.condition = " WHERE " + condition;
	}
	
	public void updateTEXT(String columnName, String newValue) {
		this.columns.add(new Field(columnName, "'" + newValue + "'"));
	}
	
	public void updateBLOB(String columnName, String newValue) {
		this.columns.add(new Field(columnName, "'" + newValue + "'"));
	}
	
	public void updateINTEGER(String columnName, int newValue) {
		this.columns.add(new Field(columnName, Integer.toString(newValue)));
	}
	
	public void updateREAL(String columnName, double newValue) {
		this.columns.add(new Field(columnName, Double.toString(newValue)));
	}

	public String toSQL() {
		StringBuilder sql = new StringBuilder();
		Iterator<Field> it = this.columns.iterator();
		
		sql.append("UPDATE ");
		sql.append(this.tableName);
		sql.append(" SET ");

		while(it.hasNext()) {
			Field tmp = it.next();
			sql.append(tmp.getFieldName());
			sql.append(" = ");
			sql.append(tmp.getFieldValue());
			if(it.hasNext()) {
				sql.append(",");
			}
		}
		
		sql.append(this.condition);
		sql.append(";");
		
		return sql.toString();
	}
}
