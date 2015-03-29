package core.db.sqlite.field;

public class Field {

	private String fieldName;
	private String fieldValue;
	
	public Field(String fName, String fValue) {
		this.fieldName = fName;
		this.fieldValue = fValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}
}
