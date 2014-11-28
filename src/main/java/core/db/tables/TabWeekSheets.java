package core.db.tables;

public enum TabWeekSheets {

	WSID("WSID"),
	UID("FK_UID"),
	TSID("FK_TSID"),
	WEEK_NUMBER("WeekNumber"),
	WEEK_DATE("WeekDate"),
	STATUS("Status");
	
	private final String str;
	private TabWeekSheets(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
