package screen;

import java.util.ArrayList;

import button.PauseButton;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
	public static final String greenTankURL = ClassLoader.getSystemResource("").toString();
	public static final String redTankURL = ClassLoader.getSystemResource("").toString();
	private Canvas gameCanvas;
	private AnchorPane buttonPane;
	public static ArrayList<String> keyPressed;
	public static boolean isPressingKey;
	
	private GameScreen() {
		super();
		setWidth(1080);
		setHeight(720);
		backgroundURL = ClassLoader.getSystemResource("").toString();
		createBackground();
		gameCanvas = GameLogic.getInstance().getGameCanvas();
		getChildren().add(gameCanvas);
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
	
	private void createBackground() {
		ImageView background = new ImageView(new Image(backgroundURL));
		background.setPreserveRatio(true);
		background.setFitWidth(1080);
		getChildren().add(background);
	}
	
	private void createButtonPane() {
		buttonPane = new AnchorPane();
		PauseButton pauseButton = new PauseButton();
		buttonPane.getChildren().add(pauseButton);
		AnchorPane.setTopAnchor(pauseButton,120.0);
		AnchorPane.setLeftAnchor(pauseButton,440.0);
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
	
	public static void addChildren(Node node) {
		
	}
	
}
