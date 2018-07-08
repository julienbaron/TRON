package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PositionTest {

	Position position;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		position = new Position(10,10);
		position.setMaxX(50);
		position.setMaxY(50);
	}

	@Test
	public void testGetX() {
		assertEquals(10,position.getX());
	}

	@Test
	public void testSetX() {
		position.setX(20);
		assertEquals(20, position.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(10, position.getY());
	}

	@Test
	public void testSetY() {
		position.setY(20);
		assertEquals(20, position.getY());
	}

}