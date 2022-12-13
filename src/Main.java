import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import screen.GameScreen;
import screen.HomeScreen;

public class Main extends Application{
	
	private final static int WINDOW_WIDTH = 1080;
	private final static int WINDOW_HEIGHT = 720;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		StackPane root = new StackPane();
		Pane home = new HomeScreen(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		GameScreen.scene = new Scene(root);
		stage.setScene(GameScreen.scene);
		stage.setTitle("Tank V Tank");

		root.getChildren().add(home);
		
		stage.setResizable(false);
		stage.show();
	}

}
