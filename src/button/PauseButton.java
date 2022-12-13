package button;

import logic.GameLogic;

public class PauseButton extends MyBaseButton {
	
	private static String pictureURL = ClassLoader.getSystemResource("icon/pause.png").toString();
	
	public PauseButton() {
		super(80,80,pictureURL);
	}

	@Override
	public void handleOnMouseClicked() {
		setEffect(null);
		GameLogic.getInstance().pauseGame();	
	}
	
}
