package logic;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import object.Bullet;
import object.Tank;
import screen.GameScreen;
import screen.PauseScreen;

public class GameLogic {

	private static GameLogic instance = null;
	private Tank[] tanks;
	private ArrayList<Bullet> bullets;
	private Canvas gameCanvas;
	private AnimationTimer gameTimer;

	private GameLogic() {
		tanks = new Tank[2];
		tanks[0] = new Tank(600, 500, "red");
		tanks[1] = new Tank(300, 200, "green");
		bullets = new ArrayList<Bullet>();
		gameCanvas = new Canvas(1080, 720);
		initializeGameTimer();
	}

	public static GameLogic getInstance() {
		if (instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	private void initializeGameTimer() {
		gameTimer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				GameScreen.get().requestFocus();
				GameLogic.getInstance().getGameCanvas().getGraphicsContext2D().clearRect(0,0,1080,720);
				tanks[0].update();
				tanks[1].update();
				for (Bullet bullet : bullets) {
					bullet.update();
				}
				GameScreen.keyPressed.remove("ENTER");
				GameScreen.keyPressed.remove("SPACE");
			}
		};
	}

	public void startNewGame() {
		instance = null;
		GameScreen.resetGameScreen();
		GameLogic.getInstance().gameTimer.start();
	}
	
	public void pauseGame() {
		gameTimer.stop();
		GameScreen.get().getChildren().add(new PauseScreen());
	}
	
	public void resumeGame() {
		GameScreen.get().getChildren().remove(3);
		gameTimer.start();
	}

	public Canvas getGameCanvas() {
		return gameCanvas;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public Tank getGreenTank() {
		return tanks[1];
	}

	public Tank getRedTank() {
		return tanks[0];
	}
	
}
