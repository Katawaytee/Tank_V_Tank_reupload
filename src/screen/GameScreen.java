package screen;

import java.util.ArrayList;

import button.PauseButton;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import logic.GameLogic;

public class GameScreen extends MyBaseScreen {

	private static GameScreen gameScreen = null;
	private static String backgroundURL = ClassLoader.getSystemResource("background/grassBackground.jpg").toString();
	public static final String greenTankURL = ClassLoader.getSystemResource("icon/greenTank.png").toString();
	public static final String redTankURL = ClassLoader.getSystemResource("icon/redTank.png").toString();
	public static final String bombURL = ClassLoader.getSystemResource("icon/bomb.png").toString();
	private Canvas gameCanvas;
	private AnchorPane buttonPane;
	private HeartPane heartPane;
	public static AudioClip takeShotSound = new AudioClip(ClassLoader.getSystemResource("audio/TakeShot.wav").toString());
	public static AudioClip explosionSound = new AudioClip(ClassLoader.getSystemResource("audio/Explosion.wav").toString());
	public static ArrayList<String> keyPressed = new ArrayList<String>();
	public static boolean isPressingKey;
	public static Scene scene;
	
	private GameScreen() {
		super();
		addBackground();
		gameCanvas = GameLogic.getInstance().getGameCanvas();
		gameCanvas.setVisible(true);
		getChildren().add(gameCanvas);
		heartPane = new HeartPane();
		getChildren().add(heartPane);
		addButtonPane();
		addListener();
		setFocused(true);
	}
	
	public static GameScreen get() {
		if (gameScreen == null) {
			gameScreen = new GameScreen();
		}
		return gameScreen;
	}
	
	public static void resetGameScreen() {
		gameScreen = null;
		GameScreen.get();
	}
	
	private void addBackground() {
		ImageView background = new ImageView(new Image(backgroundURL));
		background.setPreserveRatio(true);
		background.setFitWidth(1500);
		getChildren().add(background);
	}
	
	private void addButtonPane() {
		buttonPane = new AnchorPane();
		PauseButton pauseButton = new PauseButton(80,80);
		buttonPane.getChildren().add(pauseButton);
		AnchorPane.setTopAnchor(pauseButton,20.0);
		AnchorPane.setLeftAnchor(pauseButton,500.0);
		getChildren().add(buttonPane);
	}
	
	private void addListener() {
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (!GameScreen.keyPressed.contains(event.getCode().toString())) {
					GameScreen.keyPressed.add(event.getCode().toString());
				}
				GameScreen.isPressingKey = true;
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				GameScreen.keyPressed.remove(event.getCode().toString());
				if(GameScreen.keyPressed.isEmpty()) {
					GameScreen.isPressingKey = false;
				}
			}
		});
		
	}

	public HeartPane getHeartPane() {
		return heartPane;
	}
	
	
}
