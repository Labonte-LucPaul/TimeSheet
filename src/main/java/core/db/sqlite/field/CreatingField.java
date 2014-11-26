package core.db.sqlite.field;


public class CreatingField extends Field {

	private FieldType type;
	private boolean allowNULL = true;
	
	public CreatingField(String fName, String fValue, FieldType type, boolean allowNull) {
		super(fName, fValue);
		this.type = type;
		this.allowNULL = allowNull;
	}
	
	public CreatingField(String fName, String fValue, FieldType type) {
		this(fName, fValue, type, true);
	}

	public FieldType getType() {
		return type;
	}

	public boolean isAllowNULL() {
		return allowNULL;
	}

}
