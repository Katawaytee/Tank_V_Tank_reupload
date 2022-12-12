package object;

import utility.Moveable;
import utility.Updatable;

public abstract class Entity implements Updatable, Moveable {

	protected double x;
	protected double y;
	protected int speed;
	protected int angle;
	
	public abstract void move();
	
	public abstract void update();
	
}
