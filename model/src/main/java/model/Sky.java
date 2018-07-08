package model;

/**
 * <h1>The Class sky charge screen .</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Sky implements IArea {
	private static String		IMAGE	= "fond.png";
	private final Dimension	dimension;
	private Image						image;

	
	/**
     * constructor
     * 
     *@param dimension the dimension 
     *          
     */
	public Sky(final Dimension dimension) {
		this.dimension = dimension;
		try {
			this.image = ImageIO.read(new File("../images/" + IMAGE));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
     * gets the dimension
     * 
     *@return dimension 
     *          
     */
	@Override
	public Dimension getDimension() {
		return this.dimension;
	}
	
	/**
     * gets the width 
     * 
     *@return dimension 
     *          
     */

	@Override
	public int getWidth() {
		return this.getDimension().getWidth();
	}	
	
	/**
     * gets the height
     * 
     *@return dimension 
     *          
     */

	@Override
	public int getHeight() {
		return this.getDimension().getHeight();
	}
	
	/**
     * gets the image 
     * 
     *@return image 
     *          
     */

	@Override
	public Image getImage() {
		return this.image;
	}
}
