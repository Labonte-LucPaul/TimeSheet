package core.db.sqlite.querybuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.db.sqlite.querybuilder.Delete;

public class DeleteTest {

	private Delete delete;
	
	@Before
	public void setUp() throws Exception {
		delete = new Delete("test", "ID = 3"); 
	}

	@Test
	public void testDelete() {
		assertNotNull(delete);
	}

	@Test
	public void testToSQL() {
		String expected = "DELETE FROM test WHERE ID = 3;";
		assertEquals(expected, delete.toSQL());
	}

}
