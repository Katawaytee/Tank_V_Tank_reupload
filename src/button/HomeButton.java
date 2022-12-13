package button;

import screen.GameScreen;
import screen.HomeScreen;

public class HomeButton extends MyBaseButton {
	
	private static String pictureURL = ClassLoader.getSystemResource("icon/home.png").toString();
	
	public HomeButton() {
		super(50,50,pictureURL);
		
	}

	@Override
	public void handleOnMouseClicked() {
		GameScreen.scene.setRoot(HomeScreen.get());
	}
	
}
