package core.db.tables;

public enum TabProjects {

	PID("PID"),
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
