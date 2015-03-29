package core.db.sqlite;

public enum FilePath {

	DATABASE_SOURCE("data/timesheet.db");
	
	private String path;
	private FilePath(String s) {
		this.path = s;
	}
	
	public String toString() {
		return this.path;
	}
}
