package button;

import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import logic.GameLogic;
import screen.GameScreen;

public class PlayButton extends MyBaseButton {

	public PlayButton() {
		super();
		pictureURL = ClassLoader.getSystemResource("play.png").toString();
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
				if (GameLogic.getInstance().getRedTank().die() || GameLogic.getInstance().getGreenTank().die()) {
					GameLogic.getInstance().startNewGame();
					GameScreen.scene.setRoot(GameScreen.get());
				} else {
					GameLogic.getInstance().resumeGame();
				}
			}
		});
		
	}
	
}
