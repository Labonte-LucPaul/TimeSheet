package core.db.sqlite.field;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreatingFieldTest {

	CreatingField cf = null;
	
	@Before
	public void setUp() throws Exception {
		cf = new CreatingField("UserName", "Bob Gratton", FieldType.TEXT, false);
	}

	@Test
	public void testCreatingFieldStringStringFieldTypeBoolean() {
		CreatingField f = new CreatingField("name", "value", FieldType.INT, true);
		assertNotNull("'f' is null.", f);
	}

	@Test
	public void testCreatingFieldStringStringFieldType() {
		CreatingField f = new CreatingField("name", "value", FieldType.INT);
		assertNotNull("'f' is null.", f);
	}

	@Test
	public void testGetType() {
		FieldType expected = FieldType.TEXT;
		assertEquals("Get Type does not match", expected, cf.getType());
	}

	@Test
	public void testIsAllowNULL() {
		assertFalse("Allow NULL does not match", cf.isAllowNULL());
	}

	@Test
	public void testIsAllowNULL_true() {
		CreatingField f = new CreatingField("name", "value", FieldType.INT, true);
		assertTrue("Allow NULL does not match", f.isAllowNULL());
	}
	
	@Test
	public void testIsAllowNULL_ByDefault() {
		CreatingField f = new CreatingField("name", "value", FieldType.INT);
		assertTrue("Allow NULL does not match", f.isAllowNULL());
	}
}
