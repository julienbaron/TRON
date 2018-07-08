package model;

import java.io.File;

import javafx.scene.media.AudioClip;

/**
 * class to play music in background
 * 
 * @author 
 *@version 1.0
 *
 */
@SuppressWarnings("restriction")
public class Music
{
	public Music()
	{
		AudioClip aC = new AudioClip(new File("musico.mp3").toURI().toString());
		aC.setVolume(0.15);
		aC.play();
	}
}