package core.db.sqlite.querybuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import core.db.sqlite.querybuilder.Select;

public class SelectTest {

	Select select;
	
	@Before
	public void setUp() throws Exception {
		select = new Select("test");
		init();
	}
	
	@Ignore
	public void init() {
		select.addColumnName("ID");
		select.addColumnName("FirstName");
		select.addColumnName("LastName");
		select.addColumnName("Address");
	}

	@Test
	public void testSelectString() {
		Select se = new Select("TEST");
		assertNotNull(se);
	}

	@Test
	public void testSelectStringBoolean() {
		Select se = new Select("TEST", false);
		assertNotNull(se);
	}

	@Test
	public void testToSQL() {
		String expected = "SELECT ID,FirstName,LastName,Address FROM test;";
		assertEquals(expected, select.toSQL());
	}
	
	@Test
	public void testToSQL_condition() {
		select = null;
		select = new Select("test", false);
		select.setCondition("ID = 1");
		init();
		
		String expected = "SELECT ID,FirstName,LastName,Address FROM test WHERE ID = 1;";
		assertEquals(expected, select.toSQL());
	}
	
	@Test
	public void testToSQL_allColumn() {
		select = null;
		select = new Select("test", true);
		String expected = "SELECT * FROM test;";
		assertEquals(expected, select.toSQL());
	}

}
