package button;

import logic.GameLogic;
import screen.GameScreen;
import screen.HomeScreen;

public class StartButton extends MyBaseButton {
	

	private static String pictureURL = ClassLoader.getSystemResource("icon/play.png").toString();
	
	public StartButton(int width,int height) {
		super(width,height,pictureURL);
		
	}
	
	
	
	@Override
	public void handleOnMouseClicked() {
		// TODO Auto-generated method stub
		GameLogic.getInstance().startNewGame();
		GameScreen.scene.setRoot(GameScreen.get());
		HomeScreen.get().stopBackgroundMusic();
	}
}
