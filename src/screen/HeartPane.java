package screen;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class HeartPane extends AnchorPane {

	Canvas greenHeartCanvas;
	Canvas redHeartCanvas;
	
	public HeartPane() {
		super();
		setWidth(1080);
		setHeight(720);
		greenHeartCanvas = createHeartCanvas();
		redHeartCanvas = createHeartCanvas();
		getChildren().addAll(greenHeartCanvas, redHeartCanvas);
		AnchorPane.setTopAnchor(greenHeartCanvas, 20.0);
		AnchorPane.setTopAnchor(redHeartCanvas, 20.0);
		AnchorPane.setLeftAnchor(greenHeartCanvas, 20.0);
		AnchorPane.setRightAnchor(redHeartCanvas, 20.0);
	}
	
	private Canvas createHeartCanvas() {
		Canvas canvas = new Canvas(160,60);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		String heartURL =  ClassLoader.getSystemResource("heart.png").toString();
		Image heartImage = new Image(heartURL);
		gc.drawImage(heartImage, 0, 5, 50, 50);
		gc.drawImage(heartImage, 55, 5, 50, 50);
		gc.drawImage(heartImage, 110, 5, 50, 50);
		return canvas;
	}
	
	public void removeHeart(String color, int life) {
		if (color.equals("green")) {
			GraphicsContext gc = greenHeartCanvas.getGraphicsContext2D();
			gc.clearRect(life * 55, 0, 50, 60);
		} else {
			GraphicsContext gc = redHeartCanvas.getGraphicsContext2D();
			gc.clearRect(-(life - 2) * 55, 0, 50, 60);
		}
	}
	
}