package initialconfig.createdb;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabOptions;
import core.db.tables.Tables;

public class CreateTableOptions extends CreateTables {

	private CreateTable table;
	
	public CreateTableOptions() {
		this.table = new CreateTable(Tables.OPTIONS.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.addTextField(TabOptions.OPTION_NAME.toString(), "", false);
		table.addTextField(TabOptions.OPTION_VALUE.toString(), "", true);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
