package button;

import javafx.application.Platform;

public class ExitButton extends MyBaseButton {
	
	private static String pictureURL = ClassLoader.getSystemResource("icon/exit.png").toString();
	
	public ExitButton(int width,int height) {
		super(width,height,pictureURL);
		
	}

	@Override
	public void handleOnMouseClicked() {
		// TODO Auto-generated method stub
		Platform.exit();
	}
	
}
