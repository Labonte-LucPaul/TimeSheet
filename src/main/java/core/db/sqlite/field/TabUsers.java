package core.db.sqlite.field;

public enum TabUsers {

	UID("ID"),
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
