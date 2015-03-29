package core.db.tables;

public enum TabUsersProjects {

	UID("UID"),
	PID("PID");
	
	private String str;
	private TabUsersProjects(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
