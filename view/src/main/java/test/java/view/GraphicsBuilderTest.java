package view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Dimension;
import model.DogfightModel;

public class GraphicsBuilderTest {

	final DogfightModel model = new DogfightModel();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		
 	model.buildArea(new Dimension(1000, 700));

		
	}

	@Test
	public void testGetGlobalWidth() {
		assertEquals(1000, model.getArea().getWidth() );
	
	}

	@Test
	public void testGetGlobalHeight() {
		
		assertEquals(700, model.getArea().getHeight() );
	
	}

	

}
