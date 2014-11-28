package initialconfig.createdb.create;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabTaskGroup;
import core.db.tables.Tables;

public class CreateTableTaskGroup extends CreateTables {

	private CreateTable table;
	
	public CreateTableTaskGroup() {
		this.table = new CreateTable(Tables.TASK_GROUP.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.setPrimaryKey(TabTaskGroup.TGID.toString());
		table.addTextField(TabTaskGroup.NAME.toString(), "", false);	
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
