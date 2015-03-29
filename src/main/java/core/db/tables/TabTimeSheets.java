package core.db.tables;

public enum TabTimeSheets {

	TSID("TSID"),
	UID("FK_UID"),
	PID("FK_PID"),
	TID("FK_TID"),
	DATE("FirstDate"),
	SUNDAY("Sunday"),
	MONDAY("Monday"),
	TUESDAY("tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday"),
	COMMENTS("Comments");
	
	private final String str;
	private TabTimeSheets(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
