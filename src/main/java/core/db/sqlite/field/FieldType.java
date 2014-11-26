package core.db.sqlite.field;

public enum FieldType {
	INT("INT"), TEXT("TEXT"), BLOB("BLOB"), REAL("REAL"), NULL("NULL");

	private String type;
	private FieldType(String t) {
		type = t;
	}
	
	public String getType() {
		return type;
	}
}

