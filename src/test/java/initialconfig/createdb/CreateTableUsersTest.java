package initialconfig.createdb;

import static org.junit.Assert.*;
import initialconfig.createdb.create.CreateTableUsers;

import org.junit.Before;
import org.junit.Test;

public class CreateTableUsersTest {

	CreateTableUsers table;
	String expected = "CREATE TABLE USERS (UID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT NOT NULL,LastName TEXT NOT NULL,login TEXT NOT NULL,eMail TEXT NOT NULL,PassWord BLOB NOT NULL,IV INT NOT NULL,Departement TEXT,AccessLevel INT NOT NULL);";
	
	@Before
	public void setUp() throws Exception {
		table = new CreateTableUsers();
	}

	@Test
	public void testCreateTableUsers() {
		assertNotNull(table);
	}

	@Test
	public void testCreate() {
		String actual = table.create();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSQL() {
		table.create();
		String actual = table.getSQL();
		assertEquals(expected, actual);
	}

}
