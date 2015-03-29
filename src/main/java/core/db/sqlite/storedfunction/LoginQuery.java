package core.db.sqlite.storedfunction;

import core.db.sqlite.querybuilder.BooleanType;
import core.db.sqlite.querybuilder.ConditionEquals;
import core.db.sqlite.querybuilder.Select;
import core.db.tables.TabUsers;
import core.db.tables.Tables;

public class LoginQuery implements Query {

	private String login;
	private String password;
	private Select select = null;
	
	public LoginQuery(String login, String password) {
		this.login = login;
		this.password = password;
		generateSQL();
	}
	
	@Override
	public void generateSQL() {
		
		this.select = new Select(Tables.USERS.toString());
		
		this.select.addColumnName(TabUsers.UID.toString());
		this.select.addColumnName(TabUsers.FIRST_NAME.toString());
		this.select.addColumnName(TabUsers.LAST_NAME.toString());
		this.select.addColumnName(TabUsers.EMAIL.toString());
		this.select.addColumnName(TabUsers.LOGIN.toString());
		this.select.addColumnName(TabUsers.DEPARTEMENT.toString());
		this.select.addColumnName(TabUsers.ACCESS_LEVEL.toString());
		
		ConditionEquals condLogin = new ConditionEquals("login");
		condLogin.setBooleanAfter(BooleanType.AND);
		condLogin.setField(TabUsers.LOGIN.toString(), login);
		this.select.addCondition(condLogin);
		
		ConditionEquals condPasswd = new ConditionEquals("passwd");
		condPasswd.setField(TabUsers.PASSWD.toString(), password);
		this.select.addCondition(condPasswd);
	}
	
	@Override
	public String getSQL() {
		return this.select.toSQL();
	}
}
