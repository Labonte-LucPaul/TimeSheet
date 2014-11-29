package core.db.sqlite.querybuilder;

import core.db.sqlite.field.Field;

public class ColumnTypeSetters {

	protected Field field;
	
	public void setField(String fieldName, String value) {
		this.field = new Field(fieldName, "'" + value + "'");
	}
	
	public void setField(String fieldName, int value) {
		this.field = new Field(fieldName, Integer.toString(value));
	}
	
	public void setField(String fieldName, double value) {
		this.field = new Field(fieldName, Double.toString(value));
	}
	
}
