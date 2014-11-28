package core.db.tables;

public enum Tables {
	
	OPTIONS("OPTIONS"),
	USERS("USERS"),
	UGROUP("USERS_GROUP"),
	UPROJECTS("USERS_PROJECTS"),
	PROJECTS("PROJECTS"),
	TASK("TASK"),
	TASK_GROUP("TASK_GROUP"),
	TASK_GROUP_ASSOCIATION("TASK_GROUP_ASSOCIATION"),
	TIME_SHEETS("TIME_SHEETS"),
	WEEK_SHEETS("WEEK_SHEETS");
	
	private final String str;
	private Tables(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
