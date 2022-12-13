package button;

import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import logic.GameLogic;

public class PauseButton extends MyBaseButton {

	public PauseButton() {
		super();
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
				setEffect(null);
				GameLogic.getInstance().pauseGame();
			}
		});
		
	}
	
}
