package model;

/**
 * <h1>The Class Position setPosition of object .</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */

public class Position {
	private int	x;
	private int	y;
	private int	maxX	= 1;
	private int	maxY	= 1;
	
	 /**
     * Constructor.
     *
     * @param x
     * 
     *  @param y
     */

	public Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public Position(final Position position) {
		this(position.getX(), position.getY());
	}
	
	 /**
     * gets the x.
     *
     *@return x
     */
	public int getX() {
		return this.x;
	}
	 /**
     * set the x.
     *
     *
     */

	public void setX(final int x) {
		this.x = (x + this.maxX) % this.maxX;
	}
	
	 /**
     * gets the y.
     *
     *@return y
     */

	public int getY() {
		return this.y;
	}
	
	 /**
     * set the y
     *
     *
     */

	public void setY(final int y) {
		this.y = (y + this.maxY) % this.maxY;
	}
	
	 /**
     * set the MaxX
     *
     *
     */

	protected void setMaxX(final int maxX) {
		this.maxX = maxX;
	}
	
	 /**
     * set the maxY
     *
     *
     */
	protected void setMaxY(final int maxY) {
		this.maxY = maxY;
	}
}
