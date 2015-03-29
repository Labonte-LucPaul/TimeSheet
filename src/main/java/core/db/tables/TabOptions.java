package core.db.tables;

public enum TabOptions {

	OPTION_NAME("OptionName"),
	OPTION_VALUE("OptionValue");

	private final String str;
	private TabOptions(String s) {
		str = s;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
