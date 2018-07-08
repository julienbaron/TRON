package controller;

import java.awt.event.InputEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


import model.Direction;
import model.IDogfightModel;
import model.IMobile;
import model.Position;
import view.IViewSystem;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */


public class DogfightController implements IOrderPerformer {
	private static int						TIME_SLEEP	= 30;
	private final IDogfightModel	dogfightModel;
	private boolean								isGameOver	= false;
	private boolean								isNextLevel	= false;
	private String win="";          
	private IViewSystem						viewSystem;
	static int board[][] = new int [120][80]; 
	
	
	 /**
     * Constructor.
     *
     * @param model
     *            the model
     */
	public DogfightController(final IDogfightModel dogfightModel) {
		this.dogfightModel = dogfightModel;
	
	}
	
	 /**
     * Set the direction of the mobile. 
     *
     * @param userOrder the userorder
     *            
     */
	
	@Override
	public void orderPerform(final IUserOrder userOrder) {
		if (userOrder != null) {
			final IMobile plane = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer());
			if (plane != null) {
				Direction direction;
				switch (userOrder.getOrder()) {
					case UP:
						direction = Direction.UP;
						break;
					case RIGHT:
						direction = Direction.RIGHT;
						break;
					case DOWN:
						direction = Direction.DOWN;
						break;
					case LEFT:
						direction = Direction.LEFT;
						break;
					case NOP:
						direction = Direction.NOP;
						break;
					
					
					default:
						
						direction = Direction.NOP;
						break;
				}
				plane.setDirection(direction);
			}
		}
	}

	


	 /**
     * Test collision between mobile.
     *
     * @param mobile the mobile 
     *            
     * @param mobile the mobile
     * 
     * @return false
     */
	
	private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) {
		
		if ((weapon.getPosition().getX() >= mobile.getPosition().getX() )
				&& (weapon.getPosition().getX()  <= mobile.getPosition().getX() + mobile.getWidth())) {
			if ((weapon.getPosition().getY() >= mobile.getPosition().getY())
					&& (weapon.getPosition().getY()   <= mobile.getPosition().getY() + mobile.getHeight()) ) {
				return true;
			}
		}
		return false;
	}
	
	 /**
     * Facade Collision for player 0.
     *
     * @param monster
     * 
     * return false
     *            
     *         
     */
	
	private boolean manageCollisionMonster(final IMobile monster) {
		final ArrayList<IMobile> target = new ArrayList<IMobile>();

		
		final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
		for (final IMobile mobile : this.dogfightModel.getMobiles()) {
			initialMobiles.add(mobile);
		}
		for (final IMobile mobile : initialMobiles) {
			if (!mobile.isMonster()) {
				if (this.isWeaponOnMobile(mobile, monster)) {
	
				this.isGameOver = true;
				return true;
			}
			}
		}

		return false;
	}
	
	 /**
     * Facade collision for player 1.
     *
     * @param lorann
     * 
     * @return false
     *           
     *         
     */
	
	private boolean manageCollisionLorann(final IMobile lorann) {
		final ArrayList<IMobile> target = new ArrayList<IMobile>();
;
		
		final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
		for (final IMobile mobile : this.dogfightModel.getMobiles()) {
			initialMobiles.add(mobile);
		}
		for (final IMobile mobile : initialMobiles) {
	
			if (!mobile.isLorann()) {
			if (this.isWeaponOnMobile(mobile, lorann)) {
					this.isGameOver = true;
	
				
				return true;
			}
			}
		}

		
		return false;
	}
	
	 /**
     * Intro screen.
     *
     */
		
		
		public void intro() {
			BufferedImage image; 
			
			try {
				image = ImageIO.read(new File("../images/Capture.png"));
				this.viewSystem.afficheImage(image,70, 100);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(3000);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			
		
			this.viewSystem.closeAll();
		}
		 /**
	     * Gameover screen.
	     *
	     *         
	     */

		public void gameover() {
			BufferedImage image; 
			
			try {
				image = ImageIO.read(new File("../images/end.png"));
				this.viewSystem.afficheImage(image,400, 200);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(3000);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			
		
			this.viewSystem.closeAll();
		}
		
		 /**
	     * initialization variable.
	     *
	     *         
	     */
		
	public int play1() {
		
		for(int i=0;i<120;i++)
			for(int j=0; j<80;j++) board[i][j]=0;
		
		win="";
		
		long startTime = System.currentTimeMillis();
		this.gameLoop();
		int ret=0;

		if(this.isGameOver) ret = 0;
		 
		if(this.isNextLevel) ret = 1;
       


        long exTime = System.currentTimeMillis() - startTime;
        
        int temps = (int) (exTime/1000);

        System.out.println("temps : " + exTime/1000);
        System.out.println("le gagnant est : " + win);
        
       this.dogfightModel.InsertScore(win, temps);
        
        this.viewSystem.displayMessage("le gagnant est : " + win + " en " + exTime/1000 + "s");
		
		try {
			Thread.sleep(2000);
		} catch (final InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		this.viewSystem.closeAll();
		
		return ret;
	}

	int tX = 0;
	int tY = 0;
	
	 /**
     * gameLoop.
     *
     *         
     */
	
	
	private void gameLoop() {
		IMobile lorann = this.dogfightModel.getMobileByPlayer(0);
		
		while (!this.isGameOver && !this.isNextLevel) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
			for (final IMobile mobile : this.dogfightModel.getMobiles()) {
				initialMobiles.add(mobile);
			}
			for (final IMobile mobile : initialMobiles) {
	
				if (mobile.isMonster()) {
					if(!this.manageCollisionMonster(mobile)) { 
						
						tY=mobile.getPosition().getY() ;
						tX=mobile.getPosition().getX() ;						
					
						
						this.viewSystem.afficheRectangle(tX, tY, 5, 5, 1);
						board[tX/5][tY/5]=1;		
						
					} // 
					else
						win="player1";
					mobile.move();
					
					tY=mobile.getPosition().getY() ;
					tX=mobile.getPosition().getX() ;
					if( board[tX/5][tY/5]==1) {this.isGameOver = true; win="player1";}
				}
				
				
				if (mobile.isLorann()) {
					if(!this.manageCollisionLorann(mobile)) { 

						tY=mobile.getPosition().getY() ;
						tX=mobile.getPosition().getX() ;						
					
						
						this.viewSystem.afficheRectangle(tX, tY, 5, 5, 0);
						board[tX/5][tY/5]=1;
						
						
					} 
					else
						win="player0";
					mobile.move();
					
					tY=mobile.getPosition().getY() ;
					tX=mobile.getPosition().getX() ;
					if( board[tX/5][tY/5]==1) {this.isGameOver = true;win="player0";}
					
					
				} 
				
			}
			this.dogfightModel.setMobilesHavesMoved();
		}
	}
	
	
	 /**
     * set the view .
     *
     * @param view the view
     *            
     * 
     *         
     */

	public void setViewSystem(final IViewSystem viewSystem) {
		this.viewSystem = viewSystem;
	}
}
