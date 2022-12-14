package button;

import screen.GameScreen;
import screen.TutorialScreen;

public class TutorialButton extends MyBaseButton {
	

	private static String pictureURL = ClassLoader.getSystemResource("icon/questionmark.png").toString();
	
	public TutorialButton(int width,int height) {
		super(width,height,pictureURL);
		
	}
	
	@Override
	public void handleOnMouseClicked() {
		// TODO Auto-generated method stub
		GameScreen.scene.setRoot(TutorialScreen.get());
	}
}