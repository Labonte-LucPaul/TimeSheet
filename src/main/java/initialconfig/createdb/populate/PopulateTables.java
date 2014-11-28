package initialconfig.createdb.populate;

public abstract class PopulateTables {

	public abstract void addValue(String columnName, String value);
	
	public abstract String getSQL();
}
