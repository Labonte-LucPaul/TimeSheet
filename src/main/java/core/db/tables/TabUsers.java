package core.db.tables;

public enum TabUsers {

	UID("UID"),
	FIRST_NAME("FirstName"),
	LAST_NAME("LastName"),
	LOGIN("login"),
	PASSWD("PassWord"),
	IV("IV"),
	EMAIL("eMail");
	
	private String str;
	private TabUsers(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
