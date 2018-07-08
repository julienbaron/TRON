package controller;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <h1>The Class UserOrderTest allows to test if the methods works well.</h1>
 *
 * @author Julien BARON
 * @version 1.0
 */

public class UserOrderTest {

	UserOrder order;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		order = new UserOrder(0,Order.DOWN);
	}

	@Test
	public void testGetPlayer() {
		assertEquals(0,order.getPlayer());
	}

	@Test
	public void testGetOrder() {
		assertEquals(Order.DOWN,order.getOrder());
	}

}