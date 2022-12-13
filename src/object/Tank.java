package object;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GameLogic;
import screen.GameScreen;

public class Tank extends Entity {

	private int life;
	private String color;
	private Image tankImage;
	private Image bombImage;
	private boolean canShoot;

	public Tank(double x, double y, String color) {
		this.x = x;
		this.y = y;
		angle = 0;
		speed = 3;
		life = 3;
		this.color = color;
		this.canShoot=true;
		if (this.color.equals("green")) {
			tankImage = new Image(GameScreen.greenTankURL);
		} else if (color.equals("red")) {
			tankImage = new Image(GameScreen.redTankURL);
		}
		bombImage = new Image(GameScreen.bombURL);
	}

	public void move(boolean forward) {
		double nextX;
		double nextY;
		if (forward) {
			nextY = y - Math.cos(Math.toRadians(angle)) * speed;
			nextX = x + Math.sin(Math.toRadians(angle)) * speed;
		} else {
			nextY = y + Math.cos(Math.toRadians(angle)) * speed;
			nextX = x - Math.sin(Math.toRadians(angle)) * speed;
		}
		if((nextY<=720&&nextY>=0)&&(nextX<=1080&&nextX>=0)) {
			x = nextX;
			y = nextY;
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
		if(canShoot) {
			Thread thread = new Thread(() -> {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {	
						Tank anotherTank;
						if (color.equals("green")) {
							anotherTank = GameLogic.getInstance().getRedTank();
						} else {
							anotherTank = GameLogic.getInstance().getGreenTank();
						}
						double radAngle = Math.toRadians(angle);
						Bullet newBullet = new Bullet(x + (50 * Math.sin(radAngle)), y - (50 * Math.cos(radAngle)), angle - 90, anotherTank);
						GameLogic.getInstance().getBullets().add(newBullet);
						canShoot=false;
					}
				});
				
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
					
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						canShoot=true;
					}
				});
					
		});
		thread.start();
		
		}
	}

	public void hitByBullet(GraphicsContext gc) {
		life--;
		GameScreen.takeShotSound.play();
		GameScreen.get().getHeartPane().removeHeart(color, life);
		if (die()) {
			gc.save();
			gc.translate(x, y);
			gc.drawImage(bombImage, -75, -75, 150, 150);
			gc.restore();
			GameScreen.explosionSound.play();
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
