package screen;


import button.StartButton;
import button.TutorialButton;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class HomeScreen extends MyBaseScreen{
	
	private static HomeScreen homeScreen = null;
	private final String BackgroundURL;
	private final String BackgroundMusicURL;
	private final MediaPlayer music;
	public static Scene scene;
	
	public HomeScreen() {

		BackgroundURL = ClassLoader.getSystemResource("background/homeBackground.jpg").toString();
		BackgroundMusicURL = ClassLoader.getSystemResource("audio/BackgroundMusic.mp3").toString();
		music = new MediaPlayer(new Media(BackgroundMusicURL));
		
		Canvas canvas= new Canvas(getWindowWidth(), getWindowHeight());
		getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
	
		addBackground(gc, BackgroundURL);
		createStartButton();
		playBackgroundMusic();
		
	}
	
	private void createStartButton() {
		// TODO Auto-generated method stub
		AnchorPane anchorPane = new AnchorPane();
		StartButton startButton = new StartButton(125,125);
		TutorialButton tutorialButton = new TutorialButton(75, 75);
		
		anchorPane.getChildren().addAll(startButton,tutorialButton);
		AnchorPane.setTopAnchor(startButton, 525.0);
		AnchorPane.setLeftAnchor(startButton, 470.0);
		
		AnchorPane.setTopAnchor(tutorialButton, 20.0);
		AnchorPane.setLeftAnchor(tutorialButton, 990.0);
		
		getChildren().add(anchorPane);
				
	}

	private void addBackground(GraphicsContext gc, String BackgroundURL) {
		Image Background = new Image(BackgroundURL);
		gc.drawImage(Background, 0, 0);
	}
	
	private void playBackgroundMusic() {
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
