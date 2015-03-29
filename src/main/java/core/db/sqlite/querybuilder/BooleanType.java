package core.db.sqlite.querybuilder;

public enum BooleanType {

	NONE(""),
	AND(" AND "),
	OR(" OR ");
	
	private String booleanType;
	private BooleanType(String s) {
		this.booleanType = s;
	}
	
	public String toString() {
		return this.booleanType;
	}
}
