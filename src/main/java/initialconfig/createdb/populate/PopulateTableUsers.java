package initialconfig.createdb.populate;

import core.db.sqlite.querybuilder.InsertInto;
import core.db.tables.TabUsers;
import core.db.tables.Tables;

public class PopulateTableUsers extends PopulateTables {

	private InsertInto insert;
	
	public PopulateTableUsers() {
		this.insert = new InsertInto(Tables.USERS.toString());
		
	}
	
	public void populateFields(String fName, String lName, String login, String email) {
		insert.addText(TabUsers.FIRST_NAME.toString(), fName);
		insert.addText(TabUsers.LAST_NAME.toString(), lName);
		insert.addText(TabUsers.LOGIN.toString(), login);
		insert.addText(TabUsers.EMAIL.toString(), email);
		insert.addInteger(TabUsers.IV.toString(), 0);
		insert.addText(TabUsers.DEPARTEMENT.toString(), "SysAdmin");
		insert.addInteger(TabUsers.ACCESS_LEVEL.toString(), 1);
		
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
