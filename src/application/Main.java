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
	public void start(Stage primaryStage) throws Exception {
		
		
		GameScreen.scene = new Scene(HomeScreen.get());
		primaryStage.setScene(GameScreen.scene);
		primaryStage.setTitle("Tank V Tank");

		
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	

}
