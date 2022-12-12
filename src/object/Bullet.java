package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet extends Entity {

	private boolean destroyed;
	private Color color;
	
	public Bullet(double x, double y, int angle, Color color) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		speed = 15;
		this.color = color;
		destroyed = false;
	}
	
	public void move(boolean forward) {
		
	}
	
	public void collide(Tank tank) {
		
	}
	
	public void draw(GraphicsContext gc) {
		
	}
	
	public void update() {
		
	}
	
}
