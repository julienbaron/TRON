package view;

import java.awt.image.BufferedImage;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import model.IDogfightModel;
import gameframe.GameFrame;

/**
 * <h1>The Class View .</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */

public class DogfightView implements IViewSystem, Runnable {
	private final GraphicsBuilder	graphicsBuilder;
	private final EventPerformer	eventPerformer;
	private final Observable			observable;
	private GameFrame							gameFrame;

	/**
     * constructor
     * 
     *@param orderPerformer the orderPerformer
     *@param Model the Model
     *@param observable the observable 
     */
	public DogfightView(final IOrderPerformer orderPerformer, final IDogfightModel dogfightModel, final Observable observable) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(dogfightModel);
		this.eventPerformer = new EventPerformer(orderPerformer);
		SwingUtilities.invokeLater(this);
	}
	
	/**
     * run
     * 
     */

	@Override
	public void run() {
		this.gameFrame = new GameFrame("TRON", this.eventPerformer, this.graphicsBuilder, this.observable);
	}
	
	/**
     * displayMessage
     * 
     */


	@Override
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	/**
     * closeAll
     * 
     */

	@Override
	public void closeAll() {
		this.gameFrame.dispose();
		
	}
	
	/**
     * afficheImage 
     * 
     * @param image 
     * @param x
     * @param y
     */
	
	@Override
	public void afficheImage(BufferedImage image, int x, int y) {
		// TODO Auto-generated method stub
		this.graphicsBuilder.afficheImage(image, x, y);
	}
	
	/**
     * afficheRectangle
     * 
     * @param x
     * @param y
     * @param tailleX
     * @param tailleY
     * @param couleur 
     */

	@Override
	public void afficheRectangle(int x, int y, int tailleX, int tailleY, int couleur) {
		// TODO Auto-generated method stub
		this.graphicsBuilder.afficheRectangle(x, y, tailleX, tailleY, couleur);
	}

	
}
