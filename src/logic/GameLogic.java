package logic;

public class GameLogic {

	private static GameLogic instance = null;
	
	private GameLogic() {
		
	}
	
	public static GameLogic getInstance() {
		if(instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}
	
}
