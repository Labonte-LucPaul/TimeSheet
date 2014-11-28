package core.db.tables;

public enum TabTaskGroupAssociation {
	
	TGID("TGID"),
	TID("TID");
	
	private String str;
	private TabTaskGroupAssociation(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
