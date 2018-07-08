package view;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.IUserOrder;
import controller.Order;
import controller.UserOrder;


public class EventPerformerTest {
	

	
	IUserOrder userOrder;
	


	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	
	@Before
	public void setUp() throws Exception {
		
		
		userOrder = new UserOrder(0, Order.DOWN);

	}

	@Test
	public void testKeyCodeToUserOrder() {
	
		assertEquals(Order.DOWN, userOrder.getOrder());
	}

}
