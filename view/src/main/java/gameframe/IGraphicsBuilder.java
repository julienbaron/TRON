package gameframe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public interface IGraphicsBuilder {
	public void applyModelToGraphic(Graphics graphics, ImageObserver observer);

	public int getGlobalWidth();

	public int getGlobalHeight();
	
	public void afficheImage(BufferedImage image, int x, int y);
	
	public void afficheRectangle(int x, int y, int tailleX, int tailleY, int couleur);
	
}
