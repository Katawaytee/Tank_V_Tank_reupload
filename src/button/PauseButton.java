package button;

import logic.GameLogic;

public class PauseButton extends MyBaseButton {
	
	private static String pictureURL = ClassLoader.getSystemResource("icon/pause.png").toString();
	
	public PauseButton(int width,int height) {
		super(width,height,pictureURL);
		addListener();
	}

	@Override
	public void handleOnMouseClicked() {
		GameLogic.getInstance().pauseGame();	
	}
	
}
