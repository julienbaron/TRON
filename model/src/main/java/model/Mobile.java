package model;

import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The class Mobile manage the sprite .</h1>
 * 
 * @author Julien BARON 
 * @version 1.0
 */


class Mobile implements IMobile {
	private Direction				direction;
	private final Position	position;
	private final Dimension	dimension;
	private final int				speed;
	private IDogfightModel	dogfightModel;
	private Image						images[];
	
	/**
     * constructor
     * 
     *@param direction the direction
     *@param position the position
     *@param dimension the dimension 
     *@param speed
     *@param image  
     *          
     */

	public Mobile(final Direction direction, final Position position, final Dimension dimension, final int speed, final String image) {
		this.direction = direction;
		this.position = position;
		this.dimension = dimension;
		this.speed = speed;
		try {
			this.buildAllimages(image);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * gets the direction
     * 
     *@return direction
     *          
     */

	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	/**
     * set the direction
     * 
     *          
     */


	@Override
	public void setDirection(final Direction direction) {
		this.direction = direction;
	}
	
	/**
     * gets the position
     * 
     * @return position
     * 
     *          
     */

	@Override
	public Position getPosition() {
		return this.position;
	}
	
	/**
     * gets the Dimension 
     * 
     * @return dimension 
     * 
     *          
     */

	@Override
	public Dimension getDimension() {
		return this.dimension;
	}

	@Override
	public void placeInArea(final IArea area) {
		this.position.setMaxX(area.getDimension().getWidth());
		this.position.setMaxY(area.getDimension().getHeight());
	}
	
	/**
     * move allows to move mobile 
     * 
     * 
     *          
     */

	@Override
	public void move() {
		switch (this.direction) {
			case UP:
				this.moveUp();
				break;
			case RIGHT:
				this.moveRight();
				break;
			case DOWN:
				this.moveDown();
				break;
			case LEFT:
				this.moveLeft();
				break;
			case NOP:
				break;
			default:
				break;
		}
	}

	/**
     * to move up the mobile 
     *     
     */

	private void moveUp() {
		this.position.setY(this.position.getY() - this.speed);
	}
	
	/**
     * to move right the mobile 
     *     
     */

	private void moveRight() {
		this.position.setX(this.position.getX() + this.speed);
	}
	
	/**
     * to move down the mobile 
     *     
     */

	private void moveDown() {
		this.position.setY(this.position.getY() + this.speed);
	}

	private void moveLeft() {
		this.position.setX(this.position.getX() - this.speed);
	}

	/**
     * the methods isPlayer
     * 
     * @param player 
     * @return false
     *     
     */
	@Override
	public boolean isPlayer(final int player) {
		return false;
	}
	
	/**
     * gets the model
     * 
     * @return model
     * 
     *          
     */

	public IDogfightModel getDogfightModel() {
		return this.dogfightModel;
	}

	/**
     * set the model
     * 
     * @param model the model
     * 
     *          
     */
	
	@Override
	public void setDogfightModel(final IDogfightModel dogfightModel) {
		this.dogfightModel = dogfightModel;
		this.getPosition().setMaxX(this.getDogfightModel().getArea().getDimension().getWidth());
		this.getPosition().setMaxY(this.getDogfightModel().getArea().getDimension().getHeight());
	}

	@Override
	public boolean hit() {
		return false;
	}

	/**
     * gets the width
     * 
     * @return  dimension 
     * 
     *          
     */
	

	@Override
	public int getWidth() {
		switch (this.direction) {
			case UP:
			case DOWN:
				return this.getDimension().getHeight();
			case RIGHT:
			case LEFT:
			default:
				return this.getDimension().getWidth();
		}
	}
	
	/**
     * gets the Height 
     * 
     * @return  dimension 
     * 
     *          
     */

	@Override
	public int getHeight() {
		switch (this.direction) {
			case UP:
			case DOWN:
				return this.getDimension().getWidth();
			case RIGHT:
			case LEFT:
			default:
				return this.getDimension().getHeight();
		}
	}
	
	/**
     * gets the speed
     * 
     * @return  speed 
     * 
     *          
     */

	@Override
	public int getSpeed() {
		return this.speed;
	}
	
	/**
     * buildAllimages
     *
     *@param  image name 
     *@throws IOException
     *          
     */

	private void buildAllimages(final String imageName) throws IOException {
		this.images = new Image[5];
		this.images[Direction.UP.ordinal()] = ImageIO.read(new File("../images/" + imageName + "_UP.png"));
		this.images[Direction.RIGHT.ordinal()] = ImageIO.read(new File("../images/" + imageName + "_RIGHT.png"));
		this.images[Direction.DOWN.ordinal()] = ImageIO.read(new File("../images/" + imageName + "_DOWN.png"));
		this.images[Direction.LEFT.ordinal()] = ImageIO.read(new File("../images/" + imageName + "_LEFT.png"));
		this.images[Direction.NOP.ordinal()] = ImageIO.read(new File("../images/" + imageName + "_NOP.png"));
	}

	/**
     * gets the Image
     * 
     * @return  image 
     * 
     *          
     */
	@Override
	public Image getImage() {
		return this.images[this.direction.ordinal()];
	}

	@Override
	public boolean isLorann() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recule() {
		// TODO Auto-generated method stub
		switch (this.direction) {
		case UP:
			this.setDirection(Direction.NOP);
			this.moveDown(); 
			break;
		case RIGHT:
			this.setDirection(Direction.NOP);
			this.moveLeft(); 
			break;
		case DOWN:
			this.setDirection(Direction.NOP);
			this.moveUp(); 
			break;
		case LEFT:
			this.setDirection(Direction.NOP);
			this.moveRight(); 
			break;
		case NOP:
			break;
		default:
			break;
	}
		
	}

	@Override
	public boolean isMonster() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void cherche(IMobile mobile) {
		// TODO Auto-generated method stub
		
		switch (mobile.getDirection()) {
		case UP:
			this.setDirection(Direction.DOWN);
			//this.moveDown(); 
			//this.setDirection(Direction.NOP);
			break;
		case RIGHT:
			this.setDirection(Direction.LEFT);
			System.out.println("right");
			//this.moveLeft(); 
			//this.setDirection(Direction.NOP);
			break;
		case DOWN:
			this.setDirection(Direction.UP);
			//this.moveUp(); 
			
			//this.setDirection(Direction.NOP);
			break;
		case LEFT:
			this.setDirection(Direction.RIGHT);
			System.out.println("left");
			//this.moveRight(); 
			break;
		case NOP:
			break;
		default:
			break;
	}
		
	}

	@Override
	public void reculeMonster() {
		// TODO Auto-generated method stub
		switch (this.direction) {
		case UP:
			this.setDirection(Direction.DOWN);
			break;
		case RIGHT:
			this.setDirection(Direction.LEFT);
			break;
		case DOWN:
			this.setDirection(Direction.UP);
			break;
		case LEFT:
			this.setDirection(Direction.RIGHT);
			break;
		case NOP:
			break;
		default:
			break;
	}
		
	}
}
