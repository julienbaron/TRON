package view;

import java.awt.image.BufferedImage;

/**
 * <h1>The Interface IViewSystem.</h1>
 * 
 * @author Julien BARON 
 * @version 1.0
 */

public interface IViewSystem {
	public void displayMessage(final String message);

	public void closeAll();
	
	public void afficheImage(BufferedImage image, int x, int y);
	
	public void afficheRectangle(int x, int y, int tailleX, int tailleY, int couleur);
}
