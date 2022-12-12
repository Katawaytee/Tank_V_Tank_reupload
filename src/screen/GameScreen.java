package screen;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import logic.GameLogic;

public class GameScreen extends StackPane {

	private final String backgroundURL;
	public static final String greenTankURL = ClassLoader.getSystemResource("").toString();
	public static final String redTankURL = ClassLoader.getSystemResource("").toString();
	private Canvas gameCanvas;
	private AnchorPane buttonPane;
	public static String keyPressed;
	public static boolean isPressingKey;
	
	public GameScreen() {
		super();
		backgroundURL = ClassLoader.getSystemResource("").toString();
		createBackground();
		gameCanvas = GameLogic.getInstance().getGameCanvas();
		getChildren().add(gameCanvas);
		createButtonPane();
		addListener();
		setFocused(true);
	}
	
	private void createBackground() {
		ImageView background = new ImageView(new Image(backgroundURL));
		background.setPreserveRatio(true);
		background.setFitWidth(1080);
		getChildren().add(background);
	}
	
	private void createButtonPane() {
		buttonPane = new AnchorPane();
		Button pauseButton = new Button();
		pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		buttonPane.getChildren().add(pauseButton);
		AnchorPane.setTopAnchor(pauseButton,120.0);
		AnchorPane.setLeftAnchor(pauseButton,440.0);
		getChildren().add(buttonPane);
	}
	
	private void addListener() {
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				GameScreen.keyPressed = event.getCode().toString();
				GameScreen.isPressingKey = true;
			}
		});
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				GameScreen.isPressingKey = false;
			}
		});
		
	}
	
}
