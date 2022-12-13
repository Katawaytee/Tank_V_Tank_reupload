package button;

import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import screen.GameScreen;
import screen.HomeScreen;

public class HomeButton extends MyBaseButton {

	public HomeButton() {
		super();
		pictureURL = ClassLoader.getSystemResource("home.png").toString();
		addPicture();
		addCircle();
	}
	
	@Override
	public void addListener() {
		
		circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(new Glow());
			}
		});
		
		circle.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
		
		circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				StackPane newRoot = new StackPane();
				newRoot.getChildren().add(new HomeScreen(1080, 720));
				GameScreen.scene.setRoot(newRoot);
			}
		});
		
	}
	
}
