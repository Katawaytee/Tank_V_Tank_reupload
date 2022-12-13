package button;

import javafx.application.Platform;

public class ExitButton extends MyBaseButton {
	
	private static String pictureURL = ClassLoader.getSystemResource("icon/exit.png").toString();
	
	public ExitButton() {
		super(50,50,pictureURL);
	}

	@Override
	public void handleOnMouseClicked() {
		// TODO Auto-generated method stub
		Platform.exit();
	}
	
}
