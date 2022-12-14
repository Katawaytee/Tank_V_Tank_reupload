package screen;

import java.util.ArrayList;

import button.HomeButton;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TutorialScreen extends MyBaseScreen {
	
	private static TutorialScreen tutorialScreen = null;
	private static String redTankURL=ClassLoader.getSystemResource("icon/redTank.png").toString();;
	private static String greenTankURL=ClassLoader.getSystemResource("icon/greenTank.png").toString();
	private static String backgroundURL=ClassLoader.getSystemResource("background/tutorialBackground.jpg").toString();
	
	public TutorialScreen() {
		super();

		Canvas canvas = new Canvas(getWindowWidth(),getWindowHeight());
		GraphicsContext gc = canvas.getGraphicsContext2D();

		addBackground(gc);
		addPane(gc);
		addPicture(gc);
		addText(gc);
		
		getChildren().add(canvas);
		
		addButton();
	}
	
	private void addBackground(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image background = new Image(backgroundURL); 
		gc.drawImage(background, 0, 0, 1080,720);
	}

	private void addButton() {
		// TODO Auto-generated method stub
		AnchorPane anchorPane = new AnchorPane();
		HomeButton homeButton = new HomeButton(80,80);
		
		homeButton.addListener();
		
		anchorPane.getChildren().add(homeButton);
		AnchorPane.setTopAnchor(homeButton, 20.0);
		AnchorPane.setLeftAnchor(homeButton, 975.0);
		
		getChildren().add(anchorPane);
	}

	private void addText(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BLACK);
		Font theFont = Font.font("RockWell", FontWeight.BOLD, 36);
		gc.setFont(theFont);
		
		gc.fillText("Green Tank",285,175);
		gc.fillText("Red Tank",640,175);
		
		theFont = Font.font("RockWell", FontWeight.LIGHT, 24);
		gc.setFont(theFont);
		
		ArrayList<String> TextsPlayer1 = new ArrayList<String>();

		TextsPlayer1.add("W : Move Forward");
		TextsPlayer1.add("S : Move Back");
		TextsPlayer1.add("A : Left Rotate");
		TextsPlayer1.add("D : Right Rotate");
		TextsPlayer1.add("Spacebar : Shoot");
		
		int current = 400;
		for(String text:TextsPlayer1) {
			gc.fillText(text,285,current);
			current+=30;
		}
		
		ArrayList<String> TextsPlayer2 = new ArrayList<String>();
		
		TextsPlayer2.add("Up : Move Forward");
		TextsPlayer2.add("Down : Move Back");
		TextsPlayer2.add("Left : Left Rotate");
		TextsPlayer2.add("Right : Right Rotate");
		TextsPlayer2.add("Enter : Shoot");
		
		current = 400;
		for(String text:TextsPlayer2) {
			gc.fillText(text,610,current);
			current+=30;
		}
		
		
	}

	private void addPicture(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image redTank=new Image(redTankURL);
		Image greenTank=new Image(greenTankURL);
		gc.save();
		gc.translate(325,225);
		gc.drawImage(greenTank,0,0,125,125);
		gc.restore();
		gc.save();
		gc.translate(650,225);
		gc.drawImage(redTank,0,0,125,125);
		gc.restore();
	}

	private void addPane(GraphicsContext gc) {
		gc.setFill(Color.rgb(178, 240, 248, 0.4));
		gc.fillRect(0,0,getWindowWidth(),getWindowHeight());
		gc.save();
		gc.translate(540,360);
		gc.setFill(Color.FORESTGREEN);
		gc.setStroke(Color.DARKGREEN);
		gc.setLineWidth(8);
		gc.strokeRoundRect(-350,-250,725,475,30,30);
		gc.fillRoundRect(-350,-250,725,475,30,30);
		gc.restore();
	}
	
	public static TutorialScreen get() {
		if(tutorialScreen==null) {
			tutorialScreen = new TutorialScreen();
		}
		return tutorialScreen;
	}
	
}