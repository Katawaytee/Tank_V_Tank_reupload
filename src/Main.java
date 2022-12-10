import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import screen.HomeScreen;

public class Main extends Application{
	
	private final static int WINDOW_WIDTH=1080;
	private final static int WINDOW_HEIGHT=720;
	StackPane root;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		root = new StackPane();
		Pane home = new HomeScreen(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Tank V Tank");

		root.getChildren().add(home);
		
		stage.show();
	}

}
