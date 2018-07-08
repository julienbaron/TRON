package main;

import java.awt.event.KeyEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import controller.DogfightController;
import controller.Order;
import controller.UserOrder;
import model.Dimension;
import model.Direction;
import model.DogfightModel;
import model.Lorann;
import model.Monster_1;
import model.Position;
import view.DogfightView;
import model.Music;

/**
 * <h1>The Class main initialization of controller view model.</h1>
 *
 * @author Julien Baron.
 * @version 1.0
 */



public abstract class Jpu2016Dogfight {
	
	
	static int level_number = 1;
	static int level_number_max = 1;
	
	public static void main(final String[] args) {

		final DogfightModel dogfightModelIntro = new DogfightModel();
		final DogfightModel dogfightModelFin = new DogfightModel();
		final DogfightModel dogfightModel = new DogfightModel();

		
		Music music = new Music();
		

		dogfightModelIntro.buildArea(new Dimension(1000, 700));
		



		final DogfightController dogfightControllerIntro = new DogfightController(dogfightModelIntro);
		final DogfightView dogfightViewIntro = new DogfightView(dogfightControllerIntro, dogfightModelIntro, dogfightModelIntro);
		dogfightControllerIntro.setViewSystem(dogfightViewIntro);
		dogfightControllerIntro.intro();
		

		
		int ret = 99;
		
		while (ret != 0 && level_number <= level_number_max)
		{
	
	
			
		dogfightModel.buildArea(new Dimension(600, 400));

		dogfightModel.addMobile(new Monster_1(1, Direction.RIGHT, new Position(0,200), "monster_1"));
		
		dogfightModel.addMobile(new Lorann(0, Direction.LEFT, new Position(595,200), "lorann"));
		
		final DogfightController dogfightController = new DogfightController(dogfightModel);
		final DogfightView dogfightView = new DogfightView(dogfightController, dogfightModel, dogfightModel);
		dogfightController.setViewSystem(dogfightView);
		
		
		ret = dogfightController.play1();
		level_number ++;
		
		}
		
		dogfightModelFin.buildArea(new Dimension(1000, 700));
	
		final DogfightController dogfightControllerFin = new DogfightController(dogfightModelFin);
		final DogfightView dogfightViewFin = new DogfightView(dogfightControllerFin, dogfightModelFin, dogfightModelFin);
		dogfightControllerFin.setViewSystem(dogfightViewFin);
		
		if(ret==0) dogfightControllerFin.gameover();
		
	}
	
	

}
