package controller;

/**
 * <h1>The class for getorder of the player</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */


public class UserOrder implements IUserOrder {
	private final int		player;
	private final Order	order;
	
	 /**
     * Constructor. 
     *
     * @param player  
     * 
     * @param order 
     *            
     */

	public UserOrder(final int player, final Order order) {
		this.player = player;
		this.order = order;
	}
	
	 /**
     * gets the Player. 
     *
     *@return player
     * 
     */

	@Override
	public int getPlayer() {
		return this.player;
	}
	
	 /**
     * gets the Order. 
     *
     *@return order
     * 
     */


	@Override
	public Order getOrder() {
		return this.order;
	}
}
