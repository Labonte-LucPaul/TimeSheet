package core.db.sqlite.querybuilder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import core.db.sqlite.field.FieldType;
import core.db.sqlite.querybuilder.CreateTable;

public class CreateTableTest {

	CreateTable ct = null;
	
	@Before
	public void setUp() throws Exception {
		ct = new CreateTable("TableTest");
	}

	@Test
	public void testCreateTable() {
		ct = null;
		ct = new CreateTable("creating");
		assertNotNull(ct);
	}

	@Test
	public void testSetPrimaryKey() {
		ct.setPrimaryKey("pkey");
		String expected = "pkey INT PRIMARY KEY NOT NULL,";
		assertEquals("Primary key does not match", expected, ct.getSQLPrimaryKey());
	}

	@Test
	public void testSetPrimaryKey_empty() {
		String expected = "";
		assertEquals("Primary key is not null", expected, ct.getSQLPrimaryKey());
	}
	
	@Test
	public void testAddIntegerField_NotNULL() {
		ct.addIntegerField("UserAge", 50, false);
		String expected = "UserAge " + FieldType.INT.toString() + " NOT NULL";
		assertEquals("Integer Field does not match", expected, ct.buildFieldsSQL(ct.getFields().get(0)));
	}

	@Test
	public void testAddIntegerField_NULL() {
		ct.addIntegerField("UserAge", 50, true);
		String expected = "UserAge " + FieldType.INT.toString();
		assertEquals("Integer Field does not match", expected, ct.buildFieldsSQL(ct.getFields().get(0)));
	}
	
	@Test
	public void testAddTextField() {
		ct.addTextField("UserName", "Bob Gratton", false);
		String expected = "UserName TEXT NOT NULL";
		assertEquals("TEXT Field does not match", expected, ct.buildFieldsSQL(ct.getFields().get(0)));
	}

	@Test
	public void testAddBLOBField() {
		ct.addBLOBField("UserName", "Bob Gratton", false);
		String expected = "UserName BLOB NOT NULL";
		assertEquals("BLOB Field does not match", expected, ct.buildFieldsSQL(ct.getFields().get(0)));
	}

	@Test
	public void testAddRealField() {
		ct.addRealField("RandomNumber", 3.5, false);
		String expected = "RandomNumber REAL NOT NULL";
		assertEquals("Real Field does not match", expected, ct.buildFieldsSQL(ct.getFields().get(0)));
	}

	@Test
	public void testToSQL() {
		createTable();
		String expected = "CREATE TABLE TableTest "
				+ "(pkey INT PRIMARY KEY NOT NULL,"
				+ "UserName TEXT NOT NULL,"
				+ "UserAge INT NOT NULL,"
				+ "UserAverage REAL)";
		assertEquals(expected, ct.toSQL());
	}

	@Ignore
	public void createTable() {
		ct.setPrimaryKey("pkey");
		ct.addTextField("UserName", "", false);
		ct.addIntegerField("UserAge", 43, false);
		ct.addRealField("UserAverage", 7.2, true);
	}
	
	@Test
	public void testGetSQLPrimaryKey() {
		ct.setPrimaryKey("pkey");
		String expected = "pkey INT PRIMARY KEY NOT NULL,";
		assertEquals("Primary key does not match", expected, ct.getSQLPrimaryKey());
	}

	@Test
	public void testGetSQLPrimaryKey_Empty() {
		String expected = "";
		assertEquals("Primary key is not null", expected, ct.getSQLPrimaryKey());
	}
	
	@Test
	public void testBuildFieldsSQL() {
		ct.addTextField("Test", "", false);
		String expected = "Test TEXT NOT NULL";
		assertEquals(expected, ct.buildFieldsSQL(ct.getFields().get(0)));
	}
	
	public void testBuildFieldsSQL_True() {
		ct.addTextField("Test", "", true);
		String expected = "Test TEXT NOT NULL";
		assertEquals(expected, ct.buildFieldsSQL(ct.getFields().get(0)));
	}

}
