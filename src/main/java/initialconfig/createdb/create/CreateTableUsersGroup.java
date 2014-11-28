package initialconfig.createdb.create;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabUsersGroup;
import core.db.tables.Tables;

public class CreateTableUsersGroup extends CreateTables {

	private CreateTable table;
	
	public CreateTableUsersGroup() {
		this.table = new CreateTable(Tables.UGROUP.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.setPrimaryKey(TabUsersGroup.GID.toString());
		table.addTextField(TabUsersGroup.GROUP_NAME.toString(), "", false);
		table.addTextField(TabUsersGroup.DESCRIPTION.toString(), "", true);
		table.addTextField(TabUsersGroup.ACCESS_LEVEL.toString(), "", false);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
