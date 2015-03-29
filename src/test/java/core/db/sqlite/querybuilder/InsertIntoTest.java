package core.db.sqlite.querybuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.db.sqlite.querybuilder.InsertInto;

public class InsertIntoTest {

	InsertInto insert = null;
	
	@Before
	public void setUp() throws Exception {
		insert = new InsertInto("TestTable");
		insert.addInteger("ID", 1);
		insert.addText("Name", "Paul");
		insert.addInteger("Age", 32);
		insert.addText("Address", "Québec rules");
		insert.addReal("Salary", 200350.00);
	}

	@Test
	public void testToSQL() {
		String expected = "INSERT INTO TestTable (ID,Name,Age,Address,Salary)VALUES (1,'Paul',32,'Québec rules',200350.0);";
		assertEquals(expected, insert.toSQL());
	}

	@Test
	public void testInsertInto() {
		InsertInto ii = new InsertInto("TEST");
		assertNotNull(ii);
	}
	
	@Test
	public void testSetCondition() {
		insert.setCondition("WHERE ID = 1");
		String expected = "INSERT INTO TestTable (ID,Name,Age,Address,Salary)VALUES (1,'Paul',32,'Québec rules',200350.0)WHERE ID = 1;";
		assertEquals(expected, insert.toSQL());
	}
}
