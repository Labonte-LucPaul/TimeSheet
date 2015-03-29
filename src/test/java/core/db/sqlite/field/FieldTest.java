package core.db.sqlite.field;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.db.sqlite.field.Field;

public class FieldTest {

	private Field field = null;
	
	@Before
	public void createField() {
		field = new Field("UserName", "Bob Gratton");
	}
	
	@Test
	public void testField() {
		Field f = new Field("name", "value");
		assertNotNull("'f' is null", f);
	}

	@Test
	public void testGetFieldName() {
		String expected = "UserName";
		assertEquals("Testing GetFieldName", expected, field.getFieldName());
	}

	@Test
	public void testGetFieldValue() {
		String expected = "Bob Gratton";
		assertEquals("Testing GetFieldValue", expected, field.getFieldValue());
	}

}
