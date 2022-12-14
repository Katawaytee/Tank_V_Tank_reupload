package object;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GameLogic;
import screen.GameScreen;
import utility.Controllable;

public class Tank extends Entity implements Controllable{

	private int life;
	private String color;
	private Image tankImage;
	private Image bombImage;
	private boolean hasDelay;
	private String keyUp;
	private String keyDown;
	private String keyLeft;
	private String keyRight;
	private String keyShoot;

	public Tank(double x, double y, String color) {
		this.x = x;
		this.y = y;
		angle = 0;
		speed = 3;
		life = 3;
		this.color = color;
		this.hasDelay=false;
		if (this.color.equals("green")) {
			tankImage = new Image(GameScreen.greenTankURL);
			setKeyMove("W", "S", "A", "D");
			setKeyShoot("SPACE");
		} else if (this.color.equals("red")) {
			tankImage = new Image(GameScreen.redTankURL);
			setKeyMove("UP", "DOWN", "LEFT", "RIGHT");
			setKeyShoot("ENTER");
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
		if(!hasDelay) {
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
						hasDelay=true;
					}
				});
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						hasDelay=false;
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
			if (GameScreen.keyPressed.contains(keyUp)) {
				move(true);
			}
			if (GameScreen.keyPressed.contains(keyDown)) {
				move(false);
			}
			if (GameScreen.keyPressed.contains(keyLeft)) {
				turn(true);
			}
			if (GameScreen.keyPressed.contains(keyRight)) {
				turn(false);
			}
			if (GameScreen.keyPressed.contains(keyShoot)) {
				shoot();
			}
		}
		draw(GameLogic.getInstance().getGameCanvas().getGraphicsContext2D());
	}

	

	public boolean die() {
		return life <= 0;
	}

	@Override
	public void setKeyMove(String up, String down, String left, String right) {
		// TODO Auto-generated method stub
		keyUp=up;
		keyDown=down;
		keyLeft=left;
		keyRight=right;
	}

	@Override
	public void setKeyShoot(String shoot) {
		// TODO Auto-generated method stub
		keyShoot=shoot;
	}
	
	public String getColor() {
		return color;
	}
}
