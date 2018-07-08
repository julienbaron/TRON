package model;

import java.util.ArrayList;

/**
 * <h1>The Interface IModel.</h1>
 * 
 * @author Julien BARON 
 * @version 1.0
 */

public interface IDogfightModel {
	public void buildArea(final Dimension dimension);

	public IArea getArea();

	public void addMobile(final IMobile mobile);

	public void removeMobile(final IMobile mobile);

	public ArrayList<IMobile> getMobiles();

	public IMobile getMobileByPlayer(int player);

	public void setMobilesHavesMoved();
	
	public int getTablevel(int x, int y);
	
	public void setTablevel(int val, int x, int y);
	
	public void InsertScore(String name, int score);
}