package button;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class MyBaseButton extends StackPane {

	protected String pictureURL;
	protected Circle circle;
	
	public MyBaseButton() {
		super();
		setWidth(50);
		setHeight(50);
		setAlignment(Pos.CENTER);
	}
	
	protected void addPicture() {
		Canvas canvas = new Canvas(50,50);
		Image image = new Image(pictureURL);
		canvas.getGraphicsContext2D().drawImage(image,0,0,50,50);
		getChildren().add(canvas);
	}
	
	protected void addCircle() {
		circle = new Circle(25,Color.TRANSPARENT);
		getChildren().add(circle);
	}
	
	public abstract void addListener();
	
}
