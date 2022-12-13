package object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GameLogic;
import screen.GameScreen;

public class Tank extends Entity {

	private int life;
	private String color;
	private Image tankImage;

	public Tank(double x, double y, String color) {
		this.x = x;
		this.y = y;
		angle = 0;
		speed = 5;
		life = 3;
		this.color = color;
		if (this.color.equals("green")) {
			tankImage = new Image(GameScreen.greenTankURL);
		} else if (color.equals("red")) {
			tankImage = new Image(GameScreen.redTankURL);
		}
	}

	public void move(boolean forward) {
		if (forward) {
			y -= Math.cos(Math.toRadians(angle)) * speed;
			x += Math.sin(Math.toRadians(angle)) * speed;
		} else {
			y += Math.cos(Math.toRadians(angle)) * speed;
			x -= Math.sin(Math.toRadians(angle)) * speed;
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

	public void shoot() {
		Tank anotherTank;
		if (color.equals("green")) {
			anotherTank = GameLogic.getInstance().getRedTank();
		} else {
			anotherTank = GameLogic.getInstance().getGreenTank();
		}
		double radAngle = Math.toRadians(angle);
		Bullet newBullet = new Bullet(x + (50 * Math.sin(radAngle)), y - (50 * Math.cos(radAngle)), angle - 90, anotherTank);
		GameLogic.getInstance().getBullets().add(newBullet);
	}

	public void hitByBullet() {
		life--;
		System.out.println(life);
		GameScreen.get().getHeartPane().removeHeart(color, life);
		if (die()) {
			GameLogic.getInstance().pauseGame();
		}
	}

	private void draw(GraphicsContext gc) {
		gc.save();
		gc.translate(x, y);
		gc.rotate(angle);
		gc.drawImage(tankImage, -50, -50, 100, 100);
		gc.restore();
	}

	public void update() {
		if (GameScreen.isPressingKey) {
			if (color.equals("green")) {
				if (GameScreen.keyPressed.contains("W")) {
					move(true);
				}
				if (GameScreen.keyPressed.contains("S")) {
					move(false);
				}
				if (GameScreen.keyPressed.contains("A")) {
					turn(true);
				}
				if (GameScreen.keyPressed.contains("D")) {
					turn(false);
				}
				if (GameScreen.keyPressed.contains("SPACE")) {
					shoot();
				}
			} else if (color.equals("red")) {
				if (GameScreen.keyPressed.contains("UP")) {
					move(true);
				}
				if (GameScreen.keyPressed.contains("DOWN")) {
					move(false);
				}
				if (GameScreen.keyPressed.contains("LEFT")) {
					turn(true);
				}
				if (GameScreen.keyPressed.contains("RIGHT")) {
					turn(false);
				}
				if (GameScreen.keyPressed.contains("ENTER")) {
					shoot();
				}
			}
		}
		draw(GameLogic.getInstance().getGameCanvas().getGraphicsContext2D());
	}

	public String getColor() {
		return color;
	}

	public boolean die() {
		return life <= 0;
	}
	
}
