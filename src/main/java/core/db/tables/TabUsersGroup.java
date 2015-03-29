package core.db.tables;

public enum TabUsersGroup {

	GID("GID"),
	GROUP_NAME("GroupName"),
	DESCRIPTION("Description"),
	ACCESS_LEVEL("AccessLevel");

	private final String str;
	private TabUsersGroup(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
