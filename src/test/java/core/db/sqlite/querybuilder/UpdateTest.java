package core.db.sqlite.querybuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.db.sqlite.querybuilder.Update;

public class UpdateTest {

	private Update update;
	
	@Before
	public void setUp() throws Exception {
		update = new Update("test");
		update.setCondition("ID = 3");
		update.updateTEXT("UserName", "BobGratton");
		update.updateINTEGER("Age", 50);
		update.updateREAL("Average", 0.01);
		update.updateBLOB("password", "somePassword");
	}

	@Test
	public void testUpdate() {
		Update upd = new Update("test");
		assertNotNull(upd);
	}

	@Test
	public void testToSQL() {
		String expected = "UPDATE test SET UserName = 'BobGratton',Age = 50,Average = 0.01,password = 'somePassword' WHERE ID = 3;";
		assertEquals(expected, update.toSQL());
	}

}
