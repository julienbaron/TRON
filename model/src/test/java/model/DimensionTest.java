package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DimensionTest {

	Dimension dimension;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		dimension = new Dimension (200,300);
		
	}

	@Test
	public void testGetWidth() {
		assertEquals(200,dimension.getWidth());
	}

	@Test
	public void testSetWidth() {
		dimension.setWidth(250);
		assertEquals(250,dimension.getWidth());
	}

	@Test
	public void testGetHeight() {
		assertEquals(300,dimension.getHeight());
	}

	@Test
	public void testSetHeight() {
		dimension.setHeight(350);
		assertEquals(350,dimension.getHeight());
		
	}
}
