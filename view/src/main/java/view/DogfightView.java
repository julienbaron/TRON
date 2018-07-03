package view;

import java.awt.image.BufferedImage;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import model.IDogfightModel;
import gameframe.GameFrame;

public class DogfightView implements IViewSystem, Runnable {
	private final GraphicsBuilder	graphicsBuilder;
	private final EventPerformer	eventPerformer;
	private final Observable			observable;
	private GameFrame							gameFrame;

	public DogfightView(final IOrderPerformer orderPerformer, final IDogfightModel dogfightModel, final Observable observable) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(dogfightModel);
		this.eventPerformer = new EventPerformer(orderPerformer);
		SwingUtilities.invokeLater(this);
	}

	@Override
	public void run() {
		this.gameFrame = new GameFrame("Dogfight", this.eventPerformer, this.graphicsBuilder, this.observable);
	}

	@Override
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}

	@Override
	public void closeAll() {
		this.gameFrame.dispose();
		
	}

	@Override
	public void afficheImage(BufferedImage image, int x, int y) {
		// TODO Auto-generated method stub
		this.graphicsBuilder.afficheImage(image, x, y);
	}

	@Override
	public void afficheRectangle(int x, int y, int tailleX, int tailleY, int couleur) {
		// TODO Auto-generated method stub
		this.graphicsBuilder.afficheRectangle(x, y, tailleX, tailleY, couleur);
	}

	
}
