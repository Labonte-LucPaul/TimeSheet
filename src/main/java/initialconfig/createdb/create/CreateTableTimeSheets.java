package initialconfig.createdb.create;

import core.db.sqlite.querybuilder.CreateTable;
import core.db.tables.TabTimeSheets;
import core.db.tables.Tables;

public class CreateTableTimeSheets extends CreateTables {

	private CreateTable table;
	
	public CreateTableTimeSheets() {
		this.table = new CreateTable(Tables.TIME_SHEETS.toString());
	}
	
	@Override
	public String create() {
		addFields();
		return getSQL();
	}

	@Override
	protected void addFields() {
		table.setPrimaryKey(TabTimeSheets.TSID.toString());
		table.addIntegerField(TabTimeSheets.UID.toString(), 0, false);
		table.addIntegerField(TabTimeSheets.PID.toString(), 0, false);
		table.addIntegerField(TabTimeSheets.TID.toString(), 0, false);
		table.addRealField(TabTimeSheets.DATE.toString(), 0.0, false);
		table.addRealField(TabTimeSheets.SUNDAY.toString(), 0.0, false);
		table.addRealField(TabTimeSheets.MONDAY.toString(), 0.0, false);
		table.addRealField(TabTimeSheets.TUESDAY.toString(), 0.0, false);
		table.addRealField(TabTimeSheets.WEDNESDAY.toString(), 0.0, false);
		table.addRealField(TabTimeSheets.THURSDAY.toString(), 0.0, false);
		table.addRealField(TabTimeSheets.FRIDAY.toString(), 0.0, false);
		table.addRealField(TabTimeSheets.SATURDAY.toString(), 0.0, false);
		table.addTextField(TabTimeSheets.COMMENTS.toString(), "", true);
	}

	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
