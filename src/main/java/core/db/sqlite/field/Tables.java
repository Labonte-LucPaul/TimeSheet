package core.db.sqlite.field;

public enum Tables {
	
	OPTIONS("OPTIONS"),
	USERS("USERS"),
	UGROUP("USERS_GROUP"),
	UPROJECTS("USERS_PROJECTS"),
	PROJECTS("PROJECTS"),
	TASKS("TASKS"),
	TIME_SHEETS("TIME_SHEETS");
	
	private final String str;
	private Tables(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
