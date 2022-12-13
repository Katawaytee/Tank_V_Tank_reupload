package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screen.GameScreen;
import screen.HomeScreen;

public class Main extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		
		GameScreen.scene = new Scene(HomeScreen.get());
		stage.setScene(GameScreen.scene);
		stage.setTitle("Tank V Tank");

		
		stage.setResizable(false);
		stage.show();
	}
	
	

}
