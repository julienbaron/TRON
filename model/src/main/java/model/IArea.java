package model;

import java.awt.Image;

/**
 * <h1>The Interface IArea.</h1>
 * 
 * @author Julien BARON 
 * @version 1.0
 */

public interface IArea {

	public Dimension getDimension();

	public int getWidth();

	public int getHeight();

	public Image getImage();
}