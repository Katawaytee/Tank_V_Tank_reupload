package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;

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
		x += Math.cos(Math.toRadians(angle)) * speed;
		y += Math.sin(Math.toRadians(angle)) * speed;
	}
	
	private void collide(Tank tank) {
		destroyed = true;
		tank.hitByBullet();
	}
	
	private void draw(GraphicsContext gc) {
		gc.setFill(color);
		double radius = 20;
		gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	public void update() {
		draw(GameLogic.getInstance().getGameCanvas().getGraphicsContext2D());
	}
	
}
