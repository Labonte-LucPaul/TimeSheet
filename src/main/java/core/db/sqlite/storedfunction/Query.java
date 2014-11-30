package core.db.sqlite.storedfunction;

public interface Query {

	void generateSQL();
	
	public String getSQL();
}
