package button;

import screen.GameScreen;
import screen.HomeScreen;

public class HomeButton extends MyBaseButton {
	
	private static String pictureURL = ClassLoader.getSystemResource("icon/home.png").toString();
	
	public HomeButton(int width,int height) {
		super(width,height,pictureURL);
		
	}

	@Override
	public void handleOnMouseClicked() {
		GameScreen.scene.setRoot(HomeScreen.get());
	}
	
}
