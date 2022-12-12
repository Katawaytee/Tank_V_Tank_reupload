package object;

import utility.Moveable;
import utility.Updatable;

public abstract class Entity implements Updatable, Moveable {

	private double x;
	private double y;
	private int speed;
	private int angle;
	
	public abstract void move();
	
	public abstract void update();
	
}
