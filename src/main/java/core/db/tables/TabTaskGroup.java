package core.db.tables;

public enum TabTaskGroup {
	
	TGID("TGID"),
	NAME("GroupName");
	
	private String str;
	private TabTaskGroup(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
