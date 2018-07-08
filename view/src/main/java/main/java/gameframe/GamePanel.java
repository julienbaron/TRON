package gameframe;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * <h1>The Class gamepanel panel of the game.</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */
class GamePanel extends JPanel implements Observer {
	private static final long				serialVersionUID	= 3987064896591403626L;
	private final IGraphicsBuilder	graphicsBuilder;
	
	/**
     * constructor
     * 
     *@param graphicsBuilder the graphicsBuilder
     *          
     */

	public GamePanel(final IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}
	
	/**
     * Update
     * 
     *@param arg 0
     *@param arg 1
     *          
     */

	@Override
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	
	/**
     * paintcompomnent 
     * 
     *@param graphics the graphics
     *          
     */

	@Override
	protected void paintComponent(final Graphics graphics) {
		this.graphicsBuilder.applyModelToGraphic(graphics, this);
	}

}
