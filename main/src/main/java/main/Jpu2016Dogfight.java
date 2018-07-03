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

public abstract class Jpu2016Dogfight {

	static int level[] = new int[100]; 
	//static String objet[] = new String[100];
	//static int posX[] = new int[100];
	//static int posY[] = new int[100];
	
	
	static int level_number = 1;
	static int level_number_max = 1;
	
	public static void main(final String[] args) {

		final DogfightModel dogfightModelIntro = new DogfightModel();
		final DogfightModel dogfightModelFin = new DogfightModel();
		final DogfightModel dogfightModel = new DogfightModel();
		/*
		try {
			readLevel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		

		dogfightModelIntro.buildArea(new Dimension(1000, 700));
		



		final DogfightController dogfightControllerIntro = new DogfightController(dogfightModelIntro);
		final DogfightView dogfightViewIntro = new DogfightView(dogfightControllerIntro, dogfightModelIntro, dogfightModelIntro);
		dogfightControllerIntro.setViewSystem(dogfightViewIntro);
		dogfightControllerIntro.intro();
		
	    // level 
		
		int ret = 99;
		
		while (ret != 0 && level_number <= level_number_max)
		{
	
/*
			try {
				readLevel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	*/		
			
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
		
		// game over
		if(ret==0) dogfightControllerFin.gameover();
		
	}
	
	public static void readLevel() throws IOException {
		 File file = new File("level/lorann_level_1.csv");
		 FileReader fileReader = new FileReader(file);
		 BufferedReader bufferedReader = new BufferedReader(fileReader);
		 
		 String line;
		 String newLine = System.getProperty("line.separator");
		 String[] tokenizedLine;
		
		 for(int i=0; i<100; i++ ) {
			 level[i]=0 ;
	         	
		 }
		 
		
		 
		
		int j=0;
		while ((line = bufferedReader.readLine()) != null) {
		        tokenizedLine = parse(line);
		        
		        System.out.println(tokenizedLine[0] + "*" + tokenizedLine[1] + "*" + tokenizedLine[2] + "*" + tokenizedLine[3]   );
		       int i =Integer.parseInt(tokenizedLine[0]) ;
		        if (i==level_number) {
		         level[j]=Integer.parseInt(tokenizedLine[0]) ;
		        	
		        
		        j++;
		        }
		       
		    }
		System.out.println("nb objets chargés : " + j );
		   
		
		
	}
	
	private static String[] parse(String line) { // use split or Scanner
	    return line.split(";");
	}

}
