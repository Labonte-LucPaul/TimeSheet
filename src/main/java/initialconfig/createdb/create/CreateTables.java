package initialconfig.createdb.create;

public abstract class CreateTables {

	public abstract String create();
	
	protected abstract void addFields();
	
	public abstract String getSQL();
}
