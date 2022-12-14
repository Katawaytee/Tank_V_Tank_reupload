package button;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class MyBaseButton extends StackPane {

	private String pictureURL;
	private Circle circle;
	private double width;
	private double height;
	
	public MyBaseButton(double width,double height,String pictureURL) {
		super();
		this.width=width;
		this.height=height;
		this.pictureURL=pictureURL;
		setWidth(width);
		setHeight(height);
		setAlignment(Pos.CENTER);
		setPicture();
		addCircle();
		
	}
	
	
	protected void addCircle() {
		circle = new Circle(width/2,Color.TRANSPARENT);
		getChildren().add(circle);
	}
	
	private void setPicture() {
		Canvas canvas = new Canvas(width,height);
		Image image = new Image(pictureURL);
		canvas.getGraphicsContext2D().drawImage(image,0,0,width,height);
		getChildren().add(canvas);
	}
	
	public abstract void handleOnMouseClicked();
	
	public void addListener() {
		circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				circle.setCursor(Cursor.HAND);
				setEffect(new Glow());
			}
		});
		
		circle.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
		
		circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handleOnMouseClicked();
			}
		});
	};
	
}
