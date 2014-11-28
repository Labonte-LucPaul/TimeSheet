package initialconfig.createdb.populate;

import core.db.sqlite.querybuilder.InsertInto;
import core.db.tables.TabUsers;
import core.db.tables.Tables;

public class PopulateTableUsers extends PopulateTables {

	private InsertInto insert;
	
	public PopulateTableUsers() {
		this.insert = new InsertInto(Tables.USERS.toString());
		insert.addText(TabUsers.FIRST_NAME.toString(), "root");
		insert.addText(TabUsers.LAST_NAME.toString(), "root");
		insert.addText(TabUsers.LOGIN.toString(), "root");
		insert.addInteger(TabUsers.IV.toString(), 0);
	}
	
	@Override
	public void addValue(String columnName, String value) {
		insert.addBLOB(columnName, value);
	}

	@Override
	public String getSQL() {
		return this.insert.toSQL();
	}

}
