package core.db.sqlite.querybuilder;

import java.util.ArrayList;
import java.util.Iterator;

import core.db.sqlite.field.CreatingField;
import core.db.sqlite.field.FieldType;

public class CreateTable {

	private String tableName = "";
	private String primaryKey = "";
	private ArrayList<CreatingField> fields;
	
	public CreateTable(String tableName) {
		this.tableName = tableName;
		this.fields = new ArrayList<CreatingField>();
	}
	
	protected ArrayList<CreatingField> getFields() {
		return this.fields;
	}
	
	public void setPrimaryKey(String pkey) {
		this.primaryKey = pkey;
	}

	public void addIntegerField(String fieldName, int defaultValue, boolean allowNULL) {
		this.addField(new CreatingField(fieldName, Integer.toString(defaultValue), FieldType.INT, allowNULL));
	}
	
	public void addTextField(String fieldName, String defaultValue, boolean allowNULL) {
		this.addField(new CreatingField(fieldName, defaultValue, FieldType.TEXT, allowNULL));
	}
	
	public void addBLOBField(String fieldName, String defaultValue, boolean allowNULL) {
		this.addField(new CreatingField(fieldName, defaultValue, FieldType.BLOB, allowNULL));
	}
	
	public void addRealField(String fieldName, double defaultValue, boolean allowNULL) {
		this.addField(new CreatingField(fieldName, Double.toString(defaultValue), FieldType.REAL, allowNULL));
	}
	
	private void addField(CreatingField cf) {
		this.fields.add(cf);
	}

	public String toSQL() {
		
		StringBuilder sql = new StringBuilder();
		Iterator<CreatingField> it = this.fields.iterator();

		sql.append("CREATE TABLE " + this.tableName + " ");
		sql.append("(");
		sql.append(getSQLPrimaryKey());
		
		while(it.hasNext()) {
			sql.append(buildFieldsSQL(it.next()));
			if(it.hasNext()) {
				sql.append(",");
			}
		}
		
		sql.append(");");
		
		return sql.toString();
	}
	
	protected String getSQLPrimaryKey() {
		if(this.primaryKey.isEmpty()) {
			return "";
		}
		return (this.primaryKey + " INTEGER PRIMARY KEY AUTOINCREMENT,");
	}
	
	protected String buildFieldsSQL(CreatingField cf) {
		return cf.getFieldName() + " " + cf.getType() + getIsNull(cf.isAllowNULL());
	}
	
	protected String getIsNull(boolean isNull) {
		if(isNull) {
			return "";
		}
		return " NOT NULL";
	}
}
