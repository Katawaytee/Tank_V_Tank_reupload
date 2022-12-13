package button;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;

public class ExitButton extends MyBaseButton {

	public ExitButton() {
		super();
		pictureURL = ClassLoader.getSystemResource("").toString();
		addPicture();
		addCircle();
		addListener();
	}

	@Override
	protected void addListener() {
		
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
				Platform.exit();
			}
		});
		
	}
	
}
