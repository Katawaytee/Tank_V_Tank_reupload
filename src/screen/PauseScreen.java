package screen;


import java.util.ArrayList;

import button.ExitButton;
import button.MyBaseButton;
import button.HomeButton;
import button.PlayButton;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class PauseScreen extends MyBaseScreen {
	
	public PauseScreen() {
		super();
		addButtonPane();
		addButtons();
	}
	
	private void addButtonPane() {
		Canvas canvas = new Canvas(getWindowWidth(),getWindowHeight());
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.rgb(178, 240, 248, 0.4));
		gc.fillRect(0,0,getWindowWidth(),getWindowHeight());
		gc.save();
		gc.translate(540,360);
		gc.setFill(Color.LIGHTGREY);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(5);
		gc.strokeRoundRect(-150,-100,300,200,30,30);
		gc.fillRoundRect(-150,-100,300,200,30,30);
		gc.restore();
		getChildren().add(canvas);
	}
	
	private void addButtons() {
		ArrayList<MyBaseButton> buttons = new ArrayList<MyBaseButton>();
		HomeButton homeButton = new HomeButton(60,60);
		PlayButton playButton = new PlayButton(60,60);
		ExitButton exitButton = new ExitButton(60,60);
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.getChildren().addAll(homeButton,playButton,exitButton);
		buttons.add(homeButton);
		buttons.add(playButton);
		buttons.add(exitButton);
		
		for (MyBaseButton button : buttons) {
			button.addListener();
		}
		
		AnchorPane.setTopAnchor(homeButton, 330.0);
		AnchorPane.setTopAnchor(playButton, 330.0);
		AnchorPane.setTopAnchor(exitButton, 330.0);
		AnchorPane.setLeftAnchor(homeButton, 427.5);
		AnchorPane.setLeftAnchor(playButton, 515.0);
		AnchorPane.setLeftAnchor(exitButton, 602.5);
		getChildren().add(anchorPane);
	}
	
}
