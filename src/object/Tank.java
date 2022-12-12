package object;

import javafx.scene.canvas.GraphicsContext;

public class Tank extends Entity {
	
	private int life;
	
	public Tank(double x, double y) {
		this.x = x;
		this.y = y;
		angle = 0;
		speed = 5;
		life = 3;
	}

	public void move(boolean forward) {
		if (forward) {
			x += Math.cos(Math.toRadians(angle)) * speed;
			y += Math.sin(Math.toRadians(angle)) * speed;
		} else {
			x -= Math.cos(Math.toRadians(angle)) * speed;
			y -= Math.sin(Math.toRadians(angle)) * speed;
		}
	}

	private void turn(boolean left) {
		if (left) {
			angle -= 3;
			if (angle < 0)
				angle += 360;
		} else {
			angle += 3;
			if (angle >= 360)
				angle -= 360;
		}
	}
	
	public void hitByBullet() {
		life--;
	}
	
	public void draw(GraphicsContext gc) {
		
	}
	
	public void update() {
		
	}
	
}
