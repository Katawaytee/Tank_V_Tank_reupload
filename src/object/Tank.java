package object;

public class Tank extends Entity {

	public Tank(double x, double y) {
		this.x = x;
		this.y = y;
		this.angle = 0;
		this.speed = 5;
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

}
