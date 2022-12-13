package screen;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import logic.GameLogic;

public class HomeScreen extends Pane{
	private final String BackgroundURL;
	private final String BackgroundMusicURL;
	private MediaPlayer music;
	
	public HomeScreen(int width, int height) {

		BackgroundURL = ClassLoader.getSystemResource("home/Background.jpg").toString();
		BackgroundMusicURL = ClassLoader.getSystemResource("audio/BackgroundMusic.mp3").toString();
		
		Canvas canvas= new Canvas(width, height);
		getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
	
		renderBackground(gc, BackgroundURL);
		createPlayButton();
		playBackgroundMusic(BackgroundMusicURL);
		
	}
	
	private void createPlayButton() {
		// TODO Auto-generated method stub
		AnchorPane pane = new AnchorPane();
		pane.setLayoutX(540);
		pane.setLayoutY(600);
		
		
		Circle cir = new Circle(50);
		cir.setFill(Color.BLUE);
		cir.setStroke(Color.MEDIUMBLUE);
		cir.setStrokeWidth(8);
		Polygon poly =  new Polygon(-15,-25,-15,25,25,0); 
		poly.setFill(Color.CRIMSON);
		pane.getChildren().addAll(cir,poly);
		getChildren().add(pane);
		
		pane.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				pane.setCursor(Cursor.HAND);
				cir.setEffect(new InnerShadow(30, Color.BLACK));
			}
		});
		
		pane.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				cir.setEffect(null);;
			}
		});
		
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				GameLogic.getInstance().startNewGame();
				GameScreen.scene.setRoot(GameScreen.get());
				music.stop();
			}
		});
		
	}

	private void renderBackground(GraphicsContext gc, String BackgroundURL) {
		System.out.print(BackgroundURL);
		Image Background = new Image(BackgroundURL);
		gc.drawImage(Background, 0, 0);
	}
	
	private void playBackgroundMusic(String url) {
		music = new MediaPlayer(new Media(url));
		music.setOnEndOfMedia(new Runnable() {
		       public void run() {
		         music.seek(Duration.ZERO);
		       }
		   });
		music.play();
	}
}
