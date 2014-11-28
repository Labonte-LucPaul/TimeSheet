package initialconfig.createdb;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabUsersProjects;
import core.db.tables.Tables;

public class CreateTableUsersProjects extends CreateTables {

	private CreateTable table;
	
	public CreateTableUsersProjects() {
		this.table = new CreateTable(Tables.UPROJECTS.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.addIntegerField(TabUsersProjects.PID.toString(), 0, false);
		table.addIntegerField(TabUsersProjects.UID.toString(), 0, false);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
