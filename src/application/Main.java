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
	public void start(Stage PrimaryStage) throws Exception {
		
		
		GameScreen.scene = new Scene(HomeScreen.get());
		PrimaryStage.setScene(GameScreen.scene);
		PrimaryStage.setTitle("Tank V Tank");

		
		PrimaryStage.setResizable(false);
		PrimaryStage.show();
	}
	
	

}
