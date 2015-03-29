package initialconfig.createdb.create;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabTask;
import core.db.tables.Tables;

public class CreateTableTask extends CreateTables {

	private CreateTable table;
	
	public CreateTableTask() {
		this.table = new CreateTable(Tables.TASK.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.setPrimaryKey(TabTask.TID.toString());
		table.addTextField(TabTask.NAME.toString(), "", false);
		table.addTextField(TabTask.DESCRIPTION.toString(), "", true);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
