package model;

/**
 * <h1>The class lorann is the first player .</h1>
 * 
 * @author Julien BARON 
 * @version 1.0
 */

public class Lorann extends Mobile {
	private static int	SPEED		= 5;
	private static int	WIDTH		= 5;
	private static int	HEIGHT	= 5;

	
	private final int		player;
	 
	/**
     * constructor
     * 
     *@param player
     *@param direction the direction
     *@param position the position
     *@param image 
     *          
     */
	
	public Lorann(final int player, final Direction direction, final Position position, final String image) {
		super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, image);
		this.player = player;
	}

	@Override
	public boolean isPlayer(final int player) {
		return this.player == player;
	}

	@Override
	public boolean hit() {
		this.getDogfightModel().removeMobile(this);
		return true;
	}
	
	@Override
	public boolean isLorann() {
		// TODO Auto-generated method stub
		return true;
	}
}

