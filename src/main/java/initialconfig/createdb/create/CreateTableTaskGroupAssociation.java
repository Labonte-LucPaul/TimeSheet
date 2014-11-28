package initialconfig.createdb.create;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabTaskGroupAssociation;
import core.db.tables.Tables;

public class CreateTableTaskGroupAssociation extends CreateTables {

	private CreateTable table;
	
	public CreateTableTaskGroupAssociation() {
		this.table = new CreateTable(Tables.TASK_GROUP_ASSOCIATION.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.addIntegerField(TabTaskGroupAssociation.TGID.toString(), 0, false);
		table.addIntegerField(TabTaskGroupAssociation.TID.toString(), 0, false);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
