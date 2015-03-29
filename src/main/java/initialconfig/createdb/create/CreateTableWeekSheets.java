package initialconfig.createdb.create;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabWeekSheets;
import core.db.tables.Tables;

public class CreateTableWeekSheets extends CreateTables {

	private CreateTable table;
	
	public CreateTableWeekSheets() {
		this.table = new CreateTable(Tables.WEEK_SHEETS.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.setPrimaryKey(TabWeekSheets.WSID.toString());
		table.addIntegerField(TabWeekSheets.UID.toString(), 0, false);
		table.addIntegerField(TabWeekSheets.TSID.toString(), 0, false);
		table.addTextField(TabWeekSheets.WEEK_DATE.toString(), "", false);
		table.addIntegerField(TabWeekSheets.WEEK_NUMBER.toString(), 0, false);
		table.addTextField(TabWeekSheets.STATUS.toString(), "", false);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
