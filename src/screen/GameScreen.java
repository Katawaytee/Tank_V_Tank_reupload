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
import javafx.scene.layout.StackPane;
import logic.GameLogic;

public class GameScreen extends StackPane {

	private static GameScreen gameScreen = null;
	private final String backgroundURL;
	public static final String greenTankURL = ClassLoader.getSystemResource("greenTank.png").toString();
	public static final String redTankURL = ClassLoader.getSystemResource("redTank.png").toString();
	private Canvas gameCanvas;
	private AnchorPane buttonPane;
	private HeartPane heartPane;
	public static ArrayList<String> keyPressed = new ArrayList<String>();
	public static boolean isPressingKey;
	public static Scene scene;
	
	private GameScreen() {
		super();
		setWidth(1080);
		setHeight(720);
		backgroundURL = ClassLoader.getSystemResource("grassBackground.jpg").toString();
		createBackground();
		gameCanvas = GameLogic.getInstance().getGameCanvas();
		gameCanvas.setVisible(true);
		getChildren().add(gameCanvas);
		heartPane = new HeartPane();
		getChildren().add(heartPane);
		createButtonPane();
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
	
	private void createBackground() {
		ImageView background = new ImageView(new Image(backgroundURL));
		background.setPreserveRatio(true);
		background.setFitWidth(1500);
		getChildren().add(background);
	}
	
	private void createButtonPane() {
		buttonPane = new AnchorPane();
		PauseButton pauseButton = new PauseButton();
		buttonPane.getChildren().add(pauseButton);
		AnchorPane.setTopAnchor(pauseButton,20.0);
		AnchorPane.setLeftAnchor(pauseButton,515.0);
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
				GameScreen.isPressingKey = false;
			}
		});
		
	}

	public HeartPane getHeartPane() {
		return heartPane;
	}
	
}
