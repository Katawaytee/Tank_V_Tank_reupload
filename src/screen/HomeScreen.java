package screen;


import java.util.ArrayList;

import button.MyBaseButton;
import button.StartButton;
import button.TutorialButton;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class HomeScreen extends MyBaseScreen{
	
	private static HomeScreen homeScreen = null;
	private static String backgroundURL = ClassLoader.getSystemResource("background/homeBackground.jpg").toString();;
	private static String backgroundMusicURL = ClassLoader.getSystemResource("audio/Backgroundmusic.mp3").toString();
	private MediaPlayer music;
	
	public HomeScreen() {
		
		music = new MediaPlayer(new Media(backgroundMusicURL));
		
		addBackground();
		addButtons();
		playBackgroundMusic();
		
	}
	
	private void addButtons() {
		// TODO Auto-generated method stub
		ArrayList<MyBaseButton> buttons = new ArrayList<MyBaseButton>();
		AnchorPane anchorPane = new AnchorPane();
		StartButton startButton = new StartButton(125,125);
		TutorialButton tutorialButton = new TutorialButton(75, 75);
		
		buttons.add(startButton);
		buttons.add(tutorialButton);
		
		for(MyBaseButton button:buttons) {
			button.addListener();
			anchorPane.getChildren().add(button);
		}
		
		AnchorPane.setTopAnchor(startButton, 525.0);
		AnchorPane.setLeftAnchor(startButton, 470.0);
		
		AnchorPane.setTopAnchor(tutorialButton, 20.0);
		AnchorPane.setLeftAnchor(tutorialButton, 990.0);
		
		getChildren().add(anchorPane);
				
	}

	private void addBackground() {
		Canvas canvas= new Canvas(getWindowWidth(), getWindowHeight());	
		GraphicsContext gc = canvas.getGraphicsContext2D();
	
		Image Background = new Image(backgroundURL);
		gc.drawImage(Background, 0, 0);
		
		getChildren().add(canvas);
	}
	
	public void playBackgroundMusic() {
		music.setOnEndOfMedia(new Runnable() {
		       public void run() {
		         music.seek(Duration.ZERO);
		       }
		   });
		music.play();
	}
	
	public void stopBackgroundMusic() {
		music.stop();
	}
	
	public static HomeScreen get() {
		if(homeScreen==null) {
			homeScreen = new HomeScreen();
		}
		return homeScreen;
	}
	
}
