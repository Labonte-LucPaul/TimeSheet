package core.db.tables;

public enum TabTask {

	TID("TID"),
	NAME("TaskName"),
	DESCRIPTION("Description");
	
	private String str;
	private TabTask(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
