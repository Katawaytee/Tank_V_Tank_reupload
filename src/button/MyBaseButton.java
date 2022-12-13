package button;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public abstract class MyBaseButton extends Canvas {

	protected String pictureURL;
	
	public MyBaseButton() {
		super(50,50);
	}
	
	protected void addPicture() {
		Image image = new Image(pictureURL);
		getGraphicsContext2D().drawImage(image,0,0,50,50);
	}
	
	protected abstract void addListener();
	
}
