package core.db.sqlite.querybuilder;

public interface SQLCondition {

	public String getConditionName();
	
	public String getConditionSQL();
	
	public void setBooleanAfter(BooleanType type);
}
