package initialconfig.createdb.create;

import core.db.tables.*;
import core.db.sqlite.querybuilder.*;

public class CreateTableUsers extends CreateTables {

	CreateTable table;
	
	public CreateTableUsers() {
		this.table = new CreateTable(Tables.USERS.toString());
	}
	
	@Override
	public String create() {
		try {
			addFields();
			return getSQL();
		} catch (Exception ex) {
			new Exception(ex.getMessage());
		}
		return new Exception().toString();
	}
	
	@Override
	protected void addFields() {
		table.setPrimaryKey(TabUsers.UID.toString());
		table.addTextField(TabUsers.FIRST_NAME.toString(), "", false);
		table.addTextField(TabUsers.LAST_NAME.toString(), "", false);
		table.addTextField(TabUsers.LOGIN.toString(), "", false);
		table.addTextField(TabUsers.EMAIL.toString(), "", false);
		table.addBLOBField(TabUsers.PASSWD.toString(), "", false);
		table.addIntegerField(TabUsers.IV.toString(), 0, false);
		table.addTextField(TabUsers.DEPARTEMENT.toString(), "", true);
		table.addIntegerField(TabUsers.ACCESS_LEVEL.toString(), 0, false);
	}
	
	@Override
	public String getSQL() {
		return this.table.toSQL();
	}

}
