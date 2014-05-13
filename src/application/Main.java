// Rachael Colley 2014
// Space Invaders Assignment Part 1.
// Provided implementation.

// Your name and student number here <-- <-- <--

package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;


public class Main extends Application {


	// Attributes of this class.
	private final String MY_NAME_AND_STUDENT_NUMBER = "Rachael Colley 007"; // <-- change this to you <-- <-- <--
	private FlowPane rootLayout;
	private Canvas drawingCanvas;
	private GraphicsContext graphicsObject;
	private Scene scene;

	private final double CANVAS_WIDTH = 500;
	private final double CANVAS_HEIGHT = 500;

	private final int GAME_ASSET_WIDTH_DIVISOR = 20;
	private final double GAME_ASSET_HEIGHT_PERCENTAGE = 0.75;

	private SpaceShip spaceShip;
	private Alien[] alienList;
	private ArrayList<Projectile> projectileList;
	private int playerScore;

	// used by aliens and spaceship.
	private double gameAssetWidth;
	private double gameAssetHeight;



	@Override
	public void start(Stage primaryStage) {
		// Implementation provided. No need to alter.

		try {
			rootLayout = new FlowPane();
			drawingCanvas = new Canvas(CANVAS_WIDTH,CANVAS_HEIGHT);
			graphicsObject = drawingCanvas.getGraphicsContext2D();
			rootLayout.getChildren().add(drawingCanvas);
			scene = new Scene(rootLayout,CANVAS_WIDTH,CANVAS_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


			initialise(); 
			gameLoop(); 


			primaryStage.setTitle(MY_NAME_AND_STUDENT_NUMBER);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}




	public void initialise() {
		// Implementation provided. No need to alter.
		playerScore = 0;
		gameAssetWidth = 0;
		gameAssetHeight = 0;
		initialiseGameAssetDimensions();
		initialiseSpaceShipPosition();
		initialiseAlienFleetPosition();
		initialiseProjectileList();
		addEventHandlers();
	}




	public void initialiseGameAssetDimensions() {
		// Required.
	}




	public void initialiseSpaceShipPosition() {
		// Required.
	}




	public double makeMiddleXCoord() {
		// Required.
		return 0;
	}




	public void initialiseAlienFleetPosition() {
		// Implementation not required for part 1.
		alienList = new Alien[15];

	}




	public void initialiseProjectileList() { 
		// Implementation provided. No need to alter.
		projectileList = new ArrayList<Projectile>();
	}





	public void gameLoop() {
		// Implementation provided. No need to alter.
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {

				draw();
				update();
				checkForCollision();

				placeHolderAnimation(); // <-- REMOVE THIS LINE <-- <--

			}

		};

		timer.start();
		
	}




	public void draw() {
		// Implementation provided. No need to alter.
		graphicsObject.setFill(Color.WHITE);
		graphicsObject.fillRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT);
		drawSpaceShip();
		drawAliens();
		drawProjectiles();
	}




	public void update() {
		// Implementation provided. No need to alter.
		updateAlienFleetPosition();
		updateProjectiles();
	}




	public void checkForCollision() {
		// Implementation provided. No need to alter.
		detectProjectileCollisionWithAlien();
		detectProjectileCollisionWithSpaceship();
	}




	public void drawSpaceShip() {
		// Required.
	}




	public void drawAliens() {
		// Implementation not required for part 1.
	}




	public void drawProjectiles() {
		// Implementation provided. No need to alter.
		graphicsObject.setFill(Color.BLACK);
		for (int x = 0; x < projectileList.size(); x ++ ) {
			Projectile currentProjectile = projectileList.get(x);
			graphicsObject.fillRect(currentProjectile.getCurrentX(), 
					currentProjectile.getCurrentY(), 
					currentProjectile.getWidth(), 
					currentProjectile.getHeight());
		}
	}




	public void updateAlienFleetPosition() {
		// Implementation not required for part 1.
	}




	public void updateProjectiles() {
		// Implementation provided. No need to alter.
		Iterator<Projectile> i = projectileList.iterator();
		while (i.hasNext()) {
			Projectile currentProjectile = i.next();
			double axisLength = CANVAS_HEIGHT;
			double travelIncrement = currentProjectile.getTravelRate() * axisLength;
			currentProjectile.setCurrentY(currentProjectile.getCurrentY() - travelIncrement);
			if (currentProjectile.getCurrentY() <= 0) {
				i.remove();
				System.out.println("projectileList size: " + projectileList.size());
			} 
		}
	}




	public void addEventHandlers() {
		// Required.
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {

				if (ke.getCode() == KeyCode.SPACE) {
					System.out.println("Shoot from here");
					// Here...

				} else if (ke.getCode() == KeyCode.RIGHT) {
					System.out.println("Move east from here");
					// Here...

				} else if (ke.getCode() == KeyCode.LEFT) {
					System.out.println("Move west from here");
					// Here...

				} 

			}

		});

	}





	public boolean checkForWestEdge(double currentXCoord) {
		// Required.

		return false;
	}





	public boolean checkForEastEdge(double currentXCoord, double widthToCheck) {
		// Required.

		return false;
	}





	public void updateSpaceShipPosition(String direction) {
		// Required.
	}





	public void fireProjectile() {
		// Required.
	}




	public void addNewProjectile(double x, double y) {
		// Implementation provided. No need to alter.
		projectileList.add(new Projectile(x,y));
		System.out.println("projectileList size: " + projectileList.size());
	}




	public void updatePlayerScore() {
		// Implementation not required for part 1.
	}




	public void detectProjectileCollisionWithAlien() {
		// Implementation not required for part 1.
	}




	public void detectProjectileCollisionWithSpaceship() {
		// Implementation not required for part 1.
	}




	public void gameOver() {
		// Implementation not required for part 1.
	}




	public static void main(String[] args) {
		// Implementation provided. No need to alter.
		launch(args);
	}




	// Placeholder animation. Locate the statement in gameloop() to remove it.
	private List<Projectile> northAnimList = new ArrayList<Projectile>();
	private List<Projectile> southAnimList = new ArrayList<Projectile>();
	public void placeHolderAnimation() {
		graphicsObject.setFill(Color.BLACK);
		graphicsObject.fillRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT);
		int offset = (int) (CANVAS_WIDTH / 20);
		if (northAnimList.size() == 0) {
			double xCoord = offset;
			double yCoord = CANVAS_HEIGHT;
			for (int x = 0; x < 10; x ++ ) {
				Projectile p = new Projectile(xCoord,yCoord);
				northAnimList.add(p);
				xCoord += (CANVAS_WIDTH / 10);
			}
		}
		if (southAnimList.size() == 0) {
			double xCoord = offset;
			double yCoord = 0;
			for (int x = 0; x < 10; x ++ ) {
				Projectile p = new Projectile(xCoord,yCoord);
				southAnimList.add(p);
				xCoord += (CANVAS_WIDTH / 10);
			}
		}
		for (int x = 0; x < northAnimList.size(); x ++ ) {
			Projectile p = northAnimList.get(x);
			graphicsObject.setFill(Color.CHARTREUSE);
			graphicsObject.fillOval(p.getCurrentX(), p.getCurrentY(), p.getWidth(), p.getHeight());
		}
		for (int x = 0; x < southAnimList.size(); x ++ ) {
			Projectile p = southAnimList.get(x);
			graphicsObject.setFill(Color.CHARTREUSE);
			graphicsObject.fillOval(p.getCurrentX(), p.getCurrentY(), p.getWidth(), p.getHeight());
		}
		Iterator<Projectile> northIterator = northAnimList.iterator();
		while (northIterator.hasNext()) {
			Projectile p = northIterator.next();
			p.setCurrentY(p.getCurrentY() - ((p.getTravelRate() * CANVAS_HEIGHT)/2));
			if (p.getCurrentY() <= 0) {
				northIterator.remove();
			} 
		}
		Iterator<Projectile> southIterator = southAnimList.iterator();
		while (southIterator.hasNext()) {
			Projectile p = southIterator.next();
			p.setCurrentY(p.getCurrentY() + ((p.getTravelRate() * CANVAS_HEIGHT)/2));
			if (p.getCurrentY() >= CANVAS_HEIGHT) {
				southIterator.remove();
			} 
		}
	}





} // End class.
