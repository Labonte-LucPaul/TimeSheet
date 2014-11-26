package core.db.sqlite.field;

public enum UsersProjects {

	UID("UID"),
	PID("PID");
	
	private String str;
	private UsersProjects(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
