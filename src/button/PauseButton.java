package button;

import logic.GameLogic;

public class PauseButton extends MyBaseButton {

	public PauseButton() {
		super();
		pictureURL = ClassLoader.getSystemResource("").toString();
		addPicture();
		addListener();
	}
	
	@Override
	protected void addListener() {
		GameLogic.getInstance().pauseGame();
	}
	
}
