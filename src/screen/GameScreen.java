package screen;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class GameScreen extends StackPane {

	private final String backgroundURL;
	
	public GameScreen() {
		super();
		backgroundURL = ClassLoader.getSystemResource("").toString();
		createBackground();
	}
	
	private void createBackground() {
		ImageView background = new ImageView(new Image(backgroundURL));
		background.setPreserveRatio(true);
		background.setFitWidth(1080);
		getChildren().add(background);
	}
	
}
