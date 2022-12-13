package screen;

import java.util.ArrayList;

import button.ExitButton;
import button.HomeButton;
import button.MyBaseButton;
import button.PlayButton;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class PauseScreen extends StackPane {

	Canvas buttonPane;
	
	public PauseScreen() {
		super();
		setWidth(1080);
		setHeight(720);
		addButtonPane();
		addButtons();
	}
	
	private void addButtonPane() {
		buttonPane = new Canvas(1080,720);
		GraphicsContext gc = buttonPane.getGraphicsContext2D();
		gc.setFill(Color.rgb(178, 240, 248, 0.4));
		gc.fillRect(0,0,1080,720);
		gc.save();
		gc.translate(540,360);
		gc.setFill(Color.WHITE);
		gc.fillRoundRect(-150,-100,300,200,30,30);
		gc.restore();
		getChildren().add(buttonPane);
	}
	
	private void addButtons() {
		ArrayList<MyBaseButton> buttons = new ArrayList<MyBaseButton>();
		HomeButton homeButton = new HomeButton();
		PlayButton playButton = new PlayButton();
		ExitButton exitButton = new ExitButton();
		AnchorPane anchorPane = new AnchorPane();
		buttons.add(homeButton);
		buttons.add(playButton);
		buttons.add(exitButton);
		anchorPane.getChildren().addAll(homeButton,playButton,exitButton);
		for (MyBaseButton button : buttons) {
			button.addListener();
		}
		AnchorPane.setTopAnchor(homeButton, 335.0);
		AnchorPane.setTopAnchor(playButton, 335.0);
		AnchorPane.setTopAnchor(exitButton, 335.0);
		AnchorPane.setLeftAnchor(homeButton, 427.5);
		AnchorPane.setLeftAnchor(playButton, 515.0);
		AnchorPane.setLeftAnchor(exitButton, 602.5);
		getChildren().add(anchorPane);
	}
	
}
