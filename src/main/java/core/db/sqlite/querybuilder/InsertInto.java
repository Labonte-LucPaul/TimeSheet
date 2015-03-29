package core.db.sqlite.querybuilder;

import java.util.ArrayList;
import java.util.Iterator;

import core.db.sqlite.field.Field;
public class InsertInto {

	private String tableName;
	private String condition;
	private ArrayList<Field> fields;

	public InsertInto(String tableName) {
		this.tableName = tableName;
		this.fields = new ArrayList<Field>();
		this.condition = "";
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void addText(String columnName, String text) {
		this.fields.add(new Field(columnName, "'" + text.replace("'", "''") + "'"));
	}

	public void addBLOB(String columnName, String blob) {
		this.fields.add(new Field(columnName, "'" + blob + "'"));
	}

	public void addInteger(String columnName, int number) {
		this.fields.add(new Field(columnName, Integer.toString(number)));
	}

	public void addReal(String columnName, double real) {
		this.fields.add(new Field(columnName, Double.toString(real)));
	}

	public String toSQL() {
		
		StringBuilder sqlColName = new StringBuilder();
		StringBuilder sqlValues= new StringBuilder();
		
		Iterator<Field> it = this.fields.iterator();

		sqlColName.append("INSERT INTO " + this.tableName + " (");
		sqlValues.append("VALUES (");
		
		while (it.hasNext()) {
			Field tmp = it.next();
			
			sqlColName.append(tmp.getFieldName());
			sqlValues.append(tmp.getFieldValue());
			
			if (it.hasNext()) {
				sqlColName.append(",");
				sqlValues.append(",");
			}
		}

		sqlColName.append(")");
		sqlValues.append(")");
		sqlValues.append(this.condition);
		sqlValues.append(";");
		
		sqlColName.append(sqlValues.toString());
		
		return sqlColName.toString();
	}

}
