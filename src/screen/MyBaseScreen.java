package screen;

import javafx.scene.layout.StackPane;

public abstract class MyBaseScreen extends StackPane{
	private final static int WINDOW_WIDTH = 1080;
	private final static int WINDOW_HEIGHT = 720;
	
	public MyBaseScreen() {
		// TODO Auto-generated constructor stub
		super();
		setWidth(WINDOW_WIDTH);
		setHeight(WINDOW_HEIGHT);
	}

	public static int getWindowWidth() {
		return WINDOW_WIDTH;
	}

	public static int getWindowHeight() {
		return WINDOW_HEIGHT;
	}
	
}
