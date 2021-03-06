package view;

import java.awt.event.KeyEvent;

import controller.IOrderPerformer;
import controller.IUserOrder;
import controller.Order;
import controller.UserOrder;
import gameframe.IEventPerformer;

/**
 * <h1>The Class EventPerformer generate order for controller.</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */


class EventPerformer implements IEventPerformer {
	private final IOrderPerformer orderPerformer;
	
	/**
     * constructor
     * 
     *@param orderperfomer the orderperfomer
     *          
     */

	public EventPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
	
	/**
     * eventPerform 
     * 
     *@param keyCode the keyEvent
     *          
     */
	
	@Override
	public void eventPerform(final KeyEvent keyCode) {
		final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
		if (userOrder != null) {
			this.orderPerformer.orderPerform(userOrder);
		}
	}
	
	/**
     * keyCodeToUserOrder
     * 
     *@param keyCode 
     *
     *@return userOrder
     *          
     */

	public IUserOrder keyCodeToUserOrder(final int keyCode) {
		IUserOrder userOrder;
		switch (keyCode) {
			case KeyEvent.VK_UP:
				userOrder = new UserOrder(0, Order.UP);
				break;
			case KeyEvent.VK_RIGHT:
				userOrder = new UserOrder(0, Order.RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				userOrder = new UserOrder(0, Order.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				userOrder = new UserOrder(0, Order.LEFT);
				break;
			case KeyEvent.VK_CONTROL:
				userOrder = new UserOrder(0, Order.SHOOT);
				break;

			case KeyEvent.VK_Z:
				userOrder = new UserOrder(1, Order.UP);
				break;
			case KeyEvent.VK_D:
				userOrder = new UserOrder(1, Order.RIGHT);
				break;
			case KeyEvent.VK_S:
				userOrder = new UserOrder(1, Order.DOWN);
				break;
			case KeyEvent.VK_Q:
				userOrder = new UserOrder(1, Order.LEFT);
				break;
			case KeyEvent.VK_SHIFT:
				userOrder = new UserOrder(1, Order.SHOOT);
				break;
			default:
				//userOrder = new UserOrder(0, Order.NOP);
				//System.out.println("nop2");
				userOrder = null;
		}
	
		return userOrder;
	}
}
