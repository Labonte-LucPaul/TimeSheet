package core.db.sqlite.field;

public enum TabProjects {

	PID("ID"),
	NAME("ProjectName"),
	DESCRIPTION("Description"),
	WEEKLEY_TIME("WeekleyTime");
	
	private String str;
	private TabProjects(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
