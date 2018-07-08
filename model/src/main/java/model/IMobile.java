package model;

import java.awt.Image;

/**
 * <h1>The Interface IModel.</h1>
 * 
 * @author Julien BARON 
 * @version 1.0
 */

public interface IMobile {

	public Direction getDirection();

	public void setDirection(final Direction direction);

	public Position getPosition();

	public Dimension getDimension();

	public int getWidth();

	public int getHeight();

	public int getSpeed();

	public Image getImage();

	public void move();
	
	public void recule();
	public void reculeMonster();
	public void cherche( IMobile mobile);

	public void placeInArea(IArea area);

	public boolean isPlayer(int player);

	public void setDogfightModel(IDogfightModel dogfightModel);

	public boolean hit();

	
	public boolean isLorann();
	public boolean isMonster();
	

}