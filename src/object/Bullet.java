package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;

public class Bullet extends Entity {

	private boolean destroyed;
	private Color color;
	private double distanceTravelled;
	private Tank anotherTank;
	
	public Bullet(double x, double y, int angle, Tank anotherTank) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		speed = 15;
		this.anotherTank = anotherTank;
		if (this.anotherTank.getColor().equals("green")) {
			color = Color.RED;
		} else {
			color = Color.GREEN;
		}
		distanceTravelled = 0;
		destroyed = false;
	}
	
	public void move(boolean forward) {
		double dx = Math.cos(Math.toRadians(angle)) * speed;
		double dy = Math.sin(Math.toRadians(angle)) * speed;
		x += dx;
		y += dy;
		distanceTravelled += Math.hypot(dx,dy);
	}
	
	private void collide(Tank tank) {
		destroyed = true;
		tank.hitByBullet(GameLogic.getInstance().getGameCanvas().getGraphicsContext2D());
	}
	
	private void draw(GraphicsContext gc) {
		gc.setFill(color);
		double radius = 5;
		gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	public void update() {
		if (destroyed) {
			return;
		} else if (isCollide()) {
			collide(anotherTank);
			return;
		} else if (distanceTravelled >= 300) {
			destroyed = true;
			return;
		}
		move(true);
		draw(GameLogic.getInstance().getGameCanvas().getGraphicsContext2D());
	}
	
	private boolean isCollide() {
		double dx = x - anotherTank.x;
		double dy = y - anotherTank.y;
		double dRadian = Math.atan(dy / dx) % 0.78 ;
		double minDistanceBetween = 38.5 / Math.cos(dRadian);
		double currentDistanceBetween = Math.hypot(Math.abs(dx), Math.abs(dy));
		if (currentDistanceBetween <= minDistanceBetween) {
			return true;
		}
		return false;
	}
	
}
