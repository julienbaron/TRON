package model;

import model.dao.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * <h1>The Class Model manage mobile and SQL .</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */

public class DogfightModel extends Observable implements IDogfightModel {
	private Sky												sky;
	private final ArrayList<IMobile>	mobiles;
	private int level;
	private int score;
	private int tablevel[][] = new int [21][13];
	
	 /**
     * Constructor.
     *
     */
	
	public DogfightModel() {
		this.mobiles = new ArrayList<>();
		this.level = 1;
		this.score = 0;
		for(int i=0; i<21; i++) {
			for(int j=0; j< 13; j++){
				tablevel[i][j] =0; 
			}
		}
	}
	
	 /**
     *  getArea.
     *
     *    
     */

	@Override
	public IArea getArea() {
		return this.sky;
	}
	
	 /**
     * buildArea.
     *
     * @param Dimension
     */
	
	@Override
	public void buildArea(final Dimension dimension) {
		this.sky = new Sky(dimension);
	}
	
	 /**
     * addMobile.
     *
     * @param mobile 
     */
	
	@Override
	public void addMobile(final IMobile mobile) {
		this.mobiles.add(mobile);
		mobile.setDogfightModel(this);
	}
	
	 /**
     * removeMobile.
     *
     * @param mobile 
     */
	
	@Override
	public void removeMobile(final IMobile mobile) {
		this.mobiles.remove(mobile);
	}
	
	 /**
     * getMobiles.
     *
     * 
     */

	@Override
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}
	
	 /**
     * getMobileByPlayer.
     *
     * @param player
     */
	
	@Override
	public IMobile getMobileByPlayer(final int player) {
		for (final IMobile mobile : this.mobiles) {
			if (mobile.isPlayer(player)) {
				return mobile;
			}
		}
		return null;
	}
	
	 /**
     * setMobilesHavesMoved.
     *
     * @param mobile 
     */

	@Override
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
	
	 /**
     * setMobilesHavesMoved.
     *
     * @param val
     * @param x 
     * @param y 
     */
	
	
	public void setTablevel(int val, int x, int y) {
		tablevel[x][y] =val;
	}
	
	 /**
     * getTablevel
     *
     * @param x 
     * 
     * @param y
     */
	
	public int getTablevel(int x, int y) {
		return tablevel[x][y];
	}


	 /**
     * InsertScore in the database .
     *
     * @param name 
     * @param score
     */
	
	@Override
	public void InsertScore(String name, int score) {
		// TODO Auto-generated method stub
		try {
			final DAOScore daoScore = new DAOScore(DBConnection.getInstance().getConnection());
			daoScore.SaveScore(name, score);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		
	}
}
