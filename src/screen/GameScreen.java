package screen;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import logic.GameLogic;

public class GameScreen extends StackPane {

	private final String backgroundURL;
	public static final String greenTankURL = ClassLoader.getSystemResource("").toString();
	public static final String redTankURL = ClassLoader.getSystemResource("").toString();
	private Canvas gameCanvas;
	
	public GameScreen() {
		super();
		backgroundURL = ClassLoader.getSystemResource("").toString();
		createBackground();
		gameCanvas = GameLogic.getInstance().getGameCanvas();
		getChildren().add(gameCanvas);
	}
	
	private void createBackground() {
		ImageView background = new ImageView(new Image(backgroundURL));
		background.setPreserveRatio(true);
		background.setFitWidth(1080);
		getChildren().add(background);
	}
	
}
