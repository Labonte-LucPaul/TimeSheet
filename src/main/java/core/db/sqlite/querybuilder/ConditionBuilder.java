package core.db.sqlite.querybuilder;

import java.util.ArrayList;

public class ConditionBuilder {
	
	private ArrayList<SQLCondition> condition;

	public ConditionBuilder() {
		this.condition = new ArrayList<SQLCondition>();
	}
	
	public void addCondition(SQLCondition condition) {
		this.condition.add(condition);
	}
	
	public String getCondition() {
		if(this.condition.isEmpty()) {
			return "";
		}
		
		StringBuilder cnd = new StringBuilder();
		cnd.append(" WHERE ");
		for(SQLCondition c : this.condition) {
			cnd.append(c.getConditionSQL());
		}
		return cnd.toString();
	}
}
