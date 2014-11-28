package initialconfig.createdb.create;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabProjects;
import core.db.tables.Tables;

public class CreateTableProjects extends CreateTables {

	CreateTable table;
	
	public CreateTableProjects() {
		this.table = new CreateTable(Tables.PROJECTS.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.setPrimaryKey(TabProjects.PID.toString());
		table.addTextField(TabProjects.NAME.toString(), "", false);
		table.addTextField(TabProjects.DESCRIPTION.toString(), "", true);
		table.addRealField(TabProjects.WEEKLEY_TIME.toString(), 0.0, true);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
