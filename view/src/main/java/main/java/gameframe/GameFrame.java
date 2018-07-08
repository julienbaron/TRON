package gameframe;

import java.awt.HeadlessException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;

/**
 * <h1>The Class gameframe initialization screen.</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */

public class GameFrame extends JFrame implements KeyListener {
	private static final long			serialVersionUID	= -1112124206501543946L;
	private final IEventPerformer	eventPerformer;
	
	/**
     * constructor
     * 
     *@param title
     *@param eventPerformer the eventPerformer
     *@param eventPerformer the GraphicsBuilder
     *@param observable the observable  
     *          
     */

	public GameFrame(final String title, final IEventPerformer eventPerformer, final IGraphicsBuilder graphicsBuilder, final Observable observable)
			throws HeadlessException {
		this.eventPerformer = eventPerformer;

		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setVisible(true);

		final GamePanel gamePanel = new GamePanel(graphicsBuilder);
		this.setContentPane(gamePanel);
		this.setSize(graphicsBuilder.getGlobalWidth() + this.getInsets().left + this.getInsets().right,
				graphicsBuilder.getGlobalHeight() + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
		observable.addObserver(gamePanel);

		this.setVisible(true);
	}
	
	/**
     * keyPressed
     * 
     *@param KeyEvent the KeyEvent 
     *          
     */

	@Override
	public void keyPressed(final KeyEvent keyEvent) {
		this.eventPerformer.eventPerform(keyEvent);
	}
	

	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		//this.eventPerformer.eventPerform(keyEvent);
		

	}

	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub

	}

}
