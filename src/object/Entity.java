package object;

import utility.Moveable;
import utility.Updatable;

public abstract class Entity implements Updatable, Moveable {

	protected double x;
	protected double y;
	protected int speed;
	protected int angle;
	
	public abstract void move(boolean forward);
	
	public abstract void update();
	
}
