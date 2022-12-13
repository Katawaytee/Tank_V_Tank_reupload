package button;

import javafx.scene.canvas.Canvas;

public abstract class MyBaseButton extends Canvas {

	protected String pictureURL;
	
	public MyBaseButton() {
		super(50,50);
	}
	
	protected abstract void addListener();
	
}
