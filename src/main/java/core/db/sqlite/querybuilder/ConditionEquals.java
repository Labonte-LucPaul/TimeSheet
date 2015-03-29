package core.db.sqlite.querybuilder;

public class ConditionEquals extends ColumnTypeSetters implements SQLCondition {

	private String conditionName;
	private BooleanType type;
	
	public ConditionEquals(String name) {
		this.conditionName = name;
		this.type = BooleanType.NONE;
	}
	
	@Override
	public String getConditionName() {
		return this.conditionName;
	}

	@Override
	public String getConditionSQL() {
		return (super.field.getFieldName() + (" = " + (super.field.getFieldValue() + this.type.toString())));
	}

	@Override
	public void setBooleanAfter(BooleanType type) {
		this.type = type;
	}

}
