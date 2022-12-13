package button;

import logic.GameLogic;
import screen.GameScreen;

public class PlayButton extends MyBaseButton {

	private static String pictureURL = ClassLoader.getSystemResource("icon/play.png").toString();
	
	public PlayButton(int width,int height) {
		super(width,height,pictureURL);
		
	}
	
	@Override
	public void handleOnMouseClicked() {
		// TODO Auto-generated method stub
		if (GameLogic.getInstance().getRedTank().die() || GameLogic.getInstance().getGreenTank().die()) {
			GameLogic.getInstance().startNewGame();
			GameScreen.scene.setRoot(GameScreen.get());
		} else {
			GameLogic.getInstance().resumeGame();
		}
	}
	
}
