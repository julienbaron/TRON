package model;

/**
 * <h1>The Class Dimension setDimension of object .</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */

public class Dimension {
	private int	width;
	private int	height;
	
	 /**
     * Constructor.
     *
     * @param width 
     * 
     *  @param height
     */

	public Dimension(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	public Dimension(final Dimension dimension) {
		this(dimension.getWidth(), dimension.getHeight());
	}
	
	 /**
     * getWidth.
     *
     *
     */

	public int getWidth() {
		return this.width;
	}
	
	 /**
     * setWidth.
     *
     *
     */

	public void setWidth(final int width) {
		this.width = width;
	}
	
	 /**
     * getHeight.
     *
     *
     */

	public int getHeight() {
		return this.height;
	}
	
	 /**
     * setHeight.
     *
     *
     */

	public void setHeight(final int height) {
		this.height = height;
	}

}
